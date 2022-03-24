package com.dojooverflow.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dojooverflow.models.Answer;
import com.dojooverflow.models.Question;
import com.dojooverflow.models.Tag;
import com.dojooverflow.services.DojoService;



@Controller
public class MainController {
    private final DojoService dojoService;

    public MainController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/")
    public String home() {
        return "index.jsp";
    }

    @GetMapping("/questions")
    public String dashboard(Model model) {
        List<Question> questions = dojoService.allQuestions();
        model.addAttribute("questions", questions);
        return "dashboard.jsp";
    }

    @GetMapping("/questions/new")
    public String createQuestion(Model model, @ModelAttribute("askquestion") Question askquestion) {
        model.addAttribute("askquestion", askquestion);
        return "newquestion.jsp";
    }

    @PostMapping("/questions/new/process")
    public String createQuestionProcess(@RequestParam (value = "question") String question,
                                        @RequestParam (value = "tags") String tags) {
        String smalltags = tags.toLowerCase();
        String [] listOfTags = smalltags.split(",");
        List<String> allTags = Arrays.asList(listOfTags);

        if (question.length() < 1) {
            return "redirect:/emptyquestion";
        }
        else if (tags.length() < 1) {
            return "redirect:/emptytags";
        }
        else if (allTags.size() > 3) {
            return "redirect:/toomanytags";
        }
        else {
            Question q = dojoService.createQuestion(question);
            ArrayList<Tag> allTagsConv = new ArrayList<Tag>();

            for (int i = 0; i < allTags.size(); i++) {
                Tag findTag = dojoService.findBySubject(allTags.get(i));
                if (findTag == null) {
                    Tag t = dojoService.createStringTag(allTags.get(i));
                    allTagsConv.add(t);
                }
                else {
                    allTagsConv.add(findTag);
                }
            }
            q.setTags(allTagsConv);
            dojoService.updateQuestion(q);
            return "redirect:/questions";
        }
    }

    @GetMapping("/emptyquestion")
    public String emptyQuestion (RedirectAttributes target) {
        target.addFlashAttribute("question", "Question field cannot be blank");
        return "redirect:/questions/new";
    }

    @GetMapping("/emptytags")
    public String emptyTags (RedirectAttributes target) {
        target.addFlashAttribute("tag", "Tag field cannot be blank");
        return "redirect:/questions/new";
    }

    @GetMapping("/toomanytags")
    public String tooManyTags (RedirectAttributes target) {
        target.addFlashAttribute("tag", "Question cannot have more than three tags");
        return "redirect:/questions/new";
    }

    @GetMapping("/questions/{id}")
    public String answers (Model model, @PathVariable("id") Long id) {
        Question question = dojoService.findQuestion(id);
        model.addAttribute("question", question);
        return "answers.jsp";
    }

   @PostMapping("/questions/{id}/answer")
    public String answerQuestion (@PathVariable("id") Long id,
                                  @RequestParam (value = "answer") String answer, HttpSession session) {
        if (answer.length() < 2) {
            session.setAttribute("id", id);
            return "redirect:/noanswer";
        }
        else {
            Answer a = new Answer();
            a.setAnswer(answer);
            Question question = dojoService.findQuestion(id);
            a.setQuestion(question);
            dojoService.createAnswer(a);
            return "redirect:/questions/" + id;
        }
    }

    @GetMapping("/noanswer")
    public String noAnswer (RedirectAttributes target, HttpSession session) {
        target.addFlashAttribute("answer", "Answer must be two or more characters long");
        Long id = (Long) session.getAttribute("id");
        return "redirect:/questions/" + id;
    }
}
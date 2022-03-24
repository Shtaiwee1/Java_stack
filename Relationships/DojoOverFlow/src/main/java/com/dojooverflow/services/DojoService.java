package com.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojooverflow.models.Answer;
import com.dojooverflow.models.Question;
import com.dojooverflow.models.Tag;
import com.dojooverflow.repositories.AnswerRepository;
import com.dojooverflow.repositories.QuestionRepository;
import com.dojooverflow.repositories.TagRepository;

@Service
public class DojoService {
	
	private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final AnswerRepository answerRepository;

    public DojoService (QuestionRepository questionRepository,
                                TagRepository tagRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
        this.answerRepository = answerRepository;
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public List<Tag> allTags() {
        return tagRepository.findAll();
    }

    public List<Answer> allAnswer() {
        return answerRepository.findAll();
    }

    public Question createQuestion(String question) {
        Question q = new Question(question);
        return questionRepository.save(q);
    }

    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag createStringTag (String tag) {
        Tag newTag = new Tag (tag);
        return tagRepository.save(newTag);
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        }
        else {
            return null;
        }
    }

    public Tag findBySubject(String subject) {
        return tagRepository.findBySubject(subject);
    }
}



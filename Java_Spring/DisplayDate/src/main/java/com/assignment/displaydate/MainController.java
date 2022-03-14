package com.assignment.displaydate;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		String patternD = "EEEEE ',' 'the' d 'of' MMMMM, yyyy ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternD);
		model.addAttribute("date", simpleDateFormat.format(new Date()));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		String patternT = "K:mm a";
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(patternT);
		model.addAttribute("time", simpleTimeFormat.format(new Date()));
		return "time.jsp";
	}
	

}

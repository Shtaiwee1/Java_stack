package com.example.pathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariablesTest {
	@RequestMapping("/m/{track}/{module}/{lesson}")
	public String index(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson) {
		return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
		
	}

}

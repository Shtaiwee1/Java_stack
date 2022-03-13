package com.example.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiVarTest {
	@RequestMapping("/travel/{city}")
	public String index(@PathVariable("city") String inputCity) {
		return "Congratulations! You will soon travel to " + inputCity + " ! ";	
	}
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") String inputNumber) {
		int result = Integer.parseInt(inputNumber);
		if(result % 2 == 0) {
		return "You will take a grand journey in the near future, but be weary of tempting offers " ;	
	}else {
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends." ;
	}
	
}
}

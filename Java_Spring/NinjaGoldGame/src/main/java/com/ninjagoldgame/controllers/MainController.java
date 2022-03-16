package com.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/Gold")
    public String gold(HttpSession session) {
        if(session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }
        


        if((int)session.getAttribute("gold") < 0) {
            return "prison.jsp";
        }
        return "index.jsp";
    }
	
	@PostMapping("/process")
		public String process(HttpSession session,@RequestParam(value="place") String place) {
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
			if(place.equals("farm")) {
				int rand = ThreadLocalRandom.current().nextInt(10, 21);
				int currentGold = (int) session.getAttribute("gold");
				session.setAttribute("gold", currentGold + rand);
				 ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		            activities.add(0, "You have entered a farm and earned " + rand + " gold. ("
		                    + time + ")");
				
			}else if(place.equals("cave")){
				int rand = ThreadLocalRandom.current().nextInt(5, 11);
				int currentGold = (int) session.getAttribute("gold");
				session.setAttribute("gold", currentGold + rand);
				 ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		            activities.add(0, "You have entered a cave and earned " + rand + " gold. ("
		                    + time + ")");
				
			}else if(place.equals("house")) {
				int rand = ThreadLocalRandom.current().nextInt(2, 6);
				int currentGold = (int) session.getAttribute("gold");
				session.setAttribute("gold", currentGold + rand);
				 ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		            activities.add(0, "You have entered a house and earned " + rand + " gold. ("
		                    + time + ")");
				
			}else if(place.equals("quest")) {
				int rand = ThreadLocalRandom.current().nextInt(-50, 51);
				int currentGold = (int) session.getAttribute("gold");
				session.setAttribute("gold", currentGold + rand);
				 ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
				 if(rand > 0) {
					 activities.add(0, "You have completed a quest and earned " + rand + " gold. ("
			                    + time + ")");
				 }else if(rand < 0) {
					 activities.add(0, "You have failed a quest and lost " + rand + " gold.Ouch ("
			                    + time + ")");
				 }else if(rand == 0) {
					 activities.add(0, "Your job was done poorly so you deserve nothing LOL,threfore you lost " + rand + " gold. ("
			                    + time + ")");
					 
				 }
		            
				
			}
			else if(place.equals("spa")) {
				int rand = ThreadLocalRandom.current().nextInt(-20, -6);
				int currentGold = (int) session.getAttribute("gold");
				session.setAttribute("gold", currentGold + rand);
				 ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		            activities.add(0, "You have entered a spa and lost " + rand + " gold. ("
		                    + time + ")");
			}
			return "redirect:/Gold";
		}
	
	@GetMapping("/reset")
    public String reset(HttpSession session) {
        if(session.getAttribute("gold") != null) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }
        return "redirect:/Gold";
	}
}



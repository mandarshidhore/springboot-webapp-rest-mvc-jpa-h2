package com.sssm.springbootwebapprestmvcjpah2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sssm.springbootwebapprestmvcjpah2.dao.AthleteRepo;
import com.sssm.springbootwebapprestmvcjpah2.model.Athlete;

@Controller
public class HomeController {

	@Autowired
	private AthleteRepo repo;

	@RequestMapping("/home")
	public String welcome() {
		System.out.println(">> welcome");
		return "athleteinfo";
	}

	@RequestMapping("/addathlete")
	public String addathlete(Athlete athlete) {
		System.out.println(">> addathlete");
		// persist Athlete to db
		repo.save(athlete);
		return "athleteinfo";
	}

	@RequestMapping("/getathletebyage")
	public ModelAndView getathletebyage(@RequestParam("age") int age) {
		System.out.println(">> getathletebyage");
		// fetch Athlete from db - by age
		Athlete athlete = repo.findById(age).orElse(null);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showathlete");
		mav.addObject("ath", athlete);
		return mav;
	}

	@RequestMapping("/getathletebyfirstname")
	public ModelAndView getathletebyfirstname(@RequestParam("firstN") String fn) {
		System.out.println(">> getathletebyfirstname");
		// fetch Athlete from db - by first name - uses custom method defined in AthleteRepo
		Athlete athlete = repo.findByFName(fn);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showathlete");
		mav.addObject("ath", athlete);
		return mav;
	}

}

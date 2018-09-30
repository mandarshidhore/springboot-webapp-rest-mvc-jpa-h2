package com.sssm.springbootwebapprestmvcjpah2.controller;

import java.util.Optional;

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
	
	@RequestMapping("/getathlete")
	public ModelAndView getathlete(@RequestParam("age") int id) {
		System.out.println(">> getathlete");
		// fetch Athlete from db
		Athlete athlete = repo.findById(id).orElse(null);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showathlete");
		mav.addObject("ath", athlete);
		return mav;
	}

}

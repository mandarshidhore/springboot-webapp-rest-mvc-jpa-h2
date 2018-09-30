package com.sssm.springbootwebapprestmvcjpah2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

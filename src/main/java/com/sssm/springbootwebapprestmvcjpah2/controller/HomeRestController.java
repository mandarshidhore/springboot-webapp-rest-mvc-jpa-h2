package com.sssm.springbootwebapprestmvcjpah2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sssm.springbootwebapprestmvcjpah2.dao.AthleteRepoJPA;
import com.sssm.springbootwebapprestmvcjpah2.model.Athlete;

@RestController
public class HomeRestController {

	@Autowired
	private AthleteRepoJPA repo;

	@RequestMapping("/getallathletes")
	public List<Athlete> getallathletes() {
		System.out.println(">> getallathletes");
		// jackson library brought in by Spring Boot converts response to JSON
		// if xml is needed, send in header Accept:application/xml
		return repo.findAll();
	}

	// produces = "application/xml" inside @RequestMapping restricts content type to xml
	// if Accept:application/json is sent in header, error similar to below is produced -
	//	{
	//	    "timestamp": "2018-10-01T03:02:59.175+0000",
	//	    "status": 406,
	//	    "error": "Not Acceptable",
	//	    "message": "Could not find acceptable representation",
	//	    "path": "/getathlete/37"
	//	}
	@RequestMapping(path = "/getathlete/{age}", produces = "application/xml")
	public Optional<Athlete> getathlete(@PathVariable("age") int age) {
		System.out.println(">> getathlete");
		return repo.findById(age);
	}
	
	// if you send form-data from client, you don't have to specify @RequestBody
	@PostMapping(path = "/addathleterestcallformdata", produces = "application/json")
	public Athlete addathleterestcallformdata(Athlete athlete) {
		System.out.println(">> addathleterestcallformdata");
		return repo.save(athlete);
	}
	
	// if you send raw from client, you have to specify @RequestBody
	@PostMapping(path = "/addathleterestcallrawdata", produces = "application/xml")
	public Athlete addathleterestcallrawdata(@RequestBody Athlete athlete) {
		System.out.println(">> addathleterestcallrawdata");
		return repo.save(athlete);
	}

	// delete an athlete by age
	@DeleteMapping(path = "/deleteathlete/{age}")
	public void deleteathlete(@PathVariable("age") int age) {
		System.out.println(">> deleteathlete");
		repo.deleteById(age);
	}
	
	// update an athlete by age
	@PutMapping(path = "/updateathlete")
	public void updateathlete(@RequestBody Athlete athlete) {
		System.out.println(">> updateathlete");
		// note that this is actually a saveOrUpdate type of call - if passed Athlete
		// object does not exist in db, it will be created
		repo.save(athlete);
	}

}

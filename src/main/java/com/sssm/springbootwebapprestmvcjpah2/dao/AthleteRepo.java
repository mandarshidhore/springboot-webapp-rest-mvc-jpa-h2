package com.sssm.springbootwebapprestmvcjpah2.dao;

import org.springframework.data.repository.CrudRepository;

import com.sssm.springbootwebapprestmvcjpah2.model.Athlete;

public interface AthleteRepo extends CrudRepository<Athlete, Integer> {

	// basic CRUD operations are implemented under the covers by Spring
	
	// this is custom method defined - findBy followed by property (in model object) with first letter capitalized
	Athlete findByFName(String fn);
}

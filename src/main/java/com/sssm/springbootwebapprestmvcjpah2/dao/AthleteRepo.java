package com.sssm.springbootwebapprestmvcjpah2.dao;

import org.springframework.data.repository.CrudRepository;

import com.sssm.springbootwebapprestmvcjpah2.model.Athlete;

public interface AthleteRepo extends CrudRepository<Athlete, Integer> {
	// basic CRUD operations are implemented under the covers by Spring
}

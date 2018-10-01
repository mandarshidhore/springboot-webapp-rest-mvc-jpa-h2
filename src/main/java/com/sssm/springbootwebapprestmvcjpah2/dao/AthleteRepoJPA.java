package com.sssm.springbootwebapprestmvcjpah2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sssm.springbootwebapprestmvcjpah2.model.Athlete;

// this extends JpaRepository to get its additional features
public interface AthleteRepoJPA extends JpaRepository<Athlete, Integer> {

}

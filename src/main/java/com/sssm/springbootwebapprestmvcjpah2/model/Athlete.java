package com.sssm.springbootwebapprestmvcjpah2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

// enable JPA by marking a class w/ @Entity and a field with @Id
// Spring Boot automatically creates the schema of an embedded DataSource
// see https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
@Entity
public class Athlete {

	@Id
	private int age;
	private String fName;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Override
	public String toString() {
		return "Athlete [age = " + age + ", first name = " + fName + "]";
	}

}

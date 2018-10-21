package com.sssm.springbootwebapprestmvcjpah2;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringbootWebappRestMvcJpaH2ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getAllAthletes() {
		try {
			String result = mvc.perform(get("/getallathletes").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
			System.out.println("\n==== Result ====\n");
			System.out.println(result);
			System.out.println("\n==== Result ====\n");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}

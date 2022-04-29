package com.paradigma.sga.contract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.paradigma.sga.infrastructure.controller.PricesController;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BaseTestClass {

	@Autowired
	private PricesController pricesController;
	
	@BeforeEach
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(pricesController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
	
}

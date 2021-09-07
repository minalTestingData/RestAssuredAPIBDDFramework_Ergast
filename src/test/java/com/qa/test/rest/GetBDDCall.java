package com.qa.test.rest;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class GetBDDCall {

	@Test
	public void ergastCircuitForConstructorIDSize_2016() {
		
		Response response = get("http://ergast.com/api/f1/2016/circuits/americas/constructors.json");
		
		Object resptime = response.getTime();
		String contentlength = response.getHeader("Content-Length");
		System.out.println("resptime is:"+resptime);
		Assert.assertEquals(contentlength, "1695");
		
		
		given().
		header("content-type","application/json; charset=utf-8").	
		when().
		get("http://ergast.com/api/f1/2016/circuits/americas/constructors.json").
		then().
		statusCode(200).
		body("MRData.ConstructorTable.Constructors.constructorId",hasSize(11)).log().all();
	}
}

package parsing;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.crypto.Data;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.util.Asserts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

class Datatest{
	
	private String name;
	private int salary;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

class AllData{
	
	private List<Datatest> list;

	public List<Datatest> getList() {
		return list;
	}

	public void setList(List<Datatest> list) {
		this.list = list;
	}
	
}
public class NewClassforGit {
	
	@Test
	public void test() throws JsonProcessingException {
		
		Datatest datatest=new Datatest();
		datatest.setId(1);
		datatest.setName("Akshay");
		datatest.setSalary(2000);
		
		Datatest datatest2=new Datatest();
		datatest2.setId(2);
		datatest2.setName("Satish");
		datatest2.setSalary(3000);
		ObjectMapper mapper=new ObjectMapper();
		JSONArray jsonArray=new JSONArray();
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("emp1",new JSONObject(mapper.writeValueAsString(datatest)));
		jsonObject.put("emp2", new JSONObject(mapper.writeValueAsString(datatest2)));
		
		jsonArray.put(jsonObject);
		
		
		 RestAssured.baseURI = "https://httpbin.org/post";
         RequestSpecification reqSpec = RestAssured.given();
         reqSpec.body(jsonArray.toString());
         reqSpec.contentType(ContentType.JSON);
         Response res = reqSpec.post();
         ValidatableResponse valRes = res.then().log().all().statusCode(200);
    
	}

	@Test
	public void test2() throws JsonProcessingException {
		System.out.println("Adding duplicate new file");
	}

}

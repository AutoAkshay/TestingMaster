package sessionPart3.session20to29;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.json.simple.JSONArray;

import static org.hamcrest.CoreMatchers.equalTo;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.LogSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

class Emp {

	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

public class Session21_JSONArrayPOJODemo {

//	@Test
	void serialization() throws JsonProcessingException {

		Emp emp1 = new Emp();
        emp1.setFirstName("Suresh");
        emp1.setLastName("Mehra");
        emp1.setGender("Male");
        emp1.setAge(35);
        emp1.setSalary(10000.00);

        // Create second employee
        Emp emp2 = new Emp();
        emp2.setFirstName("Ravi");
        emp2.setLastName("Kumar");
        emp2.setGender("Male");
        emp2.setAge(28);
        emp2.setSalary(12000.00);

        // Create third employee
        Emp emp3 = new Emp();
        emp3.setFirstName("Anita");
        emp3.setLastName("Sharma");
        emp3.setGender("Female");
        emp3.setAge(30);
        emp3.setSalary(15000.00);

		List<Emp> listOfEmp=new ArrayList<Emp>();
		
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		ObjectMapper objMapper=new ObjectMapper();
		String JSONArrayPayload=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		
		System.out.println(JSONArrayPayload);
		
		RestAssured.baseURI="https://httpbin.org/post";
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.body(JSONArrayPayload.toString());
		reqSpec.contentType(ContentType.JSON);
		
		Response res= reqSpec.when().post();
		
		ValidatableResponse valRes= res.then().log().all().statusCode(200);
		
		System.out.println("******************Response Body***************************");
		res.prettyPrint();
		
		ResponseBody body=res.getBody();
		JsonPath jsonPath= body.jsonPath();
		
		List<Emp> list=jsonPath.getList("json",Emp.class);
		System.out.println("*****************For each loop***************************");
		for (Emp emp : list) {			
			System.out.println(emp.getFirstName()+" "+emp.getLastName());
		}
	}

}

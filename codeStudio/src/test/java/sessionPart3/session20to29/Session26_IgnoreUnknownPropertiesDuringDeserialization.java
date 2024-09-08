package sessionPart3.session20to29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

//@JsonIgnoreProperties(ignoreUnknown = true)
class EmpPOJOClass1 {
	private String firstName;
	private String lastName;	
	private String gender;
	private int age;
	private double salary;
	private boolean isMarried;
	
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
	
	public boolean getIsMarried() {
		return isMarried;
	}
	
	public void setIsMarried(boolean isMarried) {
		this.isMarried=isMarried;
	}
}

public class Session26_IgnoreUnknownPropertiesDuringDeserialization {

	@Test
	public void createUser() throws JsonProcessingException {
		
		String payLoad="{\r\n"
				+ "  \"firstName\" : \"Akshay\",\r\n"
				+ "  \"lastName\" : \"Kalam\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"age\" : 30,\r\n"
				+ "  \"salary\" : 100000.0,\r\n"
				+ "  \"isMarried\" : true,\r\n"
				+ "  \"fullName\" : \"Akshay Kalam\"\r\n"
				+ "}\r\n"
				+"";
//
		EmpPOJOClass1 emp1=new EmpPOJOClass1();
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String body=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		
		EmpPOJOClass1 epc=mapper.readValue(payLoad, EmpPOJOClass1.class);
		
		System.out.println("First Name:: "+epc.getFirstName());
		System.out.println("Last Name:: "+epc.getLastName());
		System.out.println("Age:: "+epc.getAge());
		System.out.println("Salary:: "+epc.getSalary());
		System.out.println("Marriage Status:: "+epc.getIsMarried());
		System.out.println("Gender:: "+epc.getGender());
		
		
	}
}

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
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@JsonIgnoreProperties(value = {"gender","salary","fullName"},allowGetters = true)
class EmployeePOJOClass1 {
	private String firstName;
	private String lastName;	
	private String gender;
	private int age;
	private double salary;
	private boolean isMarried;
	private String fullName;
	
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
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName=fullName;
	}
}
//IgnoreEmptyNullandDefaultValuesInPayload2
public class Session25_POJO_IgnoreEmptyNullandDefaultValuesInPayload {

	@Test
	public void createUser() throws JsonProcessingException {

		EmployeePOJOClass1 emp1=new EmployeePOJOClass1();
		
		emp1.setFirstName("Akshay");
		emp1.setLastName("Kalam");
		emp1.setAge(30);
		emp1.setGender("Male");
		emp1.setSalary(100000);
		emp1.setIsMarried(true);
		emp1.setFullName("Akshay Kalam");
		
		
		
		ObjectMapper mapper=new ObjectMapper();
		String body=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		System.out.println(body);
		
		EmployeePOJOClass1 epc=mapper.readValue(body, EmployeePOJOClass1.class);
		
		System.out.println("First Name:: "+epc.getFirstName());
		System.out.println("Last Name:: "+epc.getLastName());
		System.out.println("Age:: "+epc.getAge());
		System.out.println("Salary:: "+epc.getSalary());
		System.out.println("Marriage Status:: "+epc.getIsMarried());
		System.out.println("Gender:: "+epc.getGender());
		System.out.println("Full Name:: "+epc.getFullName());
	}
}

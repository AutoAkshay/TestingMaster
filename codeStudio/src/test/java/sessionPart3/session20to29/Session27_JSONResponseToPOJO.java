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
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

class empInfo{
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean isMarried;
	private List<String> hobbies;
	private List<String> degress;
	private Map<String,String> familyMember;
	
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
	
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<String> getDegress() {
		return degress;
	}
	public void setDegress(List<String> degress) {
		this.degress = degress;
	}
	public Map<String, String> getFamilyMember() {
		return familyMember;
	}
	public void setFamilyMember(Map<String, String> familyMember) {
		this.familyMember = familyMember;
	}
	
}
public class Session27_JSONResponseToPOJO {

	@Test
	public void createUser() throws JsonProcessingException {
		
		RestAssured.baseURI="https://run.mocky.io/v3/8bfe50de-227c-4167-932c-1098919d392f";
		
		RequestSpecification reqSpec=RestAssured.given();
		
		Response res=reqSpec.get();
//		ValidatableResponseOptions valRes=res.then().log().all().statusCode(200);
		
		ObjectMapper mapper=new ObjectMapper();
		
		ResponseBody body=res.getBody();
		String info=body.asString();
		System.out.println(body);
//		empInfo eInfo=mapper.readValue(info, empInfo.class);
		empInfo eInfo=reqSpec.get().as(empInfo.class);
		
		System.out.println("First name ::"+eInfo.getFirstName());
		System.out.println("Last name ::"+eInfo.getLastName());
		System.out.println("Age ::"+eInfo.getAge());
		System.out.println("Gender ::"+eInfo.getGender());
		System.out.println("salary ::"+eInfo.getSalary());
		System.out.println("Marriage Status ::"+eInfo.isMarried());
		System.out.println("Hobbies ::"+eInfo.getHobbies());
		System.out.println(eInfo.getDegress());
		System.out.println("Family members ::"+eInfo.getFamilyMember());
		
		System.out.println("Hobby Details::");
		int number=0;
		for(String hobby:eInfo.getHobbies()) {
			number++;
			System.out.println(number +"::"+hobby);
		}
		System.out.println("Family Member Details::");
		for(Map.Entry<String, String> entry:eInfo.getFamilyMember().entrySet()) {			
			System.out.println(entry.getKey()+"::"+entry.getValue());
		}
		
	}
}

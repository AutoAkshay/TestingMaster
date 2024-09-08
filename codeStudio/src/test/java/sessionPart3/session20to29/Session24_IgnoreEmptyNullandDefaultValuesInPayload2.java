package sessionPart3.session20to29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
class EmployeePOJOClass {
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean isMarried;
	private String[] hobbies;
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
	
	public boolean getIsMarried() {
		return isMarried;
	}
	
	public void setIsMarried(boolean isMarried) {
		this.isMarried=isMarried;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
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

public class Session24_IgnoreEmptyNullandDefaultValuesInPayload2 {

	@Test
	public void createUser() throws JsonProcessingException {

		EmployeePOJOClass emp1=new EmployeePOJOClass();
		
		emp1.setFirstName("Akshay");
		emp1.setLastName("Kalam");
		emp1.setAge(30);
		emp1.setGender("Male");
		emp1.setSalary(100000);
		emp1.setIsMarried(true);
		
		String[] hobbies= new String[2];
		hobbies[0]="Cricket";
		hobbies[1]="footBall";
		emp1.setHobbies(hobbies);
		List<String> degress =new ArrayList<>();
		degress.add("EHS Officer");
		degress.add("Software Engineer");
		emp1.setDegress(degress);
		Map<String, String> familyMember=new HashMap<String, String>();
		familyMember.put("1", "Mother");
		familyMember.put("2", "Father");
		emp1.setFamilyMember(familyMember);
		
		ObjectMapper mapper=new ObjectMapper();
		String body=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
//		System.out.println(body);
		
		EmployeePOJOClass class1= mapper.readValue(body, EmployeePOJOClass.class);
		System.out.println(class1.getFirstName());
		System.out.println(class1.getLastName());
		System.out.println(class1.getIsMarried());
		System.out.println(class1.getSalary());
		System.out.println(class1.getGender());
		System.out.println(class1.getAge());		
		System.out.println(class1.getFamilyMember());
		System.out.println(class1.getDegress());
		
	}
}

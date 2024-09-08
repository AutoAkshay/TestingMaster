package sessionPart3.session20to29;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

class EmployeeAdress {
	private String street;
	private String city;
	private String state;
	private int picode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPicode() {
		return picode;
	}

	public void setPicode(int picode) {
		this.picode = picode;
	}
}
class EmpData {

	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private EmployeeAdress adress;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasttName() {
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
	public EmployeeAdress getAdress() {
		return adress;
	}
	public void setAdress(EmployeeAdress adress) {
		this.adress = adress;
	}
}

public class Session22_DemoNestedPayload {
	
	@Test
	public void createUser() throws JsonProcessingException {
		EmpData data=new EmpData();
		data.setFirstName("Akshay");
		data.setLastName("Kalam");
		data.setGender("Male");
		data.setAge(31);
		data.setSalary(10000);
		
		EmployeeAdress address=new EmployeeAdress();
		address.setStreet("NDA Road");
		address.setCity("Pune");
		address.setState("MH");
		address.setPicode(431023);
		
		data.setAdress(address);
		
		ObjectMapper objectMapper=new ObjectMapper();
		String body=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		RestAssured.baseURI="https://httpbin.org/post";
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.body(body.toString());
		reqSpec.contentType(ContentType.JSON);
		
		Response res= reqSpec.post();
		
		ValidatableResponse valRes= res.then().log().all().statusCode(200);
	}
}

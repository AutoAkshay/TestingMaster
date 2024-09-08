package sessionPart1.session1to9;

import org.testng.Assert;
import org.testng.annotations.Test;



import  io.restassured.RestAssured.*;
import  io.restassured.matcher.RestAssuredMatchers.*;
import  org.hamcrest.Matchers.*;
import org.json.JSONObject;

import java.util.HashMap;
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
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Session3_HTTPrequests{

	/*HTTP response consists of -->
	status code, 
	header(Content-Type, Content-Length, Date, Server, Set-Cookie, Cache-Control, Expires, Last-Modified, Retry-After), 
	response body
	*/
//	@Test
	void test01() {
		
		Response res= RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("Respose body:: " +res.getBody().asString());
		System.out.println("Respose code:: "+res.getStatusCode());
		System.out.println("Respose time:: "+res.getTime());
		System.out.println("Respose Header:: "+res.getHeader("Content-type"));
		
		//validate status 
		int expectedStatusCode=200;
		int actualStatusCode=res.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode,"Not matching");
	}
	
//	@Test
	void getMethod() {
		
		RestAssured assure=new RestAssured();
		
		assure.given().queryParam("page", 2)
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200).log().all();
	}
	
	int id;
	@Test (priority = 1)
	void postMethod() {
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("name", "Prachi");
		jsonObject.put("job", "Tuitor");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		id=RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
		.when()
			.post().jsonPath().getInt("id");
		
		System.out.println("Generated ID:: "+id);
	}
	
	@Test(priority = 2)
	void putMethod() {
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("name", "Akshay");
		jsonObject.put("job", "Safety Officer");
		
		RestAssured.baseURI="https://reqres.in/api/users/"+id;
		
		RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
		
		System.out.println("Generated ID at Put level:: "+id);
	}
	
	@Test(priority = 3)
	void patchMethod() {
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("job", "QA");
		
		RestAssured.baseURI="https://reqres.in/api/users/"+id;
		
		RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
		.when()
			.patch()
		.then()
			.statusCode(200)
			.log().all();
		
		System.out.println("Generated ID at Patch level:: "+id);
	}
	
	@Test(priority = 4)
	void deleteMethod() {
		
		JSONObject jsonObject=new JSONObject();
		
		RestAssured.baseURI="https://reqres.in/api/users/"+id;
		
		RestAssured.given().contentType(ContentType.JSON).body(jsonObject.toString())
		.when()
			.delete();
		
		System.out.println("Generated ID at delete level:: "+id);
	}
	
}

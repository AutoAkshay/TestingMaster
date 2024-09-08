package sessionPart1.session1to9;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

import static org.hamcrest.CoreMatchers.equalTo;

import java.net.URI;
import java.util.HashMap;
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
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Session8_Authentication_BasicAndPreemtive{

//	@Test
	void basicAuth() {
		
		RequestSpecification reqSpec= RestAssured.given().auth().basic("postman", "password");
		
		reqSpec.baseUri("http://postman-echo.com/");
		reqSpec.basePath("basic-auth");
		
		Response response= reqSpec.get();
		
		ResponseBody body= response.getBody();
		String resBody=body.asString();
		
		System.out.println(resBody);
		System.out.println(response.getStatusLine());
		
	}	
	
//	@Test
	void preemtiveAuth() {
		
		RequestSpecification reqSpec= RestAssured.given().auth().preemptive().basic("postman", "password");
		
		reqSpec.baseUri("http://postman-echo.com/");
		reqSpec.basePath("basic-auth");
		
		Response response= reqSpec.get();
		
		ResponseBody body= response.getBody();
		String resBody=body.asString();
		
		System.out.println(resBody);
		
		System.out.println(response.getStatusLine());
	}	
	
//	@Test
	void digestAuth() {
		
		RequestSpecification reqSpec= RestAssured.given().auth().digest("postman", "password");
		
		reqSpec.baseUri("http://postman-echo.com/");
		reqSpec.basePath("basic-auth");
		
		Response response= reqSpec.get();
		
		ResponseBody body= response.getBody();
		String resBody=body.asString();
		
		System.out.println(resBody);
		
		System.out.println(response.getStatusLine());
	}		
}

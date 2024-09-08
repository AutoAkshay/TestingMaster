package sessionPart1.session1to9;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.ah.A;

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

public class Session4_ValidateHTTPresponseRequests{

	@Test
	void test01() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
	//	RestAssured.when().get().then().log().all().statusCode(200);
		
		RequestSpecification requestSpec=RestAssured.given();
		
		Response response=requestSpec.get();
		
		ValidatableResponse validateRes= response.then().log().all();
		System.out.println(validateRes);
//		validateRes.statusLine("HTTP/1.1 200 OK");
//		validateRes.body("data.first_name", equalTo("Janet"));
		
	}
	
//	@Test
	void test01_BDDStyle() {
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		given()
		
		.when()
			.get()
		.then().statusCode(200).log().all().statusLine("HTTP/1.1 200 OK");
		
	}
	
	
}

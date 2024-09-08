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

public class Session5_ValidateHTTPresponseHeaders{

	@Test
	void test01() {
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		Response response= given()
		
		.when().get();
//		ValidatableResponse valRes=response.then().log().all();
		String contentType= response.header("Content-Type");
		
		System.out.println("contentType:: "+ contentType);
		
		Headers headers=response.getHeaders();
		
		for (Header header : headers) {
			
			System.out.println(header.getName()+":"+header.getValue());
			System.out.println("-----------------------------------------------");
		}
		
		//validate
		
		String expected="application/json; charset=utf-8";
		
		Assert.assertEquals(contentType, expected,"Not matching");
		
		}	
}

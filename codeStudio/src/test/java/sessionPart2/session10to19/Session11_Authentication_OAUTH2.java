package sessionPart2.session10to19;

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
import io.restassured.specification.LogSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Session11_Authentication_OAUTH2{

	//key :- fe9c5cddb7e01d747b4611c3fc9eaf2c
//	@Test
	void AuthorozationKey() {
		
		RestAssured.baseURI="https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=matric&cnt=7";
		
		given()
			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		.when()
			.get(baseURI)
		.then().log().all().statusCode(200);
		
		
		
	}	
	
	@Test
	void AuthorozationKey2() {
		
		RestAssured.baseURI="https://api.openweathermap.org/";
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.basePath("data/2.5/forecast/daily");
		reqSpec.queryParam("q", "Delhi");
		reqSpec.queryParam("units", "matric");
		reqSpec.queryParam("cnt", "7");
		reqSpec.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c");
		Response res= reqSpec.when().get();
		ValidatableResponse valRes= res.then().log().all().statusCode(200);
		
		System.out.println(valRes);
		
		
	}	
	
}

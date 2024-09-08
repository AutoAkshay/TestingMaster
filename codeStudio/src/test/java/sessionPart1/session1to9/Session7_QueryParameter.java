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

public class Session7_QueryParameter{

	@Test
	void test01() {
		
//		given()
//			.pathParams("mypath","users")		
//			.queryParam("page", "2")		
//		.when()
//			.get("https://reqres.in/api/{mypath}")		
//		.then()
//			.log().all();
		
		//second type
		
		RequestSpecification resSpec= RestAssured.given();
		resSpec.baseUri("https://reqres.in/");//https://reqres.in/api/users?page=2&id=10
		resSpec.basePath("api/users");
		resSpec.queryParam("page", 2).queryParam("id", "10");
		
		Response response= resSpec.get();
		ResponseBody body= response.getBody();
		String resBody=body.asString();
		
		JsonPath jsonPath= body.jsonPath();
		
		String first_name=jsonPath.get("data.first_name");
		
		System.out.println(resBody);
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Byron");
	}	
	
}

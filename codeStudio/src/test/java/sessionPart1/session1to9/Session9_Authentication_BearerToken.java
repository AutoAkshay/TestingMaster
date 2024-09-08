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
import io.restassured.specification.LogSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Session9_Authentication_BearerToken{

	@Test
	void bearerToken() {
		
		String bearerToken="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";
		RequestSpecification reqSpec= RestAssured.given().header("Authorization", "Bearer " + bearerToken);
		
		reqSpec.baseUri("http://api.github.com/");
		reqSpec.basePath("user/repos");
		
		Response res= reqSpec.get();
		
		ResponseBody body=res.getBody();
		
		String resBody=body.asString();
		
		System.out.println(resBody);
		
		
//		given()
//		.header("Authorization","Bearer "+ bearerToken)
//		.when()
//			.get("http://api.github.com/user/repos")		
//		.then().log().all();
		
	}	
	
}

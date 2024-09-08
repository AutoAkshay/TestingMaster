package sessionPart1.session1to9;

import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Session2_IntroOfRestAssured{
	
	@Test
	void getRequest() {
		
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		
		System.out.println(res.asString());
		
		System.out.println(res.statusCode());
		System.out.println(res.timeIn(TimeUnit.MILLISECONDS));
	}
}

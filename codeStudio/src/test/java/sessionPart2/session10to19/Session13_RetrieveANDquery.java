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
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

public class Session13_RetrieveANDquery {

	@Test
	void RetrieveANDquery() {
		
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "Akshay");
		jsonData.put("job", "Tester");
		
		RequestSpecification resSpec= given()
			.body(jsonData.toString())
			.contentType(ContentType.JSON)
			.header("name","Akshay");
		resSpec.baseUri("https://reqres.in/");
		resSpec.basePath("api/users");
		Response res= resSpec.post();
		
		QueryableRequestSpecification querySpec=SpecificationQuerier.query(resSpec);
		
		String baseBody=querySpec.getBody();
		String basePath=querySpec.getBasePath();
		String baseURI=querySpec.getBaseUri();
		
		System.out.println("Base body:: "+baseBody);
		System.out.println("Base path:: "+basePath);
		System.out.println("Base URI:: "+baseURI);
		Headers headers=querySpec.getHeaders();
		for (Header header : headers) {
			System.out.println("--------Headers Details-----------");
			System.out.println(header.getName() +"::"+header.getValue());
			System.out.println("--------------------------------------------------");
		}
		
	}

}

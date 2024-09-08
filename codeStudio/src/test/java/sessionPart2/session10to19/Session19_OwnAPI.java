package sessionPart2.session10to19;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.LogSpecification;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;

public class Session19_OwnAPI {
	@Test
	void OwnAPI() {
		
		HashMap map=new HashMap<>();
		
		map.put("name", "Akshay");
		map.put("location", "India");
		map.put("phone", "788740");		
		String[] courses= {"C++","JAVA"};		
		map.put("courses", courses);
		
		Response response=  given().body(map).contentType(ContentType.JSON)
		
		.when().get("http://localhost:3000/students");
		
		ValidatableResponse valRes= response.then().log().all();
//		String id=response.jsonPath().get("id");
//		
//		System.out.println(id);
	}
}

package sessionPart3.session20to29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.RequestBuilder;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;


public class Session29_ResponseSpecificationAndResponseSpecBuilder {

	ResponseSpecification res=null;
	
	@BeforeMethod
	public void statusValidation() {
		
		ResponseSpecBuilder builder=new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectStatusLine("HTTP/1.1 200 OK");
		builder.expectContentType(ContentType.JSON);
		builder.expectResponseTime(Matchers.lessThan(2000L));
		
		res= builder.build();
	}
	
	@Test
	public void createUser() throws JsonProcessingException {
		
        RestAssured.baseURI = "https://reqres.in/api/users";        
        RequestSpecification reqSpec = RestAssured.given();        
        Response response = reqSpec.get();
        ValidatableResponse valRes = response.then().spec(res);
        
	}
}

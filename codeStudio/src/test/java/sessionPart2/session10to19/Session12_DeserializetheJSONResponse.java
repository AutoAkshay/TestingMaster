package sessionPart2.session10to19;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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


class DataDetails{
	
	private String name;
	private String job;
	private String id;
	private String createdAt;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}	
}
public class Session12_DeserializetheJSONResponse {

	@Test
	void DeserializetheJSONResponse() throws JsonMappingException, JsonProcessingException {
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "Akshay Kalam");
		jsonObject.put("job", "Automation Engineer");
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.body(jsonObject.toString());
		reqSpec.contentType(ContentType.JSON);
		
		Response res=reqSpec.post();
		ResponseBody resBody=res.getBody();
		
		String body=resBody.asString();
		
//		ValidatableResponse valRes= res.then().log().all();
		
		ObjectMapper mapper=new ObjectMapper();
		
		DataDetails data=mapper.readValue(body, DataDetails.class);
		
		System.out.println("Name :: "+data.getName());
		System.out.println("Job Type:: "+data.getJob());
		System.out.println("Created time :: "+data.getCreatedAt());
		System.out.println("ID :: "+data.getId());
		
		Assert.assertEquals(data.getName(), "Akshay Kalam");
		
	}

}

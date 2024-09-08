package sessionPart3.session20to29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
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
import io.restassured.specification.SpecificationQuerier;


public class Session28_AddHeaders {

	@Test
	public void createUser() throws JsonProcessingException {
		
        Map<String, String> header = new HashMap<>();
        header.put("Header1", "CheckHeader1");
        header.put("Header2", "CheckHeader2");
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Akshay");
        jsonObject.put("job", "Software Engineer");
        
        RestAssured.baseURI = "https://reqres.in/api/users";
        
        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.headers(header);
        reqSpec.header("Header3","CheckHeader3");
        reqSpec.body(jsonObject.toString());
        reqSpec.contentType(ContentType.JSON);
        reqSpec.log().headers();
        
        Response res = reqSpec.post();
        ValidatableResponse valRes = res.then().log().all().statusCode(201);
        
		
	}
}

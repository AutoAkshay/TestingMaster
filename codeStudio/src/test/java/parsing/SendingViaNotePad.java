package parsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.io.File;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SendingViaNotePad {
	
	@Test
	void parsing() throws JsonProcessingException, FileNotFoundException {
		
		File file=new File("C:\\Users\\akshayak\\Documents\\jsonFiles\\Request.json");
		
		FileReader reader=new FileReader(file);
		
		JSONTokener tokener=new JSONTokener(reader);
		
		JSONObject data=new JSONObject(tokener);
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.body(data.toString());
		reqSpec.contentType(ContentType.JSON);
		Response res= reqSpec.post();
		
		res.then().log().all();
		
		
	}
}

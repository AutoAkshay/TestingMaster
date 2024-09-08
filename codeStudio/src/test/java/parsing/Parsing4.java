package parsing;

import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Parsing4 {
	
	@Test
	void parsing() throws IOException {
			
			File file=new File("C:\\Users\\akshayak\\Documents\\jsonFiles\\Request.json");
			FileReader fileReader=new FileReader(file);
			JSONTokener jsonTokener=new JSONTokener(fileReader);
			JSONObject jsonObject=new JSONObject(jsonTokener);
            // Set the base URI
            RestAssured.baseURI = "http://localhost:3000/data";

            // Read the JSON file content into a String
//            String jsonBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\akshayak\\Documents\\jsonFiles\\Request.json")));

            // Create a new RequestSpecification
            RequestSpecification req = RestAssured.given();

            // Set the request body to the content of the JSON file
            req.body(jsonObject.toString());

            // Set the content type to JSON
            req.header("Content-Type", "application/json");

            // Send the POST request
            Response response = req.post();

            // Print the response
            System.out.println(response.getBody().asString());
        
	}
}

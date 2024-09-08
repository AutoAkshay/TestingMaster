package parsing;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
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

public class parsingDataTesting {

	@Test
	void bodyTesting2() throws JsonProcessingException {

		String bodyInString = "{\r\n"
				+ "\"id\": \"0001\",\r\n"
				+ "\"type\": \"donut\",\r\n"
				+ "\"name\": \"Cake\",\r\n"
				+ "\"ppu\": 0.55,\r\n"
				+ "\"batters\":\r\n"
				+ "{\r\n"
				+ "\"batter\":\r\n"
				+ "[\r\n"
				+ "{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n"
				+ "{ \"id\": \"1002\", \"type\": \"Chocolate\" },\r\n"
				+ "{ \"id\": \"1003\", \"type\": \"Blueberry\" },\r\n"
				+ "{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "}\r\n"
				+ "";
		JsonPath path = new JsonPath(bodyInString);

		List<String> types = path.getList("batters.batter.type");
		List<String> ids = path.getList("batters.batter.id");

		for (int i = 0; i < types.size(); i++) {
			if (types.get(i).equals("Chocolate")) {
				System.out.println(ids.get(i));
			}
		}
	}
}

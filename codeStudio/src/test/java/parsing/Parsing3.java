package parsing;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Parsing3 {
	
	@Test
	void parsing() throws JsonProcessingException {String jsonData ="{\r\n"
			+ "	\"id\": \"0001\",\r\n"
			+ "	\"type\": \"donut\",\r\n"
			+ "	\"name\": \"Cake\",\r\n"
			+ "	\"ppu\": 0.55,\r\n"
			+ "	\"batters\":\r\n"
			+ "		{\r\n"
			+ "			\"batter\":\r\n"
			+ "				[\r\n"
			+ "					{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n"
			+ "					{ \"id\": \"1002\", \"type\": \"Chocolate\" },\r\n"
			+ "					{ \"id\": \"1003\", \"type\": \"Blueberry\" },\r\n"
			+ "					{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\r\n"
			+ "				]\r\n"
			+ "		}\r\n"
			+ "}";

		
		JSONArray jsonArray = new JSONObject(jsonData).getJSONObject("batters").getJSONArray("batter");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if (jsonObject.get("type").equals("Chocolate")) {
				System.out.println(jsonObject.get("id"));
				break;
			}
		}
	}
}

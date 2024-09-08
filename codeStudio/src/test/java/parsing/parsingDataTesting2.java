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

public class parsingDataTesting2 {

	@Test
	void bodyTesting2() throws JsonProcessingException {
		RestAssured.baseURI = "http://localhost:3000/Employees";

		RequestSpecification reqSpec = RestAssured.given();

		Response res = reqSpec.get();

		ResponseBody body = res.getBody();

		String bodyInString = body.asString();
		JsonPath path = new JsonPath(bodyInString);

		List<Integer> salaries = path.getList("salary");
		List<String> names = path.getList("firstName");
		List<Object> ids = path.getList("id");
		
//		System.out.println("Name at 10:: "+names.get(10));
		
		for (int i = 0; i < ids.size(); i++) {
			
			Integer salary = salaries.get(i);
			String name = names.get(i);
			Object id=ids.get(i);
			if (salary < 100000) {
				System.out.println(id+". "+ name+ " Salary is " + ":: " + salary);
				System.out.println();
			}
		}
	}
}

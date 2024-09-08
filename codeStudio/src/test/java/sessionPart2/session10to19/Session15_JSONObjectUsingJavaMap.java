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

public class Session15_JSONObjectUsingJavaMap {
	@Test
	void JSONObjectUsingJavaMap() {
		
		HashMap map=new HashMap<>();
		map.put("name", "Akshay");
		map.put("job", "QA");
		map.put("salary", "20000");
		String courses[]= {"C++","JAVA"};
		map.put("course", courses);
		
		RequestSpecification reqSpec=RestAssured.given().body(map).contentType(ContentType.JSON.toString());
		reqSpec.baseUri("https://reqres.in/");
		reqSpec.basePath("api/users");
		Response res= reqSpec.post();
		
		ValidatableResponse valRes= res.then().log().all();
		
		int id=res.jsonPath().getInt("id");
		
		System.out.println(id);
		
	}
}

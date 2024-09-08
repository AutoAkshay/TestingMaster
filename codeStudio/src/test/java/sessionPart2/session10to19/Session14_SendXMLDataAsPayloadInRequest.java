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

public class Session14_SendXMLDataAsPayloadInRequest {
	
//	@Test
	void SendjsonDataAsPayloadInRequest() {
		
		String jsonData="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		RequestSpecification resSpec=RestAssured.given();
		resSpec.baseUri("https://petstore.swagger.io/");
		resSpec.basePath("v2/pet");
		resSpec.header("accept", "application/json");
		resSpec.header("Content-Type", "application/json");
		resSpec.body(jsonData);
		resSpec.contentType(ContentType.JSON.toString());
		
		Response res= resSpec.post();
		
		ResponseBody resBody=res.getBody();
		
		System.out.println(resBody.asPrettyString());
		
		Assert.assertEquals(200, res.statusCode(),"not matching");
		
		res.then().body("pet.name", equalTo("doggie"));		
	}

//	@Test
	void SendXMLDataAsPayloadInRequest() {
		
		String xmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		RequestSpecification resSpec=RestAssured.given();
		resSpec.baseUri("https://petstore.swagger.io/");
		resSpec.basePath("v2/pet");
		resSpec.header("accept", "application/xml");
		resSpec.header("Content-Type", "application/xml");
		resSpec.body(xmlData);
		resSpec.contentType(ContentType.XML);
		
		Response res= resSpec.post();
		
		ResponseBody resBody=res.getBody();
		
		System.out.println(resBody.asPrettyString());
		
		Assert.assertEquals(200, res.statusCode(),"not matching");
		
		res.then().body("pet.name", equalTo("doggie"));
		
		
	}
	
	@Test
	void SendXMLDataAsPayloadInRequest2() {
		String xmldata="<travelerinformationresponse>\r\n"
				+ "    <per_page>10</per_page>\r\n"
				+ "    <total_records>5622</total_records>\r\n"
				+ "    <total_pages>563</total_pages>\r\n"
				+ "    <travelers>\r\n"
				+ "        <travelinformation>\r\n"
				+ "            <id>1</id>\r\n"
				+ "            <name>John Doe</name>\r\n"
				+ "            <address>1234 Elm Street</address>\r\n"
				+ "            <email>johndoe@example.com</email>\r\n"
				+ "            <createdAt>2024-07-28</createdAt>\r\n"
				+ "        </travelinformation>\r\n"
				+ "        <travelinformation>\r\n"
				+ "            <id>2</id>\r\n"
				+ "            <name>Jane Smith</name>\r\n"
				+ "            <address>5678 Oak Avenue</address>\r\n"
				+ "            <email>janesmith@example.com</email>\r\n"
				+ "            <createdAt>2024-07-28</createdAt>\r\n"
				+ "        </travelinformation>\r\n"
				+ "        <travelinformation>\r\n"
				+ "            <id>3</id>\r\n"
				+ "            <name>Michael Johnson</name>\r\n"
				+ "            <address>91011 Maple Road</address>\r\n"
				+ "            <email>michaeljohnson@example.com</email>\r\n"
				+ "            <createdAt>2024-07-28</createdAt>\r\n"
				+ "        </travelinformation>\r\n"
				+ "        <travelinformation>\r\n"
				+ "            <id>4</id>\r\n"
				+ "            <name>Emily Davis</name>\r\n"
				+ "            <address>1213 Birch Lane</address>\r\n"
				+ "            <email>emilydavis@example.com</email>\r\n"
				+ "            <createdAt>2024-07-28</createdAt>\r\n"
				+ "        </travelinformation>\r\n"
				+ "        <travelinformation>\r\n"
				+ "            <id>5</id>\r\n"
				+ "            <name>David Brown</name>\r\n"
				+ "            <address>1415 Cedar Street</address>\r\n"
				+ "            <email>davidbrown@example.com</email>\r\n"
				+ "            <createdAt>2024-07-28</createdAt>\r\n"
				+ "        </travelinformation>\r\n"
				+ "    </travelers>\r\n"
				+ "</travelerinformationresponse>\r\n"
				+ "";
		
		XmlPath path=new XmlPath(xmldata);
		
		String details=path.get("travelerinformationresponse.travelers.travelinformation[0].email").toString();
		
//		System.out.println(details);
		Assert.assertEquals(details, "johndoe@example.com","not matching");
		List<Object> totalTraveller=path.getList("travelerinformationresponse.travelers.travelinformation");
		System.out.println(totalTraveller.size()); 
	}
}

package sessionPart2.session10to19;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

public class Session17_JSONObjectUsingJacksonAPI {
	@Test
	void JSONObjectUsingJavaMap() throws IOException {
		
		ObjectMapper mapper=new ObjectMapper();
		
		ObjectNode node= mapper.createObjectNode();
		node.put("First Name", "Akshay");
		node.put("Last Name", "Kalam");
		node.put("age", "31");
		node.put("Salary","31000");
		node.put("is Married", true);
		
		ObjectNode skillNode=mapper.createObjectNode();
		skillNode.put("Language", "Java");
		skillNode.put("WebAutomation", "Selenium");
		skillNode.put("API Testing", "Rest Assured");
		
		node.set("skill", skillNode);
		
		String details=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
		
		System.out.println(details);
		
		String firstName=node.get("First Name").asText();
		
		System.out.println(firstName);
		
		Map<String,String> map=new HashMap<>();
		
		
		Iterator<String> itr=node.fieldNames();
		System.out.println("\n*********** Fields Name ***************");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Iterator<JsonNode> values= node.elements();
		System.out.println("\n*********** Fields value ***************");
		while(values.hasNext()) {
			System.out.println(values.next());
		}
		
		System.out.println("\n*********** Field Key = Fields Name ***************");
		Iterator<Entry<String, JsonNode>> allFields=node.fields();
		
		while(allFields.hasNext()) {
			System.out.println(allFields.next());
		}
		
		node.remove("First Name").asText();
		
		System.out.println("Node after removing value:: "+node.toPrettyString());
	}
}

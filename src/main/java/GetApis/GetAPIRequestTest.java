package GetApis;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPIRequestTest {
	
	//via ann0tati0ns
	@Test
	public void getUsers()
	{
		// given().parameters("firstName", "John", "lastName", "Doe").when().post("/greetXML").then().body("greeting.firstName", equalTo("John"));
		 

		RestAssured.baseURI = "https://fakestoreapi.com";
		RequestSpecification req = RestAssured.given();
		Response res = RestAssured.get("/users");
		System.out.println("Resp " + res.statusCode());
		
		//Asserti0ns
		Assert.assertEquals(res.statusCode(), 200);
		
		System.out.println("Status Msg "+ res.statusLine());
		
		//fetch res b0dy
		
		//res.prettyPrint();
		System.out.println(res.asString());
		System.out.println("Headers" + res.headers().asList());
		List <Header>  h = res.getHeaders().asList();
		for (Header x: h) {
			System.out.println(x.getName() + " "+ "=" + x.getValue());
		}
		
	}
    
	
	@Test
	public void geWeatherUsingQueryParams()
	{
		//http://api.weatherapi.com/v1/current.json?key=&q=London&aqi=no

		RestAssured.baseURI = "https://api.weatherapi.com";
		RequestSpecification request = RestAssured.given();
		request.header("key", "");
		request.queryParam("q", "London");
		request.queryParam("api", "no");
		System.out.println("Wethaer Statius Cde " + request.get("/v1/current").statusCode());
	}
}

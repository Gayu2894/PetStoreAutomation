package api.endPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.response.Response;

public class userEndpoints {

	public static Response createUser(User payload)
	 {
		 Response res=given()
				      .accept("application/json")
		              .contentType("application/json")
		              .body(payload)
		 
		 .when()
		    .post(Routes.postUrl);
	       
		 return res;
		 
	 }
	
	public static Response readUser(String Username)
	 {
		 Response res=given()
				      .accept("application/json")
				      .pathParam("username", Username)
		  .when()
		    .get(Routes.getUrl);
	       
		 return res;
		 
	 }
	
	public static Response updateUser(User payload, String Username)
	 {
		Response res=given()
			      .accept("application/json")
	              .contentType("application/json")
	              .pathParam("username", Username)
	              .body(payload)
	 
	    .when()
	       .put(Routes.updateUrl);
     
	    return res;
	 }
	
	public static Response deleteUser(String Username)
	 {
		 Response res=given()
				      .accept("application/json")
				      .pathParam("username", Username)
		  .when()
		    .delete(Routes.deleteUrl);
	       
		 return res;
		 
	 }
	
}

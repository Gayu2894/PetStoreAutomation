package api.endPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.response.Response;

public class userEndpoints2 {
	
	static ResourceBundle getUrl()
	{
	ResourceBundle Routes= ResourceBundle.getBundle("Routes");
	return Routes;
	}
	
	public static Response createUser(User payload)
	 {
		
		String postUrl= getUrl().getString("post_Url");
		 Response res=given()
				      .accept("application/json")
		              .contentType("application/json")
		              .body(payload)
		 
		 .when()
		    .post(postUrl);
	       
		 return res;
		 
	 }
	
	public static Response readUser(String Username)
	 {
		String getUrl= getUrl().getString("get_Url");
		 Response res=given()
				      .accept("application/json")
				      .pathParam("username", Username)
		  .when()
		    .get(getUrl);
	       
		 return res;
		 
	 }
	
	public static Response updateUser(User payload, String Username)
	 {
		String updateUrl= getUrl().getString("update_Url");
		Response res=given()
			      .accept("application/json")
	              .contentType("application/json")
	              .pathParam("username", Username)
	              .body(payload)
	 
	    .when()
	       .put(updateUrl);
     
	    return res;
	 }
	
	public static Response deleteUser(String Username)
	 {
		String deleteUrl= getUrl().getString("delete_Url");
		 Response res=given()
				      .accept("application/json")
				      .pathParam("username", Username)
		  .when()
		    .delete(deleteUrl);
	       
		 return res;
		 
	 }
	
}

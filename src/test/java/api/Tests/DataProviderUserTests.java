package api.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Utilities.DataProviders;
import api.endPoints.userEndpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class DataProviderUserTests {

	
	User userPayload;

	@Test(priority=1,dataProvider="data",dataProviderClass=DataProviders.class)
	public void postTest(String id,String uname,String fname,String lname,String email,String pwd,String ph)
	{
		userPayload= new User();
	     
	     userPayload.setId(Integer.parseInt(id));
	     userPayload.setUsername(uname);
	     userPayload.setFirstName(fname);
	     userPayload.setLastName(lname); 
	     userPayload.setEmail(email); 
	     userPayload.setPassword(pwd); 
	     userPayload.setPhone(ph); 
	     System.out.println("Id: "+userPayload.getId());
	     System.out.println("UserName: "+ userPayload.getUsername());
	     System.out.println("FirstName: "+userPayload.getFirstName());
	     System.out.println("LastName: "+userPayload.getLastName());
	     System.out.println("Email: "+userPayload.getEmail());
	     System.out.println("Password: "+userPayload.getPassword());
	     System.out.println("Phone: "+userPayload.getPhone());
	    
	    
		Response Response =userEndpoints.createUser(userPayload);
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider="Usernames",dataProviderClass=DataProviders.class)
	public void getTest(String uname)
	{
		
		Response Response =userEndpoints.readUser(uname);
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	
	//@Test(priority=3) -yet to change the script
	public void putTest()
	{
		 
		Response Response =userEndpoints.updateUser(userPayload,this.userPayload.getUsername());
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	
	@Test(priority=4,dataProvider="Usernames",dataProviderClass=DataProviders.class)
	public void deleteTest(String uname)
	{
		Response Response =userEndpoints.deleteUser(uname);
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	
}

	


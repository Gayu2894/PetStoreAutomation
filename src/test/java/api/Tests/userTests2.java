package api.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.userEndpoints;
import api.endPoints.userEndpoints2;
import api.payloads.User;
import io.restassured.response.Response;

public class userTests2 {
	
	Faker faker ;
	User userPayload;
	
	@BeforeMethod
	@BeforeClass
	public void setUp()
	{
		
	 faker = new Faker();
     userPayload= new User();
     
     userPayload.setId(faker.idNumber().hashCode());
     userPayload.setUsername(faker.name().username());
     userPayload.setFirstName(faker.name().firstName());
     userPayload.setLastName(faker.name().lastName()); 
     userPayload.setEmail(faker.internet().emailAddress()); 
     userPayload.setPassword(faker.internet().password(6, 8)); 
     userPayload.setPhone(faker.phoneNumber().cellPhone()); 
     userPayload.setUserStatus(0); 
     System.out.println("Id: "+userPayload.getId());
     System.out.println("UserName: "+ userPayload.getUsername());
     System.out.println("FirstName: "+userPayload.getFirstName());
     System.out.println("LastName: "+userPayload.getLastName());
     System.out.println("Email: "+userPayload.getEmail());
     System.out.println("Password: "+userPayload.getPassword());
     System.out.println("Phone: "+userPayload.getPhone());
     System.out.println("Status: "+userPayload.getUserStatus());
    }
	
	
	@Test(priority=1)
	public void postTest()
	{
		Response Response =userEndpoints2.createUser(userPayload);
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void getTest()
	{
		
		Response Response =userEndpoints2.readUser(this.userPayload.getUsername());
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3)
	public void putTest()
	{
		userPayload.setFirstName(faker.name().firstName());
	    userPayload.setLastName(faker.name().lastName()); 
	    userPayload.setEmail(faker.internet().emailAddress()); 
		Response Response =userEndpoints2.updateUser(userPayload,this.userPayload.getUsername());
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	
	//@Test(priority=4)
	public void deleteTest()
	{
		Response Response =userEndpoints2.deleteUser(this.userPayload.getUsername());
		Response.then().log().all();
		Assert.assertEquals(Response.getStatusCode(), 200);
		
	}
	

}

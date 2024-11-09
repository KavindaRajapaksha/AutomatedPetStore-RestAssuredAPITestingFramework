package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import api.dataConstents.ConstantValues;
import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	User userPayload;
	SoftAssert softAssert=new SoftAssert();
	
	public Logger logger;
	@BeforeClass
	public void setup() {
	  faker=new Faker();
	  userPayload=new User();
	  
	  userPayload.setId(faker.idNumber().hashCode());
	  userPayload.setUsername(faker.name().username());
	  userPayload.setFirstName(faker.name().firstName());
	  userPayload.setLastName(faker.name().lastName());
	  userPayload.setEmail(faker.internet().safeEmailAddress());
	  userPayload.setPassword(faker.internet().password(5,10));
	  userPayload.setPhone(faker.phoneNumber().cellPhone());
	  
	  //logs
	  logger = LogManager.getLogger(this.getClass());
	  
	}

	@Test(description="TC-001",priority=1)
	public void testPostUser() {
		logger.info("*****testPostUser*****");
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		int statusCode=response.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
	@Test(description="TC-002",priority=2)
	public void getUserByName() {
		logger.info("*****getUserByName*****");
		Response response=UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		int statusCode=response.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
	@Test(description="TC-003",priority=3)
	public void updateUserByUserName() {
		//update data using payload
		logger.info("*****updateUserByUserName*****");
		  userPayload.setFirstName(faker.name().firstName());
		  userPayload.setLastName(faker.name().lastName());
		  userPayload.setEmail(faker.internet().safeEmailAddress());
		  
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		int statusCode=response.getStatusCode();
		Response updatedResponse=UserEndPoints.readUser(this.userPayload.getUsername());
		updatedResponse.then().log().all();
		int updatedResponseStatusCode=updatedResponse.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertEquals(updatedResponseStatusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
	@Test(description="TC-004",priority=4)
	public void deleteUserByUserName() {
		logger.info("*****deleteUserByUserName*****");
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		int statusCode=response.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
}

package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import api.dataConstents.ConstantValues;
import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	SoftAssert softAssert=new SoftAssert();
	public Logger logger;
	@BeforeClass
	public void setup() {
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(description="Create-Users",priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userId,String userName,String fname,String lname,String userEmail,String pwd,String ph) {
		logger.info("*****testDDPostUser*****");
		User userPayload=new User();
		  userPayload.setId(Integer.parseInt(userId));
		  userPayload.setUsername(userName);
		  userPayload.setFirstName(fname);
		  userPayload.setLastName(lname);
		  userPayload.setEmail(userEmail);
		  userPayload.setPassword(pwd);
		  userPayload.setPhone(ph);
		  
		  Response response=UserEndPoints.createUser(userPayload);
		  softAssert.assertEquals(response.getStatusCode(),ConstantValues.successStatusCode);
		  softAssert.assertAll();
	}
	
	@Test(description="Get-Users",priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testGetUserByUserNames(String userName) {
		logger.info("*****testDDGetUserByUserNames*****");
		Response response=UserEndPoints.readUser(userName);
		softAssert.assertEquals(response.getStatusCode(),ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
	
	@Test(description="Delete-Users",priority=3,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteByUserNames(String userName){
		logger.info("*****testDeleteByDDUserNames*****");
		Response response=UserEndPoints.deleteUser(userName);
		softAssert.assertEquals(response.getStatusCode(),ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
}

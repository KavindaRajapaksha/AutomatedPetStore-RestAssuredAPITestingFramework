package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import api.dataConstents.ConstantValues;
import api.endpoints.StoreEndPoints;
import api.payloads.Store;
import io.restassured.response.Response;


public class StoreTests {
	Faker faker;
	Store storePayload;
	SoftAssert softAssert=new SoftAssert();
	
	public Logger logger;
	@BeforeClass
	public void setup() {
	    faker = new Faker();
	    storePayload = new Store();
	    
	    storePayload.setId(faker.number().randomDigitNotZero());
	    storePayload.setPetId(faker.number().randomDigitNotZero());
	    storePayload.setQuantity(faker.number().numberBetween(1, 10));
	    storePayload.setStatus(faker.options().option("pending", "shipped", "delivered"));
	    storePayload.setComplete(faker.bool().bool());
	    
	    logger = LogManager.getLogger(this.getClass());
	}
	

	@Test(description="TC-009",priority=1)
	public void placeOrder() {
		logger.info("*****placeOrder*****");
		Response response=StoreEndPoints.placeOrder(storePayload);
		response.then().log().all();
		int statusCode=response.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
	@Test(description="TC-010",priority=2)
	public void getOrderByOrderId() {
		logger.info("*****getOrderByOrderId*****");
		Response response=StoreEndPoints.getOrder(this.storePayload.getId());
		response.then().log().all();
		int statusCode=response.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
	@Test(description="TC-011",priority=2)
	public void getInventory() {
		logger.info("*****getInventory*****");
		Response response=StoreEndPoints.getInventory();
		response.then().log().all();
		int statusCode=response.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
	@Test(description="TC-012",priority=4)
	public void deleteOrderByOrderId() {
		logger.info("*****deleteOrderByOrderId*****");
		Response response=StoreEndPoints.deleteOrder(this.storePayload.getId());
		response.then().log().all();
		int statusCode=response.getStatusCode();
		softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
		softAssert.assertAll();
	}
}

package api.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import api.dataConstents.ConstantValues;
import api.endpoints.PetEndPoints;
import api.payloads.Pet;
import io.restassured.response.Response;

public class PetTest {

	Faker faker;
	Pet petPayload;
	SoftAssert softAssert=new SoftAssert();
	public Logger logger;
	
	  @BeforeClass
	    public void setup() {
	        faker = new Faker();
	        petPayload = new Pet();

	        petPayload.setId(faker.idNumber().hashCode());
	        petPayload.setName(faker.animal().name());
	        petPayload.setStatus(faker.options().option("available", "sold", "pending"));
	        petPayload.setPhotoUrls(List.of(faker.internet().url(), faker.internet().url()));
	        
	        logger = LogManager.getLogger(this.getClass());
	    }
	  
	  @Test(description="TC-005",priority=1)
		public void testPostPet() {
			logger.info("*****testPostPet*****");
			Response response=PetEndPoints.createPet(petPayload);
			response.then().log().all();
			int statusCode=response.getStatusCode();
			softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
			softAssert.assertAll();
		}
	  @Test(description="TC-006",priority=2)
		public void getPetByPetId() {
			logger.info("*****getPetByPetId*****");
			Response response=PetEndPoints.getPetById(this.petPayload.getId());
			response.then().log().all();
			int statusCode=response.getStatusCode();
			softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
			softAssert.assertAll();
		}

		@Test(description="TC-007",priority=3)
		public void updatePetByPetId() {
			logger.info("*****updatePetByPetId*****");
			petPayload.setName(faker.animal().name());
		    petPayload.setStatus(faker.options().option("available", "sold", "pending"));
			  
			Response response=PetEndPoints.updatePetById(this.petPayload.getId(),this.petPayload.getName(),this.petPayload.getStatus());
			response.then().log().all();
			int statusCode=response.getStatusCode();
			Response updatedResponse=PetEndPoints.getPetById(this.petPayload.getId());
			updatedResponse.then().log().all();
			int updatedResponseStatusCode=updatedResponse.getStatusCode();
			softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
			softAssert.assertEquals(updatedResponseStatusCode,ConstantValues.successStatusCode);
			softAssert.assertAll();
		}
		@Test(description="TC-008",priority=4)
		public void deletePetByPetId() {
			logger.info("*****deletePetByPetId*****");
			Response response=PetEndPoints.deletePetById(this.petPayload.getId());
			response.then().log().all();
			int statusCode=response.getStatusCode();
			softAssert.assertEquals(statusCode,ConstantValues.successStatusCode);
			softAssert.assertAll();
		}
	
}

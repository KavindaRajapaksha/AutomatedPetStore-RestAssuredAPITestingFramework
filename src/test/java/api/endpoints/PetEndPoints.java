package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	public static Response createPet(Pet payload){
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		  .post(Routes.post_pet_url);
		return response;
	}
	
	public static Response getPetById(int petId){
		Response response=given()
		   .accept(ContentType.JSON)
		   .pathParam("petId", petId)
		.when()
		  .get(Routes.get_pet_url);
		return response;
	}
	public static Response updatePetById(int petId, String name, String status) {
	    Response response = given()
	        .contentType(ContentType.URLENC)
	        .accept(ContentType.JSON)
	        .pathParam("petId", petId)
	        .formParam("name", name)
	        .formParam("status", status)
	    .when()
	        .post(Routes.update_pet_url);

	    return response;
	}
	public static Response deletePetById(int petId){
		Response response=given()
				   .accept(ContentType.JSON)
				   .pathParam("petId", petId)
				.when()
				  .delete(Routes.delete_pet_url);
			return response;
	}
}

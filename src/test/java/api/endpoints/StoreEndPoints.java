package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	public static Response placeOrder(Store payload){
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		  .post(Routes.post_order_url);
		return response;
	}
	public static Response getOrder(int orderId){
		Response response=given()
		   .accept(ContentType.JSON)
		   .pathParam("orderId", orderId)
		.when()
		  .get(Routes.get_order_by_id_url);
		return response;
	}
	public static Response getInventory(){
		Response response=given()
		   .accept(ContentType.JSON)
		.when()
		  .get(Routes.get_inventory_url);
		return response;
	}
	public static Response deleteOrder(int orderId){
		Response response=given()
		   .accept(ContentType.JSON)
		   .pathParam("orderId", orderId)
		.when()
		  .delete(Routes.delete_order_by_id_url);
		return response;
	}	
}

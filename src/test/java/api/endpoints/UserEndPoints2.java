package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints2 {
	
	static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties for get url s
		return routes;
	}
	
	public static Response createUser(User payload){
		String post_user_url=getURL().getString("post_user_url");
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		  .post(post_user_url);
		return response;
	}
	
	public static Response readUser(String userName){
		String get_user_url=getURL().getString("get_user_url");
		Response response=given()
		   .accept(ContentType.JSON)
		   .pathParam("username", userName)
		.when()
		  .get(get_user_url);
		return response;
	}
	
	public static Response updateUser(String userName,User payload){
		String update_user_url=getURL().getString("update_user_url");
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username", userName)
		   .body(payload)
		.when()
		  .put(update_user_url);
		return response;
	}
	
	public static Response deleteUser(String userName){
		String delete_user_url=getURL().getString("delete_user_url");
		Response response=given()
		   .accept(ContentType.JSON)
		   .pathParam("username", userName)
		.when()
		  .delete(delete_user_url);
		return response;
	}
	
}

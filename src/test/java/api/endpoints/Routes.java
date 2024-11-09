package api.endpoints;

/*
 swagger uri--->https:https://petstore.swagger.io/v2/
 
 create user(post)--->https://petstore.swagger.io/v2/user
 get user(get)---->https://petstore.swagger.io/v2/{username}
 update user(put) ---->https://petstore.swagger.io/v2/user/{username}
 delete user(delete) ----->https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	public static String base_url="https://petstore.swagger.io/v2/";
	
	//user model url
	public static String post_url=base_url+"user";
	public static String get_url=base_url+"user/{username}";
	public static String update_url=base_url+"user/{username}";
	public static String delete_url=base_url+"user/{username}";
	
	//store model url
	public static String post_order_url=base_url+"store/order";
	public static String get_order_by_id_url=base_url+"store/order/{orderId}";
	public static String get_inventory_url=base_url+"store/inventory";
	public static String delete_order_by_id_url=base_url+"store/order/{orderId}";
	
	//pet model url 
	public static String post_pet_url=base_url+"pet";
	public static String get_pet_url=base_url+"pet/{petId}";
	public static String update_pet_url=base_url+"pet/{petId}";
	public static String delete_pet_url=base_url+"pet/{petId}";
}

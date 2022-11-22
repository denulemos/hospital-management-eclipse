package statics;

import models.UserModel;

public class UserStatic {
	public static UserModel currentUser;
	 public static UserModel setGlobalUser (String name, String lastname, String id, String specialty, int price) {
	       UserModel user = new UserModel(name, lastname, id, specialty, price, null);
	       currentUser = user;
	       return user;
	   }
}

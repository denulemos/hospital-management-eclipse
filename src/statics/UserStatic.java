package statics;

import models.UserModel;

public class UserStatic {
	public static UserModel currentUser;
	 public static UserModel setGlobalUser (UserModel user) {
	       currentUser = user;
	       return user;
	   }
}

package com.capgemini.online_test.dao;
import com.capgemini.online_test.util.*;
import java.util.HashMap;

import com.capgemini.online_test.dto.*;

public class AccessUserIdRepo {
	
	public static User getUserObject(long userId) {
		//this function returns the user object by taking user id
	  HashMap<Long,User> map=Userid_Rep.gettable();
	  return map.get(userId);
	}
	public static void putUserObject(User obj) {
		//this function is pushing the modified user data into userIdReository
		Userid_Rep.putData(obj);
	}
	public static void putUserObject() {
		Userid_Rep.putData(new User("shahil",11615915,true,null,"Abc-1234"));
		Userid_Rep.putData(new User("harish",11605004,false,null,"Abc-1235"));
		Userid_Rep.putData(new User("satish",11604993,false,null,"Abc-1236"));
	}
}

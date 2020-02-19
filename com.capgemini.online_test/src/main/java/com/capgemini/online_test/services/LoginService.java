package com.capgemini.online_test.services;
import com.capgemini.online_test.dao.*;
import java.util.Scanner;
import com.capgemini.online_test.dto.User;
import com.capgemini.online_test.util.*;
import com.capgemini.online_test.exception.*;

public class LoginService {
	long userId;
	String password;
	public static long checkLogin(long userId,String password) {
		User obj = AccessUserIdRepo.getUserObject(userId);
		try {
			if(obj==null) {
				throw new MyException("User doesn't exist/wrong userId");
			}
		try {
			if(password.equals(obj.getUserPassword())) {
				return userId;
		}
			else {
				throw new MyException("Incorrect UserId / password");
			}
	}
		finally {
			
		}
		}
		catch (MyException exp) {
			System.out.println(exp);
			Scanner input=new Scanner(System.in);
			System.out.println("Enter UserId :");
			long userId1=input.nextLong();
			System.out.println("Enter Password :");
			String password1=input.next();
			return 0;
		}
}
}

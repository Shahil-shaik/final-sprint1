package com.capgemini.online_test.UI;
import java.math.BigInteger;
import java.util.Scanner;

import com.capgemini.online_test.dao.AccessTestRepo;
import com.capgemini.online_test.dao.AccessUserIdRepo;
import com.capgemini.online_test.dao.AccessUserRepo;
import com.capgemini.online_test.dto.User;
import com.capgemini.online_test.dto.test;
import com.capgemini.online_test.services.AssignTestService;
import com.capgemini.online_test.services.LoginService;
import com.capgemini.online_test.util.Userid_Rep;

public class main {
	public static void main(String args[]) {
		AccessUserIdRepo.putUserObject();
		AccessTestRepo.putTestObject();
		AccessUserRepo.putData();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter UserId :");
		long userId=input.nextLong();
		System.out.println("Enter Password :");
		String password=input.next();
		LoginService.checkLogin(userId, password);
		System.out.println("Login Sucessful");
		System.out.println("Enter userId and TestId");
		userId=input.nextLong();
		BigInteger testId=input.nextBigInteger();
		AssignTestService.assignTest(userId, testId);
		System.out.println("END");
}
}
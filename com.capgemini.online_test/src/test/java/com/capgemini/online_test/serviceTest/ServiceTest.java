package com.capgemini.online_test.serviceTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.math.BigInteger;

import org.junit.Test;

import com.capgemini.online_test.dao.AccessTestRepo;
import com.capgemini.online_test.dao.AccessUserIdRepo;
import com.capgemini.online_test.dao.AccessUserRepo;
import com.capgemini.online_test.dto.User;
import com.capgemini.online_test.dto.test;
import com.capgemini.online_test.exception.MyException;
import com.capgemini.online_test.services.AssignTestService;
import com.capgemini.online_test.services.LoginService;
import com.capgemini.online_test.util.Userid_Rep;

public class ServiceTest {
	LoginService object=new LoginService();
	@Test
	public void AssignTestServiceTest1() {
		User obj = new User();
		obj.setIsAdmin(false);
		obj.setUserId(11614444);
		obj.setUserName("ramesh"); 
		obj.setUserPassword("Abc-123");
		AccessUserIdRepo.putUserObject(obj);
		test obj1 = new test();
		BigInteger testId=new BigInteger("112222");
		obj1.setTestId(testId);
		AccessTestRepo.putTestObject(obj1);
		AssignTestService.assignTest((long) 11614444, testId);
		assertEquals(testId,AccessUserRepo.getTestId(11614444));
	}
	@Test
	public void AssignTestServiceTest2() {
		assertNotEquals(new BigInteger("112232"),AccessUserRepo.getTestId(11614444));
	}
	@Test
	public void LoginServiceTest1() {
		User obj = new User("rajesh",11615555,false,null,"Abc-12345");
		Userid_Rep.putData(obj);
		assertEquals(11615555,LoginService.checkLogin(11615555, "Abc-12345"));
		}
	@Test 
	public void LoginServiceTest2() {
		Throwable exp=assertThrows(
				MyException.class,()->{
					LoginService.checkLogin((long)11614923,"Abc-1234");
				}
				);
		assertNotEquals("User doesn't exist/wrong userId",exp.getMessage());
	}
	@Test 
	public void LoginServiceTest3() {
		MyException exp=assertThrows(
				MyException.class,()->{
					LoginService.checkLogin((long)11615915,"Abc-12345");
				}
				);
		assertEquals("Incorrect UserI / password",exp.getMessage());
	}
	
}

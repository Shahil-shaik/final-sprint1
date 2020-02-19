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
	@Test
	public void LoginServiceTest1() {
		User obj = new User("shahil",11615915,false,null,"Abc-123");
		Userid_Rep.putData(obj);
		assertEquals(11615915,LoginService.checkLogin(11615915, "Abc-123"));
		}
	@Test 
	public void LoginServiceTest2() {
		MyException exp=assertThrows(
				MyException.class,()->{
					LoginService.checkLogin((long)11615923,"Abc-123");
				}
				);
		assertEquals("Incorrect UserI / password",exp.getMessage());
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
	@Test
	public void AssignTestServiceTest1() {
		User obj = new User();
		obj.setIsAdmin(false);
		obj.setUserId(11615915);
		obj.setUserName("satish"); 
		obj.setUserPassword("Abc-123");
		AccessUserIdRepo.putUserObject(obj);
		test obj1 = new test();
		BigInteger testId=new BigInteger("123456");
		obj1.setTestId(testId);
		AccessTestRepo.putTestObject(obj1);
		AssignTestService.assignTest((long) 11615915, testId);
		assertEquals(testId,AccessUserRepo.getTestId(11615915));
	}
	@Test
	public void AssignTestServiceTest2() {
		User obj = new User();
		obj.setIsAdmin(false);
		obj.setUserId(11615915);
		obj.setUserName("satish"); 
		obj.setUserPassword("Abc-123");
		AccessUserIdRepo.putUserObject(obj);
		test obj1 = new test();
		BigInteger testId=new BigInteger("123456");
		obj1.setTestId(testId);
		AccessTestRepo.putTestObject(obj1);
		AssignTestService.assignTest((long) 11615915, testId);
		assertNotEquals(new BigInteger("12223"),AccessUserRepo.getTestId(11615915));
	}
}

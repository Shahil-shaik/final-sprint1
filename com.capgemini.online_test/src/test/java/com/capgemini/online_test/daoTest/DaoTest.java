package com.capgemini.online_test.daoTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import com.capgemini.online_test.dao.AccessTestRepo;
import com.capgemini.online_test.dao.AccessUserIdRepo;
import com.capgemini.online_test.dao.AccessUserRepo;
import com.capgemini.online_test.dto.*;

public class DaoTest {
	@Test
	public void AcessTestRepoTest1() {
		test obj = new test();
		BigInteger testId=new BigInteger("123456");
		obj.setTestId(testId);
		AccessTestRepo.putTestObject(obj);
		assertEquals(obj,AccessTestRepo.getTestObject(testId));
	}
	@Test
	public void AcessTestRepoTest2() {
		test obj = new test();
		BigInteger testId=new BigInteger("78910");
		obj.setTestId(testId);
		AccessTestRepo.putTestObject(obj);
		assertNotEquals(obj,AccessTestRepo.getTestObject(new BigInteger("456123")));
	}
	@Test
	public void AccessUserrepoTest1() {
		BigInteger testId=new BigInteger("12345");
		AccessUserRepo.putData((long) 11615004, testId);
		assertEquals(testId,AccessUserRepo.getTestId(11615004));
	}
	@Test
	public void AccessUserrepoTest2() {
		BigInteger testId=new BigInteger("54321");
		AccessUserRepo.putData((long) 11615101, testId);
		assertNotEquals(testId,AccessUserRepo.getTestId(11615004));
	}
	@Test
	public void AcessUserIdRepo_getUserObjectTest1() {
		User obj = new User();
		obj.setIsAdmin(false);
		obj.setUserId(11615915);
		obj.setUserName("shahil"); 
		obj.setUserPassword("Abc-123");
		AccessUserIdRepo.putUserObject(obj);
		assertEquals(obj,AccessUserIdRepo.getUserObject(11615915));
	}
	@Test
	public void AcessUserIdRepo_getUserObjectTest2() {
		User obj = new User();
		obj.setIsAdmin(false);
		obj.setUserId(11615916);
		obj.setUserName("satish"); 
		obj.setUserPassword("Abc-123");
		AccessUserIdRepo.putUserObject(obj);
		assertNotEquals(obj,AccessUserIdRepo.getUserObject(11615915));
	}
	
}

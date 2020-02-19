package com.capgemini.online_test.services;

import com.capgemini.online_test.dao.*;
import com.capgemini.online_test.dto.*;
import com.capgemini.online_test.util.*;

import java.math.BigInteger;

public class AssignTestService {
	public static void assignTest(Long userId,BigInteger testId) {
		AccessUserRepo.putData(userId,testId);
		User obj = AccessUserIdRepo.getUserObject(userId);
		test obj1=AccessTestRepo.getTestObject(testId);
		obj.setUserTest(obj1);
		AccessUserIdRepo.putUserObject(obj);
	}
}

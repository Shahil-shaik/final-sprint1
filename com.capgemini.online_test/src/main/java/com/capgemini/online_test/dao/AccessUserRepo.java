package com.capgemini.online_test.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.online_test.dto.test;
import com.capgemini.online_test.util.Test_Rep;
import com.capgemini.online_test.util.User_Rep;

public class AccessUserRepo {
	public static BigInteger getTestId(long UserId) {
		Map<Long, BigInteger> map=User_Rep.gettable();
		return map.get(UserId);
	}
	public static void putData(Long userId,BigInteger testId) {
		User_Rep.putData(userId,testId);
	}
	public static void putData() {
		User_Rep.putData((long)11605004,new BigInteger("123456"));
	}
	
}

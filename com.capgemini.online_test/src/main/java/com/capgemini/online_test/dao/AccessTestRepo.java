package com.capgemini.online_test.dao;

import java.math.BigInteger;
import java.util.HashMap;
import com.capgemini.online_test.dto.test;
import com.capgemini.online_test.util.Test_Rep;

public class  AccessTestRepo {
	public static test getTestObject(BigInteger testId) {
		HashMap<BigInteger,test> map=Test_Rep.gettable();
		return map.get(testId);
	}
	public static void putTestObject(test obj) {
		Test_Rep.putData(obj);
	}
	public static void putTestObject() {
		test obj = new test();
		obj.setTestId(new BigInteger("123456"));
		obj.setTestTitle("CA-1");
		Test_Rep.putData(obj);
	}
}

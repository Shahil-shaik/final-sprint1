package com.capgemini.online_test.util;
import com.capgemini.online_test.dto.test;
import java.math.BigInteger;
import java.util.*;
public class Test_Rep {
	static HashMap<BigInteger, test> table = new HashMap<BigInteger,test>();

	public static HashMap<BigInteger,test> gettable() {
		return table;
	}

	public void setTable(HashMap<BigInteger, test> table) 
	{
		Test_Rep.table = table;
	}
	public static void putData(test ob)
	{
		table.put(ob.getTestId(),ob);	
	}
	}
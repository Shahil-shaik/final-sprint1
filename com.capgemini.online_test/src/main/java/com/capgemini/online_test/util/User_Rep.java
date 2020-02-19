package com.capgemini.online_test.util;
import java.math.BigInteger;
import java.util.*;

import com.capgemini.online_test.dto.*;

public class User_Rep {
static Map<Long, BigInteger> table = new HashMap<Long, BigInteger>();

public static Map<Long, BigInteger> gettable() {
	return table;
}

public void setTable(Map<Long, BigInteger> table) 
{
	this.table = table;
}
public User_Rep()
{
	
}
public static void putData(Long ob,BigInteger obj)
{
table.put(ob,obj);	
}
}



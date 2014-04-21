package com.isel.lteshakedownapp.testUnity;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTest {

	private static Set<AbstractTest> testCase = null;
	
	public abstract boolean isNative();
	
	public abstract TestType getType();
	
	public abstract TestResult runTest();
	
	public abstract String getDescription();
	
	public abstract String getName();
	
	public enum TestType{
		STATIONARY, MOBILE
	}
	
	public static Set<AbstractTest> getAllTests(){
		if(testCase==null)
			buildTestCase();
		return testCase;
	}
	
	private static void buildTestCase(){
		testCase = new HashSet<AbstractTest>();
		testCase.add(new SignalStrTest());
	}
}

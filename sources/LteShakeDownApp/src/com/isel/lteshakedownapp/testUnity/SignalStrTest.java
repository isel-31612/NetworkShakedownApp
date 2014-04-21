package com.isel.lteshakedownapp.testUnity;

public class SignalStrTest extends AbstractTest {
	
	@Override
	public boolean isNative() {
		return false;
	}

	@Override
	public TestType getType() {
		return TestType.STATIONARY;
	}

	@Override
	public TestResult runTest() {
		TestResult ret = new TestResult();
		ret.originalTest = this;
		return ret;
	}

	@Override
	public String getDescription() {
		return "Measures the mobile signal strenght";
	}

	@Override
	public String getName() {
		return "Signal Strenght Test";
	}
}

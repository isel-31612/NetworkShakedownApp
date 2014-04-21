package com.isel.lteshakedownapp.async;

import com.isel.lteshakedownapp.testUnity.TestResult;

public interface IExecutableCallbacker {

	public void setSuccessfullTest(TestResult result);
	
	public android.content.Context getToastContext();
	
	public void informFinish();
}

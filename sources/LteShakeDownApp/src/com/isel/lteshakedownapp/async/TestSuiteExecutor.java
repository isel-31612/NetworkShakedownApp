package com.isel.lteshakedownapp.async;

import com.isel.lteshakedownapp.testUnity.AbstractTest;
import com.isel.lteshakedownapp.testUnity.TestResult;

import android.os.AsyncTask;
import android.widget.Toast;

public class TestSuiteExecutor extends AsyncTask<AbstractTest,TestResult,Integer> {
	
	private IExecutableCallbacker callbacker= null;

	public TestSuiteExecutor(IExecutableCallbacker callbacker){
		this.callbacker = callbacker;
	}
	@Override
	protected Integer doInBackground(AbstractTest... params) {
		int successfullTests = 0;
		for(AbstractTest test : params)
		{
			TestResult t = test.runTest();//Hard computational workload
			successfullTests++;
			
			publishProgress(t);
			
			if(isCancelled())
				break;
		}
		return successfullTests;
	}
	
	protected void onProgressUpdate(TestResult... progress) {
		for(TestResult result : progress)
			callbacker.setSuccessfullTest(result);
	}

     protected void onPostExecute(Long result) {
    	 callbacker.informFinish();
    	 String text = String.format("Executed %d tests.",result);
    	 Toast.makeText(callbacker.getToastContext(), text, Toast.LENGTH_SHORT).show();
     }
}
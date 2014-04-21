package com.isel.lteshakedownapp.android;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.isel.lteshakedownapp.R;
import com.isel.lteshakedownapp.async.IExecutableCallbacker;
import com.isel.lteshakedownapp.async.TestSuiteExecutor;
import com.isel.lteshakedownapp.storage.TestRunDAO;
import com.isel.lteshakedownapp.storage.TestRun;
import com.isel.lteshakedownapp.testUnity.AbstractTest;
import com.isel.lteshakedownapp.testUnity.TestResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class TestResultsActivity extends Activity {
	private Button backToTestButton;
	private RelativeLayout testResultsLayout;
	private TextView last=null;
	private static TestSuiteExecutor testSuite = null;//synchronization problems
	public static final String TEST_NAME_EXTRA = "TextExtra";
	private Button submitResultButton;
	private List<TestResult> resultList;
	private boolean done;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_results);
		
		backToTestButton = (Button) findViewById(R.id.backToTestButton);
		testResultsLayout = (RelativeLayout) findViewById(R.id.testResultsList);
		submitResultButton = (Button) findViewById(R.id.submitResultButton);
		submitResultButton.setEnabled(false);
		setbackToTestListener();
		setsubmitResultListener();
		
		Set<AbstractTest> tests = AbstractTest.getAllTests();
		resultList = new ArrayList<TestResult>();
		AbstractTest[] tArray = tests.toArray(new AbstractTest[0]);
		if(testSuite==null)
		{
			testSuite = generateTestSuite();
			testSuite.execute(tArray);
		}	
	}
	
	private void setbackToTestListener() {
		final Intent intent = new Intent(this,TestResultsActivity.class);
		backToTestButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
	}
	
	private void setsubmitResultListener() {
		final Intent intent = new Intent(this,SubmitResultsActivity.class);
		TestRun extra = new TestRun(resultList); 
		intent.putExtra(TEST_NAME_EXTRA, extra);
		submitResultButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
	}
	
	private void updateWithNewResult(TestResult result){
		LayoutParams lparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		TextView resultLabel=new TextView(this);
		
		if(last!=null)
			lparams.addRule(RelativeLayout.BELOW,last.getId());
		resultLabel.setLayoutParams(lparams);
		resultLabel.setText(String.format("%s => %d", result.originalTest.getName(),result.value));
		
		testResultsLayout.addView(resultLabel);
		last = resultLabel;
		resultList.add(result);
	}
	
	private TestSuiteExecutor generateTestSuite(){
		final Context ctx = this;
		return new TestSuiteExecutor(new IExecutableCallbacker() {
			@Override
			public void setSuccessfullTest(TestResult result) {
				updateWithNewResult(result);
			}
			@Override
			public Context getToastContext() {
				return ctx;
			}
			@Override
			public void informFinish() {
				done = true;
				submitResultButton.setEnabled(true);
			}
		});
	}
}


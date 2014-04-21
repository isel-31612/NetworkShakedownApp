package com.isel.lteshakedownapp.android;

import java.util.Set;

import com.isel.lteshakedownapp.R;
import com.isel.lteshakedownapp.testUnity.AbstractTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class StartTestActivity extends Activity {

	private Button startTestButton;
	private RelativeLayout startTestList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.start_test);
		startTestButton = (Button) findViewById(R.id.startTestButton);
		startTestList = (RelativeLayout) findViewById(R.id.startTestList);
		
		setStartButtonListener();
		
		Set<AbstractTest> tests = AbstractTest.getAllTests();
		TextView last = null;
		//use the same for all
		for(AbstractTest t : tests){
			LayoutParams lparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			TextView testLabel=new TextView(this);
			
			if(last!=null)
				lparams.addRule(RelativeLayout.BELOW,last.getId());
			testLabel.setLayoutParams(lparams);
			testLabel.setText(t.getName());
			
			startTestList.addView(testLabel);
			last = testLabel;
			
		}
	}
	
	private void setStartButtonListener(){
		final Intent intent = new Intent(this,TestResultsActivity.class);
		startTestButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
	}
}

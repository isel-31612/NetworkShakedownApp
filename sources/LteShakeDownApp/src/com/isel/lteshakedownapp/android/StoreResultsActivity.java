package com.isel.lteshakedownapp.android;

import com.isel.lteshakedownapp.R;
import com.isel.lteshakedownapp.storage.TestRun;
import com.isel.lteshakedownapp.storage.TestRunDAO;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StoreResultsActivity extends Activity {//TODO finish this one with event and such. Consider implementing abstract activity: PersistentActivity for common code between saving activitys
	private TestRun execution;
	private TestRunDAO DAO;
	private RelativeLayout layout;
	private Button storeTestResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit_tests);
		DAO = new TestRunDAO();
		
		if(savedInstanceState == null){
			execution = this.getIntent().getExtras().getParcelable(TestResultsActivity.TEST_NAME_EXTRA);
		}
		if(execution==null){
			TextView error = new TextView(this);
			error.setText("No results to display...");
			layout.addView(error);
		}else{
			DAO.insert(execution);
		}
		layout = (RelativeLayout) findViewById(R.id.storedTests);
		storeTestResult = (Button) findViewById(R.id.storeTestResult);
		
		setStoreListener();
	}

	private void setStoreListener() {
		storeTestResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
	}
}

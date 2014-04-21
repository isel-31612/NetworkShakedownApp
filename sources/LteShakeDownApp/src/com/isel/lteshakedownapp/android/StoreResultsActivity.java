package com.isel.lteshakedownapp.android;

import com.isel.lteshakedownapp.R;
import com.isel.lteshakedownapp.storage.TestRun;
import com.isel.lteshakedownapp.storage.TestRunDAO;

import android.app.Activity;
import android.os.Bundle;

public class StoreResultsActivity extends Activity {//TODO finish this one with event and such. Consider implementing abstract activity: PersistentActivity for common code between saving activitys
	private TestRun execution;
	private TestRunDAO DAO;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit_tests);

		if(savedInstanceState == null){
			execution = this.getIntent().getExtras().getParcelable(TestResultsActivity.TEST_NAME_EXTRA);
		}

	}
}

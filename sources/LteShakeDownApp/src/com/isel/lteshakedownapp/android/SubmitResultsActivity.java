package com.isel.lteshakedownapp.android;

import com.isel.lteshakedownapp.R;
import com.isel.lteshakedownapp.storage.TestRunDAO;
import com.isel.lteshakedownapp.storage.TestRun;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;


public class SubmitResultsActivity extends Activity {//TODO define events for submit or store
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

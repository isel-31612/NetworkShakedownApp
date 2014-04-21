package com.isel.lteshakedownapp.storage;

import java.util.ArrayList;
import java.util.List;

import com.isel.lteshakedownapp.testUnity.TestResult;

import android.os.Parcel;
import android.os.Parcelable;

public class TestRun implements Parcelable {

	private final List<TestResult> singleRun;
	
	public TestRun(Parcel in){
		singleRun = new ArrayList<TestResult>();
		in.readTypedList(singleRun, TestResult.CREATOR);
	}
	public TestRun(List<TestResult> tests) {
		singleRun = tests;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(singleRun);
	}
	
	public static final Parcelable.Creator<TestRun> CREATOR = new Parcelable.Creator<TestRun>() {

		public TestRun createFromParcel(Parcel in) {
			return new TestRun(in);
		}
		
		public TestRun[] newArray(int size) {
			return new TestRun[size];
		}
	};

}

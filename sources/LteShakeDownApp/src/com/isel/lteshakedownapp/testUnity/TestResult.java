package com.isel.lteshakedownapp.testUnity;

import android.os.Parcel;
import android.os.Parcelable;

public class TestResult implements Parcelable {//TODO fully implement parceable. originalTest doesnt need to be parceable
	public AbstractTest originalTest;
	public boolean isSuccess;
	public String error;
	public int value;
	
	public TestResult(Parcel in) {
		// TODO Auto-generated constructor stub
	}
	public TestResult() {
		isSuccess = true;
		error = "OK";
		value = 0;
	}
	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(error);
		dest.writeInt(value);
		//dest.writeBoolean(isSuccess);
	}
	
	public static final Parcelable.Creator<TestResult> CREATOR = new Parcelable.Creator<TestResult>() {

		public TestResult createFromParcel(Parcel in) {
			return new TestResult(in);
		}
		
		public TestResult[] newArray(int size) {
			return new TestResult[size];
		}
	};
}

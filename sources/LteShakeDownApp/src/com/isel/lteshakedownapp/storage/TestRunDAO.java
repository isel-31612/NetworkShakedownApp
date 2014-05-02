package com.isel.lteshakedownapp.storage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.isel.lteshakedownapp.testUnity.TestResult;

public class TestRunDAO {
	
	private final static DateFormat sdf = SimpleDateFormat.getDateInstance();
	private SQLiteDatabase bd;

	public void insert(TestRun run){
		if(run==null)
			return;
		ContentValues values = new ContentValues();
		values.clear();
		for(TestResult result : run.singleRun){
			//values.put(TestRunDAO.TEST_ID, 0); AutoIncrement
			values.put(TestRunHelper.NAME, "Name");
			values.put(TestRunHelper.CREATED, sdf.format(new Date()));
			values.put(TestRunHelper.RESULT, result.value);
			bd.insertOrThrow(TestRunHelper.DB_NAME, null, values);
		}
	}
	
	public void delete(TestRun run){
		if(run==null)
			return;
		String[] args = {run.toString()};//TODO get ID
		bd.delete(TestRunHelper.DB_NAME, TestRunHelper.TEST_ID + "=?", args);
	}
	
	public TestRun getById(int id){
		return null;//bd.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
	}
	public List<TestRun> getAll(){
		return new ArrayList<TestRun>();
	}
}
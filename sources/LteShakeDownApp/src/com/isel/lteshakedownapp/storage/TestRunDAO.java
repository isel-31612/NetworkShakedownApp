package com.isel.lteshakedownapp.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TestRunDAO extends SQLiteOpenHelper{//TODO get 2 tables, for executions and each executed test

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "execution.db";
	private static final String TABLE = "executed";
	private static final String ID = BaseColumns._ID;
	private static final String NAME = "txt";
	private static final String RESULT = "source";

	public TestRunDAO(Context ctx){
		super(ctx,DB_NAME,null,DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		String sql = "create table " + TABLE + " (" + ID + " int primary key, "
				+ RESULT + " text, " + NAME + " text)" ;
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists " + TABLE);
		onCreate(db);
	}
	
	
}

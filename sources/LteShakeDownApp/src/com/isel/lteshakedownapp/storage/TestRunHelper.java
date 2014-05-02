package com.isel.lteshakedownapp.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TestRunHelper extends SQLiteOpenHelper{

	private static final int DB_VERSION = 1;
	public static final String DB_NAME = "execution.db";
	public static final String TABLE = "executed";
	public static final String TEST_ID = BaseColumns._ID;
	public static final String NAME = "name";
	public static final String CREATED = "created";
	public static final String RESULT = "value";
	
	public TestRunHelper(Context ctx){
		super(ctx,DB_NAME,null,DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		String sql = "create table " + TABLE + " (" + TEST_ID + "INT PRIMARY KEY AUTOINCREMENT NULL, " + NAME + "text, "+ CREATED + " text, " + RESULT + " text,)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists " + TABLE);
		onCreate(db);
	}	
}

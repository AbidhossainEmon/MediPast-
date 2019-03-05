package com.example.emon.medipast;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DB_NAME="doctorInfo.DB";
    public static final int VERSION=1;

    public static final String TABLE_NAME="DoctorInfo";
    public static final String DOC_COLUM_ID="id";
    public static final String DOC_COLUM_NAME ="Name";
    public static final String DOC_COL_DETAILS ="Details";
    public static final String DOC_COL_APPOINTMENT ="Appoinentment";
    public static final String DOC_COL_PHONE ="PhoneNumber";
    public static final String DOC_COL_EMAIL ="Email";
    public static final String HISTORY_TABLE_NAME="Historyinfo";
    public static final String HISTORY_DATE="Date";
    public static final String HISTORY_IMAGE="Image";

    public static final String createTable= "create table "+TABLE_NAME+"("+DOC_COLUM_ID+ " integer primary key, " + DOC_COLUM_NAME +
            " text,"+ DOC_COL_DETAILS + " text," + DOC_COL_APPOINTMENT +" text,"+DOC_COL_PHONE+ " text,"+ DOC_COL_EMAIL +" text" + ")";

    public static final String creatHistoryTable= "create table "+HISTORY_TABLE_NAME+"("+DOC_COLUM_ID+ " integer primary key, "+DOC_COLUM_NAME+
            " text,"+DOC_COL_DETAILS+" text,"+HISTORY_DATE+" text,"+HISTORY_IMAGE+" text"+")";
    public DBhelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        db.execSQL(creatHistoryTable);
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

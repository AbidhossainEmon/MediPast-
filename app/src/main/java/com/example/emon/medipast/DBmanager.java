package com.example.emon.medipast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.emon.medipast.DBhelper.DOC_COLUM_ID;
import static com.example.emon.medipast.DBhelper.DOC_COL_APPOINTMENT;
import static com.example.emon.medipast.DBhelper.DOC_COL_DETAILS;
import static com.example.emon.medipast.DBhelper.DOC_COL_PHONE;
import static com.example.emon.medipast.DBhelper.DOC_COLUM_NAME;
import static com.example.emon.medipast.DBhelper.DOC_COL_EMAIL;
import static com.example.emon.medipast.DBhelper.HISTORY_DATE;
import static com.example.emon.medipast.DBhelper.HISTORY_IMAGE;
import static com.example.emon.medipast.DBhelper.HISTORY_TABLE_NAME;
import static com.example.emon.medipast.DBhelper.TABLE_NAME;


public class DBmanager {

    private Context context;
    private SQLiteDatabase db;
    private DBhelper helper;
    private ArrayList<person> mpersonlist;

    public DBmanager(Context context) {
        this.context = context;
        helper = new DBhelper(context);

    }

    public boolean insertStudent(person Person){


        db=helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DOC_COLUM_NAME,Person.getName());
        cv.put(DOC_COL_DETAILS,Person.getDetails());
        cv.put(DOC_COL_APPOINTMENT,Person.getAppointment());
        cv.put(DOC_COL_PHONE,Person.getPhoneNumber());
        cv.put(DOC_COL_EMAIL,Person.getEmail());

        long insertRow =db.insert(TABLE_NAME,null,cv);
        if (insertRow>0){
            db.close();
            return true;

        }
        else {
            return false;
        }

    }
    public boolean insertHistory(History history){


        db=helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DOC_COLUM_NAME,history.getName());
        cv.put(DOC_COL_DETAILS,history.getDetails());
        cv.put(HISTORY_DATE,history.getAppointment());
        cv.put(HISTORY_IMAGE,history.getImage());


        long insertRow =db.insert(HISTORY_TABLE_NAME,null,cv);
        if (insertRow>0){
            db.close();
            return true;

        }
        else {
            return false;
        }

    }

    public ArrayList<person> getAllStudent(){

        db= helper.getReadableDatabase();
        ArrayList<person> mpersonlist = new ArrayList<>();
        String query= "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {

                int id = cursor.getInt(cursor.getColumnIndex(DOC_COLUM_ID));
                String name = cursor.getString(cursor.getColumnIndex(DOC_COLUM_NAME));
                String details = cursor.getString(cursor.getColumnIndex(DOC_COL_DETAILS));
                String appointment = cursor.getString(cursor.getColumnIndex(DOC_COL_APPOINTMENT));
                String phone = cursor.getString(cursor.getColumnIndex(DOC_COL_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(DOC_COL_EMAIL));
                person Person = new person(id,name,details,appointment,phone,email);

                mpersonlist.add(Person);

            }while (cursor.moveToNext());

        }

        db.close();
        return mpersonlist;

    }
    public ArrayList<History> getAllHistoryDoctor(){
        ArrayList<History> namelisT= new ArrayList<>();
        db= helper.getReadableDatabase();
        String query= "select * from "+HISTORY_TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DOC_COLUM_ID));
                String name = cursor.getString(cursor.getColumnIndex(DOC_COLUM_NAME));
                String details = cursor.getString(cursor.getColumnIndex(DOC_COL_DETAILS));
                String historyDate = cursor.getString(cursor.getColumnIndex(HISTORY_DATE));
                String Image= cursor.getString(cursor.getColumnIndex(HISTORY_IMAGE));
                History history=new History(name,details,historyDate,Image,id);
                namelisT.add(history);

            }while (cursor.moveToNext());

        }

        db.close();
        return namelisT;

    }



    public boolean deleteStudent(int id){
        db= helper.getWritableDatabase();
        int deleteRow=db.delete(TABLE_NAME,DOC_COLUM_ID+"="+id,null);
        if (deleteRow>0){
            db.close();
            return true;
        }
        else {
            return false;
        }
    }
}


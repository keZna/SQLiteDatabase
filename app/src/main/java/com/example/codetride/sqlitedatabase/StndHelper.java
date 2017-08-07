package com.example.codetride.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by CodeTride on 2017/07/27.
 */

public class StndHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    ContentValues values;

    public static final String DATABASE_NAME = "Studentss.db";
    public static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "Students";
    public static final String _ID = "ID";
    public static final String NAME = "Name";
    public static final String SURNAME = "Surname";
    public static final String MARKS = "Marks";
    public static final String STUDENTNo = "StudentNo";
    public static final String selection = NAME + " = ? ";
    public static final String TYPE = "UPDATE";
    public static final int UPDATE_RECORD=1;
    public static final int ADD_RECORD=2;
    public static final String UPDATE="Update";
    public static final String ADD="ADD";
    public static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT NOT NULL,"
            + SURNAME + " TEXT NOT NULL,"
            + MARKS + " TEXT NOT NULL,"
            + STUDENTNo + " TEXT NOT NULL);";

    public StndHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.close();
    }

    public void AddStudent(ContactStudent contactStudent) {
        db = this.getWritableDatabase();

        values = new ContentValues();
        values.put(NAME, contactStudent.getmName());
        values.put(SURNAME, contactStudent.getmSurname());
        values.put(MARKS, contactStudent.getmMarks());
        values.put(STUDENTNo, contactStudent.getmStudentNo());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void Update(long id, String name, String surname, String marks, String studentNo) {
        db = this.getWritableDatabase();

        values = new ContentValues();
        values.put(NAME, name);
        values.put(SURNAME, surname);
        values.put(MARKS, marks);
        values.put(STUDENTNo, studentNo);
        db.update(TABLE_NAME, values, _ID + "=" + id, null);
    }

    public void update(ContactStudent contactStudent){
        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,contactStudent.getmName());
        values.put(SURNAME,contactStudent.getmSurname());
        values.put(MARKS,contactStudent.getmMarks());
        values.put(STUDENTNo, contactStudent.getmStudentNo());
        db.update(TABLE_NAME, values, _ID + " =? ", new String[]{String.valueOf(contactStudent.getmID())});
        db.close();
    }

    public int Delete(String x) {

        int count = 0;
        db = this.getWritableDatabase();
        String[] selectionArgs = {String.valueOf(x)};

        count = db.delete(TABLE_NAME,
                selection,
                selectionArgs
        );
        return count;
    }

    public void DeleteAll(){
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }

    public ArrayList<ContactStudent> getAllStudents() {
        ArrayList<ContactStudent> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        ContactStudent contactStudent;

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contactStudent = new ContactStudent();
                contactStudent.setmID(cursor.getInt(0));
                contactStudent.setmName((cursor.getString(1)));
                contactStudent.setmSurname(cursor.getString(2));
                contactStudent.setmMarks(cursor.getString(3));
                contactStudent.setmStudentNo(cursor.getString(4));
                students.add(contactStudent);
            }
        }
        cursor.close();
        db.close();
        return students;
    }
}

package com.example.codetride.sqlitedatabase;

/**
 * Created by CodeTride on 2017/07/27.
 */

public class ContactStudent {

    private String mName, mSurname, mMarks, mStudentNo;
    private int mID;

    public ContactStudent() {
    }

    public ContactStudent(int mID, String mName, String mSurname, String mMarks, String mStudentNo) {
        this.mID = mID;
        this.mName = mName;
        this.mSurname = mSurname;
        this.mMarks = mMarks;
        this.mStudentNo = mStudentNo;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int ID) {
        this.mID = ID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String Name) {
        this.mName = Name;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String Surname) {
        this.mSurname = Surname;
    }

    public String getmMarks() {
        return mMarks;
    }

    public void setmMarks(String Marks) {
        this.mMarks = Marks;
    }

    public String getmStudentNo() {
        return mStudentNo;
    }

    public void setmStudentNo(String StudentNo) {
        this.mStudentNo = StudentNo;
    }

    @Override
    public String toString() {
        return mName + " - "
                + mSurname + " - "
                + mMarks + " - "
                + mStudentNo;
    }
}

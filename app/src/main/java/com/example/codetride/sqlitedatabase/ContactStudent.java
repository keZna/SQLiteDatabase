package com.example.codetride.sqlitedatabase;

/**
 * Created by CodeTride on 2017/07/27.
 */

public class ContactStudent {

    private String mName, mSurname, mMarks;
    private int mID;

    public ContactStudent() {
    }

    public ContactStudent(int mID, String mName, String mSurname) {
        this.mID = mID;
        this.mName = mName;
        this.mSurname = mSurname;
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

    @Override
    public String toString() {
        return mID + " .  "
                + mName + " - "
                + mSurname;
    }
}

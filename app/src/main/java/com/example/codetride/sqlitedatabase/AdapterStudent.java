package com.example.codetride.sqlitedatabase;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CodeTride on 2017/08/07.
 */

public class AdapterStudent extends ArrayAdapter<ContactStudent> {

    private TextView mName, mSurname, mMarks, mStudentNo;

    public AdapterStudent(Context context, ArrayList<ContactStudent> contactStudents) {
        super(context, 0, contactStudents);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ContactStudent currentStudent = getItem(position);

        View studentList = convertView;
        if (studentList==null){
            studentList = LayoutInflater.from(getContext()).inflate(R.layout.student_list_view,parent,false);
        }

        mName= (TextView) studentList.findViewById(R.id.lblName);
        mName.setText(currentStudent.getmName());

        mSurname = (TextView) studentList.findViewById(R.id.lblSurname);
        mSurname.setText(currentStudent.getmSurname());

        mMarks = (TextView) studentList.findViewById(R.id.lblMarks);
        mMarks.setText(currentStudent.getmMarks());

        mStudentNo = (TextView) studentList.findViewById(R.id.lblStudentNo);
        mStudentNo.setText(currentStudent.getmStudentNo());

        return studentList;
    }
}

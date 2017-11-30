package com.example.codetride.sqlitedatabase;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Editor2 extends AppCompatActivity {

    Intent intent;
    EditText edtId, edtName, edtSurname, edtMarks, edtStudentNo;
    StndHelper stndHelper;
    ContactStudent contactStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor2);

        edtId = (EditText) findViewById(R.id.id);
        edtName = (EditText) findViewById(R.id.name);
        edtSurname = (EditText) findViewById(R.id.surname);
        edtMarks = (EditText) findViewById(R.id.marks);
        edtStudentNo = (EditText) findViewById(R.id.studentNo);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Settings");
        builder.setMessage("Go to the settings?");
        builder.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent= new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        builder.show();

    }

    public void Add() {

        edtName = (EditText) findViewById(R.id.name);
        edtSurname = (EditText) findViewById(R.id.surname);
        edtMarks = (EditText) findViewById(R.id.marks);
        edtStudentNo = (EditText) findViewById(R.id.studentNo);

        String names = edtName.getText().toString();
        String surnames = edtSurname.getText().toString();
        String marks = edtMarks.getText().toString();
        String studentNo = edtStudentNo.getText().toString();

        int id = 0;
        contactStudent = new ContactStudent(id++, names, surnames,marks,studentNo);

        StndHelper stndHelper = new StndHelper(this);
        stndHelper.AddStudent(contactStudent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optional2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                intent = new Intent(Editor2.this,MainActivity.class);
                Add();
                startActivity(intent);
                break;
            case R.id.cancel:
                intent = new Intent(Editor2.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

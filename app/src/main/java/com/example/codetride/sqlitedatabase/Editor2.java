package com.example.codetride.sqlitedatabase;

import android.content.Intent;
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
    }

    public void Add() {

        edtName = (EditText) findViewById(R.id.name);
        edtSurname = (EditText) findViewById(R.id.surname);

        String names = edtName.getText().toString();
        String surnames = edtSurname.getText().toString();

        int id = 0;
        contactStudent = new ContactStudent(id++, names, surnames);

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

package com.example.codetride.sqlitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity {

    EditText edtId, edtName, edtSurname, edtMarks, edtStudentNo;
    Intent intent;
    StndHelper stndHelper;
    public static String intents;
    ContactStudent contactStudent;
    public String request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        edtId = (EditText) findViewById(R.id.id);
        edtName = (EditText) findViewById(R.id.name);
        edtSurname = (EditText) findViewById(R.id.surname);
        edtMarks = (EditText) findViewById(R.id.marks);
        edtStudentNo = (EditText) findViewById(R.id.studentNo);

        checkForRequest();
    }

    public void update(){

        int id=Integer.parseInt(edtId.getText().toString());
        String name=String.valueOf(edtName.getText().toString());
        String Surname=String.valueOf(edtSurname.getText().toString());
        String marks=String.valueOf(edtMarks.getText().toString());
        String studentNo=String.valueOf(edtStudentNo.getText().toString());

        StndHelper stndHelper = new StndHelper(this);
        stndHelper.Update(id,name,Surname,marks,studentNo);
    }

    private void checkForRequest() {
        request = getIntent().getExtras().get(StndHelper.TYPE).toString();
        if (request.equals(StndHelper.UPDATE)) {
           // btnDML.setText(StndHelper.UPDATE);
            edtName.setText(getIntent().getExtras().get(StndHelper.NAME).toString());
            edtSurname.setText(getIntent().getExtras().get(StndHelper.SURNAME).toString());
            edtId.setText(getIntent().getExtras().get(StndHelper._ID).toString());
            edtMarks.setText(getIntent().getExtras().get(StndHelper.MARKS).toString());
            edtStudentNo.setText(getIntent().getExtras().get(StndHelper.STUDENTNo).toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optional,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.update:
                intent = new Intent(EditorActivity.this,MainActivity.class);
                update();
                startActivity(intent);
                break;
            case R.id.cancel:
                intent = new Intent(EditorActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

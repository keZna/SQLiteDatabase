package com.example.codetride.sqlitedatabase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StndHelper stndHelper = new StndHelper(this);
    Button add;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<ContactStudent> contactStudents = stndHelper.getAllStudents();

        ListView listView = (ListView) findViewById(R.id.list_view);

        if (listView.equals("")){
            TextView name= (TextView) findViewById(R.id.lblName);
        }else{
            AdapterStudent student = new AdapterStudent(this, contactStudents);
            listView.setAdapter(student);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final     ContactStudent contacts = contactStudents.get(position);

                Dialog dialog = new Dialog(MainActivity.this);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Optional");
                builder.setMessage("You want to edit this student?");
                builder.setNeutralButton("No thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        intent = new Intent(MainActivity.this, EditorActivity.class);
                        startActivity(intent);
                        update(contacts.getmID(),contacts.getmName(),contacts.getmSurname(),contacts.getmMarks(),contacts.getmStudentNo());
                        finish();
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        stndHelper.Delete(contacts.getmName());
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                dialog=builder.create();
                builder.show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            String name = data.getStringExtra(StndHelper.NAME);
            String surname = data.getStringExtra(StndHelper.SURNAME);
            String marks = data.getStringExtra(StndHelper.MARKS);
            String studentNo = data.getStringExtra(StndHelper.STUDENTNo);

            ContactStudent contactStudent = new ContactStudent();
            contactStudent.setmName(name);
            contactStudent.setmSurname(surname);
            contactStudent.setmMarks(marks);
            contactStudent.setmStudentNo(studentNo);

            if (requestCode == StndHelper.UPDATE_RECORD){
                int id= data.getIntExtra(StndHelper._ID,contactStudent.getmID());
                stndHelper.Update(id,name,surname,marks,studentNo);
                stndHelper.update(contactStudent);

            }else if (requestCode == StndHelper.ADD_RECORD){
                stndHelper.AddStudent(contactStudent);
            }
        }
    }

    public void update(int id, String name, String surname, String marks, String studentNo){

        intent.putExtra(StndHelper.NAME,name);
        intent.putExtra(StndHelper.SURNAME,surname);
        intent.putExtra(StndHelper._ID,id);
        intent.putExtra(StndHelper.MARKS,marks);
        intent.putExtra(StndHelper.STUDENTNo,studentNo);

        intent.putExtra(StndHelper.TYPE,StndHelper.UPDATE);
        startActivityForResult(intent,StndHelper.UPDATE_RECORD);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:
                intent = new Intent(MainActivity.this,Editor2.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

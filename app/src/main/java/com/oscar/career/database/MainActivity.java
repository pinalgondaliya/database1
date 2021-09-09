package com.oscar.career.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.oscar.career.database.MYdata.AppDatabase;
import com.oscar.career.database.MYdata.AppDatabaseQuery;
import com.oscar.career.database.MYdata.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabaseQuery myQuery;
    EditText name;
    EditText rollNo;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase myappDb = Room.databaseBuilder(this,AppDatabase.class,"Student").allowMainThreadQueries().build();
        myQuery = myappDb.getAppQueries();

        name = findViewById(R.id.editTextTextPersonName);
        rollNo = findViewById(R.id.editTextTextPersonName2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        rv = findViewById(R.id.rv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = name.getText().toString();
                String n = rollNo.getText().toString();
                int enrollNo = Integer.parseInt(n);

                Student s = new Student(enrollNo,e);
                myQuery.insertStudentData(s);

//                String n = name.getText().toString();
//                String e = enroll.getText().toString();
//                int enroll = Integer.parseInt(e);
//
//                Student s = new Student(n, enroll);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).run();
//                myQueries.insertStudentData(s);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname = name.getText().toString();
                String en = rollNo.getText().toString();
                int enrollNo = Integer.parseInt(en);

                myQuery.updateStudentData(enrollNo,newname);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = rollNo.getText().toString();
                int enrollNo = Integer.parseInt(no);
                myQuery.deleteStudentData(enrollNo);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> s = myQuery.getStudentData();
                rv.setAdapter(new RecAdapter(s));
            }
        });
    }




}
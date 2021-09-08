package com.oscar.career.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;

import com.oscar.career.database.MYdata.AppDatabase;
import com.oscar.career.database.MYdata.AppDatabaseQuery;
import com.oscar.career.database.MYdata.Student;

public class MainActivity extends AppCompatActivity {

    AppDatabaseQuery myQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase myappDb = Room.databaseBuilder(this,AppDatabase.class,"Student").build();
        myQuery = myappDb.getAppQueries();
    }

    public void insert(View view) {

        Student s = new Student(56,"pinal");

        myQuery.insertStudentData(s);
    }

    public void update(View view) {
    }

    public void delete(View view) {
    }

    public void getAllRecords(View view) {
    }
}
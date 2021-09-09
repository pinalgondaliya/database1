package com.oscar.career.database.MYdata;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    int pKey;

    @ColumnInfo(name = "student_rollNo")
    public int enrollNo;

    @ColumnInfo(name = "student_name")
    public String name;

    public Student(int enrollNo,String name){
        this.enrollNo = enrollNo;
        this.name = name;
    }
}

package com.oscar.career.database.MYdata;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDatabaseQuery {

    @Insert
    public void insertStudentData(Student s);

    @Query("SELECT * FROM Student")
    public List<Student> getStudentData();

    @Query("UPDATE Student SET student_name=:newName WHERE student_rollNo=:enroll")
    public void updateStudentData(int enroll,String newName);


    @Query("DELETE FROM Student WHERE student_rollNo=:enrollNo ")
    public void deleteStudentData(int enrollNo);
}

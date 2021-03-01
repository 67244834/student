package com.abc.dao;

import com.abc.beans.Page;
import com.abc.beans.Student;

import java.util.List;

public interface IStudentManagerDao {
    int selectAllCount();
    int selectCount1(String pname);//精确查询
    int selectCount2(String pname);//模糊查询
    List<Student> selectStudentmessage(Page<Student> page);
    List<Student> selectStudentmessage1(Page<Student> page);
    List<Student> selectStudentmessage2(Page<Student> page);
    void insertStudent(Student student);
    void updateStudentById(Student student);
    void deleteStudentById(String id);
    Student selectStudentById(String id);

}

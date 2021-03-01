package com.abc.service;

import com.abc.beans.Page;
import com.abc.beans.Student;

public interface IStudentManagerService {
    Page<Student> findStudentmessage(int pageno);
    Page<Student> findStudentmessage1(int pageno, String sname);
    Page<Student> findStudentmessage2(int pageno, String sname);
    void removeStudentById(String id);
    Student findStudentById(String id);
    void saveStudent(Student student);
    void modifyStudent(Student student);
}

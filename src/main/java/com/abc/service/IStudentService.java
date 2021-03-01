package com.abc.service;

import com.abc.beans.Course;
import com.abc.beans.Page;
import com.abc.beans.Student;

import java.util.List;

public interface IStudentService {
    Student findStudentById(String id);

    void updatePassword(String id, String password);

    Page<Course> findAllCourse(int pageno);

    void insertStudentCourse(String id, String cid);

    Page<Student> findStudentCourseById(String id, int pageno);

    void removeStudentSC(String id, String cid);

    List<String> selectSCByid(String id);

    void updateStudentById(Student student);

    List<String> findSCCidBySid(String id);
}
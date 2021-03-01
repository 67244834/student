package com.abc.dao;

import com.abc.beans.Course;
import com.abc.beans.Page;
import com.abc.beans.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentDao {
    Student selectStudentById(String id);

    void updatePassword(@Param("sid") String id, @Param("password") String password);

    List<Course> selectAllCourse(Page<Course> page);

    void saveStudentCourse(@Param("id") String id, @Param("cid") String cid);

    List<Student> selectStudentCourseById(@Param("id") String id, @Param("page") Page<Student> page);

    void deleteStudentSC(@Param("id") String id, @Param("cid") String cid);

    List<String> findSCByid(String id);

    void updateStudentId(Student student);

    int selectCourseCount();//获取course的记录数

    int selectSCCount(String id);

    List<String> selectSCCidBySid(String id);
}
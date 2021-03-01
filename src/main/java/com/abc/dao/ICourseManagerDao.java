package com.abc.dao;


import com.abc.beans.Course;
import com.abc.beans.Page;


import java.util.List;

public interface ICourseManagerDao {
    int selectAllCount();
    int selectCount1(String pname);//精确查询
    int selectCount2(String pname);//模糊查询
    List<Course> selectCoursemessage(Page<Course> page);
    List<Course> selectCoursemessage1(Page<Course> page);
    List<Course> selectCoursemessage2(Page<Course> page);
    void insertCourse(Course course);
    void insertCourse1(Course course);
    void updateCourseById(Course course);
    void deleteCourseById(String id);
    Course selectCourseById(String id);
}

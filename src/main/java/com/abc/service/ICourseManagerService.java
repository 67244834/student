package com.abc.service;

import com.abc.beans.Course;
import com.abc.beans.Page;

public interface ICourseManagerService {
    Page<Course> findCoursemessage(int pageno);
    Page<Course> findCoursemessage1(int pageno, String cname);
    Page<Course> findCoursemessage2(int pageno, String cname);
    void removeCourseById(String id);
    Course findCourseById(String id);
    void saveCourse(Course course);
    void saveCourse1(Course course);
    void modifyCourse(Course course);
}

package com.abc.dao;

import com.abc.beans.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface pickDao {
    int selectAllCount();
    int selectpickCount(String tid);
    int selectStudentCount(String tid);
    void uptpassword(@Param("password") String password, @Param("tid") String tid);
    List<Course> selectAllCourse(Page<Course> page);
    List<Course> selectpickCourse(@Param("page") Page<Course> page, @Param("tid") String tid);
    List<Teacher> selectStudent(@Param("tid") String id, @Param("page") Page<Teacher> page);
    Teacher selectTeacher(String tid);
    void upTeacher(Teacher teacher);
    void updatepick(String cid);
    void upScore(Sc sc);
    void updatepickCourse(@Param("cid") String cid, @Param("tid") String tid);

}

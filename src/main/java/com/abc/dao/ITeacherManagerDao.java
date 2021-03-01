package com.abc.dao;

import com.abc.beans.Page;
import com.abc.beans.Student;
import com.abc.beans.Teacher;

import java.util.List;

public interface ITeacherManagerDao {
    int selectAllCount();
    int selectCount1(String pname);//精确查询
    int selectCount2(String pname);//模糊查询
    List<Teacher> selectTeachermessage(Page<Teacher> page);
    List<Teacher> selectTeachermessage1(Page<Teacher> page);
    List<Teacher> selectTeachermessage2(Page<Teacher> page);
    void insertTeacher(Teacher teacher);
    void updateTeacherById(Teacher teacher);
    void deleteTeacherById(String id);
    Teacher selectTeacherById(String id);
}

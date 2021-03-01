package com.abc.service;

import com.abc.beans.Page;
import com.abc.beans.Student;
import com.abc.beans.Teacher;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/1/5 0005
 */
public interface ITeacherManagerService {
    Page<Teacher> findTeachermessage(int pageno);
    Page<Teacher> findTeachermessage1(int pageno, String tname);
    Page<Teacher> findTeachermessage2(int pageno, String tname);
    void removeTeacherById(String id);
    Teacher findTeacherById(String id);
    void saveTeacher(Teacher teacher);
    void modifyTeacher(Teacher teacher);
}

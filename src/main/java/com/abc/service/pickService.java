package com.abc.service;

import com.abc.beans.*;

import java.lang.annotation.Target;
import java.util.List;

public interface pickService {
   Page<Course> findAllCourse(int pageno);
   Page<Course> findpickCourse(String id, int pageno);
   Page<Teacher> findStudent(String id, int pageno);
   Teacher findTeacher(String id);
   void midifytpassword(String password,String tid);
   void modifyTeacher(Teacher teacher);
   void modifypick(String cid, String tid);//选课
   void modifypick2(String cid);//退选
   void modifyScore(Sc sc);
}

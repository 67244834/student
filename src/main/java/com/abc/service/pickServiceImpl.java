package com.abc.service;

import com.abc.beans.*;
import com.abc.dao.ILoginDao;
import com.abc.dao.pickDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pickServiceImpl implements pickService {
    @Autowired
    private pickDao dao;
    @Override
    public Page<Course> findAllCourse(int pageno) {
        Page<Course> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = dao.selectAllCount();//课程总数
        page.setTotalRows(totalRows);
        List<Course> dates = dao.selectAllCourse(page);
        page.setDatas(dates);
        return  page;
    }//查看全部课程

    @Override
    public  Page<Course> findpickCourse(String id,int pageno) {
        Page<Course> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = dao.selectpickCount(id);
        page.setTotalRows(totalRows);
        List<Course> datas = dao.selectpickCourse(page,id);
        page.setDatas(datas);
        return page;
    }

    @Override
    public Page<Teacher> findStudent(String id,int pageno) {
        Page<Teacher> page = new Page<>();
        page.setPageno(pageno);
        int totalRows=dao.selectStudentCount(id);
        page.setTotalRows(totalRows);
        List<Teacher> datas =  dao.selectStudent(id,page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public Teacher findTeacher(String id) {
        return dao.selectTeacher(id);
    }

    @Override
    public void midifytpassword(String password,String tid) {
        dao.uptpassword(password,tid);
    }

    @Override
    public void modifyTeacher(Teacher teacher) {
        dao.upTeacher(teacher);
    }

    @Override
    public void modifypick(String cid, String tid) {//教师选课
        dao.updatepickCourse(cid,tid);
    }

    @Override
    public void modifypick2(String cid) {
        dao.updatepick(cid);
    }

    @Override
    public void modifyScore(Sc sc) {
        dao.upScore(sc);
    }
}

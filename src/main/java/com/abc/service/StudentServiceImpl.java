package com.abc.service;

import com.abc.beans.Course;
import com.abc.beans.Page;
import com.abc.beans.Student;
import com.abc.dao.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao dao;

    @Override
    public Student findStudentById(String id) {
        return dao.selectStudentById(id);
    }

    @Override
    public void updatePassword(String id,String password) {
        dao.updatePassword(id,password);
    }

    @Override
    public Page<Course> findAllCourse(int pageno) {
        Page<Course> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = dao.selectCourseCount();
        page.setTotalRows(totalRows);
        List<Course> datas=dao.selectAllCourse(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public void insertStudentCourse(String id, String cid) {
        dao.saveStudentCourse(id,cid);
    }

    @Override
    public Page<Student> findStudentCourseById(String id, int pageno) {
        Page<Student> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = dao.selectSCCount(id);
        page.setTotalRows(totalRows);
        List<Student> datas=dao.selectStudentCourseById(id,page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public void removeStudentSC(String id,String cid) {
        dao.deleteStudentSC(id,cid);
    }

    @Override
    public List<String> selectSCByid(String id) {
        return dao.findSCByid(id);
    }

    @Override
    public void updateStudentById(Student student) {
        dao.updateStudentId(student);
    }

    @Override
    public List<String> findSCCidBySid(String id) {
        return dao.selectSCCidBySid(id);
    }
}
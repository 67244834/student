package com.abc.service;

import com.abc.beans.Course;
import com.abc.beans.Page;
import com.abc.dao.ICourseManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICourseManagerServiceImlp implements ICourseManagerService{
    @Autowired
    private ICourseManagerDao iCourseManagerDao;
    @Override
    public Page<Course> findCoursemessage(int pageno) {
        Page<Course> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iCourseManagerDao.selectAllCount();
        page.setTotalRows(totalRows);
        List<Course> datas= iCourseManagerDao.selectCoursemessage(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public Page<Course> findCoursemessage1(int pageno, String cname) {
        Page<Course> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iCourseManagerDao.selectCount1(cname);
        page.setTotalRows(totalRows);
        page.setSname(cname);
        List<Course> datas= iCourseManagerDao.selectCoursemessage1(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public Page<Course> findCoursemessage2(int pageno, String cname) {
        Page<Course> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iCourseManagerDao.selectCount2(cname);
        page.setTotalRows(totalRows);
        page.setSname(cname);
        List<Course> datas= iCourseManagerDao.selectCoursemessage2(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public void removeCourseById(String id) {
        iCourseManagerDao.deleteCourseById(id);
    }

    @Override
    public Course findCourseById(String id) {
        return iCourseManagerDao.selectCourseById(id);
    }

    @Override
    public void saveCourse(Course course) {
        iCourseManagerDao.insertCourse(course);
    }
    @Override
    public void saveCourse1(Course course) {
        iCourseManagerDao.insertCourse1(course);
    }

    @Override
    public void modifyCourse(Course course) {
        iCourseManagerDao.updateCourseById(course);
    }
}

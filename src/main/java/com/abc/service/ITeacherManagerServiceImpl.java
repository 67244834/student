package com.abc.service;

import com.abc.beans.Page;
import com.abc.beans.Student;
import com.abc.beans.Teacher;
import com.abc.dao.ITeacherManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/1/5 0005
 */
@Service
public class ITeacherManagerServiceImpl  implements  ITeacherManagerService{
    @Autowired
    private ITeacherManagerDao iTeacherManagerDao;
    @Override
    public Page<Teacher> findTeachermessage(int pageno) {
        Page<Teacher> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iTeacherManagerDao.selectAllCount();
        page.setTotalRows(totalRows);
        List<Teacher> datas= iTeacherManagerDao.selectTeachermessage(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public Page<Teacher> findTeachermessage1(int pageno, String tname) {
        Page<Teacher> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iTeacherManagerDao.selectCount1(tname);
        page.setTotalRows(totalRows);
        page.setSname(tname);
        List<Teacher> datas= iTeacherManagerDao.selectTeachermessage1(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public Page<Teacher> findTeachermessage2(int pageno, String tname) {
        Page<Teacher> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iTeacherManagerDao.selectCount2(tname);
        page.setTotalRows(totalRows);
        page.setSname(tname);
        List<Teacher> datas= iTeacherManagerDao.selectTeachermessage2(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public void removeTeacherById(String id) {
        iTeacherManagerDao.deleteTeacherById(id);
    }

    @Override
    public Teacher findTeacherById(String id) {
        return iTeacherManagerDao.selectTeacherById(id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        iTeacherManagerDao.insertTeacher(teacher);
    }

    @Override
    public void modifyTeacher(Teacher teacher) {
        iTeacherManagerDao.updateTeacherById(teacher);
    }
}

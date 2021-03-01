package com.abc.service;

import com.abc.beans.Page;
import com.abc.beans.Student;
import com.abc.dao.IStudentManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IStudentManagerServiceImpl implements IStudentManagerService {
    @Autowired
    private IStudentManagerDao iStudentManagerDao;
    @Override
    public Page<Student> findStudentmessage(int pageno) {
        Page<Student> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iStudentManagerDao.selectAllCount();
        page.setTotalRows(totalRows);
        List<Student> datas= iStudentManagerDao.selectStudentmessage(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public Page<Student> findStudentmessage1(int pageno ,String sname) {
        Page<Student> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iStudentManagerDao.selectCount1(sname);
        page.setTotalRows(totalRows);
        page.setSname(sname);
        List<Student> datas= iStudentManagerDao.selectStudentmessage1(page);
        page.setDatas(datas);
        return page;
    }
    @Override
    public Page<Student> findStudentmessage2(int pageno ,String sname) {
        Page<Student> page = new Page<>();
        page.setPageno(pageno);
        int totalRows = iStudentManagerDao.selectCount2(sname);
        page.setTotalRows(totalRows);
        page.setSname(sname);
        List<Student> datas= iStudentManagerDao.selectStudentmessage2(page);
        page.setDatas(datas);
        return page;
    }
    @Override
    public void removeStudentById(String id) {
        iStudentManagerDao.deleteStudentById(id);
    }

    @Override
    public Student findStudentById(String id) {
        return iStudentManagerDao.selectStudentById(id);
    }

    @Override
    public void saveStudent(Student student) {
        iStudentManagerDao.insertStudent(student);
    }

    @Override
    public void modifyStudent(Student student) {
        iStudentManagerDao.updateStudentById(student);
    }
}

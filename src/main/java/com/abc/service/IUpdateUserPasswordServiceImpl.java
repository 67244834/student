package com.abc.service;

import com.abc.dao.ITeacherManagerDao;
import com.abc.dao.IUpdateUserPasswordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/1/5 0005
 */
@Service
public class IUpdateUserPasswordServiceImpl implements IUpdateUserPasswordService {
    @Autowired
    private IUpdateUserPasswordDao iUpdateUserPasswordDao;
    @Override
    public void updateTeacherpassword(String renewpass, String stid) {
        iUpdateUserPasswordDao.updateteacherpassword(renewpass,stid);
    }

    @Override
    public void updateStudentpassword(String renewpass, String stid) {
        iUpdateUserPasswordDao.updatestudentpassword(renewpass,stid);
    }
}

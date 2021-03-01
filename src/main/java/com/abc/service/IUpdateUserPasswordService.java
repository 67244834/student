package com.abc.service;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/1/5 0005
 */
public interface IUpdateUserPasswordService {
    void updateTeacherpassword(String renewpass, String stid);
    void updateStudentpassword(String renewpass, String stid);
}

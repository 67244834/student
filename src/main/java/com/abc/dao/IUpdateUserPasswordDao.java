package com.abc.dao;

import org.apache.ibatis.annotations.Param;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/1/5 0005
 */
public interface IUpdateUserPasswordDao {
    void updateteacherpassword(@Param("renewpass") String renewpass, @Param("stid") String stid);
    void updatestudentpassword(@Param("renewpass") String renewpass, @Param("stid") String stid);
}

package com.abc.dao;

import com.abc.beans.Manager;
import org.apache.ibatis.annotations.Param;

public interface IManagerDao {
    void updatepassword(@Param("password") String password, @Param("mid") String mid);
    Manager selectmessage(String mid);
    void updatemessage(Manager manager);

}

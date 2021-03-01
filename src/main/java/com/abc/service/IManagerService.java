package com.abc.service;

import com.abc.beans.Manager;

public interface IManagerService {
    void updatepassword(String password, String mid);
    Manager findmanager(String mid);
    void updatemessage(Manager manager);
}

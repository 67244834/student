package com.abc.service;

import com.abc.beans.Manager;
import com.abc.dao.IManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IManagerServiceImpl implements IManagerService {
    @Autowired
    private IManagerDao Imdao;
    @Override
    public void updatepassword(String password, String mid) {
        Imdao.updatepassword(password,mid);
    }

    @Override
    public Manager findmanager(String mid) {
        return Imdao.selectmessage(mid);
    }

    @Override
    public void updatemessage(Manager manager) {
        Imdao.updatemessage(manager);
    }
}

package com.abc.service;

import com.abc.dao.ILoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILoginServiceImpl implements ILoginService {
    @Autowired
    private ILoginDao Ldao;
    @Override
    public String findspassword(String id) {
        return Ldao.selectspassword(id);
    }

    @Override
    public String findtpassword(String id) {
        return Ldao.selecttpassword(id);
    }

    @Override
    public String findmpassword(String id) {
        return Ldao.selectmpassword(id);
    }
}

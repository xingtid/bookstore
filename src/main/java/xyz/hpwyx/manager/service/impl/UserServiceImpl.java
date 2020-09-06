package xyz.hpwyx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BUserMapper;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BUserMapper dao;

    @Override
    public BUser findUserByUserName(BUser user) {
        BUser userName = dao.findByUserName (user);
        return userName;
    }

    public int register(BUser user) {
        user.setuName (user.getuUsername ());
        dao.insert (user);
        return 1;
    }
}

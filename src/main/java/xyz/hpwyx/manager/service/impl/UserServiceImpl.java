package xyz.hpwyx.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.mapper.BUserMapper;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.UserService;

import java.util.List;

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
        user.setuIsAdmin ("1");
        dao.insert (user);
        return 1;
    }

    @Override
    public int countUser() {
        return dao.countUser ();
    }

    @Override
    public int updateUser(BUser user) {
        return dao.updateByPrimaryKey (user);
    }

    @Override
    public BUser selectByPrimaryKey(Integer uId) {
        return dao.selectByPrimaryKey (uId);
    }

    public List<BUser> findList(BUser user){
        return dao.findList (user);
    }
}

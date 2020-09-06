package xyz.hpwyx.manager.service;

import org.springframework.stereotype.Service;
import xyz.hpwyx.manager.pojo.BUser;

@Service
public interface UserService {
    BUser findUserByUserName(BUser user);

    int register(BUser user);
}
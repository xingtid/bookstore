package xyz.hpwyx.manager.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.hpwyx.manager.pojo.BUser;
import xyz.hpwyx.manager.service.UserService;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println ("授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        BUser user = new BUser ();
        user.setuUsername (token.getUsername ());
        BUser user1 = userService.findUserByUserName (user);
        if (user1 == null){
            return null;
        }
        if (!token.getUsername ().equals (user1.getuUsername ())) {
            return null;
        }

        System.out.println ("认证逻辑");
        return new SimpleAuthenticationInfo ("", user1.getuPassword (), "");
    }
}

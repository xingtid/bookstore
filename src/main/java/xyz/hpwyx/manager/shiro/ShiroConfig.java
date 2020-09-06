package xyz.hpwyx.manager.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean ();
        shiroFilterFactoryBean.setSecurityManager (securityManager);

        /*
          过滤器
          anon: 无需登录
          authc: 必须登录
          user: 如果使用rememberMe的功能可以访问
          perms: 资源授权
          role: 角色授权
         */
        Map<String, String> filterMap = new LinkedHashMap<String, String> ();
        filterMap.put ("/add", "authc");
        filterMap.put ("/admin", "authc");
        filterMap.put ("/adminType", "authc");
        filterMap.put ("/car", "authc");
//        filterMap.put ("/*","authc");
        filterMap.put ("/login", "anon");
//        filterMap.put ("/add", "perms[user:add]");
        //修改跳转页面
        shiroFilterFactoryBean.setLoginUrl ("/login.html");
        shiroFilterFactoryBean.setUnauthorizedUrl ("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap (filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager ();

        securityManager.setRealm (userRealm);
        return securityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm getRealm() {

        return new UserRealm ();
    }


}

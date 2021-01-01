package com.df.ppbong.config;

import com.df.ppbong.realm.CustomRealm;
import com.df.ppbong.realm.JwtCredentialsMatcher;
import com.df.ppbong.realm.JwtFilter;
import com.df.ppbong.realm.JwtRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * shiro 拦截器，拦截所有请求，进行认证或授权
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShirFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置websecuritymanager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //添加自定义filter
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("jwt_filter",new JwtFilter());
        shiroFilterFactoryBean.setFilters(filters);

        //配置系统受限资源
        //配置系统公共资源
        Map<String,String> map = new HashMap<>();
        map.put("/user/login","anon");//开放的资源要放在前面
        map.put("/index.html","anon");//开放的资源要放在前面
        map.put("/user/register","anon");//开放的资源要放在前面
        map.put("/**","jwt_filter");//除了开放的url外其他路径都需要经过自定义filter决定是否放行
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm DBrealm,Realm JWTrealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealms(Arrays.asList(DBrealm,JWTrealm));
        return defaultWebSecurityManager;
    }
    @Bean("DBrealm")
    public Realm getDBRealm(){

        CustomRealm customRealm = new CustomRealm();

        HashedCredentialsMatcher customCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法的名字
        customCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数，注意注册的时候密码生成需要也按这两个规则来
        customCredentialsMatcher.setHashIterations(1024);
        customRealm.setCredentialsMatcher(customCredentialsMatcher);

        customRealm.setCacheManager(getEhCacheManager());//设置缓存管理器
        customRealm.setCachingEnabled(true);//开启全局缓存功能
        customRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
        customRealm.setAuthenticationCacheName("authenticationCache");

        return customRealm;
    }

    @Bean("ehCacheManager")
    public EhCacheManager getEhCacheManager(){
        return new EhCacheManager();
    }

    @Bean("JWTrealm")
    public Realm getJWTRealm(){

        JwtRealm customRealm = new JwtRealm();

        JwtCredentialsMatcher customCredentialsMatcher = new JwtCredentialsMatcher();
        customRealm.setCredentialsMatcher(customCredentialsMatcher);

        customRealm.setCacheManager(getEhCacheManager());//设置缓存管理器
        customRealm.setCachingEnabled(true);//开启全局缓存功能

        customRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
        customRealm.setAuthorizationCacheName("authoritionCache");

        return customRealm;
    }
}

package com.cxz.realm;

import com.cxz.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Object username = pc.getPrimaryPrincipal();
        Set<String> roleControl = new HashSet<>();
        if( "Duke".equals(username) ) {
            roleControl.add("admin");
        } else if("Tiny".equals(username) ) {
            roleControl.add("superAdmin");
        }
        info.setRoles(roleControl);

        Set<String> perms = new HashSet<>();
        if( "Tiny".equals(username) ) {
            perms.add("user:add");
            perms.add("user:find");
        }
        info.setStringPermissions(perms);
        /*AuthorizationInfo info = new SimpleAuthorizationInfo(roleControl);*/

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = new User();

        if( "Duke".equals( token.getPrincipal() ) ){
            user.setUsername("Duke");
            user.setPassword("123");
        } else if( "Tiny".equals( token.getPrincipal() )){
            user.setUsername("Tiny");
            user.setPassword("111");
        }

        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
//        ByteSource by = ByteSource.Util.bytes(token.getPrincipal());
//        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),by,getName());
    }
}

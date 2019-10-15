package com.cxz.Filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomRolesAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        Subject subject = getSubject(request,response);
        System.out.println(o);
        String[] rolesArray = (String[])o;
        if( rolesArray==null || rolesArray.length==0 ) return false;
        for ( String role : rolesArray ) {
            if( subject.hasRole(role) ) return true;
        }
        return false;
    }
}

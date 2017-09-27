package com.yy.core.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.AccessControlFilter;
//自定义 FilterTOC
//
//Shiro 支持自定义 Filter 大家都知道，也经常用，这里我也用到了一个自定义 Filter，主要用于验证接口调用的 AccessToken 是否有效
public class AccessTokenFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest,
                                      ServletResponse servletResponse,
                                      Object o) {
//        if (isValidAccessToken(servletRequest.getp)) {
//            return true;
//        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, 
                                    ServletResponse servletResponse) throws Exception {
        throw new UnauthorizedException("操作授权失败！ACCESSTOKEN 失效！");
    }
}

package com.alleyz.k8s.web.filter;

import com.alleyz.k8s.bean.User;
import com.alleyz.k8s.web.util.Const;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) req;
        HttpServletResponse hsrp = (HttpServletResponse) servletResponse;
        System.out.println(hsr.getRequestURI());
        if(hsr.getRequestURI().equals("/web/")){
            User user = (User) hsr.getSession().getAttribute(Const.SIGN_IN_USER);
            if(user != null){
                hsrp.getWriter().write("<script type='text/javascript'>parent.location.href='"+hsr.getContextPath() +
                        "/index.jsp'</script>");
                return;
            }
        }
        if(hsr.getRequestURI().contains("login.jsp") || hsr.getRequestURI().contains("signIn.al") ) {
            filterChain.doFilter(req, servletResponse);
            return;
        }

        User user = (User) hsr.getSession().getAttribute(Const.SIGN_IN_USER);

        if(user == null) {
            hsrp.getWriter().write("<script type='text/javascript'>parent.location.href='"+hsr.getContextPath() +
                    "/login.jsp'</script>");
        } else {
            filterChain.doFilter(req, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

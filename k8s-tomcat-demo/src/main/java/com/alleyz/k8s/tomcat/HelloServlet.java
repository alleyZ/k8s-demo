package com.alleyz.k8s.tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaihw
 *         on 2017/12/11.
 */
public class HelloServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("name", name == null ? "anonymous" : name);
        req.getRequestDispatcher("/k8s/hello.jsp").forward(req, resp);
    }
}

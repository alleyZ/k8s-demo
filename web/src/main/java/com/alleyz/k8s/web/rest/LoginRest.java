package com.alleyz.k8s.web.rest;

import com.alleyz.k8s.bean.JsonResult;
import com.alleyz.k8s.bean.User;
import com.alleyz.k8s.web.service.UserServiceImpl;
import com.alleyz.k8s.web.util.Const;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@Log4j
public class LoginRest {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/signIn.al")
    public String signIn(String userName, String password, ModelMap map, HttpSession session) {
        log.info("signIn userName =" + userName);
        User user = userService.find(userName, password);
        if(user != null) {
            log.info("User=" + user.toString());

            session.setAttribute(Const.SIGN_IN_USER, user);
            return "/index";
        } else {
            map.put("msg", "登录错误");
        }
        return "/login";
    }

    @RequestMapping("/index.al")
    public String index() {
        return "/index";
    }

    @RequestMapping("/loginOut.al")
    @ResponseBody
    public JsonResult loginOut(HttpSession session) {

        JsonResult json = new JsonResult();
        json.setSuccess(true);
        json.setMsg("签出");
        log.info(((User)session.getAttribute(Const.SIGN_IN_USER)) .getUserName() + " loginOut");
        session.removeAttribute(Const.SIGN_IN_USER);
        return json;
    }


}


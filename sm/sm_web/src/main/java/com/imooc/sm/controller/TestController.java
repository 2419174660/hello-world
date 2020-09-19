package com.imooc.sm.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// test/*.do
//开启了自动配置通过controller注解交给ioc容器管理
@Controller("testController")
public class TestController {
    //test/show.do        /showTest.jsp页面在根目录下
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("NAME","何直蔚");
        request.getRequestDispatcher("../showTest.jsp").forward(request,response);
/*由于url是在根目录下的test模块下，而jsp页面是在根目录下，需要加上..返回上层根目录*/


    }
}

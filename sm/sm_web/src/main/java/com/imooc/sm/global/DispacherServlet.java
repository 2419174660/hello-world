package com.imooc.sm.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DispacherServlet extends GenericServlet {
    private ApplicationContext context;
@Override
    public void init() throws ServletException {
        super.init();
        context=new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
     /*
     * /staff/add.do                       /login.do
     * 控制器staffController
     * public void add()
     *
     *
     * */
        String path=request.getServletPath().substring(1);//除去第一个斜杠
        String beanName=null;
        String methodName=null;
        int index=path.indexOf('/');//判断是否有特殊模块,如上面的注释有的url是有模块名的
        //如果不为-1是代表有control模块的
        if(index!=-1){
            beanName=path.substring(0,index)+"Controller";//我自己设置的bean名字带有Control后缀
            methodName=path.substring(index+1,path.indexOf(".do"));//截取到方法名
        }else{
            beanName="selfController";//特殊指定模块，一般是不带特殊业务方法的模块，在url里不参杂模块指示
            methodName=path.substring(0,path.indexOf(".do"));

        }
        //加载容器取得对应beanControl
        Object obj=context.getBean(beanName);
        //通过反射取得对应方法
        try {
            Method method=obj.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(obj,request,response);//执行对应的方法
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

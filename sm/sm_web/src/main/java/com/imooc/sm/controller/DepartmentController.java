package com.imooc.sm.controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
   //department/list.do  //departmentList.jsp
   public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Department> list=departmentService.getAll();
       request.setAttribute("LIST",list);
       request.getRequestDispatcher("../departmentList.jsp").forward(request,response);
   }
   public void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("../departmentAdd.jsp").forward(request,response);
   }
   public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
       String name=request.getParameter("name");
       String address=request.getParameter("address");
       Department department=new Department();
       department.setName(name);
       department.setAddress(address);
       departmentService.add(department);
       response.sendRedirect("list.do");
   }
   public  void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       Integer id=Integer.parseInt(request.getParameter("id"));
       Department department=departmentService.get(id);
       request.setAttribute("OBJ",department);
       request.getRequestDispatcher("../departmentEdit.jsp").forward(request,response);
   }
   public  void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
       Integer id=Integer.parseInt(request.getParameter("id"));
       String name=request.getParameter("name");
       String address=request.getParameter("address");
       Department department=new Department();
       department.setId(id);
       department.setName(name);
       department.setAddress(address);
       departmentService.edit(department);
       response.sendRedirect("list.do");
   }
   public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
       Integer id=Integer.parseInt(request.getParameter("id"));
       departmentService.remove(id);
       response.sendRedirect("list.do");

   }
}

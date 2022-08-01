package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.brandService;
import com.itheima.service.impl.brandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取brandService对象
        brandService brandService=new brandServiceImpl();
        //获取表单提交数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();//JSON字符串

        //将JSON字符串转为Brand对象
        Brand brand = JSON.parseObject(s, Brand.class);


        brandService.update(brand);

        //添加成功就给前端反应一个响应成功的标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

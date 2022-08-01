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

/**
 * 批量删除
 */
@WebServlet("/deleteByIdsServlet")
public class deleteByIdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单提交待删除的id数据数组
        BufferedReader reader = request.getReader();
        String s = reader.readLine();//JSON字符串

        //将JSON字符串转为int []对象
        int[] ids = JSON.parseObject(s, int[].class);
        //创建brandService对象
        brandService brandService=new brandServiceImpl();
        brandService.deleteByIds(ids);

        //添加成功就给前端反应一个响应成功的标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

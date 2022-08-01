package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.brandService;
import com.itheima.service.impl.brandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 分页条件查询
 */
@WebServlet("/selectByConditionServlet")
public class selectByConditionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        brandService service = new brandServiceImpl();
        //1.接收参数当前页码，以及每页展示条数
        String currentPage = request.getParameter("currentPage");
        String size = request.getParameter("size");
        BufferedReader reader = request.getReader();
        String s = reader.readLine();//JSON字符串
        //将JSON字符串转为Brand对象
        Brand brand = JSON.parseObject(s, Brand.class);

        //接受表单对象
        //获取表单提交数据
        PageBean<Brand> brandPageBean = service.selectByPageAndCondition(
                Integer.parseInt(currentPage),Integer.parseInt(size),brand);

        // 将结果转为JSON对象
        String jsonString = JSON.toJSONString(brandPageBean);
        //写数据,因为数据是存在中文的所以要设置编码
        response.setContentType("text/json;charset=utf-8");
        //运行成功,返回运行结果写回到页面
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

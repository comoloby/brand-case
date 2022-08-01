package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface brandService {
    /**
     * 查询所有
     */
    List<Brand> selectAll();
    /**
     * 添加
     */
    void add(Brand b);
    /**
     * 删除
     */
    void delete(int id);
    /**
     * 更新
     */
    void update(Brand brand);
    /**
     * 按id批量删除
     */
    void deleteByIds(int[] ids);
    /**
     * 按页查询&查询总记录条数
     */
    PageBean<Brand> selectByPage(int currentPage, int size);

    /**
     * 按页查询&按条件&查询总记录条数
     */

    PageBean<Brand> selectByPageAndCondition(int begin,int size,Brand brand);
}

package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectAll();
    /**
     * 增加
     */
    void add(Brand brand);
    /**
     * 删除
     */
    void delete(int id);
    /**
     * 更新
     */
    void update(Brand brand);
    /**
     * 按id数组批量删除
     * 要用Param来标记传入参数
     */
    void deleteByIds(@Param("ids") int[] ids);
    /**
     * 按页查询
     */
    List<Brand> selectByPage(@Param("begin")int begin,@Param("size")int size);
    /**
     * 查询总记录数
     */
    int selectTotal();
    /**
     * 分页并且条件查询
     *
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);
    /**
     * 查询符合查询条件的数据数
     */
    int selectTotalCountByCondition(Brand brand);
}

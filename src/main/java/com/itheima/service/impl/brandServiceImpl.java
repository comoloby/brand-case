package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.brandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class brandServiceImpl implements brandService {
    //创建SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll(){
       //定义SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //实行方法
        List<Brand> brands = mapper.selectAll();

        //释放资源
        sqlSession.close();
        //返回
        return brands;
    }
   public void add(Brand brand){
       //定义SqlSession
       SqlSession sqlSession = sqlSessionFactory.openSession();
       //获取BrandMapper
       BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
       //实行方法
        mapper.add(brand);
        //提交事务
       sqlSession.commit();
       //释放资源
       sqlSession.close();
    }

    /**
     * 删除数据
     */
    @Override
    public void delete(int id) {
        //定义SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //实行方法
        mapper.delete(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * g更新
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        //定义SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //实行方法
        mapper.update(brand);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 按id批量删除
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        //定义SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //实行方法
        mapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 按页查询，传入页号以及页的大小
     * 这个Brand其实是传入PageBean的参数
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int size){
        //定义SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //计算开始索引
        int beginIndex=(currentPage-1)*size;
        //实行方法
        List<Brand> brands = mapper.selectByPage(beginIndex, size);
        //查询总记录数
        int total = mapper.selectTotal();
        //封装
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.setRows(brands);
        pageBean.setTotalcount(total);
        //释放资源
        sqlSession.close();
        return pageBean;
    }
    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage,int size,Brand brand){
        //定义SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //计算开始索引
        int beginIndex=(currentPage-1)*size;

        //因为做的是模糊条件查询所以要对传入的查询条件做一下处理
        String brandName = brand.getBrandName();
//        brandName!=''会报错所以要换一种表达方法来判断其不为空值
        if(brandName!=null&&brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");

        }
        String companyName = brand.getCompanyName();
        if(companyName!=null&&companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }
        //实行方法
        List<Brand> brands = mapper.selectByPageAndCondition(beginIndex,size,brand);
        //查询总记录数
        int total = mapper.selectTotalCountByCondition(brand);
        //封装
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.setRows(brands);
        pageBean.setTotalcount(total);
        //释放资源
        sqlSession.close();
        return pageBean;
    }

}

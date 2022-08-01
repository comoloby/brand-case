package com.itheima.pojo;

import java.util.List;

//分页查询的JavaBean封装的是总共数据条数以及每页应当展示的内容
//这个T是指带泛型，是为了方便代码复用的，使用的时候再定义T的具体内容
public class PageBean<T> {
    private int totalcount;
    private List<T> rows;


    public PageBean() {
    }

    public PageBean(int totalcount, List<T> rows) {
        this.totalcount = totalcount;
        this.rows = rows;
    }

    /**
     * 获取
     * @return totalcount
     */
    public int getTotalcount() {
        return totalcount;
    }

    /**
     * 设置
     * @param totalcount
     */
    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    /**
     * 获取
     * @return rows
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String toString() {
        return "PageBean{totalcount = " + totalcount + ", rows = " + rows + "}";
    }
}

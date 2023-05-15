package com.tzh.service;


import com.tzh.pojo.Person;
import com.tzh.pojo.pageBean;

import java.util.List;

public interface personService {
    /*
     * 查询所有
     * @return
     * */
    List<Person> selectAll();

    /*
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     * */
    pageBean<Person> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    pageBean<Person> selectByPageAndCondition(int currentPage, int pageSize, Person person);

    /**
     * 分页条件查询2
     * @param currentPage
     * @param pageSize
     * @return
     */
    pageBean<Person> selectByPageAndCondition2(int currentPage, int pageSize, Person person);

    /**
     * 根据id批量删除
     * @param ids
     */
    void deleteByIds(int [] ids);

    /**
     * 添加数据
     * @param person
     */
    void add(Person person);

    /**
     * 更新数据
     * @param person
     */
    void update(Person person);
}

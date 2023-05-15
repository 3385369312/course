package com.tzh.service.impl;


import com.tzh.mapper.PersonMapper;

import com.tzh.pojo.Person;
import com.tzh.pojo.pageBean;

import com.tzh.service.personService;
import com.tzh.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class personServiceImpl implements personService {
    // 1. 创建sqlSessionFactory工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Person> selectAll() {
        // 2. 获取SQLSession对象
        SqlSession sqlSession = factory.openSession();
        // 3. 获取BrandMapper
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);


        // 4. 调用方法
        List<Person> persons = mapper.selectALL();
        // 5. 释放资源
        sqlSession.close();
        return persons;
    }

    @Override
    public pageBean<Person> selectByPage(int currentPage, int pageSize) {
        // 2. 获取SQLSession对象
        SqlSession sqlSession = factory.openSession();
        // 3. 获取BrandMapper
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);


        // 4.计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        // 5. 查询当前页数据
        List<Person> rows = mapper.selectByPage(begin, size);

        // 6. 查询总记录数
        int totalCount = mapper.selectTotalCount();

        // 7.封装pageBean对象
        pageBean<Person> pageBean = new pageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        // 8.释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public pageBean<Person> selectByPageAndCondition(int currentPage, int pageSize, Person person) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        // 处理person条件，模糊表达式
        String personName = person.getPersonName();

        if (personName != null && personName.length() > 0) {
            person.setPersonName("%" + personName + "%");
        }

        //5. 查询当前页数据
        List<Person> rows = mapper.selectByPageAndCondition(begin, size, person);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(person);


        //7. 封装PageBean对象
        pageBean<Person> pageBean = new pageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public pageBean<Person> selectByPageAndCondition2(int currentPage, int pageSize, Person person) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        // 处理person条件，模糊表达式
        String personName = person.getPersonName();
        String education = person.getEducation();
        String title = person.getTitle();
        if (personName != null && personName.length() > 0) {
            person.setPersonName("%" + personName + "%");
        }
        if (education != null && education.length() > 0) {
            person.setEducation("%" + education + "%");
        }
        if (title != null && title.length() > 0) {
            person.setTitle("%" + title + "%");
        }

        //5. 查询当前页数据
        List<Person> rows = mapper.selectByPageAndCondition2(begin, size, person);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCountByCondition2(person);


        //7. 封装PageBean对象
        pageBean<Person> pageBean = new pageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public void deleteByIds(int[] ids) {
        // 2. 获取SQLSession对象
        SqlSession sqlSession = factory.openSession();
        // 3. 获取BrandMapper
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        // 4. 调用方法
        mapper.deleteByIds(ids);
        sqlSession.commit();//提交事务
        // 5. 释放资源
        sqlSession.close();
    }

    @Override
    public void add(Person person) {
        // 2. 获取SQLSession对象
        SqlSession sqlSession = factory.openSession();
        // 3. 获取BrandMapper
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        // 4. 调用方法
        mapper.add(person);

        sqlSession.commit();//提交事务

        // 5. 释放资源
        sqlSession.close();
    }

    @Override
    public void update(Person person) {
        SqlSession sqlSession = factory.openSession();

        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        mapper.update(person);

        sqlSession.commit();

        sqlSession.close();
    }


}

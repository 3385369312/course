package com.tzh.web.servlet;

import com.alibaba.fastjson.JSON;

import com.tzh.pojo.Person;
import com.tzh.pojo.pageBean;

import com.tzh.service.impl.personServiceImpl;
import com.tzh.service.personService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "personServlet", value = "/person/*")
public class personServlet extends baseServlet{
    private personService personService= new personServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 调用service查询
        List<Person> persons = personService.selectAll();
        // 2. 转为JSON数据
        String jsonString = JSON.toJSONString(persons);
        // 3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收当前页码和每页展示条数   url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 调用service查询
        pageBean<Person> pageBean = personService.selectByPage(currentPage,pageSize);
        // 2. 转为JSON数据
        String jsonString = JSON.toJSONString(pageBean);
        // 3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 员工的简单分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收 当前页码 和 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 person
        Person person = JSON.parseObject(params, Person.class);

        //2. 调用service查询
        pageBean<Person> pageBean = personService.selectByPageAndCondition(currentPage,pageSize,person);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 管理员组合分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收 当前页码 和 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 person
        Person person = JSON.parseObject(params, Person.class);

        //2. 调用service查询
        pageBean<Person> pageBean = personService.selectByPageAndCondition2(currentPage,pageSize,person);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 根据id批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine(); // json字符串

        // 得到的是[1,2,3,]这样的JSON字符串，需要转为int[]
        int[] ids = JSON.parseObject(params, int[].class);

        // 2. 调用service添加
        personService.deleteByIds(ids);
        // 3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 添加数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine(); // json字符串

        // 转为brand对象
        Person person = JSON.parseObject(params, Person.class);

        // 2. 调用service添加
        personService.add(person);
        // 3. 响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 更新
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        BufferedReader reader = req.getReader();
        String params = reader.readLine();

        Person person = JSON.parseObject(params, Person.class);

        personService.update(person);

        resp.getWriter().write("success");
    }
}

package com.tzh.mapper;


import com.tzh.pojo.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonMapper {
    // mybatis注解
    /*
     * 查询所有
     * return
     * */
    @Select("select * from information")
    List<Person> selectALL();

    /*
     * 批量删除
     * */
    void deleteByIds(@Param("ids") int [] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select top (#{size}) * from information where id not in(select top (#{begin}) id from information) ")
    List<Person> selectByPage(@Param("begin") int begin,@Param("size") int size);
    /**
     * 总记录数
     * @return
     */
    @Select("select count(*) from information")
    int selectTotalCount();

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    List<Person> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("person") Person person);

    /**
     * 根据条件查询总记录数
     * @param person
     * @return
     */
    int selectTotalCountByCondition(@Param("person") Person person);

    /**
     * 分页条件查询2
     * @param begin
     * @param size
     * @return
     */
    List<Person> selectByPageAndCondition2(@Param("begin") int begin, @Param("size") int size, @Param("person") Person person);

    /**
     * 根据条件查询总记录数2
     * @param person
     * @return
     */
    int selectTotalCountByCondition2(@Param("person") Person person);


    /**
     * 添加数据
     * @param person
     */
    @Insert("insert into information values(#{personName},#{gender},#{education},#{marriage},#{title},#{wages})")
    void add(Person person);

    /**
     * 管理员更新数据
     * @param person
     */
    @Update("update information set personName = #{personName}, gender = #{gender},education = #{education},marriage=#{marriage}, title=#{title}, wages=#{wages} where id = #{id}")
    void update(Person person);
}

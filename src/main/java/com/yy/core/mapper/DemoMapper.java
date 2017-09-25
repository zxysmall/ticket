package com.yy.core.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yy.core.bean.Demo;

@Mapper 
public interface DemoMapper {
//    @Select("select * from demo where name = #{name}")
    public List<Demo> likeName(String name);
//    @Select("select * from demo")
    public List<Demo> findAll();
//    @Select("select * from demo where id = #{id}")
    public Demo getById(long id);
//    @Select("select name from demo where id = #{id}")
    public String getNameById(long id);
}


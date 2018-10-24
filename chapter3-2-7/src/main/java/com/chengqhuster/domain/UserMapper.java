package com.chengqhuster.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user(name, age) values (#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Results({@Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")})
    @Select("select name, age from user")
    List<User> findAll();
}
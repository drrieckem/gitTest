package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(@Param("id") int id);
    // 1）方法不行 返回Parameter index out of range (1 > number of parameters, which is 0).错误
//  1） @Select("select* from user where  name like '%#{name}%'")
//    2）这个注解也行
//    2）@Select("select* from user where  name like concat('%' #{name} '%')")
    @Select("select* from user where  name like '%' #{name} '%'")
    List<User> queryUserNameLike(@Param("name") String name);


}
package io.zhi.springbootmybatisdruid.dao;

import io.zhi.springbootmybatisdruid.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Mapper
public interface UserDao {
	public int insertUser(@Param("user") User user) throws Exception;
	public User findUserByName(String name) throws Exception;
	public List<User> findUsers() throws Exception;
}

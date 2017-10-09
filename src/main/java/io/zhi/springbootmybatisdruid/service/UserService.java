package io.zhi.springbootmybatisdruid.service;

import io.zhi.springbootmybatisdruid.pojo.User;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface UserService {
	public int inserUser(User user) throws Exception;
	public List<User> findUsers() throws Exception;
	public User findUserByName(String name) throws Exception;
	//All users with paging
	public PageInfo<User> findAll(Integer pageNo, Integer pageSize) throws Exception;
}

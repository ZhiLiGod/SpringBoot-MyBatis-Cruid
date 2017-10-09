package io.zhi.springbootmybatisdruid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.zhi.springbootmybatisdruid.dao.UserDao;
import io.zhi.springbootmybatisdruid.pojo.User;
import io.zhi.springbootmybatisdruid.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int inserUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

	@Override
	public List<User> findUsers() throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUsers();
	}

	@Override
	public User findUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserByName(name);
	}

	@Override
	public PageInfo<User> findAll(Integer pageNo, Integer pageSize) throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<User> list = userDao.findUsers();
		PageInfo<User> page = new PageInfo<User>(list);
		//System.out.println(page.getList().size());
		return page;
	}

}

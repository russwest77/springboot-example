package com.wondersgroup.store.user.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.wondersgroup.store.user.bo.User;
import com.wondersgroup.store.user.dao.UserMapper;
import com.wondersgroup.store.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void findAllUsers() {
		//List<User> result = userMapper.findAllUsers();
		String sql = "select * from user";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> resultMap : result) {
			for(Entry<String,Object> entry : resultMap.entrySet()){
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
			}
		}
	}

	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}

	@Override
	public User findUserById(String id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
}

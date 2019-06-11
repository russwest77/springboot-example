package com.wondersgroup.store.user.dao;

import com.wondersgroup.store.user.bo.User;

public interface UserMapper {
	
	int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}

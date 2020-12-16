package com.hippo.service.impl;

import com.hippo.entity.User;
import com.hippo.service.UserService;

/**
 * @Author: HAOHAORUI
 * @Date: Create in 4:04 PM 2020/12/15
 * @Email: rhh0809@163.com
 */
public class UserServiceImpl implements UserService {
    @Override
    public User selectUserFromName(String userName) {

        User user = new User();
        return user;
    }

    @Override
    public int register(User user) {

        return 0;
    }
}

package com.hippo.service;

import com.hippo.entity.User;

/**
 * @Author: HAOHAORUI
 * @Date: Create in 4:03 PM 2020/12/15
 * @Email: rhh0809@163.com
 */
public interface UserService {


    public User selectUserFromName(String userName);

    public int register(User user);

}

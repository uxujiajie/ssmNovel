package com.ssm.test.service;

import com.ssm.test.domain.User;
import com.ssm.test.domain.UserExam;

/**
 * Created by xu on 2017/7/23.
 */
public interface UserService {
    /**
     *  注册
     */
    void registUser(User user,String basePath) throws Exception;
    /**
     * 查找用户
     */
    User findUserByName(String username);
    /**
     * 激活
     */
    void activeUser(String activeCode);
    /**
     * 登录
     */
    UserExam loginUser(User user);
    /**
     * 删除书架
     */
    void deleteRacks(Integer userId,Integer[] bookId);
}

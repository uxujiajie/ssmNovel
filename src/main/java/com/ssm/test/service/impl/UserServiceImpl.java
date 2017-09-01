package com.ssm.test.service.impl;

import com.ssm.test.domain.User;
import com.ssm.test.domain.UserExam;
import com.ssm.test.mapper.UserMapper;
import com.ssm.test.service.UserService;
import com.ssm.test.util.MailUitls;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 用户控制层实现类
 *
 * @author xu
 * @create 2017-07-23-11:16
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user,String basePath) throws Exception {
        User user1 = userMapper.selectUser(user);
        if(user1 != null)
            return;

        //生成UUID作为激活码
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUserAcode(uuid);
        user.setUserRole(0);
        user.setUserState(0);
        user.setUserBalance(new BigDecimal(0));
        userMapper.insertUser(user);
        //发送激活邮件
        MailUitls.sendMail(user.getUserEmail(), uuid, basePath);
    }

    public User findUserByName(String username) {
        User user = new User();
        user.setUserName(username);
        User user1 =  userMapper.selectUser(user);
        if(user1 == null)
            return null;
        return user1;
    }

    /**
     * 激活用户
     * @param activeCode
     */
    public void activeUser(String activeCode) {
        userMapper.updateUserState(activeCode);
    }

    public UserExam loginUser(User user) {
        UserExam user1 =  userMapper.selectUserAndBook(user);

       if(user1 != null && user1.getUserPass().equals(user.getUserPass() ) )
           return user1;
       else
           return null;
    }

    public void deleteRacks(Integer userId, Integer[] bookId) {
        userMapper.deleteRacks(userId, bookId);
    }
}

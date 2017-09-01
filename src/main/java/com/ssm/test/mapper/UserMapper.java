package com.ssm.test.mapper;

import com.ssm.test.domain.User;
import com.ssm.test.domain.UserExam;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xu on 2017/7/23.
 */
@Repository
public interface UserMapper {

    /**
     * 添加用户
     */
    void insertUser(User user);
    /**
     * 查找用户
     */
    User selectUser(User user);
    /**
     * 查找用户带书架
     */
    UserExam selectUserAndBook(User user);
    /**
     * 修改用户
     */
    void updateUser(User user);
    /**
     * 更新用户状态
     */
    void updateUserState(String userAcode);

    /**
     * 删除用户书架
     * @param userId
     * @param bookId
     */
    void deleteRacks(@RequestParam("userId") Integer userId,@RequestParam("bookIds") Integer[] bookId);
}

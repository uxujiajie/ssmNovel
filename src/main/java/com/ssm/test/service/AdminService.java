package com.ssm.test.service;

import com.ssm.test.domain.Admin;
import com.ssm.test.domain.Book;

/**
 * 管理员专用
 * Created by xu on 2017/8/1.
 */
public interface AdminService {
    /**
     * 上传小说txt文件
     */
    void uploadNovel(Book book,String pattern) throws  Exception;

    /**
     * 登录
     */
    Admin loginAdmin(Admin admin) throws Exception;
}

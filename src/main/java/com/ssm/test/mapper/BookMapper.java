package com.ssm.test.mapper;

import java.util.List;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.BookExam;
import com.ssm.test.domain.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface BookMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    /**
     * 查询总记录数
     */
    Integer selectCount();
    /**
     * 查询所有记录
     */
    List<Book> selectByPage(@Param("begin")Integer begin, @Param("end")Integer end);

    /**\
     * 按照点击量
     * @param begin
     * @param end
     * @return
     */
    List<Book> selectByPageHits(@Param("begin")Integer begin, @Param("end")Integer end);

    /**
     * 按照更新时间   逆序
     * @param begin
     * @param end
     * @return
     */
    List<Book> selectByPageUpdateTime(@Param("begin")Integer begin, @Param("end")Integer end);

    /**
     * 按照创建时间  逆序
     * @param begin
     * @param end
     * @return
     */
    List<Book> selectByPageCreateDate(@Param("begin")Integer begin, @Param("end")Integer end);
    /**
     * 根据书名或作者查询图书
     */
    List<Book> selectByAuthorOrName(String authorOrName);
    /**
     * 按照主键查询
     * @param id
     * @return
     */
    Book selectByPrimaryKey(Integer id);

    /**
     * 根据主键查询书关联评论和用户
     */
    BookExam selectByPriKeyAndUserComm(Integer id);

    /**
     * 按照用户id查询
     * @param userId
     * @return
     */
    List<Book> selectByUserId(Integer userId);

    /**
     * 查询前12本图书，按照点击数排序
     * @return
     */
    List<Book> selectBookOrderByHit();

    /**
     * 根据书的id更新章节
     * @param id
     */
    void updateBookNum(Integer id);
    /**
     *
     */
    void updateBookNumByNum(Book book);
    /**
     * 添加书架
     * @param
     * @return
     */
    void insertBookRack(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}
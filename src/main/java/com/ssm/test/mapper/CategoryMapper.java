package com.ssm.test.mapper;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.Category;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    /**
     * 查找所有分类
     * @return
     */
    List<Category> selectAllCate();

    /**
     * 查找一级分类
     * @param
     * @return
     */
    List<Category> selectFirCate();

    /**
     * 查找一级分类和下属二级分类
     * @param id 一级分类主键
     * @return
     */
    List<Category> selectFirAndSecCate(Integer id);

    /**
     * 查找分类下的书总数
     * @return
     */
    Integer selectCountByCate(List<Category> cateList);

    /**
     * 查找分类下的书
     * @param categoryList
     * @param begin
     * @param end
     * @return
     */
    List<Book> selectBookByCate(@Param("list") List<Category> categoryList,@Param("begin") Integer begin,@Param("end") Integer end);

    /**
     * 根据id查询父id
     * @param id 主键
     * @return
     */
    Category selectParentIdById(Integer id);
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
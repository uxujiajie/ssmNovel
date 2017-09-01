package com.ssm.test.mapper;

import com.ssm.test.domain.SecExam;
import com.ssm.test.domain.Section;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionMapper {

    /**
     *根据用户id查询章节
     * @param bookId 书的id
     * @return
     */
    List<Section> selectByBookId(Integer bookId);

    int deleteByPrimaryKey(Integer id);

    int insert(Section record);

    /**
     * 添加章节，num根据查询书章节总数自动加
     * @param record
     * @return
     */
    int insertSec(Section record);

    /**
     *
     * @param section
     * @return
     */
     SecExam selectSecByBook(Section section);

    int insertSelective(Section record);

    Section selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);
}
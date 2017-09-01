package com.ssm.test.service;

import com.ssm.test.domain.SecExam;
import com.ssm.test.domain.Section;

/**章节接口
 * Created by xu on 2017/7/27.
 */
public interface SectionService {

    /**
     * 添加章节
     */
    void uploadSection(String content, Section section, Integer userId) throws  Exception;

    /**
     * 查看章节内容
     */
    SecExam lookSecContent(Integer bookId, Integer secId) throws Exception;
}

package com.ssm.test.service.impl;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.BookExam;
import com.ssm.test.domain.SecExam;
import com.ssm.test.domain.Section;
import com.ssm.test.mapper.BookMapper;
import com.ssm.test.mapper.SectionMapper;
import com.ssm.test.service.SectionService;
import com.ssm.test.util.PropUril;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;


/**
 * 章节逻辑层实现类
 *
 * @author xu
 * @create 2017-07-27-20:56
 */
public class SectionServiceImpl implements SectionService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private SectionMapper sectionMapper;
    /**
     * 上传章节
     * @param content
     * @param section
     */
    public void uploadSection(String content, Section section, Integer userId) throws Exception {
        /**
         * 根据书id查询地址
         */
        Book book = bookMapper.selectByPrimaryKey(section.getBookid() );
        if(userId != book.getUserId())
            return;                                 //此处本来该抛出异常
        section.setSectionnum(book.getBooknum()+1);
        /**
         * 添加章节到数据库
         */
        sectionMapper.insert(section);
        /**
         * 更新书的章节+1
         */
        bookMapper.updateBookNum(section.getBookid() );
       // Section sec = sectionMapper.selectByPrimaryKey(section.getId() );



        /**
         * 写入文件
         */
        File file = new File( PropUril.FILEPATH + "\\"+book.getBookurl(), (book.getBooknum()+1)+".txt");
        if (!file.exists() )
            file.createNewFile();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        String[] ss =  content.split("\n");
        for (String s : ss)
        {
            bw.write(s+"<br>");
            bw.flush();
        }
        bw.close();
        return;
    }

    /**
     * 查看章节内容
     * @param bookId
     * @param secNumId
     * @return
     * @throws Exception
     */
    public SecExam lookSecContent(Integer bookId, Integer secNumId) throws Exception {
        Section section = new Section();
        section.setBookid(bookId);
        section.setSectionnum(secNumId);
        /**
         * 查看章节
         */
        SecExam secExam = sectionMapper.selectSecByBook(section);

        /**
         * 下载小说
         */
        File file = new File(PropUril.FILEPATH+"\\"+secExam.getBookUrl(), secExam.getSectionnum()+".txt");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file),"UTF-8") );

        String s;
        StringBuffer sb = new StringBuffer();
        while ((s = br.readLine() ) != null)
        {
            sb.append(s+"<br>");
        }
        br.close();
        //设置小说内容
        secExam.setContent(sb.toString() );
        return secExam;
    }
}

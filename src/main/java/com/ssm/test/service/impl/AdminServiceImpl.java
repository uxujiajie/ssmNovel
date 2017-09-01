package com.ssm.test.service.impl;

import com.ssm.test.domain.Admin;
import com.ssm.test.domain.Book;
import com.ssm.test.domain.Section;
import com.ssm.test.mapper.AdminMapper;
import com.ssm.test.mapper.BookMapper;
import com.ssm.test.mapper.SectionMapper;
import com.ssm.test.service.AdminService;
import com.ssm.test.util.PropUril;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 管理员专用逻辑层实现类
 *
 * @author xu
 * @create 2017-08-01-20:22
 */
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SectionMapper sectionMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AdminMapper adminMapper;
    /**
     * 上传小说
     * @param book
     */
    public void uploadNovel(Book book,String pattern) throws Exception {
        //拿到数据
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(PropUril.FILEPATH+"\\"+book.getBookurl() + book.getBookname()+"_副本.txt"),
                        "GB2312")  );

        File f = new File(PropUril.FILEPATH+"\\"+book.getBookurl()+"0.txt");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));

        String s;

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m ;
        int num = 1;

        while ( ( s = br.readLine() ) != null)
        {
            m = r.matcher(s);
            if(s.length() < 50 && m.matches() )
            {
                bw.close();
                Section section = new Section();
                section.setBookid(book.getId() );
                section.setSectiontitle(s);
                section.setSectionnum(num);
                sectionMapper.insert(section);
                f = null;
                //创建章节，写入数据库
                f = new File(PropUril.FILEPATH+ "\\" + book.getBookurl()+num+".txt");
                f.createNewFile();
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8") );
                num++;
            } else {
                bw.write(s+"<br>");
            }
        }
        bw.close();
        br.close();
        book.setBooknum(--num);
        bookMapper.updateBookNumByNum(book);
    }

    public Admin loginAdmin(Admin admin) throws Exception {
        Admin loginAdmin = adminMapper.selectAdminUser(admin);
        if(loginAdmin != null && loginAdmin.getAdPass().equals(admin.getAdPass() ) &&
                loginAdmin.getRoleId().equals(admin.getRoleId() ) )
            return loginAdmin;
        return null;
    }
}

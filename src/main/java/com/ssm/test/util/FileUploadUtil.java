package com.ssm.test.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * springMvc文件上传路径类
 *
 * @author xu
 * @create 2017-07-24-16:32
 */
public class FileUploadUtil {

    /**
     * 用uuid当文件名, 文件名的hash码进行目录打散
     * @param root : 根目录
     */
    public String uploadByUUIdAndHash(MultipartFile muFile,String root) throws Exception{
        //原始名称
        String original = muFile.getOriginalFilename();

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件名称
        String fileName = uuid +
                original.substring(original.lastIndexOf(".") );

        //得到hashcode值目录分级
        int hCode = fileName.hashCode();
        String hex = Integer.toHexString(hCode);

        //文件目录
        File file = new File(root, hex.charAt(0) +"\\" + hex.charAt(1)
                + "\\" + fileName);
        if(!file.exists() )
            file.mkdirs();
        //将内存中的数据写入磁盘
        muFile.transferTo(file);

        return "";
    }
}

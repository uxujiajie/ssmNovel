package com.ssm.test.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩工具类
 *
 * @author xu
 * @create 2017-08-06-10:33
 */
public class ZipUtil {
    public static void main(String[] args) {
       File file = new File("D://神级系统.txt");
       File zipFile = new File("D://神级系统.zip");
        zipCompress(file, zipFile);
    }

    /**
     * 压缩单个文件
     * @param srcfile   源文件
     * @param zipFile   压缩后文件
     */
    public static void zipCompress(File srcfile,File zipFile) {
        FileInputStream fis = null;
        //表示zip里的文件
        ZipEntry zipEntry = new ZipEntry(srcfile.getName() );
        //File zipFile = new File("D://神级系统.zip");
        FileOutputStream fos = null;
        ZipOutputStream gos = null;
        try {
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(zipFile);
            gos = new ZipOutputStream(fos);
            gos.putNextEntry(zipEntry);
            byte[] b = new byte[1024];
            while (fis.read(b) != -1) {
                gos.write(b);
            }
            gos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (gos != null) gos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
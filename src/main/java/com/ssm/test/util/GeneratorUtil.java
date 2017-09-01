package com.ssm.test.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis逆向工程工具类
 * 利用数据库表生成pojo的mapper和java类
 * @author xu
 * @create 2017-07-24-9:41
 */
public class GeneratorUtil {
    public void generator()throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite =true;
        File configFile = new File("E://generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback,warnings);
        myBatisGenerator.generate(null);
    }
    public static void main(String[] args){
        GeneratorUtil gen = new GeneratorUtil();
        try {
            gen.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

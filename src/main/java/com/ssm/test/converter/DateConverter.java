package com.ssm.test.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换日期类型(yyyy-MM-dd)
 *
 * @author xu
 * @create 2017-07-23-8:54
 */
public class DateConverter implements Converter<String,Date> {

    public Date convert(String source) {
        //将日期串转换成日期类型
        SimpleDateFormat simFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

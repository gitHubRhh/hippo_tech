package com.hippo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: HAOHAORUI
 * @Date: Create in 9:49 AM 2020/12/16
 * @Email: rhh0809@163.com
 */
public class DateUtil {

    public static String format(Date date,String string){

        if(date==null || string==null||"".equals(string)){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(string);

        String dateFormat = sdf.format(date);

        return dateFormat;
    }
}

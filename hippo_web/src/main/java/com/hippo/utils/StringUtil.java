package com.hippo.utils;

/**
 * @Author: HAOHAORUI
 * @Date: Create in 9:42 AM 2020/12/16
 * @Email: rhh0809@163.com
 */
public class StringUtil {


    public static boolean isEmpty(String str){

        boolean flag = true;

        if(str == null || "".equals(str)){
            flag=true;
        }

        return flag;

    }



}

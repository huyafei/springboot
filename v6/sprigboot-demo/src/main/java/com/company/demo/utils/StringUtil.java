package com.company.demo.utils;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/8 15:32
 */
public class StringUtil {
    /**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @param smallLetter 是否为小写字母
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line,boolean smallLetter){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            if(smallLetter){
                sb.append(word.toLowerCase());
            }else {
                sb.append(word.toUpperCase());
            }

            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String str1="adminCodeTime";
        String str2="admin_code_time";
        System.out.println(camel2Underline(str1,true));
        System.out.println(underline2Camel(str2,true));
        String str3="admincodetime";
        System.out.println(camel2Underline(str3,true));
        System.out.println(underline2Camel(str3,true));
    }
}

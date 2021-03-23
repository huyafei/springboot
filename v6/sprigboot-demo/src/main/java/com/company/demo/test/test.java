package com.company.demo.test;

import javafx.application.Application;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/30 17:23
 */
public class test {
    @Test
    public void testMap(){
        Map<String,String> mapObj=new HashMap<>();
        mapObj.put("name","abc");
        System.out.println(mapObj);
    }
    @Test
    public void testDate(){
        Date d=new Date();
        System.out.println(d);
        //时间戳毫秒
        System.out.println(System.currentTimeMillis());
    }
    @Test
    public void selectAdminById(){
    }
}

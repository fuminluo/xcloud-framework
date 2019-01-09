package com.xcloud.framework;

import com.xcloud.framework.entity.User;
import com.xcloud.framework.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XcloudUserApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("==start===" + df.format(new Date()));// new Date()为获取当前系统时间
        List<User> users = userMapper.findAll();
        System.out.println("==数据量==" + users.size());
        System.out.println("==end==" + df.format(new Date()));// new Date()为获取当前系统时间
    }

}

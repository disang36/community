package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Component
@ContextConfiguration(classes=CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(101);
        System.out.println(user);
        User user1=userMapper.selectByName("liubei");
        System.out.println(user1);
        User user2=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user2);
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("12345");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows= userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }
    @Test
    public void updateUser(){
        int rows=userMapper.updateStatus(150,1);
        System.out.println(rows);
        int rows1=userMapper.updateHeader(150,"http://images.nowcoder.com/head/149t.png");
        System.out.println(rows1);
        int rows2=userMapper.updatePassword(150,"11111111111");
        System.out.println(rows2);
    }
    @Test
    public void testSelectPosts(){
        List<DiscussPost> list= discussPostMapper.selectDiscussPosts(149,0,10);
        for (DiscussPost post:list){
            System.out.println(post);
        }
        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }
}

package com.org.Demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.org.Demo.mp.mappers.UserMapper;
import com.org.Demo.mp.po.User;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.*;

/**
 * @author xujiafu
 * @date 2021/11/27 20:53
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelect() {
        List<User> list = userMapper.selectList(null);
        assertEquals(5, list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void test3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","name","email").likeRight("name","黄");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    public class SqlCondition {
        //下面的字符串中, %s 是占位符, 第一个 %s 是列名, 第二个 %s 是列的值
        public static final String EQUAL = "%s=#{%s}";
        public static final String NOT_EQUAL = "%s&lt;&gt;#{%s}";
        public static final String LIKE = "%s LIKE CONCAT('%%',#{%s},'%%')";
        public static final String LIKE_LEFT = "%s LIKE CONCAT('%%',#{%s})";
        public static final String LIKE_RIGHT = "%s LIKE CONCAT(#{%s},'%%')";
    }

    @Test
    public void test4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String,Object> param = new HashMap<>();
        param.put("age",40);
        param.put("name","黄飞飞");
        wrapper.allEq(param);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }
    @Test
    public void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("age", 40);
        param.put("name", null);
        wrapper.allEq(param);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


    @Test
    public void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("age", 40);
        param.put("name", null);
        wrapper.allEq(param, false);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test7() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("age", 40);
        param.put("name", "黄飞飞");
        wrapper.allEq((k,v) -> !"name".equals(k), param); // 过滤掉map中key为name的元素
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}

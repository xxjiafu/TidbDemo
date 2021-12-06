package com.org.Demo.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.org.Demo.mp.po.User;
import com.org.Demo.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
/**
 * @author xujiafu
 * @date 2021/12/5 22:57
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testGetOne() {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        wrapper.gt(User::getAge, 28);
        User one = userService.getOne(wrapper, false); // 第二参数指定为false,使得在查到了多行记录时,不抛出异常,而返回第一条记录
        System.out.println(one);
    }

    @Test
    public void testChain() {
        List<User> list = userService.lambdaQuery()
                .gt(User::getAge, 39)
                .likeRight(User::getName, "王")
                .list();
        list.forEach(System.out::println);
    }
}

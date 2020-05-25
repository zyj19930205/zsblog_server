package cn.zyj.zsblog;

import cn.zyj.zsblog.entity.User;
import cn.zyj.zsblog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ZsblogApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users=userMapper.selectUserByNameAndPwd("qwe1234rt","qwe1234");
        System.out.println(users);
    }

}

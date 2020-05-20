package cn.zyj.zsblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "cn.zyj.zsblog.mapper")
public class ZsblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsblogApplication.class, args);
    }

}

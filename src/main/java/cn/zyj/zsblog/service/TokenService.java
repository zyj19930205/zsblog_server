package cn.zyj.zsblog.service;

import cn.zyj.zsblog.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 37980
 * 用户生成token的service类
 */
@Service
public class TokenService {
    public String getToken(User user) {
        Date start = new Date();
        //一小时有效时间
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getUsername()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}

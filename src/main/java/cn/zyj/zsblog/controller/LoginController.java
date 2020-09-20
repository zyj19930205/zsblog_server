package cn.zyj.zsblog.controller;

import cn.zyj.zsblog.config.UserLoginToken;
import cn.zyj.zsblog.entity.Bo.ResultMessage;
import cn.zyj.zsblog.entity.User;
import cn.zyj.zsblog.mapper.UserMapper;
import cn.zyj.zsblog.service.TokenService;
import cn.zyj.zsblog.util.JwtUtil;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 37980
 */
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultMessage login(HttpServletRequest request, HttpServletResponse respo){
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        Boolean remember = Boolean.parseBoolean(request.getParameter("rememberme"));
        List<User> users= userMapper.selectUserByNameAndPwd(userName,passWord);
        if(users.size()==0){
            return ResultMessage.resultMessage_failed();
        }
        String token = tokenService.getToken(users.get(0));
        Cookie cookie=new Cookie("token",token);
        cookie.setPath("/");
        respo.addCookie(cookie);
        System.out.println(ResultMessage.resultMessage_success(users,token));
        return ResultMessage.resultMessage_success(users,token);
    }


    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println(JwtUtil.getTokenUserId());

        return "验证通过！";
    }

    @RequestMapping(value = "/changePwd",method = RequestMethod.POST)
    public String changePwd(User user){
        userMapper.updateById(user);
        return "修改成功!";
    }
}

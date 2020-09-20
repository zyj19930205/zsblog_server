package cn.zyj.zsblog.mapper;

import cn.zyj.zsblog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 37980
 */
@Repository
public interface UserMapper extends BaseMapper<User> {


    /**
     * 用来判断是否用户存在
     * @param username
     * @param password
     * @return
     */
    @Select("select*from zs_user where username=#{username} and password=#{password}")
     List<User> selectUserByNameAndPwd(@Param("username") String username, @Param("password") String password);


    /**
     * 根据ID查用户
     * @param userId
     * @return
     */
    @Select("select*from zs_user where id=#{id}")
    User selectUserById(@Param("id") String userId);
}

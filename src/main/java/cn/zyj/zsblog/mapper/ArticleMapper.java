package cn.zyj.zsblog.mapper;

import cn.zyj.zsblog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zyj
 */

@Repository

public interface ArticleMapper extends BaseMapper<Article> {


    @Select("select zs_article.*,zs_user.nickname from zs_user,zs_article where zs_user.id=zs_article.authorId and zs_article.id = #{id}  ")
    Map<String, Object> getArticleInfoById(Integer id);


    @MapKey("id")
    @Select("select zs_article.*,zs_user.nickname from zs_user,zs_article where zs_user.id=zs_article.authorId")
    Map<Long,Map<String,Object>> getArticle();

}

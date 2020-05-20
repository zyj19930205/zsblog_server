package cn.zyj.zsblog.mapper;

import cn.zyj.zsblog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zyj
 */

@Repository

public interface ArticleMapper extends BaseMapper<Article> {
}

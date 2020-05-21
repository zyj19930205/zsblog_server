package cn.zyj.zsblog.controller;


import cn.zyj.zsblog.entity.Article;
import cn.zyj.zsblog.mapper.ArticleMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 邹宇杰
 */
@CrossOrigin
@RestController
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    HttpServletRequest req;


    @RequestMapping(value = "/article/{id}", method =  RequestMethod.GET)
    public Map<String,Object> getArticleById(@PathVariable int id){
        //Article article=articleMapper.selectById(id);
        //List<Article> articles=articleMapper.getArticleInfoById(id);
        Map<String,Object> map= articleMapper.getArticleInfoById(id);
        System.out.println(map);
        return map;
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String addArticle(Article article){
        articleMapper.insert(article);
        return "haha";
    }

    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public Map<Long,Map<String,Object>> getArticles(){
        //List<Article> articles=articleMapper.selectList(null);
        Map<Long,Map<String,Object>> articles=articleMapper.getArticle();
        return articles;
    }

    @RequestMapping(value = "/articleTip/{id}",method = RequestMethod.POST)
    public String addArticleTips(@PathVariable int id){
        Article article=articleMapper.selectById(id);
        Long tips = article.getTips();
        tips++;
        article.setTips(tips);
        articleMapper.updateById(article);
        return "success";
    }
}

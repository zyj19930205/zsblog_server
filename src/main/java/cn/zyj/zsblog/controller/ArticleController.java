package cn.zyj.zsblog.controller;


import cn.zyj.zsblog.entity.Article;
import cn.zyj.zsblog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 邹宇杰
 */
@CrossOrigin
@RestController
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;


    @RequestMapping(value = "/article/{id}", method =  RequestMethod.GET)
    public Article getArticleById(@PathVariable int id){
        Article article=articleMapper.selectById(id);
        return article;
    }


    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String addArticle(Article article){
        articleMapper.insert(article);
        return "haha";
    }

    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public List<Article> getArticles(){
        List<Article> articles=articleMapper.selectList(null);
        return articles;
    }
}

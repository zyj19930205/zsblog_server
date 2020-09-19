package cn.zyj.zsblog.controller;


import cn.zyj.zsblog.config.UserLoginToken;
import cn.zyj.zsblog.entity.Article;
import cn.zyj.zsblog.mapper.ArticleMapper;
import cn.zyj.zsblog.util.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.Claims;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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


    @UserLoginToken
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
        System.out.println(article);
        articleMapper.insert(article);
        return "haha";
    }

    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public Map<Long,Map<String,Object>> getArticles(HttpServletRequest request){
//            String userId = JwtUtil.getTokenUserId();
            Map<Long, Map<String, Object>> articles = articleMapper.getArticle();
            return articles;
        //List<Article> articles=articleMapper.selectList(null);
    }

    @RequestMapping(value ="/articles/{userId}",method = RequestMethod.GET)
    public List<Article> getArticlesByUserId(@PathVariable int userId){
        QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("authorId",userId);
        List<Article> articles=articleMapper.selectList(queryWrapper);
        return articles;
    }

    @RequestMapping(value = "articleByPage",method = RequestMethod.GET)
    public List<Article> getArticlesByPage(@RequestParam(defaultValue = "10") int limit,@RequestParam(defaultValue = "1") int page){
        IPage<Article> articleIPage=new Page<>(page,limit);
        articleIPage = articleMapper.selectPage(articleIPage,null);
        List<Article> articles=articleIPage.getRecords();
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


    /**
     * 文件上传
     * @param file
     * @return
     */
    @RequestMapping("/getFile")
    public String getFile(@RequestParam(value = "img") MultipartFile file){
        String imgName = file.getOriginalFilename();
        // 后缀名
        String suffixName = imgName.substring(imgName.lastIndexOf("."));
        // 上传后的路径
        String filePath = "C://img//";
        // 新文件名
        imgName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + imgName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/img/" + imgName;
        return filename;
    }

    @RequestMapping(value ="del/{id}",method = RequestMethod.DELETE)
    public String delArticleById(@PathVariable int id){
        int result = articleMapper.deleteById(id);
        return "success!";
    }

    @RequestMapping(value="/upd",method = RequestMethod.POST)
    public int updateArticleById(Article article){
        System.out.println("有人访问了更新接口，传来的数据是"+article);
        int result = articleMapper.updateById(article);
        return result;
    }

    @RequestMapping(value = "/addTip/{article_id}",method = RequestMethod.GET)
    public String addTip(@PathVariable int article_id){
        articleMapper.updateStarsById(article_id);
        return "success";
    }


}

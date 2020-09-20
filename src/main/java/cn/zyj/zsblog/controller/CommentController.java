package cn.zyj.zsblog.controller;

import cn.zyj.zsblog.entity.Comment;
import cn.zyj.zsblog.mapper.CommentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 37980
 */
@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping(value = "/getComment/{articleId}",method = RequestMethod.GET)
    public List<Comment> getComment(@PathVariable int articleId){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("articleId",articleId);
        List<Comment> comments=commentMapper.selectList(queryWrapper);
        return comments;
    }

    @RequestMapping(value = "/addcomment",method = RequestMethod.POST)
    public String addComment(Comment comment){
        commentMapper.insert(comment);
        System.out.println(comment);
        return "提交成功！";
    }

}

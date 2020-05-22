package cn.zyj.zsblog.controller;


import cn.zyj.zsblog.entity.Tag;
import cn.zyj.zsblog.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 37980
 */
@CrossOrigin
@RestController
public class TagController {

    @Autowired
    TagMapper tagMapper;

    @RequestMapping(value = "getTags",method = RequestMethod.GET)
    public List<Tag> getAllTags(){
        return tagMapper.selectList(null);
    }
}

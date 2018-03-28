package com.nanfenggongxiang.Controller.Front;

import com.nanfenggongxiang.Dao.PostReplyDao;
import com.nanfenggongxiang.Dao.PostReplyMapper;
import com.nanfenggongxiang.Domain.PostReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by skyisbule on 2018/3/28.
 */
@RestController
public class postReplyController {

    @Autowired
    PostReplyMapper dao;
    @Autowired
    PostReplyDao    complexDao;

    @RequestMapping("/private/postReply/add")
    public String add(PostReply reply){
        Date date = new Date();
        reply.setReleaseTime(date);
        return dao.insert(reply)==1?"success":"error";
    }

    @RequestMapping("/public/postReply/get-by-page")
    public List<PostReply> GetByPage(int page,int postId){
        return complexDao.getPostReplyByPage(page,postId);
    }

}

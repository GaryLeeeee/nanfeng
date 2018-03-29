package com.nanfenggongxiang.Controller.Front;

import com.nanfenggongxiang.Dao.NewsCommentDao;
import com.nanfenggongxiang.Dao.NewsCommentMapper;
import com.nanfenggongxiang.Domain.NewsComment;
import com.nanfenggongxiang.Domain.PostReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by skyisbule on 2018/3/28.
 * 咨询的留言表
 */
@RestController
public class newsReplyController {

    @Autowired
    NewsCommentMapper dao;
    @Autowired
    NewsCommentDao    complexDao;

    @RequestMapping("/private/newsReply/add")
    public String add(NewsComment comment){
        Date date = new Date();
        comment.setReleaseTime(date);
        return dao.insert(comment)==1?"success":"error";
    }

    @RequestMapping("/public/newsReply/get-by-page")
    public List<NewsComment> getByPage(int newsId,int page){
        return complexDao.getByPage(page*10,newsId);
    }

}
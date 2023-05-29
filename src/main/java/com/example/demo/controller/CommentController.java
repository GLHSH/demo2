package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Experience;
import com.example.demo.entity.Reply;
import com.example.demo.service.ICommentService;
import com.example.demo.service.IReplyService;
import lombok.val;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Consumer;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-16
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    ICommentService iCommentService;

    @Resource
    IReplyService iReplyService;

    @ResponseBody
    @RequestMapping("/selectComment")
    public List<Comment> selectComment(@RequestParam("") int experience_id) {
        val comments = iCommentService.selectById(experience_id);
        val positionList = new ArrayList<Integer>();
        comments.forEach(comment-> positionList.add(comment.getId()));

        val replys = iReplyService.selectById(experience_id);
        for (int i = 0; i < replys.size(); i++) {
            val reply = replys.get(i);
            comments.get(
                    positionList.indexOf(reply.getCommentId())
            ).addReplyItem(reply);
        }
        System.out.println(" 评论信息 "+comments);
        return comments;
    }

    @ResponseBody
    @RequestMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        iCommentService.addComment(comment);
        return comment;
    }

    @ResponseBody
    @RequestMapping("/updateCommentGood")
    public int updateCommentGood(@RequestBody Comment comment) {
        System.out.println("评论点赞数更新");
        return iCommentService.updateCommentGood(comment);
    }

    @ResponseBody
    @RequestMapping("/updateReplyGood")
    public int updateReplyGood(@RequestBody Reply reply) {
        System.out.println("回复点赞数更新");
        return iReplyService.updateReplyGood(reply);
    }

    @ResponseBody
    @RequestMapping("/addReply")
    public Reply addReply(@RequestBody Reply reply) {
        iReplyService.addReply(reply);
        return reply;
    }
    @ResponseBody
    @RequestMapping("/delReply")
    public void delReply(@RequestBody Reply reply) {
        iReplyService.delReply(reply);
    }


}

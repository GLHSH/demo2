package com.example.demo.Dao;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Reply;
import com.example.demo.mapper.ReplyMapper;
import com.github.yulichang.query.MPJQueryWrapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ReplyDaoImpI implements IReplyDao {

    @Resource
    ReplyMapper replyMapper;

    @Override
    public List<Reply> seleclById(int experience_id) {
        MPJQueryWrapper<Reply> wrapper = new MPJQueryWrapper<Reply>()
                .select("*")
                .eq("t.experience_id", experience_id);
        //列表查询
        return replyMapper.selectList(wrapper);
    }

    @Override
    public void addReply(Reply reply) {
        replyMapper.insert(reply);
    }

    @Override
    public void delReply(Reply reply) {
        replyMapper.deleteById(reply);
    }

    @Override
    public int updateReplyGood(Reply reply) {
        System.out.println("CommentDao 层updatereplyGood" + reply);
        UpdateWrapper<Reply> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", reply.getId())
                .set("good", reply.getGood());
        return replyMapper.update(null, updateWrapper);
    }


}

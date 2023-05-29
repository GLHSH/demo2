package com.example.demo.Dao;

//import com.github.yulichang.query.MPJQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeTalk;
import com.example.demo.mapper.LikeExMapper;
import com.example.demo.mapper.LikeTalkMapper;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class LikeTalkDaoImpI implements ILikeTalkDao {

    @Resource
    LikeTalkMapper likeTalkMapper;

    @Override
    public int addLikeTalk(LikeTalk likeTalk) {
        System.out.println("LikeTalkDao层的待添加的 : \t" + likeTalk);

        val selectOne = selectLike(likeTalk);
        var i = -1;
        if (selectOne == null){
            i = likeTalkMapper.insert(likeTalk);
        }
        System.out.println("刚刚添加的记录:\t" + likeTalk +"\n");
        return i;
    }

    @Override
    public int delLikeTalk(LikeTalk likeTalk) {
        QueryWrapper<LikeTalk> wrapper = new QueryWrapper<>();
        wrapper.eq("experience_id", likeTalk.getExperienceId())
                .eq("comment_id", likeTalk.getCommentId())
                .eq("user_id", likeTalk.getUserId());
        if (likeTalk.getReplyId() !=null && likeTalk.getReplyId()!= 0)
            wrapper.eq("reply_id", likeTalk.getReplyId());
        val i = likeTalkMapper.delete(wrapper);
        System.out.println("刚刚删除的记录:\t" + likeTalk +"\n 影响的行数 : "+i);
        return i;
    }

    @Override
    public LikeTalk selectLike(LikeTalk likeTalk) {
        QueryWrapper<LikeTalk> wrapper = new QueryWrapper<>();
        wrapper.eq("experience_id",likeTalk.getExperienceId())
                .eq("comment_id",likeTalk.getCommentId())
                .eq("user_id",likeTalk.getUserId())
                .eq("reply_id",likeTalk.getReplyId());
        return likeTalkMapper.selectOne(wrapper);
    }
}

package com.example.demo.service.impl;

import com.example.demo.Dao.ICommentDao;
import com.example.demo.Dao.IReplyDao;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Reply;
import com.example.demo.mapper.ReplyMapper;
import com.example.demo.service.IReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-16
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {

    @Resource
    IReplyDao iReplyDao;

    @Override
    public List<Reply> selectById(int experience_id) {
        return iReplyDao.seleclById(experience_id);
    }

    @Override
    public void addReply(Reply reply) {
        iReplyDao.addReply(reply);
    }

    @Override
    public void delReply(Reply reply) {
        iReplyDao.delReply(reply);
    }

    @Override
    public int updateReplyGood(Reply reply) {
        return iReplyDao.updateReplyGood(reply);
    }
}

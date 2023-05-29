package com.example.demo.service.impl;

import com.example.demo.Dao.ILikeTalkDao;
import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeTalk;
import com.example.demo.mapper.LikeTalkMapper;
import com.example.demo.service.ILikeTalkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-18
 */
@Service
public class LikeTalkServiceImpl extends ServiceImpl<LikeTalkMapper, LikeTalk> implements ILikeTalkService {

    @Resource
    ILikeTalkDao iLikeTalkDao;

    @Override
    public int addLikeTalk(LikeTalk likeTalk) {
        return iLikeTalkDao.addLikeTalk(likeTalk);
    }

    @Override
    public int delLikeTalk(LikeTalk likeTalk) {
        return iLikeTalkDao.delLikeTalk(likeTalk);
    }

    @Override
    public LikeTalk selectLike(LikeTalk likeTalk) {
        return iLikeTalkDao.selectLike(likeTalk);
    }
}

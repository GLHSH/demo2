package com.example.demo.service.impl;

import com.example.demo.Dao.ILikeExDao;
import com.example.demo.entity.LikeEx;
import com.example.demo.mapper.LikeExMapper;
import com.example.demo.service.ILikeExService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-06
 */
@Service
public class LikeExServiceImpl extends ServiceImpl<LikeExMapper, LikeEx> implements ILikeExService {

    @Resource
    ILikeExDao likeExDao;

    @Override
    public int addLikeEx(LikeEx likeEx) {
        return likeExDao.addLikeEx(likeEx);
    }

    @Override
    public int delLikeEx(LikeEx likeEx) {
        return likeExDao.delLikeEx(likeEx);
    }

    @Override
    public LikeEx selectLike(LikeEx likeEx) {
        return likeExDao.selectLike(likeEx);
    }
}

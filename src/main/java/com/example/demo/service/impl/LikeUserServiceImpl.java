package com.example.demo.service.impl;

import com.example.demo.Dao.ILikeUserDao;
import com.example.demo.entity.LikeUser;
import com.example.demo.mapper.LikeUserMapper;
import com.example.demo.service.ILikeUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-14
 */
@Service
public class LikeUserServiceImpl extends ServiceImpl<LikeUserMapper, LikeUser> implements ILikeUserService {

    @Resource
    ILikeUserDao likeUserDao;
    @Override
    public int addLikeUser(LikeUser likeUser) {
        return likeUserDao.addLikeUser(likeUser);
    }

    @Override
    public int delLikeUser(LikeUser likeUser) {
        return likeUserDao.delLikeUser(likeUser);
    }
}

package com.example.demo.service;

import com.example.demo.entity.LikeUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-14
 */
public interface ILikeUserService extends IService<LikeUser> {
    int addLikeUser(LikeUser likeUser);

    int delLikeUser(LikeUser likeUser);

    LikeUser selectLike(LikeUser likeUser);
}

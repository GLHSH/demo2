package com.example.demo.service;

import com.example.demo.entity.LikeEx;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-06
 */
public interface ILikeExService extends IService<LikeEx> {
    int addLikeEx(LikeEx likeEx);

    int delLikeEx(LikeEx likeEx);

    LikeEx selectLike(LikeEx likeEx);
}

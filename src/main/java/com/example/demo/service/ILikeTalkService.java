package com.example.demo.service;

import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeTalk;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.LikeUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-18
 */
public interface ILikeTalkService extends IService<LikeTalk> {

    int addLikeTalk(LikeTalk likeTalk);

    int delLikeTalk(LikeTalk likeTalk);

    LikeTalk selectLike(LikeTalk likeTalk);
}

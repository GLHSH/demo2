package com.example.demo.service;

import com.example.demo.entity.GoodEx;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.LikeEx;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-18
 */
public interface IGoodExService extends IService<GoodEx> {
    int addGoodEx(GoodEx goodEx);

    int delGoodEx(GoodEx goodEx);

    GoodEx selectLike(GoodEx goodEx);
}

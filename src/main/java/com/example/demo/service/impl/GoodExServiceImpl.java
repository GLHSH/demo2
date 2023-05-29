package com.example.demo.service.impl;

import com.example.demo.Dao.IGoodExDao;
import com.example.demo.Dao.ILikeExDao;
import com.example.demo.entity.GoodEx;
import com.example.demo.entity.LikeEx;
import com.example.demo.mapper.GoodExMapper;
import com.example.demo.service.IGoodExService;
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
public class GoodExServiceImpl extends ServiceImpl<GoodExMapper, GoodEx> implements IGoodExService {

    @Resource
    IGoodExDao goodExDao;

    @Override
    public int addGoodEx(GoodEx goodEx) {
        return goodExDao.addGoodEx(goodEx);
    }

    @Override
    public int delGoodEx(GoodEx goodEx) {
        return goodExDao.delGoodEx(goodEx);
    }

    @Override
    public GoodEx selectLike(GoodEx goodEx) {
        return goodExDao.selectLike(goodEx);
    }

}

package com.wpx.shop_goods.service;

import com.wpx.shop_goods.domain.GoodsInfo;

import java.util.List;

public interface GoodsInfoService {

    List<GoodsInfo> findAll() throws Exception;

    List<GoodsInfo> search(String nameLike)throws Exception;

    GoodsInfo addGoods(GoodsInfo goodsInfo)throws Exception;

    void delGoods(String goodsNo)throws Exception;

    GoodsInfo updateGoods(GoodsInfo goodsInfo)throws Exception;


}

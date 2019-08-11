package com.wpx.shop_goods.dao;

import com.wpx.shop_goods.domain.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsInfoDao extends JpaRepository<GoodsInfo, String> {
    @Query(value = "from goodsinfo where goodsName like %:nameLike%", nativeQuery = true)
    List<GoodsInfo> search(@Param("nameLike") String nameLike);
}

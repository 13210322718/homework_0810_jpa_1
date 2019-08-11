package com.wpx.shop_goods;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wpx.shop_goods.domain.GoodsInfo;
import com.wpx.shop_goods.service.GoodsInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopGoodsApplicationTests {
    @Autowired
    GoodsInfoService goodsInfoService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<GoodsInfo>(GoodsInfo.class));
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class,GoodsInfo.class) ;
        List<GoodsInfo> goodsInfos = redisTemplate.opsForHash().values("goodsInfos");
        for (GoodsInfo goodsInfo:goodsInfos){
            System.out.println(goodsInfo);
        }
    }

    @Test
    public void add() {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsName("狗屎2");
        goodsInfo.setGoodsPrice(10.9);
        goodsInfo.setGoodsSource("天猫");
        try {
            GoodsInfo goodsInfo1 = goodsInfoService.addGoods(goodsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

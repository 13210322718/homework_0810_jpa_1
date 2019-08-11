package com.wpx.shop_goods.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wpx.shop_goods.dao.GoodsInfoDao;
import com.wpx.shop_goods.domain.GoodsInfo;
import com.wpx.shop_goods.service.GoodsInfoService;
import com.wpx.shop_goods.util.RandomStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Autowired
    GoodsInfoDao goodsInfoDao;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取全部商品,并且分页
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsInfo> findAll() throws Exception {
        List<String> goodsInfos = redisTemplate.opsForHash().values("goodsInfos");
        if (goodsInfos == null || goodsInfos.size() < 1) {
            List<GoodsInfo> all = goodsInfoDao.findAll();
            return all;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<GoodsInfo> all = new ArrayList<>();
        for (String s : goodsInfos) {
            GoodsInfo goodsInfo = objectMapper.readValue(s, GoodsInfo.class);
            all.add(goodsInfo);
        }
        return all;
    }

    /**
     * 按照商品名模糊查询
     *
     * @param nameLike
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsInfo> search(String nameLike) throws Exception {
        List<GoodsInfo> search = goodsInfoDao.search(nameLike);
        return search;
    }
    /**
     * 增加商品
     *
     * @param goodsInfo
     * @return
     * @throws Exception
     */
    @Override
    public GoodsInfo addGoods(GoodsInfo goodsInfo) throws Exception {
        //获取随机字符串
        String randomStr = RandomStr.getRandomStr();
        //设置商品编号
        goodsInfo.setGoodsNo(randomStr);
        goodsInfo.setGoodsCommentsNum(0);
        //执行保存操作
        GoodsInfo save = goodsInfoDao.save(goodsInfo);
        //进行序列化操作
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(save);
        //设置序列化
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //存入到redis哈希位置
        redisTemplate.opsForHash().put("goodsInfos", goodsInfo.getGoodsNo(), json);
        return save;
    }

    /**
     * @param goodsNo
     * @throws Exception
     */
    @Override
    public void delGoods(String goodsNo) throws Exception {
        //删除数据库表信息
        goodsInfoDao.deleteById(goodsNo);
        //删除redis缓存信息
        redisTemplate.opsForHash().delete("goodsInfos", goodsNo);
    }

    @Override
    public GoodsInfo updateGoods(GoodsInfo goodsInfo) throws Exception {
        GoodsInfo save = goodsInfoDao.save(goodsInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(save);
        //设置序列化
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //存入到redis哈希位置
        redisTemplate.opsForHash().put("goodsInfos", goodsInfo.getGoodsNo(), json);
        return save;
    }
}

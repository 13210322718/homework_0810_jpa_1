package com.wpx.shop_user.util;

import java.util.UUID;

/**
 * 该类用于长生一个随机的数字字符串
 */
public class RandomStr {
    public static String getRandomStr() {
        Integer orderId = UUID.randomUUID().toString().hashCode();
        orderId = orderId < 0 ? -orderId : orderId; //String.hashCode() 值会为空
        return orderId + "";
    }
}

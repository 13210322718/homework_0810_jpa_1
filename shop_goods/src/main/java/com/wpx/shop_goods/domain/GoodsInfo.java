package com.wpx.shop_goods.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goodsinfo")
public class GoodsInfo implements Serializable {
    @Id
    private String goodsNo;
    private String goodsName;
    private String goodsSource;
    private Double goodsPrice;
    private String goodsDescribe;
    private Integer goodsCommentsNum;
    public GoodsInfo() {
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSource() {
        return goodsSource;
    }

    public void setGoodsSource(String goodsSource) {
        this.goodsSource = goodsSource;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public Integer getGoodsCommentsNum() {
        return goodsCommentsNum;
    }

    public void setGoodsCommentsNum(Integer goodsCommentsNum) {
        this.goodsCommentsNum = goodsCommentsNum;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "goodsNo='" + goodsNo + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSource='" + goodsSource + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", goodsCommentsNum=" + goodsCommentsNum +
                '}';
    }
}

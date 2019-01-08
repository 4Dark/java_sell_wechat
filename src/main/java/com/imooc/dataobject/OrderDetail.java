package com.imooc.dataobject;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * 订单详情表
 */
@Entity
@Data
public class  OrderDetail {
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private  String productIcon;
}

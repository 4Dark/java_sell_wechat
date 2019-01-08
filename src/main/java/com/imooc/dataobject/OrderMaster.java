package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单主表
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /**订单ID**/
    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /**订单状态, 默认为新下单 0 **/
    private Integer orderStatus = OrderStatusEnum.NEW_ORDER.getCode();

    /**支付状态, 默认为0-未支付**/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

//    Transient 注解的意思 与数据库对应时 忽略此字段，但是这么做不好,使用DTO， 在格层之间传输
//    @Transient
//    private List<OrderDetail> orderDetailList;
}
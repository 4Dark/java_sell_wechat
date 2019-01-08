package com.imooc.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_STATUS_ERROR(14, "订单状态异常"),
    ORDER_UPDATE_FAILED(15, "订单更新失败"),
    PAY_STATUS_ERROR(16, "订单支付状态异常"),
    CART_EMPTY(17,"购物车为空"),
    ORDER_NOT_COMPARE(18,"订单不一致"),
    WECHAT_MP_ERROR(19,"微信公众号错误"),
    ORDER_AMOUNT_ERROR(20,"订单金额错误");

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}

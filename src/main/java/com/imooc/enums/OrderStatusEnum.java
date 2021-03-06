package com.imooc.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum{
    NEW_ORDER(0,"新订单"),
    SUCCESS(1,"已完成订单"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}

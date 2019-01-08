package com.imooc.vo;


import lombok.Data;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg="";
    private T data;  // data 里面是个对象，定义成一个范性


}

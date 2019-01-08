package com.imooc.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成主键
     * 格式：时间 + 随机数
     * @return
     */
    public static synchronized   String genUniqueKey(){
        long timeStamp = System.currentTimeMillis();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static void main(String[] args) {
        System.out.println(genUniqueKey());
    }
}
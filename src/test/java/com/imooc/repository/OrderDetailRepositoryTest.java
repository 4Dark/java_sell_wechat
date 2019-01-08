package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("00001");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.xxx.xxx/xxx.jpg");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("辣椒炒肉");
        orderDetail.setProductQuantity(2);
        orderDetail.setProductPrice(new BigDecimal(12.5));
        OrderDetail result = repository.save(orderDetail);
        Assert.assertEquals("00001",result.getDetailId());
    }

    @Test
    public void findByOrderId(){
        List<OrderDetail> result = repository.findByOrderId("123456");
        Assert.assertEquals("123456",result.get(0).getOrderId());


    }



}
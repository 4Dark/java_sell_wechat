package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "wx123456";
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("长沙");
        orderMaster.setBuyerName("张三");
        orderMaster.setOrderId("123458");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("18684979775");
        orderMaster.setOrderAmount(new BigDecimal(10.9));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderMaster> page =  repository.findByBuyerOpenid(OPENID,pageRequest);
        Assert.assertNotEquals(0,page.getTotalElements());
        Assert.assertEquals(2,page.getContent().size());
    }
}
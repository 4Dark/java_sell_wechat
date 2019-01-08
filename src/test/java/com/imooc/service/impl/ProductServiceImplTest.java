package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.transform.Source;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productInfoService;
    @Test
    public void findOne() {
        ProductInfo one = productInfoService.findOne("1234");
        Assert.assertEquals("1234",one.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productInfoService.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> all = productInfoService.findAll(pageRequest);
        Assert.assertNotEquals(0,all.getTotalElements());
//        System.out.println(all.getTotalElements());


    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("11111");
        productInfo.setProductName("皮蛋");
        productInfo.setCategoryType(2);
        productInfo.setProductStock(1);
        productInfo.setProductStatus(1);
        productInfo.setProductPrice(new BigDecimal(3.2));
        ProductInfo save = productInfoService.save(productInfo);
        Assert.assertNotNull(save);
    }
}
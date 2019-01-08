package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * CategoryServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 27, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findOne(Integer categoryId)
     */
    @Test
    public void testFindOne() throws Exception {
        ProductCategory one = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),one.getCategoryId());
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotEquals(0,all.size());
    }

    /**
     * Method: findByCategoryTypeIn(List<Integer> categoryTypeList)
     */
    @Test
    public void testFindByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    /**
     * Method: save(ProductCategory productCategory)
     */
    @Test
    public void testSave() throws Exception {
        ProductCategory one = new ProductCategory("男生专想", 10);
        ProductCategory res = categoryService.save(one);
        Assert.assertNotNull(res);
    }


} 

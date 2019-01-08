package com.imooc.controller;

import com.imooc.converter.OrderForm2OrderDTOConverter;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.vo.ProductInfoVO;
import com.imooc.vo.ProductVO;
import com.imooc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;




    @GetMapping("/list")
    public ResultVO list() {
        // 1. 查询所有的上架商品
        List<ProductInfo> upAll = productService.findUpAll();

        // 2. 查询商品类目（一次性查询）
        // 传统遍历 upAll ，获取类目 放进categoryList
        // ArrayList<Integer> categoryList = new ArrayList<>();
//先转为stream  再提取getCategoryType，然后转为集合
        List<Integer> categoryList = upAll.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(categoryList);
//        3. 数据拼装  先遍历类目，后详情

        ArrayList<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            ArrayList<ProductInfoVO> productInfoVOList = new ArrayList<>();
//            取得与类目相同的放在一个集合里面
            for (ProductInfo productInfo : upAll) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                productVO.setProductInfoVOList(productInfoVOList);
                productVOList.add(productVO);
            }

        }
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        ProductVO productVO = new ProductVO();

//        ProductInfoVO productInfoVO = new ProductInfoVO();
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

        resultVO.setData(productVOList);
        return resultVO;
    }

}

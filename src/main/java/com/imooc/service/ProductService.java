package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有的在架的商品列表
     * @return
     */
    public Page<ProductInfo> findAll(Pageable pageable);

    public ProductInfo findOne(String productId);

    public List<ProductInfo> findUpAll();

    public List<ProductInfo> findByCategoryType(Integer categoryType);

    public ProductInfo save(ProductInfo productInfo);

    /*加库存*/
    public void increaseStock(List<CartDTO> cart);

    /*减库存 */
    public void decreaseStock(List<CartDTO> cart);
}

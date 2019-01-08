package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 类目
 * Created by 廖师兄
 * 2017-05-07 14:30
 */
@Entity  // @Entity 表明该类 (UserEntity) 为一个实体类，它默认对应数据库中的表名是user_entity
@DynamicUpdate   //动态更新时间
@Data  // 包含生成get set toString 等方法  例如 @get
//@Table(name="s_product_category") 指定数据库表名，否则默认是product_category
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}

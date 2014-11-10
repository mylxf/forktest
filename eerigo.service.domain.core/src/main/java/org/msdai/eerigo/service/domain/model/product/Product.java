package org.msdai.eerigo.service.domain.model.product;

import org.msdai.eerigo.service.domain.core.AggregateRootBase;

import org.msdai.eerigo.service.domain.model.Dimensions;
import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.domain.model.category.Category;
import org.msdai.eerigo.service.domain.model.country.Country;
import org.msdai.eerigo.service.domain.model.Resource;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/10
 * Time: 22:41
 */
public class Product extends AggregateRootBase {
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品所属类别
     */
    private Category productCategory;

    /**
     * 商品所属品牌
     */
    private Brand productBrand;

    /**
     * 商品原产地
     */
    private Country origin;

    /**
     * 商品描述
     */
    private String productDesc;

    /**
     * 商品图片
     */
    private List<Resource> productImages;

    /**
     * 商品成本价
     */
    private Double costPrice;

    /**
     * 商品出售价
     */
    private Double sellPrice;

    /**
     * 商品三围
     */
    private Dimensions productDimensions;

    /**
     * 商品重量
     */
    private Double weight;

    /**
     * 商品规格参数
     */
    private List<ProductProperty> productProperties;

    /**
     * 商品聚合属性
     */
    private List<ProductProperty> productAggregateProperties;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Brand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(Brand productBrand) {
        this.productBrand = productBrand;
    }

    public Country getOrigin() {
        return origin;
    }

    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public List<Resource> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<Resource> productImages) {
        this.productImages = productImages;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Dimensions getProductDimensions() {
        return productDimensions;
    }

    public void setProductDimensions(Dimensions productDimensions) {
        this.productDimensions = productDimensions;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<ProductProperty> getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(List<ProductProperty> productProperties) {
        this.productProperties = productProperties;
    }

    public List<ProductProperty> getProductAggregateProperties() {
        return productAggregateProperties;
    }

    public void setProductAggregateProperties(List<ProductProperty> productAggregateProperties) {
        this.productAggregateProperties = productAggregateProperties;
    }
}

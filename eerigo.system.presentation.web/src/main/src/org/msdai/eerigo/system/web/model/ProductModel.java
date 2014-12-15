package org.msdai.eerigo.system.web.model;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductModel {
    private String id;
    private String productName;
    private String productCategoryId;
    private CategoryModel productCategory;
    private String productBrandId;
    private BrandModel productBrand;
    private String countryId;
    private CountryModel origin;
    private String productDesc;
    private Double costPrice;
    private Double sellPrice;
    private Double weight;
    private ResourceModel picResource;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String categoryId) {
        this.productCategoryId = categoryId;
    }

    public CategoryModel getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(CategoryModel category) {
        this.productCategory = category;
    }

    public String getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(String brandId) {
        productBrandId = brandId;
    }

    public BrandModel getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(BrandModel brand) {
        this.productBrand = brand;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public CountryModel getOrigin() {
        return origin;
    }

    public void setOrigin(CountryModel origin) {
        this.origin = origin;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ResourceModel getPicResource() {
        return picResource;
    }

    public void setPicResource(ResourceModel resource) {
        this.picResource = resource;
    }
}

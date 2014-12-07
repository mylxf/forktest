package org.msdai.eerigo.service.serviceinterface.datacontract;

import org.msdai.eerigo.core.service.BaseDTO;

import java.util.List;

/**
 * Created by fengfeng on 14/11/12.
 */
public class ProductDTO extends BaseDTO {
    private String id;
    private String productName;
    private String productCategoryId;
    private CategoryDTO productCategory;
    private String productBrandId;
    private BrandDTO productBrand;
    private String countryId;
    private CountryDTO origin;
    private String productDesc;
    private List<ResourceDTO> productImages;
    private Double costPrice;
    private Double sellPrice;
    private DimensionsDTO productDimensions;
    private Double weight;
    private List<ProductPropertyDTO> productProperties;
    private List<ProductPropertyDTO> productAggregateProperties;

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
        productCategoryId = categoryId;
    }

    public CategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(CategoryDTO category) {
        this.productCategory = category;
    }

    public String getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(String brandId) {
        productBrandId = brandId;
    }

    public BrandDTO getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(BrandDTO brand) {
        this.productBrand = brand;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public CountryDTO getOrigin() {
        return origin;
    }

    public void setOrigin(CountryDTO origin) {
        this.origin = origin;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public List<ResourceDTO> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ResourceDTO> productImages) {
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

    public DimensionsDTO getProductDimensions() {
        return productDimensions;
    }

    public void setProductDimensions(DimensionsDTO productDimensions) {
        this.productDimensions = productDimensions;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<ProductPropertyDTO> getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(List<ProductPropertyDTO> productProperties) {
        this.productProperties = productProperties;
    }

    public List<ProductPropertyDTO> getProductAggregateProperties() {
        return productAggregateProperties;
    }

    public void setProductAggregateProperties(List<ProductPropertyDTO> productAggregateProperties) {
        this.productAggregateProperties = productAggregateProperties;
    }
}

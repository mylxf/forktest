package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.BrandDomainService;
import org.msdai.eerigo.service.domain.domainservice.CategoryDomainService;
import org.msdai.eerigo.service.domain.domainservice.CountryDomainService;
import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.domain.model.category.Category;
import org.msdai.eerigo.service.domain.model.country.Country;
import org.msdai.eerigo.service.domain.model.product.Product;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.ProductService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductServiceImpl implements ProductService {
    private ProductDomainService productDomainService;
    private CategoryDomainService categoryDomainService;
    private BrandDomainService brandDomainService;
    private CountryDomainService countryDomainService;

    public void setCategoryDomainService(CategoryDomainService categoryDomainService){
        this.categoryDomainService = categoryDomainService;
    }

    public void setBrandDomainService(BrandDomainService brandDomainService){
        this.brandDomainService = brandDomainService;
    }

    public void setCountryDomainService(CountryDomainService countryDomainService){
        this.countryDomainService = countryDomainService;
    }

    public void setProductDomainService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    @Override
    public OperatorResult addProduct(ProductDTO productDTO) {
        Product product = transferProduct(productDTO);
        this.productDomainService.addProduct(product);
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult modifyProduct(ProductDTO productDTO) {
        Product product = transferProduct(productDTO);
        this.productDomainService.modifyCProduct(product);
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult removeProduct(String productId) {
        Product product = productDomainService.getProduct(productId);
        productDomainService.removeProduct(product);

        return new OperatorResult(true);
    }

    @Override
    public OperatorResult batchRemoveProduct(List<String> list) {
        for (String id : list) {
            removeProduct(id);
        }
        return new OperatorResult(true);
    }

    @Override
    public ProductDTO getProduct(String id) {
        Product product = productDomainService.getProduct(id);
        ProductDTO productDTO = ConvertUtils.convert(product, ProductDTO.class);

        if(productDTO!=null){
            if(!StringUtils.isEmpty(productDTO.getProductCategoryId())){
                Category category = categoryDomainService.getCategory(productDTO.getProductCategoryId());
                productDTO.setProductCategory(ConvertUtils.convert(category, CategoryDTO.class));
            }

            if(!StringUtils.isEmpty(productDTO.getProductBrandId())){
                Brand brand = brandDomainService.getBrand(productDTO.getProductBrandId());
                productDTO.setProductBrand(ConvertUtils.convert(brand, BrandDTO.class));
            }

            if(!StringUtils.isEmpty(productDTO.getCountryId())){
                Country country = countryDomainService.getCountry(productDTO.getCountryId());
                productDTO.setOrigin(ConvertUtils.convert(country, CountryDTO.class));
            }
        }

        return productDTO;
    }

    @Override
    public PagedResult<ProductDTO> getProducts() {
        PagedResult<ProductDTO> result = new PagedResult<ProductDTO>();

        List<Product> list = productDomainService.getProducts();
        for (Product product : list) {
            result.add(ConvertUtils.convert(product, ProductDTO.class));
        }
        return result;
    }

    private Product transferProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setProductCategoryId(productDTO.getProductCategoryId());
        product.setProductBrandId(productDTO.getProductBrandId());
        product.setCountryId(productDTO.getCountryId());
        product.setProductDesc(productDTO.getProductDesc());
        product.setCostPrice(productDTO.getCostPrice());
        product.setSellPrice(productDTO.getSellPrice());
        product.setWeight(productDTO.getWeight());

        return product;
    }
}

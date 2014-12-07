package org.msdai.eerigo.service.serviceimpl.query;


import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.query.repository.ProductQueryRepository;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.BrandService;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.CategoryService;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.CountryService;
import org.msdai.eerigo.service.serviceinterface.servicecontract.query.ProductQueryService;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductQueryServiceImpl implements ProductQueryService {
    private ProductQueryRepository productQueryRepository;
    private CategoryService categoryService;
    private BrandService brandService;
    private CountryService countryService;

    public ProductQueryServiceImpl(ProductQueryRepository productQueryRepository,
                                   CategoryService categoryService,
                                   BrandService brandService,
                                   CountryService countryService) {
        this.productQueryRepository = productQueryRepository;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.countryService = countryService;
    }

    @Override
    public PagedResult queryProducts(ProductQueryRequestMessage productQueryRequestMessage) {
        PagedResult pagedResult = this.productQueryRepository.queryProducts(productQueryRequestMessage);

        if (pagedResult != null) {
            for (ProductDTO productDTO : (List<ProductDTO>) pagedResult.getData()) {
                productDTO.setProductCategory(categoryService.getCategory(productDTO.getProductCategoryId()));
                productDTO.setProductBrand(brandService.getBrand(productDTO.getProductBrandId()));
                productDTO.setOrigin(countryService.getCountry(productDTO.getCountryId()));
            }
        }

        return pagedResult;
    }
}

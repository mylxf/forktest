package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.BrandDomainService;
import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.BrandService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 14/11/12
 * Time: 2:09 PM
 */
public class BrandServiceImpl implements BrandService {

    private BrandDomainService brandDomainService;
    private ProductDomainService productDomainService;

    public void setBrandDomainService(BrandDomainService brandDomainService) {
        this.brandDomainService = brandDomainService;
    }

    public void setProductDomainService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    @Override
    public String addBrand(BrandDTO brandDTO) {
        Brand brand = ConvertUtils.convert(brandDTO, Brand.class);
        brandDomainService.addBrand(brand);
        return "";
    }

    @Override
    public void modifyBrand(BrandDTO brandDTO) {
        Brand brand = ConvertUtils.convert(brandDTO, Brand.class);
        brandDomainService.modifyBrand(brand);
    }

    @Override
    public void removeBrand(String brandId) {
        BrandDTO brandDTO = getBrand(brandId);
        Brand brand = ConvertUtils.convert(brandDTO, Brand.class);

        if (!productDomainService.existProducts(brand))
            brandDomainService.removeBrand(brand);
    }

    @Override
    public void batchRemoveBrand(List<String> list) {
        for (String id : list) {
            removeBrand(id);
        }
    }

    @Override
    public BrandDTO getBrand(String id) {
        Brand brand = brandDomainService.getBrand(id);

        return (brand != null) ? ConvertUtils.convert(brand, BrandDTO.class) : null;
    }

    @Override
    public List<BrandDTO> getBrands() {
        List<BrandDTO> result = new ArrayList<BrandDTO>();
        List<Brand> list = brandDomainService.getBrands();
        for (Brand brand : list) {
            result.add(ConvertUtils.convert(brand, BrandDTO.class));
        }
        return result;
    }
}

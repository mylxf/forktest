package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.BrandDomainService;
import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandCollectionDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.BrandService;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 14/11/12
 * Time: 2:09 PM
 */
public class BrandServiceImpl implements BrandService {

    private static Logger logger = Logger.getLogger(BrandServiceImpl.class);

    private BrandDomainService brandDomainService;
    private ProductDomainService productDomainService;

    public void setBrandDomainService(BrandDomainService brandDomainService) {
        this.brandDomainService = brandDomainService;
    }

    public void setProductDomainService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    @Override
    public OperatorResult addBrand(BrandDTO brandDTO) {
        try {
            Brand brand = ConvertUtils.convert(brandDTO, Brand.class);
            brandDomainService.addBrand(brand);
            return new OperatorResult(true);
        } catch (Exception e) {
            logger.fatal(e, e.getCause());
            return new OperatorResult(false);
        }
    }

    @Override
    public OperatorResult modifyBrand(BrandDTO brandDTO) {
        try {
            Brand brand = ConvertUtils.convert(brandDTO, Brand.class);
            brandDomainService.modifyBrand(brand);
            return new OperatorResult(true);
        } catch (Exception e) {
            logger.fatal(e, e.getCause());
            return new OperatorResult(false);
        }
    }

    @Override
    public OperatorResult removeBrand(String brandId) {
        try {
            Brand brand = brandDomainService.getBrand(brandId);
            if (!productDomainService.existProducts(brand)) {
                brandDomainService.removeBrand(brand);
            }
            return new OperatorResult(true);
        } catch (Exception e) {
            logger.fatal(e, e.getCause());
            return new OperatorResult(false);
        }
    }

    @Override
    public OperatorResult batchRemoveBrand(List<String> list) {
        try {
            for (String id : list) {
                removeBrand(id);
            }
            return new OperatorResult(true);
        } catch (Exception e) {
            logger.fatal(e, e.getCause());
            return new OperatorResult(false);
        }
    }

    @Override
    public BrandDTO getBrand(String brandId) {
        Brand brand = brandDomainService.getBrand(brandId);
        if (brand != null) {
            return ConvertUtils.convert(brand, BrandDTO.class);
        }
        return null;
    }

    @Override
    public BrandCollectionDTO getBrands() {
        List<BrandDTO> result = new ArrayList<BrandDTO>();
        List<Brand> list = brandDomainService.getBrands();
        for (Brand brand : list) {
            result.add(ConvertUtils.convert(brand, BrandDTO.class));
        }
        BrandCollectionDTO r = new BrandCollectionDTO();
        r.setBrands(result);
        return r;
    }
}

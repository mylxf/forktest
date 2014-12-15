package org.msdai.eerigo.service.serviceimpl.action;

import org.apache.log4j.Logger;
import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.BrandDomainService;
import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.domainservice.ResourceDomainService;
import org.msdai.eerigo.service.domain.model.Resource;
import org.msdai.eerigo.service.domain.model.brand.Brand;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ResourceDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.BrandService;

import java.util.List;

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
    private ResourceDomainService resourceDomainService;

    public void setBrandDomainService(BrandDomainService brandDomainService) {
        this.brandDomainService = brandDomainService;
    }

    public void setProductDomainService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    public void setResourceDomainService(ResourceDomainService resourceDomainService) {
        this.resourceDomainService = resourceDomainService;
    }

    @Override
    public OperatorResult addBrand(BrandDTO brandDTO) {
        try {
            Brand brand = ConvertUtils.convert(brandDTO, Brand.class);
            brand.setBrandLogo(saveResource(brandDTO.getResource()));
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
            brand.setBrandLogo(saveResource(brandDTO.getResource()));
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
    public PagedResult<BrandDTO> getBrands() {
        PagedResult<BrandDTO> pagedResult = new PagedResult<BrandDTO>();
        List<Brand> list = brandDomainService.getBrands();
        for (Brand brand : list) {
            pagedResult.add(ConvertUtils.convert(brand, BrandDTO.class));
        }
        return pagedResult;
    }

    private Resource saveResource(ResourceDTO resourceDTO) {
        if (resourceDTO != null) {
            Resource resource = ConvertUtils.convert(resourceDTO, Resource.class);
            resourceDomainService.addResource(resource);
            return resource;
        } else {
            return null;
        }
    }
}

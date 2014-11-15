package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.model.product.Product;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductServiceImpl implements ProductService {
    private ProductDomainService productDomainService;

    public void setProductDomainService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = ConvertUtils.convert(productDTO, Product.class);
        this.productDomainService.addProduct(product);
    }

    @Override
    public void modifyProduct(ProductDTO productDTO) {
        Product product = ConvertUtils.convert(productDTO, Product.class);
        this.productDomainService.modifyCProduct(product);
    }

    @Override
    public void removeProduct(String productId) {

    }

    @Override
    public void batchRemoveProduct(List<String> list) {
        for(String id : list){
            removeProduct(id);
        }
    }

    @Override
    public ProductDTO getProduct(String id) {
        Product brand = productDomainService.getProduct(id);

        return (brand != null) ? ConvertUtils.convert(brand, ProductDTO.class) : null;
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> result = new ArrayList<ProductDTO>();
        List<Product> list = productDomainService.getProducts();
        for (Product product : list) {
            result.add(ConvertUtils.convert(product, ProductDTO.class));
        }
        return result;
    }
}

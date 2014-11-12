package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.service.domain.model.category.Category;
import org.msdai.eerigo.service.domain.model.product.Product;
import org.msdai.eerigo.service.domain.repository.ProductRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:09 PM
 */
public class ProductDomainService {
    private ProductRepository productRepository;

    public ProductDomainService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean existProducts(Category category) {
        return false;
    }
}

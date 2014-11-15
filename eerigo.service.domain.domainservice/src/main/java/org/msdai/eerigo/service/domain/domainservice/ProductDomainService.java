package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;
import org.msdai.eerigo.service.domain.model.brand.Brand;
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

    public boolean existProducts(Brand brand){
        return false;
    }

    public Product getProduct(String id) {
        return productRepository.find(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public boolean addProduct(Product product){
        try {
            productRepository.insert(product);
            productRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            productRepository.getContext().rollback();
            return false;
        }
    }

    public boolean modifyCProduct(Product product) {
        try {
            productRepository.update(product);
            productRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            productRepository.getContext().rollback();
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        try {
            productRepository.delete(product);
            productRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            productRepository.getContext().rollback();
            return false;
        }
    }
}

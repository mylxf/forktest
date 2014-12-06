package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.service.domain.model.brand.Brand;

import org.msdai.eerigo.service.domain.repository.BrandRepository;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:05 PM
 */
public class BrandDomainService {
    private BrandRepository brandRepository;

    public BrandDomainService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand getBrand(String id) {
        return brandRepository.find(id.replace("\"",""));
    }

    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    public boolean addBrand(Brand brand) {
        try {
            brandRepository.insert(brand);
            brandRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            brandRepository.getContext().rollback();
            return false;
        }
    }

    public boolean modifyBrand(Brand brand) {
        try {
            brandRepository.update(brand);
            brandRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            brandRepository.getContext().rollback();
            return false;
        }
    }

    public boolean removeBrand(Brand brand) {
        try {
            brandRepository.delete(brand);
            brandRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            brandRepository.getContext().rollback();
            return false;
        }
    }
}

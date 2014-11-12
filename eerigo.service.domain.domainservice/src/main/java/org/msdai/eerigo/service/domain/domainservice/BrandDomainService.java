package org.msdai.eerigo.service.domain.domainservice;


import org.msdai.eerigo.service.domain.repository.BrandRepository;

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
}

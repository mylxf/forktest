package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.service.domain.repository.CountryRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:06 PM
 */
public class CountryDomainService {
    private CountryRepository countryRepository;

    public CountryDomainService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
}

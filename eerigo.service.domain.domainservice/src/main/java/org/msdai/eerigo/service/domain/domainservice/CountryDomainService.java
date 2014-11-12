package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;
import org.msdai.eerigo.service.domain.model.country.Country;
import org.msdai.eerigo.service.domain.repository.CountryRepository;

import java.util.List;

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

    public Country getCountry(String id) {
        return countryRepository.find(id);
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public boolean addCountry(Country country){
        try {
            countryRepository.insert(country);
            countryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            countryRepository.getContext().rollback();
            return false;
        }
    }

    public boolean modifyCountry(Country country) {
        try {
            countryRepository.update(country);
            countryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            countryRepository.getContext().rollback();
            return false;
        }
    }

    public boolean removeBrand(Country country) {
        try {
            countryRepository.delete(country);
            countryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            countryRepository.getContext().rollback();
            return false;
        }
    }
}

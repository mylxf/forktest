package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.CountryDomainService;
import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.model.country.Country;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.CountryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/11/12.
 */
public class CountryServiceImpl implements CountryService {

    private CountryDomainService countryDomainService;
    private ProductDomainService productDomainService;

    public void setCountryDomainService(CountryDomainService countryDomainService) {
        this.countryDomainService = countryDomainService;
    }

    public void setProductDomainService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    @Override
    public void addCountry(CountryDTO countryDTO) {
        Country country = ConvertUtils.convert(countryDTO, Country.class);
        countryDomainService.addCountry(country);
    }

    @Override
    public void modifyCountry(CountryDTO countryDTO) {
        Country country = ConvertUtils.convert(countryDTO, Country.class);
        countryDomainService.modifyCountry(country);
    }

    @Override
    public void removeCountry(CountryDTO countryDTO) {
        Country country = ConvertUtils.convert(countryDTO, Country.class);
        countryDomainService.removeBrand(country);
    }

    @Override
    public CountryDTO getCountry(String id) {
        Country country = countryDomainService.getCountry(id);

        return (country != null) ? ConvertUtils.convert(country, CountryDTO.class) : null;
    }

    @Override
    public List<CountryDTO> getCountries() {
        List<CountryDTO> result = new ArrayList<CountryDTO>();
        List<Country> list = countryDomainService.getCountries();
        for (Country country : list) {
            result.add(ConvertUtils.convert(country, CountryDTO.class));
        }

        return result;
    }
}

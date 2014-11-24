package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
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
    public OperatorResult addCountry(CountryDTO countryDTO) {
        Country country = ConvertUtils.convert(countryDTO, Country.class);
        countryDomainService.addCountry(country);
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult modifyCountry(CountryDTO countryDTO) {
        Country country = ConvertUtils.convert(countryDTO, Country.class);
        countryDomainService.modifyCountry(country);

        return new OperatorResult(true);
    }

    @Override
    public OperatorResult removeCountry(String countryId) {
        CountryDTO countryDTO = getCountry(countryId);
        //Country country = ConvertUtils.convert(countryDTO, Country.class);
        //countryDomainService.removeBrand(country);

        return new OperatorResult(true);
    }

    @Override
    public OperatorResult batchRemoveCountry(List<String> list){
        for(String id : list){
            removeCountry(id);
        }

        return new OperatorResult(true);
    }

    @Override
    public CountryDTO getCountry(String id) {
        Country country = countryDomainService.getCountry(id);

        return (country != null) ? ConvertUtils.convert(country, CountryDTO.class) : null;
    }

    @Override
    public PagedResult<CountryDTO> getCountries() {
        PagedResult<CountryDTO> pagedResult = new PagedResult<CountryDTO>();

        /*
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId("1");
        countryDTO.setCountryName("Japan");
        pagedResult.add(countryDTO);
        */

        List<Country> list = countryDomainService.getCountries();
        for (Country country : list) {
            pagedResult.add(ConvertUtils.convert(country, CountryDTO.class));
        }

        return pagedResult;
    }
}

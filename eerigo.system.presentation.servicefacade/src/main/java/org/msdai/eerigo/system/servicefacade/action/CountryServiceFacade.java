package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CountryServiceFacade {
    public boolean addCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        restClient.post("/addCountry", countryDTO, null);

        return true;
    }

    public boolean modifyCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/modifyCountry", countryDTO, null);
    }

    public boolean removeCountry(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/removeCountry", brandId, null);
    }

    public boolean batchRemoveCountry(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/batchRemoveCountry", list, null);
    }

    public CountryDTO getCountry(String id) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/getCountry", id, CountryDTO.class);

        /*
        CountryDTO countryDTO1 = new CountryDTO();
        countryDTO1.setId(id);
        countryDTO1.setCountryName("Japan");
        countryDTO1.setCountryFlag(null);

        return new PageResultDTO<CountryDTO>(1, countryDTO1);*/
    }

    public PagedResult getCountries() throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/getCountries", null, PagedResult.class);

        /*
        List<CountryDTO> list = new ArrayList<CountryDTO>();
        CountryDTO countryDTO1 = new CountryDTO();
        countryDTO1.setId("1");
        countryDTO1.setCountryName("Japan");
        countryDTO1.setCountryFlag(null);
        list.add(countryDTO1);
        return new PageResultDTO<List<CountryDTO>>(list.size(), list);*/
    }
}

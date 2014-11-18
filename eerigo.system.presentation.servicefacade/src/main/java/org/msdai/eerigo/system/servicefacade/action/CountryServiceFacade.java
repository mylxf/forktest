package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CountryServiceFacade {
    public void addCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        //RestClient restClient = new RestClient("http://localhost:8081/country");
        //restClient.post("/addCountry", countryDTO, null);
    }

    public void modifyCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        //RestClient restClient = new RestClient("http://localhost:8081/country");
        //restClient.post("/modifyCountry", countryDTO, null);
    }

    public void removeCountry(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/country");
        restClient.post("/removeCountry", brandId, null);
    }

    public void batchRemoveCountry(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/country");
        restClient.post("/batchRemoveCountry", list, null);
    }

    public PageResultDTO<CountryDTO> getCountry(String id) throws EerigoRestClientException {
        //RestClient restClient = new RestClient("http://localhost:8081/country");
        //return restClient.post("/getCountry", id, PageResultDTO.class);
        CountryDTO countryDTO1 = new CountryDTO();
        countryDTO1.setId(id);
        countryDTO1.setCountryName("Japan");
        countryDTO1.setCountryFlag(null);

        return new PageResultDTO<CountryDTO>(1, countryDTO1);
    }

    public PageResultDTO<List<CountryDTO>> getCountries() throws EerigoRestClientException {
        //RestClient restClient = new RestClient("http://localhost:8081/country");
        //return restClient.post("/getCountries", null, PageResultDTO.class);

        List<CountryDTO> list = new ArrayList<CountryDTO>();
        CountryDTO countryDTO1 = new CountryDTO();
        countryDTO1.setId("1");
        countryDTO1.setCountryName("Japan");
        countryDTO1.setCountryFlag(null);
        list.add(countryDTO1);
        return new PageResultDTO<List<CountryDTO>>(list.size(), list);
    }
}

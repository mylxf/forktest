package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CountryServiceFacade {
    public void addCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        restClient.post("/addCountry", countryDTO, null);
    }

    public void modifyCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        restClient.post("/modifyCountry", countryDTO, null);
    }

    public void removeCountry(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        restClient.post("/removeCountry", brandId, null);
    }

    public void batchRemoveCountry(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        restClient.post("/batchRemoveCountry", list, null);
    }

    public PageResultDTO<CountryDTO> getCountry(String id) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/getCountry", id, PageResultDTO.class);
    }

    public PageResultDTO<List<CountryDTO>> getCountries() throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/getCountries", null, PageResultDTO.class);
    }
}

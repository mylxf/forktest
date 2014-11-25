package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CountryServiceFacade {
    public OperatorResult addCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/addCountry", countryDTO, OperatorResult.class);
    }

    public OperatorResult modifyCountry(CountryDTO countryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/modifyCountry", countryDTO, OperatorResult.class);
    }

    public OperatorResult removeCountry(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/removeCountry", brandId, OperatorResult.class);
    }

    public OperatorResult batchRemoveCountry(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/batchRemoveCountry", list, OperatorResult.class);
    }

    public CountryDTO getCountry(String id) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/getCountry", id, CountryDTO.class);
    }

    public PagedResult getCountries() throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/country");
        return restClient.post("/getCountries", null, PagedResult.class);
    }
}

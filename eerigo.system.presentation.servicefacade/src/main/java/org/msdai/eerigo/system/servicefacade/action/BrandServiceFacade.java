package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:51
 */
public class BrandServiceFacade {
    public void addBrand(BrandDTO brandDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        restClient.post("/addBrand", brandDTO, String.class);
    }

    public void modifyBrand(BrandDTO brandDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        restClient.post("/modifyBrand", brandDTO, null);
    }

    public void removeBrand(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        restClient.post("/removeBrand", brandId, null);
    }

    public void batchRemoveBrand(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        restClient.post("/batchRemoveBrand", list, null);
    }
}

package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.OperatorResult;

import org.msdai.eerigo.core.service.RestClient;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandCollectionDTO;

import org.msdai.eerigo.core.exception.EerigoRestClientException;

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
        OperatorResult operatorResult = restClient.post("/addBrand", brandDTO, OperatorResult.class);
    }

    public void modifyBrand(BrandDTO brandDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        OperatorResult operatorResult = restClient.post("/modifyBrand", brandDTO, OperatorResult.class);
    }

    public void removeBrand(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        OperatorResult operatorResult = restClient.post("/removeBrand", brandId, OperatorResult.class);
    }

    public void batchRemoveBrand(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        OperatorResult operatorResult = restClient.post("/batchRemoveBrand", list, OperatorResult.class);
    }

    public BrandDTO getBrand(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.get("/getBrand", new Object[]{brandId}, BrandDTO.class);
    }

    public BrandCollectionDTO getBrands() throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.get("/getBrands", new Object[]{}, BrandCollectionDTO.class);
    }
}

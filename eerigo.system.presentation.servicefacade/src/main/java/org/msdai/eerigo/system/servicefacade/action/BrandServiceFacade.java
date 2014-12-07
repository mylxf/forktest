package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.OperatorResult;

import org.msdai.eerigo.core.PagedResult;
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
    public OperatorResult addBrand(BrandDTO brandDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.post("/addBrand", brandDTO, OperatorResult.class);
    }

    public OperatorResult modifyBrand(BrandDTO brandDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.post("/modifyBrand", brandDTO, OperatorResult.class);
    }

    public OperatorResult removeBrand(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.post("/removeBrand", brandId, OperatorResult.class);
    }

    public OperatorResult batchRemoveBrand(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.post("/batchRemoveBrand", list, OperatorResult.class);
    }

    public BrandDTO getBrand(String brandId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.get("/getBrand", new Object[]{brandId}, BrandDTO.class);
    }

    public PagedResult getBrands() throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        return restClient.get("/getBrands", new Object[]{}, PagedResult.class);
    }
}

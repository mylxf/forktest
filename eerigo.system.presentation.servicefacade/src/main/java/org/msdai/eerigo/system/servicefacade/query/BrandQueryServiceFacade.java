package org.msdai.eerigo.system.servicefacade.query;

import org.msdai.eerigo.core.PagedResult;

import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;

import org.msdai.eerigo.core.service.RestClient;

import org.msdai.eerigo.core.exception.EerigoRestClientException;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/15
 * Time: 10:02
 */
public class BrandQueryServiceFacade {
    public PagedResult queryBrands(Integer index, Integer size) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brandQuery");
        BrandQueryRequestMessage request = new BrandQueryRequestMessage();
        request.setIndex(index);
        request.setSize(size);
        return restClient.post("/queryBrands", request, PagedResult.class);
    }
}

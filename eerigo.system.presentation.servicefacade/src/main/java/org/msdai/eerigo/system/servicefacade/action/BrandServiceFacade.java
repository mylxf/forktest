package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;

import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;

import org.msdai.eerigo.core.service.RestClient;

import org.msdai.eerigo.core.exception.EerigoRestClientException;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:51
 */
public class BrandServiceFacade {
    public PageResultDTO<BrandDTO> queryBrands(Integer index, Integer size) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/brand");
        BrandQueryRequestMessage request = new BrandQueryRequestMessage();
        request.setIndex(index);
        request.setSize(size);
        return restClient.post("/queryBrands", request, PageResultDTO.class);
    }
}

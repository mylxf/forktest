package org.msdai.eerigo.system.servicefacade.query;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;

import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;


/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductQueryServiceFacade {
    public PagedResult queryProducts(Integer index, Integer size) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/productQuery");
        ProductQueryRequestMessage request = new ProductQueryRequestMessage();
        request.setIndex(index);
        request.setSize(size);
        return restClient.post("/queryProducts", request, PagedResult.class);
    }
}

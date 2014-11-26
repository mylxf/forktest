package org.msdai.eerigo.system.servicefacade.query;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.message.CategoryQueryRequestMessage;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CategoryQueryServiceFacade {
    public PagedResult queryCategories(Integer index, Integer size) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/categoryQuery");
        CategoryQueryRequestMessage request = new CategoryQueryRequestMessage();
        index = (index < 0) ? 0 : index - 1;
        request.setIndex(index);
        request.setSize(size);
        return restClient.post("/queryCategories", request, PagedResult.class);
    }
}

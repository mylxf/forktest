package org.msdai.eerigo.system.servicefacade.query;

import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.message.CategoryQueryRequestMessage;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CategoryQueryServiceFacade {
    public PageResultDTO<List<BrandDTO>> queryCategories(Integer index, Integer size) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/categoryQuery");
        CategoryQueryRequestMessage request = new CategoryQueryRequestMessage();
        request.setIndex(index);
        request.setSize(size);
        return restClient.post("/queryCategories", request, PageResultDTO.class);
    }
}

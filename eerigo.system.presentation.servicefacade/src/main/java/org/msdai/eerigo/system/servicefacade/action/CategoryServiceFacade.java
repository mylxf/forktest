package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:26
 */
public class CategoryServiceFacade {
    public OperatorResult addCategory(CategoryDTO categoryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        return restClient.post("/addCategory", categoryDTO, OperatorResult.class);
    }

    public OperatorResult modifyCategory(CategoryDTO categoryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        return restClient.post("/modifyCategory", categoryDTO, OperatorResult.class);
    }

    public OperatorResult removeCategory(String categoryId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        return restClient.post("/removeCategory", categoryId, OperatorResult.class);
    }

    public OperatorResult batchRemoveCategory(List<String> list) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        return restClient.post("/batchRemoveCategory", list, OperatorResult.class);
    }

    public CategoryDTO getCategory(String id) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        return restClient.post("/getCategory", id, CategoryDTO.class);
    }

    public PagedResult getCategories() throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        return restClient.post("/getCategories", null, PagedResult.class);
    }
}

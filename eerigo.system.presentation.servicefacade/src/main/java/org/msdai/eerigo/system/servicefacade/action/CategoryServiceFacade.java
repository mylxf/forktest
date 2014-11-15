package org.msdai.eerigo.system.servicefacade.action;

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
    public void addCategory(CategoryDTO categoryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        restClient.post("/addCategory", categoryDTO, null);
    }

    public void modifyCategory(CategoryDTO categoryDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        restClient.post("/modifyCategory", categoryDTO, null);
    }

    public void removeCategory(String categoryId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        restClient.post("/removeCategory", categoryId, null);
    }

    public void batchRemoveCategory(List<String> list) throws EerigoRestClientException{
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/category");
        restClient.post("/batchRemoveCategory", list, null);
    }
}

package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductServiceFacade {
    public void addProduct(ProductDTO productDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        restClient.post("/addProduct", productDTO, null);
    }

    public void modifyProduct(ProductDTO productDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        restClient.post("/modifyProduct", productDTO, null);
    }

    public void removeProduct(String productId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        restClient.post("/removeProduct", productId, null);
    }

    public void batchRemoveProduct(List<String> list) throws EerigoRestClientException{
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        restClient.post("/batchRemoveProduct", list, null);
    }
}

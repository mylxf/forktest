package org.msdai.eerigo.system.servicefacade.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.exception.EerigoRestClientException;
import org.msdai.eerigo.core.service.RestClient;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductServiceFacade {
    public OperatorResult addProduct(ProductDTO productDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        return restClient.post("/addProduct", productDTO, OperatorResult.class);
    }

    public OperatorResult modifyProduct(ProductDTO productDTO) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        return restClient.post("/modifyProduct", productDTO, OperatorResult.class);
    }

    public OperatorResult removeProduct(String productId) throws EerigoRestClientException {
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        return restClient.post("/removeProduct", productId, OperatorResult.class);
    }

    public OperatorResult batchRemoveProduct(List<String> list) throws EerigoRestClientException{
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        return restClient.post("/batchRemoveProduct", list, OperatorResult.class);
    }

    public ProductDTO getProduct(String id) throws EerigoRestClientException{
        RestClient restClient = new RestClient("http://localhost:8081/eerigo.service/product");
        return restClient.post("/getProduct", id, ProductDTO.class);
    }
}

package org.msdai.eerigo.service.serviceinterface.servicecontract.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductService {
    @POST
    @Path("/addProduct")
    OperatorResult addProduct(ProductDTO productDTO);

    @POST
    @Path("/modifyProduct")
    OperatorResult modifyProduct(ProductDTO productDTO);

    @POST
    @Path("/removeProduct")
    OperatorResult removeProduct(String productId);

    @POST
    @Path("/batchRemoveProduct")
    OperatorResult batchRemoveProduct(List<String> list);

    @POST
    @Path("/getProduct")
    ProductDTO getProduct(String id);

    @POST
    @Path("/getProducts")
    PagedResult<ProductDTO> getProducts();
}

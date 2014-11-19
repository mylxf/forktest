package org.msdai.eerigo.service.serviceinterface.servicecontract.query;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by fengfeng on 14/11/15.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductQueryService {
    @POST
    @Path("/queryProducts")
    PagedResult queryProducts(ProductQueryRequestMessage productQueryRequestMessage);
}

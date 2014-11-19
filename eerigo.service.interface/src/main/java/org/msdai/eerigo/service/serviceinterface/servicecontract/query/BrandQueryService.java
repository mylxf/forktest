package org.msdai.eerigo.service.serviceinterface.servicecontract.query;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 1:00
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BrandQueryService {
    @POST
    @Path("/queryBrands")
    PagedResult queryBrands(BrandQueryRequestMessage brandQueryRequestMessage);
}

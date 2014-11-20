package org.msdai.eerigo.service.serviceinterface.servicecontract.query;

import org.msdai.eerigo.core.PagedResult;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;

import javax.ws.rs.*;
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
    PagedResult<BrandDTO> queryBrands(BrandQueryRequestMessage brandQueryRequestMessage);
}

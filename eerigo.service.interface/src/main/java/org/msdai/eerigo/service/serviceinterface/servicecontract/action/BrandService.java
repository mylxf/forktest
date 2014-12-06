package org.msdai.eerigo.service.serviceinterface.servicecontract.action;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandCollectionDTO;

import org.msdai.eerigo.core.OperatorResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 14/11/12
 * Time: 11:10 AM
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BrandService {
    @POST
    @Path("/addBrand")
    OperatorResult addBrand(BrandDTO brandDTO);

    @POST
    @Path("/modifyBrand")
    OperatorResult modifyBrand(BrandDTO brandDTO);

    @POST
    @Path("/removeBrand")
    OperatorResult removeBrand(String brandId);

    @POST
    @Path("/batchRemoveBrand")
    OperatorResult batchRemoveBrand(List<String> list);

    @GET
    @Path("/getBrand/{brandId}")
    BrandDTO getBrand(@PathParam("brandId") String brandId);

    @GET
    @Path("/getBrands")
    BrandCollectionDTO getBrands();
}

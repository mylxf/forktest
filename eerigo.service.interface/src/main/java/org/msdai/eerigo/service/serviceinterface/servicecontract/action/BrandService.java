package org.msdai.eerigo.service.serviceinterface.servicecontract.action;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by fengfeng on 14/11/12.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BrandService {
    @POST
    @Path("/addBrand")
    void addBrand(BrandDTO brandDTO);

    @POST
    @Path("/modifyBrand")
    void modifyBrand(BrandDTO brandDTO);

    @POST
    @Path("/removeBrand")
    void removeBrand(BrandDTO brandDTO);

    @POST
    @Path("/getBrand")
    BrandDTO getBrand(String id);

    @POST
    @Path("/getBrands")
    List<BrandDTO> getBrands();
}

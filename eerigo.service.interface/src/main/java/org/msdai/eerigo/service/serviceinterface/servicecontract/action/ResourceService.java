package org.msdai.eerigo.service.serviceinterface.servicecontract.action;

import org.msdai.eerigo.service.serviceinterface.datacontract.ResourceDTO;

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
public interface ResourceService {
    @POST
    @Path("/addResource")
    void addResource(ResourceDTO resourceDTO);

    @POST
    @Path("/modifyResource")
    void modifyResource(ResourceDTO resourceDTO);

    @POST
    @Path("/removeResource")
    void removeResource(ResourceDTO resourceDTO);

    @POST
    @Path("/getResource")
    ResourceDTO getResource(String id);

    @POST
    @Path("/getResources")
    List<ResourceDTO> getResources();
}

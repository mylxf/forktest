package org.msdai.eerigo.service.serviceinterface.servicecontract.action;

import org.msdai.eerigo.service.serviceinterface.datacontract.CountryDTO;

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
public interface CountryService {
    @POST
    @Path("/addCountry")
    void addCountry(CountryDTO countryDTO);

    @POST
    @Path("/modifyCountry")
    void modifyCountry(CountryDTO countryDTO);

    @POST
    @Path("/removeCountry")
    void removeCountry(String countryId);

    @POST
    @Path("/batchRemoveCountry")
    void batchRemoveCountry(List<String> list);

    @POST
    @Path("/getCountry")
    CountryDTO getCountry(String id);

    @POST
    @Path("/getCountries")
    List<CountryDTO> getCountries();
}

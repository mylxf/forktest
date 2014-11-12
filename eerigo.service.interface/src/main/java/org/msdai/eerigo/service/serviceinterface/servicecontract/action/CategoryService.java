package org.msdai.eerigo.service.serviceinterface.servicecontract.action;

import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:25 PM
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CategoryService {
    @POST
    @Path("/addCategory")
    void addCategory(CategoryDTO categoryDTO);

    @POST
    @Path("/modifyCategory")
    void modifyCategory(CategoryDTO categoryDTO);

    @POST
    @Path("/removeCategory")
    void removeCategory(CategoryDTO categoryDTO);

    @POST
    @Path("/getCategory")
    CategoryDTO getCategory(String uuid);

    @POST
    @Path("/getCategories")
    List<CategoryDTO> getCategories();

    @POST
    @Path("/addSubcategory")
    void addSubcategory(CategoryDTO categoryDTO, CategoryDTO subcategoryDTO);

    @POST
    @Path("/removeSubcategory")
    void removeSubcategory(CategoryDTO categoryDTO, CategoryDTO subcategoryDTO);
}
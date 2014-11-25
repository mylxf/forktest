package org.msdai.eerigo.service.serviceinterface.servicecontract.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.MenuCategoryDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by fengfeng on 14/11/25.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MenuCategoryService {
    @POST
    @Path("/addMenuCategory")
    OperatorResult addMenuCategory(MenuCategoryDTO menuCategoryDTO);

    @POST
    @Path("/modifyMenuCategory")
    OperatorResult modifyMenuCategory(MenuCategoryDTO menuCategoryDTO);

    @POST
    @Path("/removeMenuCategory")
    OperatorResult removeMenuCategory(String meunCategoryId);

    @POST
    @Path("/batchRemoveMenuCategory")
    OperatorResult batchRemoveMenuCategory(List<String> list);

    @POST
    @Path("/getMenuCategory")
    MenuCategoryDTO getMenuCategory(String uuid);

    @POST
    @Path("/getMenuCategories")
    PagedResult<MenuCategoryDTO> getMenuCategories();
}

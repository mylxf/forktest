package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.CategoryDomainService;
import org.msdai.eerigo.service.domain.domainservice.MenuCategoryDomainService;
import org.msdai.eerigo.service.domain.model.category.MenuCategory;
import org.msdai.eerigo.service.serviceinterface.datacontract.MenuCategoryDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.MenuCategoryService;

import java.util.List;

/**
 * Created by fengfeng on 14/11/25.
 */
public class MenuCategoryServiceImpl implements MenuCategoryService {
    private CategoryDomainService categoryDomainService;
    private MenuCategoryDomainService menuCategoryDomainService;

    public void setCategoryDomainService(CategoryDomainService categoryDomainService) {
        this.categoryDomainService = categoryDomainService;
    }

    public void setMenuCategoryDomainService(MenuCategoryDomainService menuCategoryDomainService) {
        this.menuCategoryDomainService = menuCategoryDomainService;
    }

    @Override
    public OperatorResult addMenuCategory(MenuCategoryDTO menuCategoryDTO) {
        MenuCategory menuCategory = ConvertUtils.convert(menuCategoryDTO, MenuCategory.class);
        menuCategoryDomainService.addMenuCategory(menuCategory);
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult modifyMenuCategory(MenuCategoryDTO menuCategoryDTO) {
        MenuCategory menuCategory = ConvertUtils.convert(menuCategoryDTO, MenuCategory.class);
        menuCategoryDomainService.modifyMenuCategory(menuCategory);
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult removeMenuCategory(String meunCategoryId) {
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult batchRemoveMenuCategory(List<String> list) {
        return new OperatorResult(true);
    }

    @Override
    public MenuCategoryDTO getMenuCategory(String uuid) {
        MenuCategory menuCategory = menuCategoryDomainService.getMenuCountry(uuid);
        if (menuCategory != null) {
            return ConvertUtils.convert(menuCategory, MenuCategoryDTO.class);
        }
        return null;
    }

    @Override
    public PagedResult<MenuCategoryDTO> getMenuCategories() {
        PagedResult<MenuCategoryDTO> pagedResult = new PagedResult<MenuCategoryDTO>();

        List<MenuCategory> menuCategories = menuCategoryDomainService.getMenuCountries();
        for (MenuCategory menuCategory : menuCategories) {
            pagedResult.add(ConvertUtils.convert(menuCategory, MenuCategoryDTO.class));
        }
        return pagedResult;
    }
}

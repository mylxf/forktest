package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;
import org.msdai.eerigo.service.domain.model.category.MenuCategory;
import org.msdai.eerigo.service.domain.repository.CategoryRepository;
import org.msdai.eerigo.service.domain.repository.MenuCategoryRepository;

import java.util.List;

/**
 * Created by fengfeng on 14/11/25.
 */
public class MenuCategoryDomainService {
    private MenuCategoryRepository menuCategoryRepository;

    public MenuCategoryDomainService(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    public MenuCategory getMenuCountry(String id) {
        return menuCategoryRepository.find(id.replace("\"",""));
    }

    public List<MenuCategory> getMenuCountries() {
        return menuCategoryRepository.findAll();
    }

    public boolean addMenuCategory(MenuCategory menuCategory){
        try {
            menuCategoryRepository.insert(menuCategory);
            menuCategoryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            menuCategoryRepository.getContext().rollback();
            return false;
        }
    }

    public boolean modifyMenuCategory(MenuCategory menuCategory) {
        try {
            menuCategoryRepository.update(menuCategory);
            menuCategoryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            menuCategoryRepository.getContext().rollback();
            return false;
        }
    }

    public boolean removeMenuCategory(MenuCategory menuCategory) {
        try {
            menuCategoryRepository.delete(menuCategory);
            menuCategoryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            menuCategoryRepository.getContext().rollback();
            return false;
        }
    }
}

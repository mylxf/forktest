package org.msdai.eerigo.service.domain.domainservice;

import org.msdai.eerigo.core.exception.EerigoRepositoryConcurrentModificationException;
import org.msdai.eerigo.service.domain.model.category.Category;
import org.msdai.eerigo.service.domain.repository.CategoryRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:04 PM
 */
public class CategoryDomainService {
    private CategoryRepository categoryRepository;

    public CategoryDomainService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(String uuid) {
        return categoryRepository.find(uuid);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public boolean addCategory(Category category) {
        try {
            categoryRepository.insert(category);
            categoryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            categoryRepository.getContext().rollback();
            return false;
        }
    }

    public boolean modifyCategory(Category category) {
        try {
            categoryRepository.update(category);
            categoryRepository.getContext().commit();
            return true;
        } catch (EerigoRepositoryConcurrentModificationException e) {
            categoryRepository.getContext().rollback();
            return false;
        }
    }
}

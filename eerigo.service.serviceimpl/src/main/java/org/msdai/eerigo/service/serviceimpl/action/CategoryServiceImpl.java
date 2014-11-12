package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.CategoryService;

import org.msdai.eerigo.service.domain.model.category.Category;

import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.domainservice.CategoryDomainService;

import org.msdai.eerigo.core.utils.ConvertUtils;

import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:36 PM
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDomainService categoryDomainService;
    private ProductDomainService productDomainService;

    public void setCategoryDomainService(CategoryDomainService categoryDomainService) {
        this.categoryDomainService = categoryDomainService;
    }

    public void setProductDomainService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = ConvertUtils.convert(categoryDTO, Category.class);
        categoryDomainService.addCategory(category);
    }

    @Override
    public void modifyCategory(CategoryDTO categoryDTO) {
        Category category = ConvertUtils.convert(categoryDTO, Category.class);
        categoryDomainService.modifyCategory(category);
    }

    @Override
    public void removeCategory(CategoryDTO categoryDTO) {
        Category category = ConvertUtils.convert(categoryDTO,Category.class);
        //检查该类别下属是否有其他类别，或者有父类别
        if (productDomainService.existProducts(category)) {

        }
    }

    @Override
    public CategoryDTO getCategory(String uuid) {
        Category category = categoryDomainService.getCategory(uuid);
        if (category != null) {
            return ConvertUtils.convert(category, CategoryDTO.class);
        }
        return null;
    }

    @Override
    public List<CategoryDTO> getCategories() {
        List<CategoryDTO> result = new ArrayList<CategoryDTO>();
        List<Category> categories = categoryDomainService.getCategories();
        for (Category category : categories) {
            result.add(ConvertUtils.convert(category, CategoryDTO.class));
        }
        return result;
    }

    @Override
    public void addSubcategory(CategoryDTO categoryDTO, CategoryDTO subcategoryDTO) {
        Category category = categoryDomainService.getCategory(categoryDTO.getId());
        Category subcategory = categoryDomainService.getCategory(subcategoryDTO.getId());
        category.addSubcategory(subcategory);
        categoryDomainService.modifyCategory(category);
    }

    @Override
    public void removeSubcategory(CategoryDTO categoryDTO, CategoryDTO subcategoryDTO) {
        Category category = categoryDomainService.getCategory(categoryDTO.getId());
        Category subcategory = categoryDomainService.getCategory(subcategoryDTO.getId());
        category.removeSubcategory(subcategory);
        categoryDomainService.modifyCategory(category);
    }
}

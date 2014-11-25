package org.msdai.eerigo.service.serviceimpl.action;

import org.msdai.eerigo.core.OperatorResult;
import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.domain.domainservice.CategoryDomainService;
import org.msdai.eerigo.service.domain.domainservice.ProductDomainService;
import org.msdai.eerigo.service.domain.model.category.Category;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.servicecontract.action.CategoryService;

import java.util.List;

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
    public OperatorResult addCategory(CategoryDTO categoryDTO) {
        Category category = ConvertUtils.convert(categoryDTO, Category.class);
        categoryDomainService.addCategory(category);
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult modifyCategory(CategoryDTO categoryDTO) {
        Category category = ConvertUtils.convert(categoryDTO, Category.class);
        categoryDomainService.modifyCategory(category);
        return new OperatorResult(true);
    }

    @Override
    public OperatorResult removeCategory(String categoryId) {
        CategoryDTO categoryDTO = getCategory(categoryId);
        //检查该类别下属是否有其他类别，或者有父类别
        return new OperatorResult(true);

    }

    @Override
    public OperatorResult batchRemoveCategory(List<String> list) {
        for (String id : list) {
            removeCategory(id);
        }
        return new OperatorResult(true);
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
    public PagedResult<CategoryDTO> getCategories() {
        PagedResult<CategoryDTO> pagedResult = new PagedResult<CategoryDTO>();

        List<Category> categories = categoryDomainService.getCategories();
        for (Category category : categories) {
            pagedResult.add(ConvertUtils.convert(category, CategoryDTO.class));
        }
        return pagedResult;
    }
}

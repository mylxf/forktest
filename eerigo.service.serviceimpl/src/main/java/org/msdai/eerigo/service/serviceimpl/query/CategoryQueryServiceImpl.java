package org.msdai.eerigo.service.serviceimpl.query;


import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.query.repository.CategoryQueryRepository;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;

import org.msdai.eerigo.service.serviceinterface.message.CategoryQueryRequestMessage;
import org.msdai.eerigo.service.serviceinterface.servicecontract.query.CategoryQueryService;

/**
 * Created by fengfeng on 14/11/15.
 */
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private CategoryQueryRepository categoryQueryRepository;

    public CategoryQueryServiceImpl(CategoryQueryRepository categoryQueryRepository) {
        this.categoryQueryRepository = categoryQueryRepository;
    }

    @Override
    public PagedResult<CategoryDTO> queryCategories(CategoryQueryRequestMessage categoryQueryRequestMessage) {
        return this.categoryQueryRepository.queryCategories(categoryQueryRequestMessage);
    }
}

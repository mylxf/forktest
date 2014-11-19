package org.msdai.eerigo.service.query.repository;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.message.CategoryQueryRequestMessage;


/**
 * Created by fengfeng on 14/11/15.
 */
public interface CategoryQueryRepository {
    PagedResult<CategoryDTO> queryCategories(CategoryQueryRequestMessage categoryQueryRequestMessage);
}

package org.msdai.eerigo.service.query.repository;

import org.msdai.eerigo.service.serviceinterface.datacontract.CategoryDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.message.CategoryQueryRequestMessage;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public interface CategoryQueryRepository {
    PageResultDTO<List<CategoryDTO>> queryCategories(CategoryQueryRequestMessage categoryQueryRequestMessage);
}

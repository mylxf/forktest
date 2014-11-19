package org.msdai.eerigo.service.query.repository;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;


/**
 * Created by fengfeng on 14/11/15.
 */
public interface ProductQueryRepository {
    PagedResult<ProductDTO> queryProducts(ProductQueryRequestMessage productQueryRequestMessage);
}

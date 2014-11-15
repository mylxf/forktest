package org.msdai.eerigo.service.query.repository;

import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;

import java.util.List;

/**
 * Created by fengfeng on 14/11/15.
 */
public interface ProductQueryRepository {
    PageResultDTO<List<ProductDTO>> queryProducts(ProductQueryRequestMessage productQueryRequestMessage);
}

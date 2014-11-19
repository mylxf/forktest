package org.msdai.eerigo.service.serviceimpl.query;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.query.repository.ProductQueryRepository;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.message.ProductQueryRequestMessage;
import org.msdai.eerigo.service.serviceinterface.servicecontract.query.ProductQueryService;

/**
 * Created by fengfeng on 14/11/15.
 */
public class ProductQueryServiceImpl implements ProductQueryService {
    private ProductQueryRepository productQueryRepository;

    public ProductQueryServiceImpl(ProductQueryRepository productQueryRepository) {
        this.productQueryRepository = productQueryRepository;
    }

    @Override
    public PagedResult queryProducts(ProductQueryRequestMessage productQueryRequestMessage) {
        return this.productQueryRepository.queryProducts(productQueryRequestMessage);
    }
}

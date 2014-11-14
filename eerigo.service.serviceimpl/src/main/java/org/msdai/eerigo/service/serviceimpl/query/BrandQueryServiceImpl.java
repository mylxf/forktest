package org.msdai.eerigo.service.serviceimpl.query;


import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;
import org.msdai.eerigo.service.serviceinterface.servicecontract.query.BrandQueryService;

import org.msdai.eerigo.service.query.repository.BrandQueryRepository;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/13/2014
 * Time: 2:08 PM
 */
public class BrandQueryServiceImpl implements BrandQueryService {

    private BrandQueryRepository brandQueryRepository;

    public BrandQueryServiceImpl(BrandQueryRepository brandQueryRepository) {
        this.brandQueryRepository = brandQueryRepository;
    }

    @Override
    public PageResultDTO<List<BrandDTO>> queryBrands(BrandQueryRequestMessage brandQueryRequestMessage) {
        return brandQueryRepository.queryBrands(brandQueryRequestMessage);
    }
}

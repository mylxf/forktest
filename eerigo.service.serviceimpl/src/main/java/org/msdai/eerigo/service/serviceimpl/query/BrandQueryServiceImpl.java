package org.msdai.eerigo.service.serviceimpl.query;


import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;
import org.msdai.eerigo.service.query.repository.BrandQueryRepository;
import org.msdai.eerigo.service.serviceinterface.servicecontract.query.BrandQueryService;

import java.util.ArrayList;
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
        //return brandQueryRepository.queryBrands(brandQueryRequestMessage);
        List<BrandDTO> list = new ArrayList<BrandDTO>();
        BrandDTO brandDTO1 = new BrandDTO();
        brandDTO1.setId("1");
        brandDTO1.setBrandName("brand1");

        BrandDTO brandDTO2 = new BrandDTO();
        brandDTO2.setId("2");
        brandDTO2.setBrandName("brand2");

        list.add(brandDTO1);
        list.add(brandDTO2);
        PageResultDTO<List<BrandDTO>> result = new PageResultDTO<List<BrandDTO>>();
        result.setCount(2);
        result.setResult(list);
        return result;


    }
}

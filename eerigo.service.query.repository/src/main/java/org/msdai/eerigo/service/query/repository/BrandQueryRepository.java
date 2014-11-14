package org.msdai.eerigo.service.query.repository;

import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.PageResultDTO;
import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/14/2014
 * Time: 11:21 AM
 */
public interface BrandQueryRepository {
    PageResultDTO<List<BrandDTO>> queryBrands(BrandQueryRequestMessage brandQueryRequestMessage);
}
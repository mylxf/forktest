package org.msdai.eerigo.service.query.repository;

import org.msdai.eerigo.core.PagedResult;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.message.BrandQueryRequestMessage;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/14/2014
 * Time: 11:21 AM
 */
public interface BrandQueryRepository {
    PagedResult<BrandDTO> queryBrands(BrandQueryRequestMessage brandQueryRequestMessage);
}
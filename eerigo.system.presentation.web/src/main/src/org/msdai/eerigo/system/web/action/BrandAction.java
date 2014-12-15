package org.msdai.eerigo.system.web.action;

import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.service.serviceinterface.datacontract.BrandDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ResourceDTO;
import org.msdai.eerigo.system.servicefacade.action.BrandServiceFacade;
import org.msdai.eerigo.system.web.model.BrandModel;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/13
 * Time: 0:44
 */
public class BrandAction extends BaseAction {
    BrandServiceFacade brandServiceFacade = new BrandServiceFacade();

    private BrandModel model = new BrandModel();
    private File file;

    public BrandModel getModel() {
        return model;
    }

    @Override
    public String doExecute() throws Exception {
        return SUCCESS;
    }

    public String openView() throws Exception {
        String id = request.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            BrandDTO brandDTO = brandServiceFacade.getBrand(id);
            model.setId(brandDTO.getId());
            model.setBrandName(brandDTO.getBrandName());
        }
        return "openView";
    }

    public String saveBrand() throws Exception {
        BrandDTO brand = new BrandDTO();
        brand.setId(model.getId());
        brand.setBrandName(model.getBrandName());

        if(((MultiPartRequestWrapper) request).getFiles("file")!=null) {
            file = ((MultiPartRequestWrapper) request).getFiles("file")[0];

            FileInputStream stream = new FileInputStream(file);
            ResourceDTO resource = new ResourceDTO();
            byte[] content = new byte[stream.available()];
            stream.read(content);
            resource.setResourceContent(content);
            brand.setResource(resource);
        }

        try {
            if (StringUtils.isEmpty(brand.getId())) {
                brandServiceFacade.addBrand(brand);
            } else {
                brandServiceFacade.modifyBrand(brand);
            }
            setAlertMsg("品牌保存成功");
        } catch (Exception e) {
            setAlertMsg("品牌保存失败");
        }
        return SHOWALERT;
    }

    public String deleteBrand() throws Exception {
        String id = request.getParameter("id");
        brandServiceFacade.removeBrand(id);
        return SUCCESS;
    }

    public String batchDelBrand() throws Exception {
        String idList = request.getParameter("id_list");
        List<String> list = new ArrayList<String>();
        String[] strings = idList.split("\\|");

        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }

        brandServiceFacade.batchRemoveBrand(list);

        return SUCCESS;
    }
}

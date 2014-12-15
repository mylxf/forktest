package org.msdai.eerigo.system.web.action;

import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.msdai.eerigo.core.BaseAction;
import org.msdai.eerigo.core.utils.ConvertUtils;
import org.msdai.eerigo.service.serviceinterface.datacontract.ProductDTO;
import org.msdai.eerigo.service.serviceinterface.datacontract.ResourceDTO;
import org.msdai.eerigo.system.servicefacade.action.BrandServiceFacade;
import org.msdai.eerigo.system.servicefacade.action.CategoryServiceFacade;
import org.msdai.eerigo.system.servicefacade.action.CountryServiceFacade;
import org.msdai.eerigo.system.servicefacade.action.ProductServiceFacade;
import org.msdai.eerigo.system.web.model.BrandModel;
import org.msdai.eerigo.system.web.model.CategoryModel;
import org.msdai.eerigo.system.web.model.CountryModel;
import org.msdai.eerigo.system.web.model.ProductModel;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengfeng on 14/12/6.
 */
public class ProductAction extends BaseAction {
    private ProductServiceFacade productServiceFacade = new ProductServiceFacade();
    private CountryServiceFacade countryServiceFacade = new CountryServiceFacade();
    private BrandServiceFacade brandServiceFacade = new BrandServiceFacade();
    private CategoryServiceFacade categoryServiceFacade = new CategoryServiceFacade();

    private ProductModel model = new ProductModel();
    private List<CountryModel> countryModels = new ArrayList<CountryModel>();
    private List<BrandModel> brandModels = new ArrayList<BrandModel>();
    private List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
    private File file;

    public ProductModel getModel() {
        return model;
    }

    public List<CountryModel> getCountryModels() {
        return countryModels;
    }

    public List<BrandModel> getBrandModels() {
        return brandModels;
    }

    public List<CategoryModel> getCategoryModels() {
        return categoryModels;
    }

    @Override
    public String doExecute() throws Exception {
        return SUCCESS;
    }

    public String openView() throws Exception {
        countryModels = countryServiceFacade.getCountries().getData();
        brandModels = brandServiceFacade.getBrands().getData();
        categoryModels = categoryServiceFacade.getCategories().getData();

        String id = request.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            ProductDTO productDTO = productServiceFacade.getProduct(id);
            model = new ProductModel();
            model.setId(productDTO.getId());
            model.setProductName(productDTO.getProductName());
            model.setProductCategoryId(productDTO.getProductCategoryId());
            model.setProductCategory(ConvertUtils.convert(productDTO.getProductCategory(), CategoryModel.class));
            model.setProductBrandId(productDTO.getProductBrandId());
            model.setProductBrand(ConvertUtils.convert(productDTO.getProductBrand(), BrandModel.class));
            model.setCountryId(productDTO.getCountryId());
            model.setOrigin(ConvertUtils.convert(productDTO.getOrigin(), CountryModel.class));
            model.setProductDesc(productDTO.getProductDesc());
            model.setCostPrice(productDTO.getCostPrice());
            model.setSellPrice(productDTO.getSellPrice());
            model.setWeight(productDTO.getWeight());
        }

        return "openView";
    }

    public String saveProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(model.getId());
        productDTO.setProductName(model.getProductName());
        productDTO.setProductCategoryId(model.getProductCategoryId());
        productDTO.setProductBrandId(model.getProductBrandId());
        productDTO.setCountryId(model.getCountryId());
        productDTO.setProductDesc(model.getProductDesc());
        productDTO.setCostPrice(model.getCostPrice());
        productDTO.setSellPrice(model.getSellPrice());
        productDTO.setWeight(model.getWeight());

        if(((MultiPartRequestWrapper) request).getFiles("file")!=null) {
            file = ((MultiPartRequestWrapper) request).getFiles("file")[0];

            FileInputStream stream = new FileInputStream(file);
            ResourceDTO resource = new ResourceDTO();
            byte[] content = new byte[stream.available()];
            stream.read(content);
            resource.setResourceContent(content);
            List<ResourceDTO> listRes = new ArrayList<ResourceDTO>();
            listRes.add(resource);
            productDTO.setProductImages(listRes);
        }

        try {
            if (StringUtils.isEmpty(productDTO.getId())) {
                productServiceFacade.addProduct(productDTO);
            } else {
                productServiceFacade.modifyProduct(productDTO);
            }
            setAlertMsg("商品保存成功");
        } catch (Exception e) {
            setAlertMsg("商品保存失败");
        }
        return SHOWALERT;
    }

    public String deleteProduct() throws Exception {
        String id = request.getParameter("id");
        return (productServiceFacade.removeProduct(id).getResult()) ? SUCCESS : ERROR;
    }

    public String batchDelProduct() throws Exception {
        String idList = request.getParameter("id_list");
        List<String> list = new ArrayList<String>();
        String[] strings = idList.split("\\|");

        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }

        return (productServiceFacade.batchRemoveProduct(list).getResult()) ? SUCCESS : ERROR;
    }
}

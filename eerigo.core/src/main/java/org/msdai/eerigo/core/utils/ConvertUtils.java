package org.msdai.eerigo.core.utils;

import org.modelmapper.ModelMapper;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 11/12/2014
 * Time: 3:40 PM
 */
public class ConvertUtils {
    private static ModelMapper modelMapper = new ModelMapper();

    public static <D> D convert(Object object, Class<D> tClass) {
        return modelMapper.map(object, tClass);
    }
}

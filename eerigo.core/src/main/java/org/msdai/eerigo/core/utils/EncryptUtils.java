package org.msdai.eerigo.core.utils;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 22:23
 */
public class EncryptUtils {
    public static String md5Encrypt(String source, String key) {
        if (!StringUtils.isEmpty(source)) {
            return Md5Crypt.md5Crypt(source.getBytes(Charset.forName("UTF-8")), key);
        }
        return "";
    }
}

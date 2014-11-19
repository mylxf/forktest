package org.msdai.eerigo.core.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.map.ser.std.NullSerializer;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: 田文涛
 * Date: 2014/11/11
 * Time: 22:20
 */
public class JsonUtils {
    private static Gson gson = new Gson();

    private final static ObjectMapper objectMapper;

    static {
        StdSerializerProvider sp = new StdSerializerProvider();
        sp.setNullValueSerializer(NullSerializer.instance);
        objectMapper = new ObjectMapper(null, sp, null);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T parseJson(Reader json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public static <T> T parseJson(Reader json, TypeReference<T> type) throws IOException {
        return (T) objectMapper.readValue(json, type);
    }
}

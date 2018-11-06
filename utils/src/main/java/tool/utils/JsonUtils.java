package tool.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.TimeZone;

/**
 * 实现描述：JSON处理工具
 *
 * @author red
 * @version v1.0.0
 */
public abstract class JsonUtils {

    private static ObjectMapper defaultMapper;
    private static ObjectMapper prettyMapper;

    static {
        defaultMapper = new ObjectMapper();
        defaultMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        defaultMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        defaultMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        defaultMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        prettyMapper = new ObjectMapper();
        prettyMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        prettyMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        prettyMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

    public static <T> String json(T obj) {
        return json(obj, false);
    }

    public static <T> String json(T obj, boolean pretty) {
        try {
            if (obj == null)
                return null;
            return (pretty ? prettyMapper : defaultMapper).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new NestableRuntimeException("JSON解析异常", e);
        }
    }

    public static <T> void json(T obj, OutputStream out) throws IOException {
        try {
            if (obj == null)
                return;
            JsonGenerator jgen = defaultMapper.getFactory().createGenerator(out, JsonEncoding.UTF8);
            defaultMapper.writeValue(jgen, obj);
        } catch (JsonProcessingException e) {
            throw new NestableRuntimeException("JSON解析异常", e);
        }
    }

    public static <T> T parse(String json, Class<T> clazz) {
        try {
            if (StringUtils.isBlank(json))
                return null;
            return defaultMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new NestableRuntimeException("JSON解析异常", e);
        }
    }

    public static JsonNode parse(String json) {
        try {
            if (StringUtils.isBlank(json))
                return null;
            return defaultMapper.readTree(json);
        } catch (IOException e) {
            throw new NestableRuntimeException("JSON解析异常", e);
        }
    }

    public static <T> List<T> parse2list(String json, Class<T> clazz){
        try {
            if (StringUtils.isBlank(json))
                return null;
            return defaultMapper.readValue(json, getCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new NestableRuntimeException("JSON解析异常", e);
        }
    }

    public static <T> T bean(JsonNode node, Class<T> clazz) {
        try {
            if (node.isMissingNode())
                return null;
            return defaultMapper.treeToValue(node, clazz);
        } catch (JsonProcessingException e) {
            throw new NestableRuntimeException("JSON解析异常", e);
        }
    }

    public static <T> T pointer(String json, String expr, Class<T> clazz) {
        try {
            if (StringUtils.isBlank(json) || StringUtils.isBlank(expr))
                return null;
            JsonNode node = defaultMapper.readTree(json).at(expr);
            return bean(node, clazz);
        } catch (IOException e) {
            throw new NestableRuntimeException("JSON解析异常", e);
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?> ... elementClasses) {
        return defaultMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}
package com.application.utils.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;

public class JacksonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);

    public static final ObjectMapper MAPPER = new ObjectMapper()
            // 扩展序列化器，增加对 java.time.* 包中时间类的序列化、反序列化支持
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

    public static String bean2Json(Object obj) {
        StringWriter sw = new StringWriter();
        try {
            JsonGenerator gen = new JsonFactory().createGenerator(sw);
            MAPPER.writeValue(gen, obj);
            gen.close();
        } catch (IOException e) {
            LOGGER.error("bean2Json error", e);
        }
        return sw.toString();
    }
    
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        try {
            return MAPPER.readValue(jsonStr, objClass);
        }
        catch (JsonProcessingException e) {
            LOGGER.error("json2Bean error", e);
        }
        catch (IOException e) {
            LOGGER.error("json2Bean error", e);
        }
        return null;
    }
    
    public static <T, T1> T json2Bean(String jsonStr, Class<T> objClass, Class<T1> subClass) {
        try {
            JavaType javaType1 = MAPPER.getTypeFactory().constructParametricType(objClass, subClass);
            return MAPPER.readValue(jsonStr, javaType1);
        }
        catch (JsonProcessingException e) {
            LOGGER.error("json2Bean error", e);
        }
        catch (IOException e) {
            LOGGER.error("json2Bean error", e);
        }
        return null;
    }

    public static <T> T object2Bean(Object o, Class<T> beanClass){
        try {

            return MAPPER.readValue(o.toString(), beanClass);
        } catch (Exception e) {
            LOGGER.error("Object2Bean error", e);
        }
        return null;
    }
    
}

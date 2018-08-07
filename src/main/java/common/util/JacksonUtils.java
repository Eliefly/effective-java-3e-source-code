package common.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * json转换工具类
 *
 * @author huangfl
 * @since 2018/4/3
 */
public class JacksonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

    /**
     * 将对象转换成json字符串。
     *
     * @param object 转换对象
     * @return json字符串
     */
    public static String objectToJson(Object object) {
        try {
            String string = MAPPER.writeValueAsString(object);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonStr  json数据
     * @param beanType Bean类型
     * @return Bean对象
     */
    public static <T> T jsonToBean(String jsonStr, Class<T> beanType) {
        try {
            return MAPPER.readValue(jsonStr, beanType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成Bean对象List
     *
     * @param jsonStr  json数据
     * @param beanType Bean类型
     * @param <T>      List存放对象泛型
     * @return List对象
     */
    public static <T> List<T> jsonToList(String jsonStr, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            return MAPPER.readValue(jsonStr, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成Bean对象包装对象.
     * 如Wrapper<User>的json串反反json化.
     *
     * @param jsonStr     json数据
     * @param wrapperType 外层包装类型
     * @param beanType    内层对象类型
     * @param <W>         返回结果泛型
     * @param <E>         包装对象泛型
     * @param <T>         内层对象泛型
     * @return 包装对象
     */
    public static <W, E, T> W jsonToBean(String jsonStr, Class<E> wrapperType, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(wrapperType, beanType);
        try {
            return MAPPER.readValue(jsonStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
package io.github.boniu.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/************************************************************************
 * author: wg
 * description: JsonUtil 
 * createTime: 10:28 2023/10/7
 * updateTime: 10:28 2023/10/7
 ************************************************************************/
public class JsonUtil {

    public static String toJsonString(Map<String, String> map) {
        // 创建一个 ObjectMapper 对象
        ObjectMapper mapper = new ObjectMapper();

        // 使用 ObjectMapper 的 writeValueAsString() 方法将 Map 转换成 JSON 字符串
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }
}

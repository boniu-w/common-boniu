package io.github.boniu.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/************************************************************************
 * author: wg
 * description: BeanUtil 
 * createTime: 10:38 2023/8/24
 * updateTime: 10:38 2023/8/24
 ************************************************************************/
public class BeanUtil {

    /**
     * @author: wg
     * @description: 实体类 转 map
     * @params:
     * @return:
     * @createTime: 15:11  2023/6/1
     * @updateTime: 15:11  2023/6/1
     */
    public static <T> Map<String, Object> bean2Map(T obj) {
        Map<String, Object> map = new HashMap<>();
        try {
            Field[] fields = obj.getClass().getDeclaredFields(); // 获取实体类的全部成员变量
            for (Field field : fields) {
                field.setAccessible(true); // 设置字段可访问以便取值
                map.put(field.getName(), field.get(obj)); // 将实体类对象的成员变量的键值对放入 Map 中
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

}

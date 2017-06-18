package com.pancake.util;

import com.pancake.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chao on 2017/6/18.
 */
public class SetAndGetUtil {

    private final Logger logger = LoggerFactory.getLogger(UpdateUtil.class);

    /**
     * 根据类的 field 调用实例 object 该 field 的 getter 方法，获取该 field的值
     * @param field 域
     * @param object 实例
     * @return 域值
     */
    public static Object runGetter(Field field, Object object)
    {

        // MZ: Find the correct method
        for (Method method : object.getClass().getMethods())
        {
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3)))
            {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))
                {
                    // MZ: Method found, run it
                    try
                    {
                        return method.invoke(object);
                    }
                    catch (IllegalAccessException e)
                    {
                        System.out.println("Could not determine method: " + method.getName());
                        e.printStackTrace();
                    }
                    catch (InvocationTargetException e)
                    {
                        System.out.println("Could not determine method: " + method.getName());
                        e.printStackTrace();
                    }

                }
            }
        }
        return null;
    }

    /**
     * 根据类的 field 调用实例 object 该 field 的 setter 方法，设该 field的值为 value
     * @param field 域
     * @param value 要设的值
     * @param object 实例
     * @return 域值
     */
    public static Object runSetter(Field field, Object value, Object object)
    {

        // MZ: Find the correct method
        for (Method method : object.getClass().getMethods())
        {
            if ((method.getName().startsWith("set")) && (method.getName().length() == (field.getName().length() + 3)))
            {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))
                {
                    // MZ: Method found, run it
                    try
                    {
                        return method.invoke(object, value);
                    }
                    catch (IllegalAccessException e)
                    {
                        System.out.println("Could not determine method: " + method.getName());
                        e.printStackTrace();
                    }
                    catch (InvocationTargetException e)
                    {
                        System.out.println("Could not determine method: " + method.getName());
                        e.printStackTrace();
                    }

                }
            }
        }
        return null;
    }
}

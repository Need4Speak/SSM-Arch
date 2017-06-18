package com.pancake.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;


/**
 * Created by chao on 2017/6/18.
 */
public class UpdateUtil<T> {
    public Class<T> entityClass;
    private final static Logger logger = LoggerFactory.getLogger(UpdateUtil.class);

    /**
     * 获取 T 的类
     * @param entityClass T 类的实例
     */
    public UpdateUtil(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * 如果 objectNew 中成员变量的值不为 null 或者 0，则用该成员变量的值更新 objectOld 中该同名成员变量的值。
     * 因为 T 为引用类型， 故会改变 原 objectOld 实参的值。
     * @param objectNew 新的对象
     * @param objectOld 原有的对象
     */
    public void update(T objectNew, T objectOld) {
        logger.info("类名:" + entityClass);
        // 获取类 T 的成员变量及其值
        Field[] fields = entityClass.getDeclaredFields();
        for( Field field : fields ){
//            if(field.getType().getName().equals("int") && 0 != SetAndGetUtil.runGetter(field, objectNew)) {
//                // TODO 太复杂，并且不满足需求，废止，java反射机制参考用。
//            }
            if(!SetAndGetUtil.runGetter(field, objectNew).equals(SetAndGetUtil.runGetter(field, objectNew))) {
                logger.info("[" + entityClass + "] " + field.getType() + " " + field.getName() + " old value: " + SetAndGetUtil.runGetter(field, objectNew));
                SetAndGetUtil.runSetter(field, SetAndGetUtil.runGetter(field, objectNew), objectOld);
                logger.info("[" + entityClass + "] " + field.getType() + " " + field.getName() + " new value: " + SetAndGetUtil.runGetter(field, objectNew));
            }
        }
    }


}

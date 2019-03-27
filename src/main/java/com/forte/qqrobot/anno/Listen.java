package com.forte.qqrobot.anno;

import com.forte.qqrobot.beans.types.MsgGetTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记用
 * 添加此注解，标注为一个监听器类
 * 标注在类上将会记录全部的方法
 * 标注在方法上将会记录此方法
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/26 10:29
 * @since JDK1.8
 **/
@Retention(RetentionPolicy.RUNTIME)	//注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.TYPE, ElementType.METHOD}) //接口、类、枚举、注解、方法
public @interface Listen {

    /**
     * 监听器所监听的类型
     * 方法上的参数将会覆盖类上的参数
     */
    MsgGetTypes value();

}

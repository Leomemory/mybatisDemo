package org.mybatis.example;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

//对于实现自己的 Interceptor 而言有两个很重要的注解，
//        一个是 @Intercepts，其值是一个@Signature 数组。
//        @Intercepts 用于表明当前的对象是一个 Interceptor，
//        而 @Signature则表明要拦截的接口、方法以及对应的参数类型。
@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})

public class ExamplePlugin implements Interceptor {
    /*
    * * @param invocation { 代理对象，被监控方法对象，当前被监控方法运行时需要的实参 }
     * @return
     * @throws Throwable*/
    public Object intercept(Invocation invocation) throws Throwable {
//        return invocation.proceed();
        System.out.println("被拦截方法执行之前，做的辅助服务······");
        Object proceed = invocation.proceed();
        System.out.println("被拦截方法执行之后，做的辅助服务······");
        return proceed;
    }


    /*
    * * @param target 表示被拦截的对象，此处为 Executor 的实例对象
     *               作用：如果被拦截对象所在的类有实现接口，就为当前拦截对象生成一个代理对象
     *               如果被拦截对象所在的类没有指定接口，这个对象之后的行为就不会被代理操作
     * @return*/
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
    public void setProperties(Properties properties) {
    }
}

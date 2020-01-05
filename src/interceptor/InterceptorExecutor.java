package interceptor;


import javassist.tools.reflect.Metaobject;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import interceptor.InterceptorUtil;

import java.util.HashMap;
import java.util.Properties;
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        ),

})
public class InterceptorExecutor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
      System.out.println("拦截方法。。");
      Object target=invocation.getTarget();
      MetaObject metaobject=SystemMetaObject.forObject(target);
      //得到数据
     // metaobject.getValue()
      //设置参数
       // invocation.getArgs()[1]=2;
        HashMap hashMap = (HashMap) invocation.getArgs()[1];
        hashMap.put("param1",2);
        hashMap.put("param2",3);
        return invocation.proceed();
    }

    @Override
    //这个方法的作用是就是让mybatis判断，是否要进行拦截，然后做出决定是否生成一个代理。
    public Object plugin(Object target) {

        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
    }

}
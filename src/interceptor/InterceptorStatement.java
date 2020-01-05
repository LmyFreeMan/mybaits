package interceptor;




import org.apache.ibatis.executor.Executor;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Statement;
import java.util.Properties;
@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "query",
                args = {Statement.class, ResultHandler.class}
        ),

})
public class InterceptorStatement implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
//        // 获取sql
//        String sql =InterceptorUtil.getSqlByInvocation(invocation);
//        String mSql = sql + " limit 2";


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
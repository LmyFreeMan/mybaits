package dao;
import pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
public class Main {
    public static void main(String[] args) throws IOException {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession session=sqlSessionFactory.openSession();
        // 通过会话对象来构建接口的实现类对象
        EmployeeDao dao=session.getMapper(EmployeeDao.class);
        // 执行查询操作
        Employee employee=dao.selectEmpById(1);
        System.out.println(employee);
        session.close();
    }
}
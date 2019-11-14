package dao;
import pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
         //执行查询操作
        Employee employee=dao.selectEmpById(1);
//        Employee employee=dao.selectEmpByIdAndLastName(1,"wang");
        System.out.println(employee);
//            //返回结果集测试list
//        List<Employee> list=dao.selectAllEmp();
//        for (Employee employee:list) {
//             System.out.println(employee);
//        }
//        //返回结果集测试map
//        Map<String,Employee> map=dao.selectAllEmp1();
//        System.out.println(map);
//        //执行删除操作
//        dao.deleteEmp(1);
//        session.commit();
//        //执行修改操作
//        Employee employee=new Employee();
//        employee.setLast_name("wang");
//        employee.setId(1);
//        dao.updateEmp(employee);
//        session.commit();
//        //执行新增操作
//        Employee employee=new Employee();
//        employee.setId(2);
//        employee.setLast_name("wang");
//        employee.setEmail("2515946609@qq.com");
//        employee.setGender("man");
//        employee.setDid(1);
//        dao.insertEmp(employee);
        session.commit();
        session.close();
    }
}
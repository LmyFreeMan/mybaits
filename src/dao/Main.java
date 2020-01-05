package dao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        EmployeeDao dao=session.getMapper(dao.EmployeeDao.class);
        //执行分页
        List<Employee> list= (List<Employee>) dao.selectPage(1,5);
        // 执行查询操作
      //  Employee employee=dao.selectEmpAndDeptById(1);
       // Employee employee=dao.selectEmpById(1);
        System.out.println(list);
        //执行连表查询操作
//        Employee employee=dao.selectEmpByIdAndLastName(1,"wang");
        //测试动态sql(if)
//        Employee emp=new Employee();
//        emp.setLast_name("wang");
//        Employee employee=dao.selectEmp(emp);
//        System.out.println(employee);
//        //测试动态sql（foreach）
//        List<Integer>list=new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        List<Employee> employees=dao.selectEmpsByIn(list);
//        System.out.println(employees);
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
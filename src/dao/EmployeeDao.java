package dao;
import pojo.Employee;
public interface EmployeeDao {
    public Employee selectEmpById(int id);
}
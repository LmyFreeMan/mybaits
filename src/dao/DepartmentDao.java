package dao;
import pojo.Department;
public interface DepartmentDao {
    public Department selectDeptById(int id);
    public Department selectEmpByDid(int id);
}

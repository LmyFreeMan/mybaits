package dao;
import org.apache.ibatis.annotations.MapKey;
import pojo.Department;
import pojo.Employee;
import java.util.List;
import java.util.Map;
public interface EmployeeDao {
    public Employee selectEmpById(int id);
    public void deleteEmp(int id);
    public void updateEmp(Employee emp);
    public void insertEmp(Employee employee);
    public Employee selectEmpByIdAndLastName(int id,String last_name);
    public List<Employee> selectAllEmp();
    @MapKey("id")
    public Map<String,Employee> selectAllEmp1();
    public Employee selectEmpAndDeptById(int id);
    public Employee selectEmp(Employee employee);
    public List<Employee> selectEmpsByIn(List<Integer> list);
}
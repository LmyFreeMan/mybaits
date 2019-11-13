package pojo;
public class Employee {
    private int id;
    private String last_name;
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", did=" + did +
                '}';
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    private String email;
    private String gender;
    private int did;
}
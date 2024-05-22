import java.io.Serializable;

public class Student implements Serializable {
  
  private String name;
  private String degree;
  private String email;


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getDegree() {
    return degree;
  }


  public void setDegree(String degree) {
    this.degree = degree;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public String toString() {
    return "Student [degree=" + degree + ", email=" + email + ", name=" + name + "]";
  }

  public Student(String name, String degree, String email) {
    this.name = name;
    this.degree = degree;
    this.email = email;
  }
}
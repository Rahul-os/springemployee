package emp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee { 
	
@Id 
private int empcode;
@Column(length=50)
private String empname ;
@Column
private long mobileno;
@Column
private Date doj;
@Column
private double salary; 
@Column
@ElementCollection(targetClass=String.class)
List<String> skills;
public int getEmpcode() {
	return empcode;
}
public void setEmpcode(int empcode) {
	this.empcode = empcode;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public double getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public Date getDoj() {
	return doj;
}
public void setDoj(Date doj) {
	this.doj = doj;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

public List<String> getSkills() {
	return skills;
}
public void setSkills(List<String> skills) {
	this.skills = skills;
}

public Employee(int empcode, String empname, long mobileno, Date doj, double salary, List<String> skills) {
	super();
	this.empcode = empcode;
	this.empname = empname;
	this.mobileno = mobileno;
	this.doj = doj;
	this.salary = salary;
	this.skills = skills;
}
public Employee() {
	
	// TODO Auto-generated constructor stub
}






}

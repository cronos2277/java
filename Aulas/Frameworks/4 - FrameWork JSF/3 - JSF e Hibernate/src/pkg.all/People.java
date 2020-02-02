package pkg.all;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Person")
@Table(name="person")
public class People {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(nullable=false, name="id")
private int code;
//Dado do tipo data, no caso apenas dia mês e ano. O temporal por padrão, alem desses dados inclui hora minuto e segundos.
@Temporal(value = TemporalType.DATE)
@Column(nullable=false)
private Date born;
@Column(nullable=false)
private Integer age;
@Column(nullable=false)
private Long phone;
@Column(nullable=false)
private String address;
@Column(nullable=false)
private String city;
@Column(nullable=false)
private String function;
@Column(nullable=false)
private String name;
@Column(nullable=false)
private Double salary;

public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public Date getBorn() {
	return born;
}
public void setBorn(Date born) {
	this.born = born;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getFunction() {
	return function;
}
public void setFunction(String function) {
	this.function = function;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
}
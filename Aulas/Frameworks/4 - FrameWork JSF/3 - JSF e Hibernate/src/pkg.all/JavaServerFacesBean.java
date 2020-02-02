package pkg.all;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="bean")
@RequestScoped
public class JavaServerFacesBean {	
	private int this_id;
	private String this_status;
	private String this_name;
	private int this_age;
	private Date this_born; //Dados do tipo date, devem ser devidamente convertido primeiro.
	private String this_city;
	private String this_address;	
	private String this_function;
	private double this_salary;	
	private long this_phone;
	private String info = Hibernate.Status;	
	
	public String userNew(){
		try{
		People person = new People();
		person.setName(this.getThis_name());
		person.setAddress(this.getThis_address());
		person.setAge(this.getThis_age());
		person.setBorn(this.getThis_born());
		person.setCity(this.getThis_city());
		person.setFunction(this.getThis_function());
		person.setPhone(this.getThis_phone());
		person.setSalary(this.getThis_salary());
		this.this_status = "Usuário Cadastrado com sucesso!";
		new Methods().save(person);
		return "success";
		}catch(Exception e){Hibernate.Status += "\nErro no JSF ao adicionar usuário, "+e.toString();this.this_status = "Erro!";return "error";}
	}
	
	public String userEdit(){
		try{
			People person = new Methods().GetByID(this.getThis_id());
			person.setName(this.getThis_name());
			person.setAddress(this.getThis_address());
			person.setAge(this.getThis_age());
			person.setBorn(this.getThis_born());
			person.setCity(this.getThis_city());
			person.setFunction(this.getThis_function());
			person.setPhone(this.getThis_phone());
			person.setSalary(this.getThis_salary());
			new Methods().edit(person);
			return "success";
			/*
			 * Repare que este método tem um retorno, no caso esse retorno é uma String,
			 * o tratamento desse retorno é semelhante ao Struts, veja no faces-config.xml
			 */
		}catch(Exception e){Hibernate.Status += "\nErro no JSF ao modificar usuário, "+e.toString();return "error";}
	}
	
	
	public String getThis_name() {
		return this_name;
	}
	public void setThis_name(String this_name) {
		this.this_name = this_name;
	}
	public int getThis_age() {
		return this_age;
	}
	public void setThis_age(int this_age) {
		this.this_age = this_age;
	}
	public Date getThis_born() {
		return this_born;
	}
	public void setThis_born(Date this_born) {
		this.this_born = this_born;
	}
	public String getThis_city() {
		return this_city;
	}
	public void setThis_city(String this_city) {
		this.this_city = this_city;
	}
	public String getThis_address() {
		return this_address;
	}
	public void setThis_address(String this_address) {
		this.this_address = this_address;
	}
	public String getThis_function() {
		return this_function;
	}
	public void setThis_function(String this_function) {
		this.this_function = this_function;
	}
	public double getThis_salary() {
		return this_salary;
	}
	public void setThis_salary(double this_salary) {
		this.this_salary = this_salary;
	}
	public long getThis_phone() {
		return this_phone;
	}
	public void setThis_phone(long this_phone) {
		this.this_phone = this_phone;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getThis_status() {
		return this_status;
	}
	public void setThis_status(String this_status) {
		this.this_status = this_status;
	}
	public int getThis_id() {
		return this_id;
	}
	public void setThis_id(int this_id) {
		this.this_id = this_id;
	}
		
}
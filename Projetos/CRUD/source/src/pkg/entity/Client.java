package pkg.entity;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dob; //Fazer função de aniversário aqui.
	private String rg;
	private String cpf;
	private String account_holder;
	private String bank_agency;
	private String account_number;
	private String account_type;	
	private String notes;
	
	public Date getDob() {		
		return dob;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public String getBank_agency() {
		return bank_agency;
	}
	public void setBank_agency(String bank_agency) {
		this.bank_agency = bank_agency;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Long getId() {
		return id;
	}
	
	public void setDob(Date dob){
		this.dob = dob;
	}
	
	public void setDob(String data) {	
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
		Date date = null;
		try{
			date = format.parse(data);
			this.dob = date;
		}catch(Exception e){
			this.dob = null;			
		}			
	}
		
}
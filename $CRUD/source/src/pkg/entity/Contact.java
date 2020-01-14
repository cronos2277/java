package pkg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="contact")
public class Contact {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String email;
	private String mobile;
	private String home_phone;
	private String secondary_phone;
	private String notes;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHome_phone() {
		return home_phone;
	}
	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}
	public String getSecondary_phone() {
		return secondary_phone;
	}
	public void setSecondary_phone(String secondary_phone) {
		this.secondary_phone = secondary_phone;
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
}

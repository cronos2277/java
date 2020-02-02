package pkg.entity;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="laptop")
public class Laptop {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String facebook_page;
	private String facebook_login;
	private String facebook_password;	
	@Temporal(TemporalType.DATE)
	private Date initial_date;
	@Temporal(TemporalType.DATE)
	private Date final_date;
	@Temporal(TemporalType.DATE)
	private Date laptop_shipped;
	@Temporal(TemporalType.DATE)
	private Date laptop_received;
	private String team_view_id;
	private String team_view_pw;
	private String notes;
	public String getFacebook_page() {
		return facebook_page;
	}
	public void setFacebook_page(String facebook_page) {
		this.facebook_page = facebook_page;
	}
	public String getFacebook_login() {
		return facebook_login;
	}
	public void setFacebook_login(String facebook_login) {
		this.facebook_login = facebook_login;
	}
	public String getFacebook_password() {
		return facebook_password;
	}
	public void setFacebook_password(String facebook_password) {
		this.facebook_password = facebook_password;
	}	
	public Date getInitial_date() {
		return initial_date;
	}	
	
	public Date getFinal_date() {
		return final_date;
	}	
	
	public Date getLaptop_shipped() {
		return laptop_shipped;
	}	
	
	public Date getLaptop_received() {
		return laptop_received;
	}
	
	public String getTeam_view_id() {
		return team_view_id;
	}
	public void setTeam_view_id(String team_view_id) {
		this.team_view_id = team_view_id;
	}
	public String getTeam_view_pw() {
		return team_view_pw;
	}
	public void setTeam_view_pw(String team_view_pw) {
		this.team_view_pw = team_view_pw;
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
	public void setInitial_date(Date initial_date){
		this.initial_date = initial_date;
	}
	public void setInitial_date(String initial_date) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
		Date date = null;
		try{
			date = format.parse(initial_date);
			this.initial_date = date;
		}catch(Exception e){
			this.initial_date = null;			
		}		
	}
	
	public void setFinal_date(Date final_date){
		this.final_date = final_date;
	}
	
	public void setFinal_date(String data) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
		Date date = null;
		try{
			date = format.parse(data);
			this.final_date = date;
		}catch(Exception e){
			this.final_date = null;
		}				
	}
	
	public void setLaptop_shipped(Date laptop_shipped){
		this.laptop_shipped = laptop_shipped;
	}
	
	public void setLaptop_shipped(String data) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
		Date date = null;
		try{
			date = format.parse(data);
			this.laptop_shipped = date;
		}catch(Exception e){
			this.laptop_shipped = null;
		}				
	}
	
	public void setLaptop_received(Date laptop_received){
		this.laptop_received = laptop_received;
	}
	
	public void setLaptop_received(String data) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
		Date date = null;
		try{
			date = format.parse(data);
			this.laptop_received = date;
		}catch(Exception e){
			this.laptop_received = null;
		}				
	}
}

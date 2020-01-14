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
@Table(name ="payment")
public class Payment {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private Double withdraw_cost;
	@Temporal(TemporalType.DATE)
	private Date payment_date;	
	private String referredby;		
	private Double contractPayment;	
	private String notes;
	public Double getWithdraw_cost() {
		return withdraw_cost;
	}
	public void setWithdraw_cost(Double withdraw_cost) {
		this.withdraw_cost = withdraw_cost;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	
	public String getReferredby() {
		return referredby;
	}
	public void setReferredby(String referredby) {
		this.referredby = referredby;
	}
	public Double getContractPayment() {
		return contractPayment;
	}
	public void setContractPayment(Double contractPayment) {
		this.contractPayment = contractPayment;
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
	
	public void setPayment_date(Date payment_date){
		this.payment_date = payment_date;
	}
	
	public void setPayment_date(String data) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
		Date date = null;
		try{
			date = format.parse(data);
			this.payment_date = date;
		}catch(Exception e){
			System.out.println("Error to persist date: "+e.toString());
		}				
	}	
}

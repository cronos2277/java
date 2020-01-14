package pkg.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer reference_bonus_status;
	private Integer shipment_status;	
	private Boolean payment_status;
	private Integer account_status;
	private String termination;
	
	public Integer getReference_bonus_status() {
		return reference_bonus_status;
	}
	public void setReference_bonus_status(Integer reference_bonus_status) {
		this.reference_bonus_status = reference_bonus_status;
	}
	public Integer getShipment_status() {
		return shipment_status;
	}
	public void setShipment_status(Integer shipment_status) {
		this.shipment_status = shipment_status;
	}
	
	public Boolean getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(Boolean payment_status) {
		this.payment_status = payment_status;
	}
	public Long getId() {
		return id;
	}
	public Integer getAccount_status() {
		return account_status;
	}
	public void setAccount_status(Integer account_status) {
		this.account_status = account_status;
	}
	public String getTermination() {
		return termination;
	}
	public void setTermination(String termination) {
		this.termination = termination;
	}
	
}

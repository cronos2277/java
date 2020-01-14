package pkg.entity;
import java.util.Date;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@Column(name="brazillaptop", nullable=false)
	private Integer BrazilLaptop;
	@Column(nullable=false)
	private String name;	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modify = new Date();
	//Relacionamento com o client
	@OneToOne(cascade = CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "client_id",nullable=false)
	private Client client;
	
	//relacionamento com o contact
	@OneToOne(cascade = CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "contact_id",nullable=false)
	private Contact contact;
	
	//relacionameto com laptop
	@OneToOne(cascade = CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "laptop_id",nullable=false)
	private Laptop laptop;
	
	//Relacionamento com o locale
	@OneToOne(cascade = CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "locale_id",nullable=false)
	private Locale locale;
	
	//Relacionamento com payment
	@OneToOne(cascade = CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "payment_id",nullable=false)
	private Payment payment;
	
	//Relacionamento com Status
	@OneToOne(cascade = CascadeType.ALL, optional=false, fetch=FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name = "status_id",nullable=false)
	private Status status;	
	
	@OneToMany(targetEntity = References.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="user")
	@JoinColumn(name="references_id", nullable=true)
	private List<References> references;
	
	@OneToMany(targetEntity = Attachments.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="user")
	@JoinColumn(name="attachments_id", nullable=true)
	private List<Attachments> attachments;	
	
	
	public Integer getBrazilLaptop() {
		return BrazilLaptop;
	}
	public void setBrazilLaptop(Integer brazilLaptop) {
		BrazilLaptop = brazilLaptop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<References> getReferences() {
		return references;
	}
	public void setReferences(List<References> references) {
		this.references = references;
	}
	public List<Attachments> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}
	public Long getId() {
		return id;
	}
	public Date getModify(){
		return this.modify;
	}
	
	public Status getStatus(){
		return this.status;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	
}

package pkg.connection;
import java.util.ArrayList;
import java.util.List;
import pkg.entity.Attachments;
import pkg.entity.Client;
import pkg.entity.Contact;
import pkg.entity.Laptop;
import pkg.entity.Locale;
import pkg.entity.Payment;
import pkg.entity.References;
import pkg.entity.Status;
import pkg.entity.User;

public class Manager extends ConnectionManager{	
	private boolean isEditable = false;
	private int key;
	private List<References> references;
	private List<Attachments> attachments;
	private Long id;
	public Client client;
	public Contact contact;
	public Laptop laptop;
	public Locale locale;
	public Payment payment;
	public Status status;
	public String name;
	public Integer laptopNumber;	
	
	public Manager(int id){	//Tome cuidado com esses métodos, escreva todos eles para evitar a inserção de dados nulos.	
		super();
		this.isEditable = this.check(id);
		if(isEditable){
			this.key = id - 1;
			this.name = super.lists.get(key).getName();
			this.client = super.lists.get(key).getClient();
			this.contact = super.lists.get(key).getContact();
			this.laptop = super.lists.get(key).getLaptop();
			this.locale = super.lists.get(key).getLocale();
			this.payment = super.lists.get(key).getPayment();
			this.status = super.lists.get(key).getStatus();
			this.id = super.lists.get(key).getId();
			this.laptopNumber = super.lists.get(key).getBrazilLaptop();
			this.references = this.getREF();
			this.attachments = this.getATT();
		}else{
			this.client = new Client();
			this.contact = new Contact();
			this.laptop = new Laptop();
			this.locale = new Locale();
			this.payment = new Payment();
			this.status = new Status();			
		}
	}
	
	public void create(User user){
		super.persistUser(user);
	}	
	
	
	public void change(){
		if(this.isEditable){
			super.user = super.lists.get(this.key);
			Long id = Long.valueOf(this.key);
			super.user.setName(this.name);
			super.user.setBrazilLaptop(this.laptopNumber);
			super.user.setClient(this.client);
			super.user.setContact(this.contact);
			super.user.setLaptop(this.laptop);
			super.user.setLocale(this.locale);
			super.user.setPayment(this.payment);
			super.user.setStatus(this.status);
			super.editUser(id, super.user);
		}else{
			System.out.println("Editable = false");
		}
	}
	
	public void addReference(String name, String notes){
		if(this.isEditable){
			super.user = super.lists.get(this.key);
			References ref = new References();			
			ref.setRef(name);
			ref.setNotes(notes);
			ref.setUser(super.user);
			super.addReferences(this.id, ref);					
		}
	}
	
	public void addAttachment(String name, String path, String notes){
		if(this.isEditable){
			super.user = super.lists.get(this.key);
			Attachments att = new Attachments();
			att.setName(name);
			att.setPath(path);
			att.setNotes(notes);
			att.setUser(super.user);
			super.addAttachments(this.id, att);					
		}
	}
	
	public void deleteAtt(int attKey){		
		if(attKey <= this.attachments.size()){			
			super.removeAttachment(this.id, this.attachments.get(attKey -1).getId());
		}else{
			System.out.printf("Deleting the attachments cannot be made");
		}
	}
	
	public void deleteRef(int refKey){		
		if(refKey <= this.references.size()){			
			super.removeReference(this.id, this.references.get(refKey -1).getId());
		}else{
			System.out.printf("Deleting the references cannot be made");
		}		
	}
	
	public Long getID(){
		return this.id;
	}
	
	private boolean check(int id){
		if((id > 0) && id <= super.lists.size()){
			return true;
		}else{
			return false;
		}
	}
	
	public List<References> getREF(){
		List<References> refs = new ArrayList<References>();
		for(References ref: super.references){
			if(ref.getUser().getId() == this.id){
				refs.add(ref);
			}
		}		
		return refs;
	}
	
	public List<Attachments> getATT(){
		List<Attachments> atts = new ArrayList<Attachments>();
		for(Attachments att: super.attachments){
			if(att.getUser().getId() == this.id){				
				atts.add(att);
			}
		}
		return atts;
	}
	
	public boolean thisIsEditable(){
		return this.isEditable;
	}
	
	public void editRef(int refKey, References ref){					
		super.editReference(this.id, this.references.get(refKey -1).getId(), ref);		
	}
	
	public void editAtt(int attKey, Attachments att){				
		super.editAttachment(this.id, this.attachments.get(attKey -1).getId(), att);		
	}
	
	public Manager(){
		this.isEditable = false;
	}
	
	
}
	


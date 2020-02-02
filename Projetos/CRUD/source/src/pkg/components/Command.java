package pkg.components;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import pkg.connection.Manager;
import pkg.entity.Client;
import pkg.entity.Contact;
import pkg.entity.Laptop;
import pkg.entity.Locale;
import pkg.entity.Payment;
import pkg.entity.Status;
import pkg.entity.User;
import pkg.main.Do;

class Command implements ActionListener{	
	private JDialog jdialog;
	private User user;
	private Client client;
	private Contact contact;
	private Laptop laptop;
	private Locale locale;
	private Payment payment;
	private Status status;
	private Double contractPayment;	
	public JButton submit;
	public JButton clean;
	public JTextField client_name;
	public JFormattedTextField dob;
	public JFormattedTextField paymentDate;
	public JFormattedTextField cpf;  
	public JTextField holder;
	public JTextField agency;
	public JTextField account;
	public JTextField type;		
	public JTextField email;
	public JTextField phone_cell;	
	public JTextField brazil_laptop_number;
	public JTextField page_name;
	public JTextField facebook_login;
	public JTextField facebook_password;	
	public JTextField contract_payment;	
	public JTextField state;
	public JTextField city;
	public JTextField neighborhood;
	public JTextField address;
	public JFormattedTextField zipcode;
	public String[] account_status_list = {"<Select>","Online","Away","Flagged"};
	public String[] payed_or_unpayed = {"<Select>","Paid","Unpaid"};	
	public String[] shipmentStatusArray = {"<Select>","Flagged","Arrived","Online"};		
	public JComboBox<String> reference_bonus_status;
	public JComboBox<String> shipment_status;	
	public JComboBox<String> payment_status;
	public JComboBox<String> account_status;
	public JTabbedPane tabbed;
	public Command(JDialog jdiag){
		this.user = new User();	
		this.jdialog = jdiag;
	}	
	
	private boolean requerimentsToSubmit(){
			
		try{
			
			if(this.client_name.getText().equals("")){
				this.tabbed.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Please inform the CUSTOMER NAME.");
				
				return false;
			}
			
			if(this.dob.getText().equals("")){
				this.tabbed.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Please inform the DOB.");				
				return false;
			}else if(!this.dob.getText().equals("")){				
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
				Date date = null;
				try{
					date = format.parse(this.dob.getText());
					if(!date.before(new Date())){
						throw new NullPointerException();
					}
				}catch(Exception e){
					this.tabbed.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "Please inform the valide DOB.");
					return false;
				}
			}
			
			if(this.cpf.getText().trim().length() < 14){
				this.tabbed.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Please inform the CPF.");
				return false;
			}
			
			if(this.holder.getText().equals("")){
				this.tabbed.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Please inform the ACCOUNT HOLDER.");
				return false;
			}
			
			if(this.account.getText().equals("")){
				this.tabbed.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Please inform the ACCOUNT NUMBER.");
				return false;
			}
			
			if(this.type.getText().equals("")){
				this.tabbed.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Please inform the ACCOUNT TYPE");
				return false;
			}
			
			if(this.agency.getText().equals("")){
				this.tabbed.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Please inform the BANK AGENCY.");
				return false;
			}			
			
			if(this.brazil_laptop_number.getText().equals("")){
				this.tabbed.setSelectedIndex(1);
				JOptionPane.showMessageDialog(null, "Please inform the BrazilLaptopNumber#.");
				return false;
			}
			
			
			if(this.email.getText().equals("")){
				int opt = JOptionPane.showConfirmDialog(null, "You want to register a new record without having his e-mail?","Registering...", JOptionPane.YES_NO_OPTION);
				if(opt == 0){
					//Não coloque nada aqui
				}else{
					this.tabbed.setSelectedIndex(1);
					return false;
				}
			}
			
			if(this.phone_cell.getText().equals("")){
				int opt = JOptionPane.showConfirmDialog(null, "You would like to register this contract without a cell phone number?","Registering...", JOptionPane.YES_NO_OPTION);
				if(opt == 0){
					//Não coloque nada aqui
				}else{
					this.tabbed.setSelectedIndex(1);
					return false;
				}
			}
			
			if(this.contract_payment.getText().equals("")){
				this.tabbed.setSelectedIndex(1);
				JOptionPane.showMessageDialog(null, "Please inform the CONTRACT PAYMENT.");
				return false;
			}else{
				try{
					this.contractPayment = Double.parseDouble(this.contract_payment.getText());
				}catch(Exception e){
					this.tabbed.setSelectedIndex(1);
					JOptionPane.showMessageDialog(null, "Invalid value. Please enter a valid real number in CONTRACT PAYMENT!");
					return false;
				}
			}
			
			if(this.page_name.getText().equals("")){
				this.tabbed.setSelectedIndex(1);
				JOptionPane.showMessageDialog(null, "Please inform the PAGE NAME.");
				return false;
			}
			
			if(this.facebook_login.getText().equals("")){
				this.tabbed.setSelectedIndex(1);
				JOptionPane.showMessageDialog(null, "Please inform the FACEBOOK LOGIN.");
				return false;
			}
			
			if(this.facebook_password.getText().equals("")){
				this.tabbed.setSelectedIndex(1);
				JOptionPane.showMessageDialog(null, "Please inform the FACEBOOK PASSWORD.");
				return false;
			}
			
			if(this.state.getText().equals("")){
				this.tabbed.setSelectedIndex(2);
				JOptionPane.showMessageDialog(null, "Please inform the STATE");
				return false;
			}
			
			if(this.city.getText().equals("")){
				this.tabbed.setSelectedIndex(2);
				JOptionPane.showMessageDialog(null, "Please inform the CITY");
				return false;
			}
			
			if(this.neighborhood.getText().equals("")){
				this.tabbed.setSelectedIndex(2);
				JOptionPane.showMessageDialog(null, "Please inform the NEIGHBORHOOD");
				return false;
			}
			
			if(this.address.getText().equals("")){
				this.tabbed.setSelectedIndex(2);
				JOptionPane.showMessageDialog(null, "Please inform the ADDRESS");
				return false;
			}
			
			if(this.zipcode.getText().trim().length() < 9){
				this.tabbed.setSelectedIndex(2);
				JOptionPane.showMessageDialog(null, "Please inform the ZIPCODE");
				return false;
			}			
			
			if(this.paymentDate.getText().equals("")){
				this.tabbed.setSelectedIndex(3);
				JOptionPane.showMessageDialog(null, "Please inform the Payment Date.");
				return false;
			}else if(!this.paymentDate.getText().equals("")){				
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyyy");
				Date date = null;
				try{
					date = format.parse(this.paymentDate.getText());
					if(!date.after(new Date())){
						int opt = JOptionPane.showConfirmDialog(null, "You did not inform a date has passed. Do you want to continue with this same data?","WARNING PAYMENT DATE", JOptionPane.YES_NO_OPTION);
						if(opt!= 0){
							this.tabbed.setSelectedIndex(3);
							return false;
						}
					}
				}catch(Exception e){
					this.tabbed.setSelectedIndex(3);
					JOptionPane.showMessageDialog(null, "Please inform the valid Payment Date.");
					return false;
				}
			}			
			
			if(this.reference_bonus_status.getSelectedIndex() < 1){
				this.tabbed.setSelectedIndex(3);
				JOptionPane.showMessageDialog(null, "Please inform the REFERENCE BONUS STATUS.");
				return false;
			}
			if(this.shipment_status.getSelectedIndex() < 1){
				this.tabbed.setSelectedIndex(3);
				JOptionPane.showMessageDialog(null, "Please inform the SHIPMENT STATUS.");
				return false;
			}			
		
			if(this.payment_status.getSelectedIndex() < 1){
				this.tabbed.setSelectedIndex(3);
				JOptionPane.showMessageDialog(null, "Please inform the PAYMENT STATUS.");
				return false;
			}
			
			if(this.account_status.getSelectedIndex() < 1){
				this.tabbed.setSelectedIndex(3);
				JOptionPane.showMessageDialog(null, "Please inform the ACCOUNT STATUS.");
				return false;
			}
			System.out.println("all requirements met!");
			return true;
		}catch(NullPointerException n){
			System.out.println(n);
			return false;
		}
		
	}	
	
	private void insertClient(){
		this.client = new Client();
		this.client.setAccount_holder(this.holder.getText());
		this.client.setAccount_number(this.account.getText());
		this.client.setAccount_type(this.type.getText());
		this.client.setBank_agency(this.agency.getText());
		this.client.setCpf(this.cpf.getText());
		this.client.setDob(this.dob.getText());
		this.user.setClient(this.client);
	}
	
	private void insertContact(){
		this.contact = new Contact();
		this.contact.setEmail(this.email.getText());		
		this.contact.setMobile(this.phone_cell.getText());		
		this.user.setContact(contact);
	}
	
	private void insertLaptop(){
		this.laptop = new Laptop();
		this.laptop.setFacebook_login(this.facebook_login.getText());
		this.laptop.setFacebook_page(this.page_name.getText());
		this.laptop.setFacebook_password(this.facebook_password.getText());		
		this.user.setLaptop(this.laptop);
	}
	
	private void insertLocale(){
		this.locale = new Locale();
		this.locale.setAddress(this.address.getText());
		this.locale.setCity(this.city.getText());
		this.locale.setNeighborhood(this.neighborhood.getText());		
		this.locale.setState(this.state.getText());
		this.locale.setZipcode(this.zipcode.getText());
		this.user.setLocale(this.locale);
	}
	
	private void insertPayment(){
		this.payment = new Payment();
		try{			
			this.payment.setContractPayment(this.contractPayment);
		}catch(Exception e){
			System.out.println("Contract payment is empty :"+e.toString());			
			this.payment.setContractPayment(0.0);
		}
		this.payment.setPayment_date((this.paymentDate.getText()));
		this.user.setPayment(this.payment);
		
	}
	
	private void insertStatus(){
		this.status = new Status();		
		this.status.setPayment_status(((this.payment_status.getSelectedIndex() == 1)?true:false));
		this.status.setReference_bonus_status((this.reference_bonus_status.getSelectedIndex()));
		this.status.setShipment_status(this.shipment_status.getSelectedIndex());
		this.status.setAccount_status(this.account_status.getSelectedIndex());
		this.user.setStatus(this.status);
	}	
	
	private void insertUser(){
		this.user.setName(this.client_name.getText());
		try{
			Integer num = new Integer(this.brazil_laptop_number.getText());
			this.user.setBrazilLaptop(num);
			this.insertStatus();
			this.insertClient();
			this.insertContact();
			this.insertLaptop();
			this.insertLocale();
			this.insertPayment();			
		}catch(Exception e){
			this.user.setBrazilLaptop(0);
		}		
		
	}	
	
	private void clean(){
		this.brazil_laptop_number.setText("");
		this.client_name.setText("");
		this.dob.setText("");
		this.cpf.setText("");
		this.holder.setText("");
		this.account.setText("");
		this.agency.setText("");
		this.type.setText("");
		this.email.setText("");
		this.phone_cell.setText("");
		this.contract_payment.setText("");
		this.facebook_login.setText("");
		this.facebook_password.setText("");
		this.page_name.setText("");
		this.state.setText("");
		this.city.setText("");
		this.neighborhood.setText("");
		this.address.setText("");
		this.zipcode.setText("");
		this.reference_bonus_status.setSelectedIndex(0);
		this.shipment_status.setSelectedIndex(0);		
		this.payment_status.setSelectedIndex(0);
		this.account_status.setSelectedIndex(0);
		this.paymentDate.setText("");
	}
	
	
	public void actionPerformed(ActionEvent ev) {			
			insertUser();
			if(ev.getSource() == this.submit){
				if(this.requerimentsToSubmit()){
					int opt = JOptionPane.showConfirmDialog(null, "Have you finished adding this client information?","Registering...", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						try{
							new Manager().create(this.user);
							JOptionPane.showMessageDialog(null, "Client registered successfully!");						
							clean();							
							this.jdialog.dispose();
							Do.clearScreen();
						}catch(Exception e){
							Do.notifyTechnicalError(e);
						}
					}
				}
			}else if(ev.getSource() == this.clean){
				int opt = JOptionPane.showConfirmDialog(null, "To clear all fields??","Cleaning... ", JOptionPane.YES_NO_OPTION);
				if(opt == 0) clean();
			}			
	}	
}

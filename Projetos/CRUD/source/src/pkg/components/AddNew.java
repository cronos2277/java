package pkg.components;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pkg.main.Do;
import pkg.main.Main;

final class AddNew{	
	public static AddNew instance;
	private JDialog frame = new JDialog(Window.window,"Add a new register");	
	private int width;
	private int height;
	private Format format;
	private Command command;
	private AddNew(){
		try{			
			this.format = new Format();
			this.command = new Command(frame);			
			this.width =  Main.dimension.width/3;
			this.height = Main.dimension.height/3;
			frame = new JDialog(Window.window,"Add a new register");
			frame.setLayout(new BorderLayout());			
			frame.add(BorderLayout.CENTER,this.tabbedPane());
			frame.add(BorderLayout.SOUTH, this.buttons());
			frame.setSize(width, height);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setModal(true);
			frame.addWindowListener(new WindowEvent());
			System.out.println("New registration window loaded successfully!");
		}catch(Exception e){
			System.out.println("Error loading the window of adding user, due to the error: "+e.toString());
		}
	}
	
	//Painel de documentos.
	
	private JPanel panelClientData(){
		JPanel client = this.getPanel("Client");		
		JLabel[] labels = new JLabel[7];		
		
		//Campo Client name.
		labels[0] = new JLabel("Customer Name");
		this.command.client_name = new JTextField();
		this.command.client_name.setDocument(this.format.getRules(1));
		this.command.client_name.addActionListener(this.command);
		this.componentsRules(client.add(labels[0]));		
		this.componentsRules(client.add(this.command.client_name));
		
		//DOB
		labels[1] = new JLabel("DOB (MM/dd/yyyy)");
		this.command.dob = new JFormattedTextField(this.format.getMask('d'));
		this.componentsRules(client.add(labels[1]));
		this.componentsRules(client.add(this.command.dob));
		
		//Campo CPF.
		labels[2] = new JLabel("CPF");
		this.command.cpf = new JFormattedTextField(this.format.getMask('c'));
		this.command.cpf.addActionListener(this.command);
		this.componentsRules((client.add(labels[2])));
		this.componentsRules((client.add(this.command.cpf)));			
		
		//Configuração de banco.
		labels[3] = new JLabel("Account Holder");
		this.command.holder = new JTextField();
		this.componentsRules(client.add(labels[3]));		
		this.command.holder.setDocument(this.format.getRules(1));
		this.componentsRules(client.add(this.command.holder));
		
		//Configuração Accont Number
		labels[4] = new JLabel("Account Number");
		this.command.account = new JTextField();
		this.command.account.setHorizontalAlignment(SwingConstants.RIGHT);
		this.command.account.setDocument(this.format.getRules(2));
		this.componentsRules(client.add(labels[4]));
		this.componentsRules(client.add(this.command.account));
		
		//Configuração Accont Type
		labels[5] = new JLabel("Account Type");
		this.command.type = new JTextField();		
		this.componentsRules(client.add(labels[5]));
		this.componentsRules(client.add(this.command.type));
		
		//Configuração Bank agency
		labels[6] = new JLabel("Bank Agency");
		this.command.agency = new JTextField();		
		this.componentsRules(client.add(labels[6]));
		this.componentsRules(client.add(this.command.agency));		
		return client;		
		
	}
	
	private JPanel panelService(){		
		JPanel service = this.getPanel("Service");		
		JLabel[] labels = new JLabel[7];		
		
		//Laptop Number
		labels[0] = new JLabel("BrazilLaptop#");
		this.command.brazil_laptop_number = new JTextField();
		this.command.brazil_laptop_number.setDocument(this.format.getRules(2));
		this.command.brazil_laptop_number.addActionListener(this.command);
		this.command.brazil_laptop_number.setHorizontalAlignment(SwingConstants.CENTER);
		this.componentsRules(service.add(labels[0]));
		this.componentsRules(service.add(this.command.brazil_laptop_number));
				
		
		//Campo de E-mail 
		labels[1] = new JLabel("E-mail to contact");
		this.command.email = new JTextField();		
		this.componentsRules(service.add(labels[1]));
		this.componentsRules(service.add(this.command.email));
						
		//Cell Phones
		labels[2] = new JLabel("Cellphone number");
		this.command.phone_cell = new JTextField();		
		this.componentsRules(service.add(labels[2]));
		this.command.phone_cell.setHorizontalAlignment(SwingConstants.CENTER);
		this.command.phone_cell.setDocument(this.format.getRules(2));
		this.componentsRules(service.add(this.command.phone_cell));
		
		//Campo Contract Payment
		labels[3] = new JLabel("Contract Payment");
		this.command.contract_payment = new JTextField();
		this.componentsRules(service.add(labels[3]));
		this.command.contract_payment.setDocument(this.format.getRules(3));
		this.command.contract_payment.setHorizontalAlignment(SwingConstants.RIGHT);
		this.componentsRules(service.add(this.command.contract_payment));
		
		//Campo Page Name
		labels[4] = new JLabel("FB Page");
		this.command.page_name = new JTextField();
		this.componentsRules(service.add(labels[4]));
		this.componentsRules(service.add(this.command.page_name));
				
		//Campo FB Login
		labels[5] = new JLabel("FB Login");	
		this.command.facebook_login = new JTextField();
		this.componentsRules(service.add(labels[5]));
		this.componentsRules(service.add(this.command.facebook_login));
				
		//Campo FB Password
		labels[6] = new JLabel("FB PW");
		this.command.facebook_password = new JTextField();
		this.componentsRules(service.add(labels[6]));
		this.componentsRules(service.add(this.command.facebook_password));
		return service;
	}	
	
	private JPanel panelContact(){		
		JPanel contact = this.getPanel("Locale");		
		JLabel[] labels = new JLabel[5];		
		
		labels[0] = new JLabel("State");
		this.command.state = new JTextField();
		this.command.state.setDocument(this.format.getRules(1));
		this.componentsRules(contact.add(labels[0]));
		this.componentsRules(contact.add(this.command.state));
		
		//Campo City
		labels[1] = new JLabel("City");
		this.command.city = new JTextField();
		this.componentsRules(contact.add(labels[1]));
		this.command.city.setDocument(this.format.getRules(1));
		this.componentsRules(contact.add(this.command.city));		
		
		//Campo Neighborhood
		labels[2] = new JLabel("Neighborhood");
		this.command.neighborhood = new JTextField();
		this.componentsRules(contact.add(labels[2]));
		this.componentsRules(contact.add(this.command.neighborhood));		
		
		//Campo Address
		labels[3] = new JLabel("Address");
		this.command.address = new JTextField();
		this.componentsRules(contact.add(labels[3]));
		this.componentsRules(contact.add(this.command.address));				
		
		
		//Campo Zip Code
		labels[4] = new JLabel("Zip Code");
		this.command.zipcode = new JFormattedTextField(this.format.getMask('z'));
		this.componentsRules(contact.add(labels[4]));
		this.componentsRules(contact.add(this.command.zipcode));
		return contact;
	}		
	
	
	private JPanel initialStatus(){
		JPanel status = this.getPanel("Status");		
		JLabel labels[] = new JLabel[5];
		
		//Payment date
		labels[0] = new JLabel("Payment Date (MM/dd/yyyy)");
		this.command.paymentDate = new JFormattedTextField(this.format.getMask('d'));
		this.componentsRules(status.add(labels[0]));
		this.componentsRules(status.add(this.command.paymentDate));
		
		//Account Status
		labels[1] = new JLabel("Account Status");
		this.command.account_status = this.format.getBox(this.command.account_status_list);
		this.componentsRules(status.add(labels[1]));
		this.componentsRules(status.add(this.command.account_status));			
		
		//Reference Bonus Options.
		labels[2] = new JLabel("Reference Bonus Status");		
		this.command.reference_bonus_status = this.format.getBox(this.command.payed_or_unpayed);		
		this.componentsRules(status.add(labels[2]));
		this.componentsRules(status.add(this.command.reference_bonus_status));
		
		//Shipment Status
		labels[3] = new JLabel("Shipment Status");
		this.command.shipment_status = this.format.getBox(this.command.shipmentStatusArray);
		this.componentsRules(status.add(labels[3]));
		this.componentsRules(status.add(this.command.shipment_status));		
		
		//Reference Bonus Options.
		labels[4] = new JLabel("Payment Status");		
		this.command.payment_status = this.format.getBox(this.command.payed_or_unpayed);		
		this.componentsRules(status.add(labels[4]));
		this.componentsRules(status.add(this.command.payment_status));
		return status;
		
	}
	
	
	private JTabbedPane tabbedPane(){
		this.command.tabbed = new JTabbedPane();
		this.command.tabbed.add(this.panelClientData());
		this.command.tabbed.add(this.panelService());
		this.command.tabbed.add(this.panelContact());		
		this.command.tabbed.add(this.initialStatus());
		return this.command.tabbed;
	}
	
	
	
	private JPanel getPanel(String name){
		JPanel panel = new JPanel();
		panel.setName(name);			
		panel.setLayout(new GridLayout(7,2));				
		return panel;
	}
	
	
	
	private JPanel buttons(){
		JPanel panels = new JPanel();		
		this.command.clean = new JButton("Clean");		
		this.command.submit = new JButton("Submit");
		this.command.submit.addActionListener(this.command);
		this.command.clean.addActionListener(this.command);
		panels.setLayout(new FlowLayout(1,2,2));
		panels.add(this.command.clean);
		panels.add(this.command.submit);		
		return panels;
	}
	
	private Component componentsRules(Component comp){		
		comp.setFont(new Font("Arial", 20, 20));
			if(comp instanceof JFormattedTextField){
				((JFormattedTextField) comp).setHorizontalAlignment(SwingConstants.CENTER);
				((JFormattedTextField) comp).addActionListener(this.command);
			}else if(comp instanceof JTextField){
				((JTextField) comp).addActionListener(this.command);
			}
		return comp;
	}
	
	public JDialog init(){
		if(!instance.frame.isVisible()){
			instance = new AddNew();
		}				
		return this.frame;
	}
	
private class WindowEvent extends WindowAdapter{		
		public void windowClosing(java.awt.event.WindowEvent arg0) {
			
				int opt = JOptionPane.showConfirmDialog(null, "You want to quit and cancel this registration?","Leave", JOptionPane.YES_NO_OPTION);
				if(opt == 0){
					frame.setDefaultCloseOperation(Do.CloseOperation());
				}else{
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		}		
	
	
	
	static{
		instance = new AddNew();
	}
}

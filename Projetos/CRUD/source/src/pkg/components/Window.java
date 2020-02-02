package pkg.components;
import pkg.table.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Window {	
	public static JFrame window;
	private Menu menu = new Menu();
	public static JTabbedPane jTabbedPane1;
	
	public Window(Dimension dim){
		try{			
			System.out.println("Loading the main window...");
			window = new JFrame("Brazil Laptop Register Software");		
			window.setLayout(new BorderLayout());		
			window.add(BorderLayout.CENTER, this.tabbed());
			window.add(BorderLayout.NORTH, this.menu.getMenu()); 
			window.setSize(dim);
			window.setLocationRelativeTo(null);		
			window.addWindowListener(new WindowEvent());		
			window.setVisible(true);
			System.out.println("Main window loaded!");
		}catch(Exception e){
			System.out.println("Error loading window, due to the error: "+e.toString());
		}
	}	
	
	//Configurar O Painel Clients Data.
	private JScrollPane clientsData(){ 
		JScrollPane ClientsData = new JScrollPane(new ClientDataTable().getTable());
		ClientsData.setName("Clients");		
		return ClientsData;
	}
	
	//Configurar O Laptop Status.
	private JScrollPane laptopTable(){
		JScrollPane Laptop = new JScrollPane(new LaptopDataTable().getTable());
		Laptop.setName("Laptops");
		return Laptop;
	}
	
	//Configurar O Painel Payment.
	private JScrollPane paymentDue(){ 
		JScrollPane PaymentDue = new JScrollPane(new PaymentDataTable().getTable());
		PaymentDue.setName("Payments");		
		return PaymentDue;
	}	
	
	private JScrollPane localeDataTable(){
		JScrollPane locale = new JScrollPane(new LocaleDataTable().getTable());
		locale.setName("Locales");		
		return locale;
	}
	
	private JScrollPane contactDataTable(){
		JScrollPane contact = new JScrollPane(new ContactDataTable().getTable());
		contact.setName("Contact");		
		return contact;
	}	
	
	//Adicionar todas as abas.
	private JTabbedPane tabbed(){			
		jTabbedPane1 = new JTabbedPane();
		jTabbedPane1.add(this.clientsData());		
		jTabbedPane1.add(this.contactDataTable());
		jTabbedPane1.add(this.localeDataTable());		
		jTabbedPane1.add(this.laptopTable());
		jTabbedPane1.add(this.paymentDue());
		
		return jTabbedPane1;
	}		
	
	//Evento de janela. Aqui é decidido como que essa janela será fechada.
	private class WindowEvent extends WindowAdapter{
		
		public void windowClosing(java.awt.event.WindowEvent arg0) {
			
				int opt = JOptionPane.showConfirmDialog(null, "Do you really wish to exit?","Leave", JOptionPane.YES_NO_OPTION);
				if(opt == 0){
					Window.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else{
					Window.window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		}	
	}	



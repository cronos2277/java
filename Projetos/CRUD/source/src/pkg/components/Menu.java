package pkg.components;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import pkg.table.ATC;

final class Menu {	
	private JMenuBar bar = new JMenuBar();	
	private JMenu registry;
	private JMenuItem addnew;
	private JMenuItem remove;
	private JMenuItem references;
	private JMenuItem attached;		
	public Menu(){
		try{			
			registry = new JMenu("Register");		
			registry.add(this.addNew());
			registry.add(this.remClient());
			registry.add(this.attachedF());
			registry.add(this.showRef());			
			System.out.println("Menus loaded successfully!");
		}catch(Exception e){
			System.out.println("Error loading menus, due to the error: "+e.toString());
		}
	}		
	
	//Item do menu, corresponde ao Add new client.
	protected JMenuItem addNew(){
		this.addnew = new JMenuItem("Add a new register");
		this.addnew.addActionListener(new Registry());
		return this.addnew;
	}
	
	//Item do menu, corresponde ao Remove selected client.
	private JMenuItem remClient(){
		this.remove = new JMenuItem("Close the selected register");
		this.remove.addActionListener(new Registry());
		return this.remove;
	}
	
	//Item do menu, correspondente ao Show all selected clients references.
	private JMenuItem showRef(){
		this.references = new JMenuItem("References of this register");
		this.references.addActionListener(new Registry());
		return this.references;
	}
	
	private JMenuItem attachedF(){
		this.attached = new JMenuItem("Content attached to this register");
		this.attached.addActionListener(new Registry());
		return this.attached;
	}
	
	//Método que retorna o menú, pronto para ser adicionado ao JFrame.
	public JMenuBar getMenu(){		
		bar.add(registry);
		bar.add(OrderByMenu.menu.order);
		bar.add(AdvanceMenu.instance.menu);
		return bar;
	}	
	
	//Esse é o método que trata do encerramento de registros.
	private void closedMenu(){	
		try{
			if((ATC.selected_id > -1) && (ATC.selected_user.getStatus().getAccount_status() != 0) ){
				int opt = JOptionPane.showConfirmDialog(null, " Are you sure you want to finish this "+ATC.selected_name+" contract?.\nThis is an action that cannot be undone.\nAre you sure you want to proceed?","WARNING CLOSING... "+ATC.selected_name.toUpperCase(), JOptionPane.YES_NO_OPTION);
				if(opt == 0){					
					Reasons.instance.init();												
				}
			}else if(ATC.selected_user.getStatus().getAccount_status() == 0){
				Reasons.instance.init();
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Select in the table by clicking on the contract that you want to close.");
			
			System.out.println(e.getCause());
		}
	}
	
	//Aqui é tratado o clique sobre o menu Registry.
	private class Registry implements ActionListener{		
		public void actionPerformed(ActionEvent event) {
			
			//Aqui é feito o teste para saber se tem alguma janela aberta, caso sim cancela-se a abertura de uma janela.
						
			if(event.getSource() == addnew){				
				AddNew.instance.init();
			}else if(event.getSource() == remove){				
				closedMenu();				
			}else if(event.getSource() == references){
				Ref.instance.init();
			}else if(event.getSource() == attached){
				Attached.instance.init();
			}			
		}
	}		
}

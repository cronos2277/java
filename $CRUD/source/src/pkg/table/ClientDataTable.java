package pkg.table;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;

import pkg.components.Reasons;
import pkg.components.Window;
import pkg.connection.Manager;
import pkg.entity.User;
import pkg.main.Do;

public class ClientDataTable extends ATC{			
	private final static String[] head = {"Account Status","BrazilLaptop#", "Client Name", "Date of Birth", "RG", "CPF", "Account Holder" ,"Bank agency", "Account Number", "Account Type","Notes"};
	
	public ClientDataTable(){		
		super(head,1);
		super.model.addTableModelListener(this);
		
	}
	
	@Override
	public void load(){	
		super.dateformat = new SimpleDateFormat("MM/dd/yyyy");
		try{			
			for(User user: users){
				Date dob = user.getClient().getDob();
				super.model.addRow(new Object[]{user.getStatus().getAccount_status(),user.getBrazilLaptop(), user.getName(),(dob == null)?"":super.dataChange(dob),user.getClient().getRg(), 
				user.getClient().getCpf(), user.getClient().getAccount_holder(), user.getClient().getBank_agency(), 
				user.getClient().getAccount_number(), user.getClient().getAccount_type(), user.getClient().getNotes(), user.getStatus().getAccount_status()});				
				super.table.getColumnModel().getColumn(3).setCellRenderer(new Conditions().Get(4));				
				if(user.getStatus().getAccount_status() == 0){					
					super.table.getColumnModel().getColumn(3).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(4).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(5).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(6).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(7).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(8).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(9).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(10).setCellRenderer(new Conditions().Get(0));
				}
			}
			System.out.println("ClientDataTable loaded!");
		}catch(Exception e){
			System.out.println("Error loading the table ClientDataTable due to error: "+e.toString());
		}
				
	}
	
	public void mouseClicked(MouseEvent ev) {
		 clicked_row = 	this.table.rowAtPoint(ev.getPoint());	
		 clicked_colunm = this.table.columnAtPoint(ev.getPoint());
		 selected_id = users.get(clicked_row).getId();
		 selected_name = users.get(clicked_row).getName();		 
		 selected_user = users.get(clicked_row);
		 selected_tab = Window.jTabbedPane1.getSelectedIndex();
		 //Edite aqui o que deve ser exibido ao dar um duplo clique em usuário bloqueado.
		 if((selected_user.getStatus().getAccount_status() == 0) && ev.getClickCount() > 1){
			 Reasons.instance.init();
		 }
		 
		 
	}

	//Esse método é chamado quando é feita alguma alteração na tabela.
	public void tableChanged(TableModelEvent arg0) {
		switch(clicked_colunm){
			case 0: {super.changedAccountStatus_C0();break;}
			case 1: {super.changedLPNumber_C1();break;}
			case 2:	{super.changedName_C2();break;}	
			case 3: {this.changedDOB_C3();break;}
			case 4: {this.changeRG_C4();break;}
			case 5: {this.changeCPF_C5();break;}
			case 6: {this.changeAccountHolder_C6();break;}
			case 7: {this.changeAgency_C7();break;}
			case 8: {this.accountNumber_C8();break;}
			case 9: {this.accounttype_C9();break;}
			case 10: {this.client_notes_C10();break;}			
		}
		
	}
	
	private void changedDOB_C3(){
		Date date = null;		
		try{
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
			date = format.parse(str);	
			System.out.println(date);
			if(!date.equals(selected_user.getClient().getDob()) ){
				Manager manager = new Manager(clicked_row + 1);
				manager.client.setDob(date);
				manager.change();				
			}
			
			Do.clearScreen();
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Data not valid!");
			Do.clearScreen();			
		}
	}
	
	
	private void changeRG_C4(){
		if(selected_user.getClient().getRg() != this.model.getValueAt(clicked_row, clicked_colunm)){
			Manager manager = new Manager(clicked_row + 1);
			try{				
				String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
				if(str.matches("^\\d+$")){
					manager.client.setRg(str);
					manager.change();
				}else{
					throw new NullPointerException();
				}
				Do.clearScreen();
			}catch(Exception e){				
				JOptionPane.showMessageDialog(null, "Please! Only numbers.");
				Do.clearScreen();
			}
		}
	}
	
	private void changeCPF_C5(){
		if(selected_user.getClient().getCpf() != this.model.getValueAt(clicked_row, clicked_colunm)){
			Manager manager = new Manager(clicked_row+1);
			try{
				String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
				if(str.matches("^\\d{3}.\\d{3}.\\d{3}.\\d{2}$")){
					manager.client.setCpf(str);
					manager.change();
					Do.clearScreen();
				}else{
					throw new NullPointerException();
				}
			}catch(Exception e){				
				JOptionPane.showMessageDialog(null, "The CPF should be numbers in the following format: ###.###.###-##");
				Do.clearScreen();
			}
		}		
	}
	
	private void changeAccountHolder_C6(){
		if(selected_user.getClient().getAccount_holder() != this.model.getValueAt(clicked_row, clicked_colunm)){
			Manager manager = new Manager(clicked_row+1);
			try{
				String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
				if(str.matches("^\\D+$")){
					manager.client.setAccount_holder(str);
					manager.change();
					Do.clearScreen();
				}else{
					throw new NullPointerException();
				}
			}catch(Exception e){				
				JOptionPane.showMessageDialog(null, "Invalid name!");
				Do.clearScreen();
			}
		}
	}
	
	private void changeAgency_C7(){
		if(selected_user.getClient().getBank_agency() != this.model.getValueAt(clicked_row, clicked_colunm)){
			Manager manager = new Manager(clicked_row+1);
			try{
				String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
				manager.client.setBank_agency(str);
				manager.change();
				Do.clearScreen();
			}catch(Exception e){				
				JOptionPane.showMessageDialog(null, "Invalid agency bank!");
				Do.clearScreen();
			}			
		}
	}
	
	private void accountNumber_C8(){
		if(selected_user.getClient().getAccount_number() != this.model.getValueAt(clicked_row, clicked_colunm)){
			Manager manager = new Manager(clicked_row+1);
			try{				
				String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
				if(str.matches("^\\d+$")){
					manager.client.setAccount_number(str);
					manager.change();
					Do.clearScreen();
				}else{
					throw new NullPointerException();
				}
			}catch(Exception e){				
				JOptionPane.showMessageDialog(null, "Invalid account number!");
				Do.clearScreen();
			}
		}
	}
	
	private void accounttype_C9(){
		if(selected_user.getClient().getAccount_type() != this.model.getValueAt(clicked_row, clicked_colunm)){
			Manager manager = new Manager(clicked_row+1);
			try{
				String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
				manager.client.setAccount_type(str);
				manager.change();
				Do.clearScreen();
			}catch(Exception e){				
				JOptionPane.showMessageDialog(null, "Invalid account Type!");
				Do.clearScreen();
			}
		}
	}
	
	private void client_notes_C10(){
		if(selected_user.getClient().getNotes() != this.model.getValueAt(clicked_row, clicked_colunm)){
			Manager manager = new Manager(clicked_row+1);
			try{
				String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
				manager.client.setNotes(str);
				manager.change();
				Do.clearScreen();
			}catch(Exception e){				
				JOptionPane.showMessageDialog(null, "Client notes note saved!");
				Do.clearScreen();
			}
		}
	}	
}
	
	

	
	

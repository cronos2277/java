package pkg.table;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;

import pkg.components.Reasons;
import pkg.components.Window;
import pkg.connection.Manager;
import pkg.entity.User;
import pkg.main.Do;
public class ContactDataTable extends ATC{
	private static final String[] head = {"Account Status","BrazilLaptop#","Client Name","E-mail", "Mobile Phone", "Home Phone","Secondary Phone", "Notes"};	
	
	public ContactDataTable(){
	super(head,2);
	super.model.addTableModelListener(this);
	}

	@Override
	public void load() {
		try{
			for(User user: users){
				super.model.addRow(new Object[]{user.getStatus().getAccount_status(),user.getBrazilLaptop(), user.getName(),
				user.getContact().getEmail(), user.getContact().getMobile(), user.getContact().getHome_phone(),
				user.getContact().getSecondary_phone(), user.getContact().getNotes()});					
				if(user.getStatus().getAccount_status() == 0){
					this.table.getColumnModel().getColumn(3).setCellRenderer(new Conditions().Get(0));
					this.table.getColumnModel().getColumn(4).setCellRenderer(new Conditions().Get(0));
					this.table.getColumnModel().getColumn(5).setCellRenderer(new Conditions().Get(0));
					this.table.getColumnModel().getColumn(6).setCellRenderer(new Conditions().Get(0));
					this.table.getColumnModel().getColumn(7).setCellRenderer(new Conditions().Get(0));
				}
			}
			System.out.println("ContactDataTable loaded!");
		}catch(Exception e){
		System.out.println("Error loading the table ContactDataTable due to error: "+e.toString());
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

	public void tableChanged(TableModelEvent arg0) {
		switch(clicked_colunm){
			case 0: {super.changedAccountStatus_C0();break;}
			case 1: {super.changedLPNumber_C1();break;}
			case 2:	{super.changedName_C2();break;}			
			case 3: {this.changedEmail_C3();break;}
			case 4: {this.changedMobile_C4();break;}
			case 5: {this.changedHome_C5();break;}
			case 6: {this.changedSec_C6();break;}
			case 7: {this.changedNotesC7();break;}
			
		}
		
	}	
	
	private void changedEmail_C3(){
		try{
			String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
			if(selected_user.getContact().getEmail() != str){
				Manager manager = new Manager(clicked_row +1);
				manager.contact.setEmail(str);
				manager.change();
				Do.clearScreen();
			}
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Error persist data: "+e.toString());
			Do.clearScreen();
		}
	}
	
	private void changedMobile_C4(){		
		try{
			String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
			if(selected_user.getContact().getMobile() != str && str.matches("^[\\d ( ) \\- //+]+$")){
				Manager manager = new Manager(clicked_row +1);
				manager.contact.setMobile(str);
				manager.change();
				Do.clearScreen();
				
			}else{
				throw new NullPointerException();
			}
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Invalid character, use numbers or these here: '(' '-' ')' '+' '/'");
			Do.clearScreen();
		}
	}
	
	private void changedHome_C5(){
		try{
			String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
			if(selected_user.getContact().getHome_phone() != str && str.matches("^[\\d ( ) \\- //+]+$")){
				Manager manager = new Manager(clicked_row +1);
				manager.contact.setHome_phone(str);
				manager.change();
				Do.clearScreen();
			}else{
				throw new NullPointerException();
			}
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Invalid character, use numbers or these here: '(' '-' ')' '+' '/'");
			Do.clearScreen();
		}
	}
	
	private void changedSec_C6(){
		try{
			String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
			if(selected_user.getContact().getSecondary_phone() != str && str.matches("^[\\d ( ) \\- //+]+$")){
				Manager manager = new Manager(clicked_row +1);
				manager.contact.setSecondary_phone(str);
				manager.change();
				Do.clearScreen();
			}else{
				throw new NullPointerException();
			}
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Invalid character, use numbers or these here: '(' '-' ')' '+' '/'");
			Do.clearScreen();
		}
	}
	
	private void changedNotesC7(){
		try{
			String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
			if(selected_user.getContact().getNotes() != str){
				Manager manager = new Manager(clicked_row +1);
				manager.contact.setNotes(str);
				manager.change();
				Do.clearScreen();
			}
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Error persist data: "+e.toString());
			Do.clearScreen();
		}
	}
}
package pkg.table;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;

import pkg.components.Reasons;
import pkg.components.Window;
import pkg.connection.Manager;
import pkg.entity.User;
import pkg.main.Do;

public class LocaleDataTable extends ATC{
	private final static String[] head = {"Account Status","BrazilLaptop#", "Client Name","State","City", "Neighborhood" ,"Address", "Zip Code", "Notes"};
	
	public LocaleDataTable(){
		super(head,4);
		super.model.addTableModelListener(this);
	}

	@Override
	public void load() {
		try{
			for(User user: users){
				super.model.addRow(new Object[]{user.getStatus().getAccount_status(),user.getBrazilLaptop(),user.getName(),user.getLocale().getState(),
						user.getLocale().getCity(), user.getLocale().getNeighborhood(), user.getLocale().getAddress(),
						user.getLocale().getZipcode(), user.getLocale().getNotes()});				
				if(user.getStatus().getAccount_status() == 0){
					super.table.getColumnModel().getColumn(3).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(4).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(5).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(6).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(7).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(8).setCellRenderer(new Conditions().Get(0));
				}
			}
			System.out.println("LocaleDataTable loaded!");
		}catch(Exception e){
			System.out.println("Error loading the table LocaleDataTable due to error: "+e.toString());
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
			case 3:	{this.state_C3();break;}
			case 4:	{this.city_C4();break;}
			case 5:	{this.neighborhood_C5();break;}
			case 6:	{this.address_C6();break;}
			case 7:	{this.zipcode_C7();break;}
			case 8:	{this.notesLocal_C8();break;}
		}
		
	}
	
	private void state_C3(){
		try{
		    String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
		    if(selected_user.getLocale().getState() != str){
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.locale.setState(str);
		    	manager.change();
		    	Do.clearScreen();
		    }
		}catch(Exception e){			
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	
	private void city_C4(){
		try{
		    String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
		    if(selected_user.getLocale().getCity() != str){
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.locale.setCity(str);
		    	manager.change();
		    	Do.clearScreen();
		    }
		}catch(Exception e){ 			
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	
	private void neighborhood_C5(){
		try{
		    String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
		    if(selected_user.getLocale().getNeighborhood() != str){
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.locale.setNeighborhood(str);
		    	manager.change();
		    	Do.clearScreen();
		    }
		}catch(Exception e){			
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	
	private void address_C6(){
		try{
		    String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
		    if(selected_user.getLocale().getAddress() != str){
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.locale.setAddress(str);
		    	manager.change();
		    	Do.clearScreen();
		    }
		}catch(Exception e){   			
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	
	private void zipcode_C7(){
		try{
		    String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
		    if(selected_user.getLocale().getZipcode() != str && str.matches("^\\d{5}-\\d{3}$")){
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.locale.setZipcode(str);
		    	manager.change();
		    	Do.clearScreen();
		    }else{
		    	throw new NullPointerException();
		    }
		}catch(Exception e){ 			
		    JOptionPane.showMessageDialog(null,"Enter the zip code in this standard: #####-###");
		    Do.clearScreen();
		}
	}
	
	
	private void notesLocal_C8(){
		try{
		    String str = this.model.getValueAt(clicked_row, clicked_colunm).toString();
		    if(selected_user.getLocale().getNotes() != str){
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.locale.setNotes(str);
		    	manager.change();
		    	Do.clearScreen();
		    }
		}catch(Exception e){ 			
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}

}

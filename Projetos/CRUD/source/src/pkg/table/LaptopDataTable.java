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
public class LaptopDataTable extends ATC{
	private final static String[] head = {"Account Status","BrazilLaptop#", "Client Name" ,"FB Page","FB Login","FB PW" ,"Shipment Status", "Initial Date", "Final Date", "Laptop Shipped", "Laptop Received","Team Wiewer ID", "Team Wiewer PW","Notes"};
	
	public LaptopDataTable(){
		super(head,3);
		super.model.addTableModelListener(this);
		
	}

	@Override
	public void load() {
		try{	
			for(User user: users){
				Date initial_date = user.getLaptop().getInitial_date();
				Date final_date = user.getLaptop().getFinal_date();
				Date laptop_shipped = user.getLaptop().getLaptop_shipped();
				Date laptop_received = user.getLaptop().getLaptop_received();
				super.model.addRow(new Object[]{user.getStatus().getAccount_status(),user.getBrazilLaptop(), user.getName(), user.getLaptop().getFacebook_page(), 
						user.getLaptop().getFacebook_login(), user.getLaptop().getFacebook_password(), user.getStatus().getShipment_status(),
								//Configurações especiais para datas!
						(initial_date == null)?"":super.dataChange(initial_date),
						(final_date == null)?"":super.dataChange(final_date),
						(laptop_shipped == null)?"":super.dataChange(laptop_shipped), 
						(laptop_received == null)?"":super.dataChange(laptop_received),
									//Fim Data
						user.getLaptop().getTeam_view_id(), user.getLaptop().getTeam_view_pw(),
						user.getLaptop().getNotes()});				
				super.table.getColumnModel().getColumn(6).setCellRenderer(new Conditions().Get(5));
				super.table.getColumnModel().getColumn(6).setCellEditor(new Conditions().GetEditor(1));
				if(user.getStatus().getAccount_status() == 0){
					super.table.getColumnModel().getColumn(3).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(4).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(5).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(6).setCellRenderer(new Conditions().Get(5));
					super.table.getColumnModel().getColumn(6).setCellEditor(new Conditions().GetEditor(1));
					super.table.getColumnModel().getColumn(7).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(8).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(9).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(10).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(11).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(12).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(13).setCellRenderer(new Conditions().Get(0));
				}
			}
			
			System.out.println("LaptopDataTable loaded!");
		}catch(Exception e){
			System.out.println("Error loading the table LaptopDataTable due to error: "+e.toString());
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
			case 0:  {super.changedAccountStatus_C0();break;}
			case 1:  {super.changedLPNumber_C1();break;}
			case 2:	 {super.changedName_C2();break;}	
			case 3:  {this.fbPage_C3();break;}
			case 4:  {this.fblogin_C4();break;}
			case 5:  {this.fbpw_C5();break;}
			case 6:  {this.shipment_Status_C6();break;}
			case 7:  {this.initial_date_C7();break;}
			case 8:  {this.final_date_C8();break;}
			case 9:  {this.laptop_shipped_C9();break;}
			case 10:  {this.laptop_received_C10();break;}
			case 11: {this.team_view_id_C11();break;}
			case 12: {this.team_view_pw_C12();break;}
			case 13: {this.lp_notes_C13();break;}
		}
		
	}	
	
	private void fbPage_C3(){
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{			
			String str = object.toString();
		    if(selected_user.getLaptop().getFacebook_page() != str){		    	
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.laptop.setFacebook_page(str);
		    	manager.change();
		    	Do.clearScreen();
		    }	
		}catch(Exception e){		   
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	private void fblogin_C4(){
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{
			String str = object.toString();
		    if(selected_user.getLaptop().getFacebook_login() != str){		    	
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.laptop.setFacebook_login(str);
		    	manager.change();
		    	Do.clearScreen();
		    }	
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	private void fbpw_C5(){
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{
			String str = object.toString();
		    if(selected_user.getLaptop().getFacebook_password()  != str){		    	
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.laptop.setFacebook_password(str);
		    	manager.change();
		    	Do.clearScreen();
		    }	
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	private void shipment_Status_C6(){
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{    
		    Integer status = new Integer(object.toString());
		    if(!selected_user.getStatus().getShipment_status().equals(status) && (status > -1 && status <= 3 )){    
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.status.setShipment_status(status);
		    	manager.change();
		    	Do.clearScreen();
		    }else{
		        throw new NullPointerException();
		    }
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"Invalid status!");
		    Do.clearScreen();
		}
	}
	
	private void initial_date_C7(){
		Date date = null;
		try{
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");			
			date = format.parse(this.model.getValueAt(clicked_row, clicked_colunm).toString());			
			if(!date.equals(selected_user.getLaptop().getInitial_date()) && (!date.equals(null))){
				Manager manager = new Manager(clicked_row + 1);
				manager.laptop.setInitial_date(date);
				manager.change();				
			}
			Do.clearScreen();
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Data is not valid!");
			Do.clearScreen();
		}
	}
	
	private void final_date_C8(){
		Date date = null;
		try{
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");			
			date = format.parse(this.model.getValueAt(clicked_row, clicked_colunm).toString());			
			if(!date.equals(selected_user.getLaptop().getFinal_date()) && (!date.equals(null))){
				Manager manager = new Manager(clicked_row + 1);
				manager.laptop.setFinal_date(date);
				manager.change();				
			}
			Do.clearScreen();
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Data is not valid!");
			Do.clearScreen();
		}
	}
	
	private void laptop_shipped_C9(){
		Date date = null;
		try{
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");			
			date = format.parse(this.model.getValueAt(clicked_row, clicked_colunm).toString());			
			if(!date.equals(selected_user.getLaptop().getLaptop_shipped()) && (!date.equals(null))){
				Manager manager = new Manager(clicked_row + 1);
				manager.laptop.setLaptop_shipped(date);
				manager.change();				
			}
			Do.clearScreen();
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Data is not valid!");
			Do.clearScreen();
		}
	}
	
	private void laptop_received_C10(){
		Date date = null;
		try{
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");			
			date = format.parse(this.model.getValueAt(clicked_row, clicked_colunm).toString());			
			if(!date.equals(selected_user.getLaptop().getLaptop_received()) && (!date.equals(null))){
				Manager manager = new Manager(clicked_row + 1);
				manager.laptop.setLaptop_received(date);
				manager.change();				
			}
			Do.clearScreen();
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Data is not valid!");
			Do.clearScreen();
		}
	}
	
	private void team_view_id_C11(){
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{    
		    String str = object.toString();
		    if(selected_user.getLaptop().getTeam_view_id() != str){    
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.laptop.setTeam_view_id(str);
		    	manager.change();
		    	Do.clearScreen();
		    }else{
		        throw new NullPointerException();
		    }
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	private void team_view_pw_C12(){
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{    
		    String str = object.toString();
		    if (selected_user.getLaptop().getTeam_view_pw() != str){   
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.laptop.setTeam_view_pw(str);
		    	manager.change();
		    	Do.clearScreen();
		    }else{
		        throw new NullPointerException();
		    }
		}catch(Exception e){		   
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	private void lp_notes_C13(){
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{    
		    String str = object.toString();
		    if(selected_user.getLaptop().getNotes() != str){    
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.laptop.setNotes(str);
		    	manager.change();
		    	Do.clearScreen();
		    }else{
		    	throw new NullPointerException();
		    }
		}catch(Exception e){		   
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}	

}

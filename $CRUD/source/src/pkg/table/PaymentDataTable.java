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

public class PaymentDataTable extends ATC{	
	private final static String[] head = {"Account Status","BrazilLaptop#","Client Name","Withdraw Cost","Reference Bonus Status","Referred By","Contract Payment","Payment Date","Payment Status","Notes"};
	
	public PaymentDataTable(){
		super(head,5);
		super.model.addTableModelListener(this);
	}

	@Override
	public void load() {
		try{
			for(User user: users){
				Date paymentDate = user.getPayment().getPayment_date();
				super.model.addRow(new Object[]{user.getStatus().getAccount_status(),user.getBrazilLaptop(),user.getName(),
						user.getPayment().getWithdraw_cost(),user.getStatus().getReference_bonus_status(), 
						user.getPayment().getReferredby(),user.getPayment().getContractPayment(),
						(paymentDate == null)?"":super.dataChange(paymentDate),
						user.getStatus().getPayment_status(),user.getPayment().getNotes()});				
				super.table.getColumnModel().getColumn(4).setCellRenderer(new Conditions().Get(6));
				super.table.getColumnModel().getColumn(4).setCellEditor(new Conditions().GetEditor(2));
				super.table.getColumnModel().getColumn(8).setCellRenderer(new Conditions().Get(7));
				super.table.getColumnModel().getColumn(8).setCellEditor(new Conditions().GetEditor(3));
				if(user.getStatus().getAccount_status() == 0){
					super.table.getColumnModel().getColumn(3).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(4).setCellRenderer(new Conditions().Get(6));
					super.table.getColumnModel().getColumn(4).setCellEditor(new Conditions().GetEditor(2));
					super.table.getColumnModel().getColumn(5).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(6).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(7).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(8).setCellRenderer(new Conditions().Get(0));
					super.table.getColumnModel().getColumn(9).setCellRenderer(new Conditions().Get(0));										
				}
			}
			System.out.println("PaymentDataTable loaded!");
		}catch(Exception e){
			System.out.println("Error loading the table PaymentDataTable due to error: "+e.toString());
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
			case 3:	 {this.withdraw_cost_C3();break;}			
			case 4:  {this.reference_bonus_status_C4();break;}
			case 5:  {this.referred_by_C5();break;}
			case 6:  {this.contract_payment_C6();break;}
			case 7:  {this.payment_date_C7();break;}			
			case 8: {this.payment_status_C8();break;}
			case 9: {this.payment_notes_C9();break;}			
		}		
	}
	
	private void withdraw_cost_C3(){		
		try{    
			Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		    	Double db = new Double(object.toString());
		    if(selected_user.getPayment().getWithdraw_cost() != db){    
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.payment.setWithdraw_cost(db);
		    	manager.change();
		    	Do.clearScreen();
		    }
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"That is not a number, please enter a valid number.");
		    Do.clearScreen();
		}
	}
	
	
	
	private void reference_bonus_status_C4(){		
		try{ 
			Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		    Integer status = new Integer(object.toString());
		    if(!selected_user.getStatus().getReference_bonus_status().equals(status)){    
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.status.setReference_bonus_status(status);
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
	
	private void referred_by_C5(){		
		try{ 
			Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		    String str = object.toString();
		    if(selected_user.getPayment().getReferredby() != str){    
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.payment.setReferredby(str);
		    	manager.change();
		    	Do.clearScreen();		    
		    }
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}
	
	private void contract_payment_C6(){		
		try{
			Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		    Double db = new Double(object.toString());
		    if(selected_user.getPayment().getContractPayment() != db){   
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.payment.setContractPayment(db);
		    	manager.change();
		    	Do.clearScreen();
		    }		    
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"That is not a number, please enter a valid number.");
		    Do.clearScreen();
		}
	}
	
	private void payment_date_C7(){
		Date date = null;
		try{
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");			
			date = format.parse(this.model.getValueAt(clicked_row, clicked_colunm).toString());			
			if(!date.equals(selected_user.getPayment().getPayment_date()) && (!date.equals(null))){
				Manager manager = new Manager(clicked_row + 1);
				manager.payment.setPayment_date(date);
				manager.change();
				Do.clearScreen();
			}
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, "Data is not valid!");
			Do.clearScreen();
		}
	}
	
	
	
	private void payment_status_C8(){ //Problemas aqui.
		Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		try{    
		    Boolean status = new Boolean(object.toString());
		    if(!selected_user.getStatus().getPayment_status().equals(status)){    
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.status.setPayment_status(status);
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
	
	private void payment_notes_C9(){		
		try{
			Object object = this.model.getValueAt(clicked_row, clicked_colunm);
		    String str = object.toString();
		    if(selected_user.getPayment().getNotes() != str){   
		    	Manager manager = new Manager(clicked_row +1);
		    	manager.payment.setNotes(str);
		    	manager.change();
		    	Do.clearScreen();
		    }
		}catch(Exception e){		    
		    JOptionPane.showMessageDialog(null,"Error persist data: "+e.toString());
		    Do.clearScreen();
		}
	}

}
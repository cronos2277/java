package pkg.table;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import pkg.connection.Manager;
import pkg.entity.User;
import pkg.main.Do;
public class Conditions{	
	
	public static User  Conditions_user;
	public TableCellRenderer Get(int num){
		switch(num){			
			case 0: return new BlockedValue();
			case 1: return new AccountStatusRenderer(new String[]{"ENDED","FLAGGED","AWAY","ONLINE"});
			case 2: return new LaptopStatus();
			case 3: return new PaymentStatus();
			case 4: return new Birthday();
			case 5: return new ShipmentStatusRenderer(new String[]{"UKNOWN","FLAGGED","ARRIVED","ONLINE"});
			case 6: return new ReferenceStatusRenderer(new String[]{"NONE","UNPAID","PAID"});
			case 7: return new PaymentStatusRenderer(new String[]{"UNPAID","PAID"});
			default: return null;
		}
	}
	
	public DefaultCellEditor GetEditor(int num){
		switch(num){
			case 0:return new AccountStatusEditor(new String[]{"FLAGGED","AWAY","ONLINE"});	//Criando uma combobox para valores editáveis de Account Status.
			case 1: return new ShipmentStatusEditor(new String[]{"FLAGGED","ARRIVED","ONLINE"});
			case 2: return new ReferenceStatusEditor(new String[]{"NONE","UNPAID","PAID"});
			case 3: return new PaymentStatusEditor(new String[]{"UNPAID","PAID"});
			default: return null;
		}
	}	
	
	private class LaptopStatus extends DefaultTableCellRenderer{
		private static final long serialVersionUID = 1L;
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {		
			
		  Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);		 
		  JLabel label = (JLabel) comp;				
		  switch(ATC.getShipmentStatus(row)){
		    case 0: {comp.setBackground(Color.GRAY);break;}
		    case 1: {comp.setBackground(new Color(255,91,91));break;}
		    case 2: {comp.setBackground(new Color(255,229,109));break;}
		    case 3: {comp.setBackground(new Color (220,220,220));break;}
		    case 4: {comp.setBackground(Color.RED);label.setText("INVALID S.S");break;}
		}
		  label.setHorizontalAlignment(SwingConstants.CENTER);
		    return label;		  
		 }
	}
	
	
	private class PaymentStatus extends DefaultTableCellRenderer{
		private static final long serialVersionUID = 1L;
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {					
		  Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);		  
		  JLabel label = (JLabel) comp;				
		  switch(ATC.checkPays_ToPayment_Date_Status(row)){
		    case 0: {comp.setBackground(Color.GRAY);break;}
		    case 1: {comp.setBackground(new Color(255,91,91));break;} //vermelho
		    case 2: {comp.setBackground(new Color(255,229,109));break;} //amarelo
		    case 3: {comp.setBackground(new Color (220,220,220));break;}
		    case 4: {comp.setBackground(Color.RED);label.setText("INVALID PAYMENT DATE!");break;}
		}
		  label.setHorizontalAlignment(SwingConstants.CENTER);
		    return label;		  
		 }
	}
	
	private class BlockedValue extends DefaultTableCellRenderer{	
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column){        
			Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  			
			if(ATC.users.get(row).getStatus().getAccount_status() == 0){
				comp.setBackground(Color.GRAY);        
				JLabel text = (JLabel) comp;
				return text;
			}else{
				comp.setBackground(Color.WHITE);						
				return comp;
			}
		}
	}
	
	private class Birthday extends DefaultTableCellRenderer{		
		private static final long serialVersionUID = 1L;
		
		
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column){        
			Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);        
			
			if(ATC.users.get(row).getStatus().getAccount_status() != 0 && ATC.users.get(row).getClient().getDob() == null){
				comp.setBackground(Color.RED);
				JLabel text = (JLabel) comp;
				text.setText("INVALIDE DOB");
				text.setHorizontalAlignment(SwingConstants.CENTER);
				return text;				
			}else if(ATC.users.get(row).getStatus().getAccount_status() == 0 && ATC.users.get(row).getClient().getDob() != null){
				comp.setBackground(Color.GRAY);		
				JLabel text = (JLabel) comp;
				text.setHorizontalAlignment(SwingConstants.CENTER);
				return text;
			}else if(ATC.users.get(row).getStatus().getAccount_status() != 0 && ATC.users.get(row).getClient().getDob() != null){					
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(ATC.users.get(row).getClient().getDob());				
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(new Date());
				
				if(cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)){
					comp.setBackground(new Color(135,206,250));        
					JLabel text = (JLabel) comp;
					text.setHorizontalAlignment(SwingConstants.CENTER);
					return text;
				}else{
					comp.setBackground(Color.WHITE);
					JLabel text = (JLabel) comp;
					text.setHorizontalAlignment(SwingConstants.CENTER);
					return text;
				}
			}
			return comp;			
		}
	}
	
 
	private class AccountStatusRenderer extends JComboBox<String> implements TableCellRenderer{		
		private static final long serialVersionUID = 1L;
		public AccountStatusRenderer(final String[] items){
			super(items);			
		}		
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {	 		
			
		    
		    
		       if (isSelected) {		    	   
		    	      super.setForeground(table.getSelectionForeground());
		    	      super.setBackground(table.getSelectionBackground());
		    	    } else {
		    	     super.setForeground(table.getForeground());
		    	      super.setBackground(table.getBackground());
		    	    }    
		       		
		       		User user = ATC.users.get(row);
		       		try{
		       			super.setSelectedIndex(user.getStatus().getAccount_status());
		       		}catch(Exception e){
		       			super.setSelectedIndex(0);
		       			new Manager(row + 1).status.setAccount_status(0);
		       		}
		       		
		    	    if(super.getSelectedIndex() == 0){
		    	    	super.setEditable(false);
		    	    	super.setBackground(Color.GRAY);
		    	    }else if(super.getSelectedIndex() == 1){
		    	    	super.setBackground(new Color(255,91,91));
		    	    }else if(super.getSelectedIndex() == 2){
		    	    	super.setBackground(new Color(255,229,109));
		    	    }else if(super.getSelectedIndex() == 3){
		    	    	super.setBackground(new Color (220,220,220));
		    	    }else{
		    	    	super.setBackground(Color.RED);
		    	    }	    	      
		    	    
		    	    return this;
		       }		
	}	
			
	static	class AccountStatusEditor extends DefaultCellEditor{		
		public static final long serialVersionUID = 1L;				
		private static JComboBox<String> combo;
		private static int line;
		public AccountStatusEditor(String[] items) {	    
			super(makeCombo(items));			
		  }		
		
		@Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			line = row;
			User user = ATC.users.get(line);
			try{				
				combo.setSelectedIndex(user.getStatus().getAccount_status() - 1);        		
				return combo;
			}catch(Exception e){
				user.getStatus().setAccount_status(0);
				combo.setSelectedIndex(0);				
				Do.notifyTechnicalError(e);
				return null;
			}
		}
		
		@Override
	    public boolean stopCellEditing() {
			Manager manager = new Manager(line + 1);
			manager.status.setAccount_status(combo.getSelectedIndex() + 1);
			manager.change();			
			return super.stopCellEditing();
		}
		
		@Override
		public Object getCellEditorValue() {
			Do.clearScreen();
			return this;
		}
		
		@Override
		public void cancelCellEditing(){
			super.cancelCellEditing();
		}
		
		
		private static JComboBox<String> makeCombo(String[] items){
			combo = new JComboBox<String>(items);			
			return combo;
		}	
		
	}
	
	 
	private class ShipmentStatusRenderer extends JComboBox<String> implements TableCellRenderer{		
		private static final long serialVersionUID = 1L;
		public ShipmentStatusRenderer(String[] args){
			super(args);
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			if (isSelected) {		    	   
	    	      super.setForeground(table.getSelectionForeground());
	    	      super.setBackground(table.getSelectionBackground());
	    	    } else {
	    	     super.setForeground(table.getForeground());
	    	      super.setBackground(table.getBackground());
	    	    }   
					User user = ATC.users.get(row);
	       		try{	       			
	       			super.setSelectedIndex(user.getStatus().getShipment_status());
	       		}catch(Exception e){
	       			super.setSelectedIndex(0);
	       			new Manager(row + 1).status.setShipment_status(0);
	       		}
	       	if(user.getStatus().getAccount_status() == 0){
	       		super.setEditable(false);
	       		super.setBackground(Color.GRAY);
	       		return this;
	       	}
	       		
	    	    if(super.getSelectedIndex() == 0){
	    	    	super.setEditable(false);
	    	    	super.setBackground(Color.GRAY);
	    	    }else if(super.getSelectedIndex() == 1){
	    	    	super.setBackground(new Color(255,91,91));
	    	    }else if(super.getSelectedIndex() == 2){
	    	    	super.setBackground(new Color(255,229,109));
	    	    }else if(super.getSelectedIndex() == 3){
	    	    	super.setBackground(new Color (220,220,220));
	    	    }else{
	    	    	super.setBackground(Color.RED);
	    	    }   
	    	    
	    	    return this;       		
		}
		
	}
	
	static class ShipmentStatusEditor extends DefaultCellEditor{		
		private static final long serialVersionUID = 1L;
		private static JComboBox<String> combo;
		private static Integer line;
		public ShipmentStatusEditor(String[] args) {			
			super(makeCombo(args));			
		}		
		
		private static JComboBox<String> makeCombo(String[] items){
			combo = new JComboBox<String>(items);			
			return combo;
		}
		
		
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			line = row;
			User user = ATC.users.get(line);
			try{
				combo.setSelectedIndex(user.getStatus().getShipment_status() -1);
				return combo;
			}catch(Exception e){				
				combo.setSelectedIndex(0);
				user.getStatus().setShipment_status(0);
				Do.logginError(e);
				return null;
			}
		}
		
		@Override
	    public boolean stopCellEditing() {
			Manager manager = new Manager(line + 1);
			manager.status.setShipment_status(combo.getSelectedIndex() +1);
			manager.change();
			return super.stopCellEditing();
		}
		
		@Override
		public Object getCellEditorValue() {
			Do.clearScreen();
			return this;
		}
		
		@Override
		public void cancelCellEditing(){
			super.cancelCellEditing();
		}		
		
	}
	
	private class ReferenceStatusRenderer extends JComboBox<String> implements TableCellRenderer{		
		private static final long serialVersionUID = 1L;

		public ReferenceStatusRenderer(final String[] args){
			super(args);
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {		    	   
	    	      super.setForeground(table.getSelectionForeground());
	    	      super.setBackground(table.getSelectionBackground());
	    	    } else {
	    	     super.setForeground(table.getForeground());
	    	      super.setBackground(table.getBackground());
	    	    }   
					User user = ATC.users.get(row);
	       		try{
	       			super.setSelectedIndex(user.getStatus().getReference_bonus_status());
	       		}catch(Exception e){
	       			super.setSelectedIndex(0);
	       		}
	       		
	       	 if(super.getSelectedIndex() == 0){	    	    	
	    	    	super.setBackground(Color.WHITE);
	    	    }else if(super.getSelectedIndex() == 1){
	    	    	super.setBackground(new Color(255,91,91));
	    	    }else if(super.getSelectedIndex() == 2){
	    	    	super.setBackground(new Color(124,205,124));	    	    
	    	    }else{
	    	    	super.setBackground(Color.WHITE);
	    	    }
	       	return this;       	 
		}
			
	}
	
	static class ReferenceStatusEditor extends DefaultCellEditor{
		private static final long serialVersionUID = 1L;
		private static JComboBox<String> combo;
		private static Integer line;
		public ReferenceStatusEditor(String[] items) {
			super(makeCombo(items));			
		}		
		
		private static JComboBox<String> makeCombo(String[] items){
			combo = new JComboBox<String>(items);			
			return combo;
		}	
		
		@Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			line = row;
			User user = ATC.users.get(line);
			try{				
				combo.setSelectedIndex(user.getStatus().getReference_bonus_status());
				return combo;
			}catch(Exception e){				
				combo.setSelectedIndex(0);
				user.getStatus().setShipment_status(0);
				Do.logginError(e);
				return null;
			}
			
		}
		
		@Override
	    public boolean stopCellEditing() {
			Manager manager = new Manager(line + 1);
			manager.status.setReference_bonus_status(combo.getSelectedIndex());
			manager.change();
			return super.stopCellEditing();
		}
		
		@Override
		public Object getCellEditorValue() {
			Do.clearScreen();
			return this;
		}
		
		@Override
		public void cancelCellEditing(){
			super.cancelCellEditing();
		}		
			
	}
	
	private class PaymentStatusRenderer extends JComboBox<String> implements TableCellRenderer{		
		private static final long serialVersionUID = 1L;
		public PaymentStatusRenderer(String[] args){
			super(args);
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			if (isSelected) {		    	   
	    	      super.setForeground(table.getSelectionForeground());
	    	      super.setBackground(table.getSelectionBackground());
	    	    } else {
	    	     super.setForeground(table.getForeground());
	    	      super.setBackground(table.getBackground());
	    	    } 
			
			User user = ATC.users.get(row);
			try{
				super.setSelectedIndex((user.getStatus().getPayment_status())?1:0);
			}catch(Exception e){
				super.setSelectedIndex(0);
			}
			
			if(super.getSelectedIndex() == 1){
				super.setBackground(Color.CYAN);
			}else{
				super.setBackground(new Color(255,91,91));
			}			
			
			return this;
		}	
		
	}
	
	static	class PaymentStatusEditor extends DefaultCellEditor implements ItemListener{		
		private static final long serialVersionUID = 1L;
		private static JComboBox<String> combo;
		private static Integer line;
		public PaymentStatusEditor(String[] items) {
			super(makeCombo(items));
			
		}
		
		private static JComboBox<String> makeCombo(String[] items){
			combo = new JComboBox<String>(items);			
			return combo;
		}
		
		@Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			line = row;
			User user = ATC.users.get(line);
			try{				
				combo.setSelectedIndex((user.getStatus().getPayment_status())?1:0);
				return combo;
			}catch(Exception e){
				combo.setSelectedIndex(0);
				user.getStatus().setShipment_status(0);
				Do.logginError(e);
				return null;
			}
			
		}
		
		private void paymentDataChange(User user, boolean bool) {
			try{
				if(bool){
				Calendar payed = Calendar.getInstance();
				Calendar now = Calendar.getInstance();
				payed.setTime(user.getPayment().getPayment_date());
				now.setTime(new Date());
				if(now.get(Calendar.DATE) - payed.get(Calendar.DATE) < 30){			
					Manager manager = new Manager(line + 1);
					if(user.getPayment().getPayment_date() != null){
						int opt = JOptionPane.showConfirmDialog(null, "You would like the program to adjust the payment date for next month?","Date of payment", JOptionPane.YES_NO_OPTION);
						if(opt == 0){
							Calendar cal = Calendar.getInstance();
							cal.setTime(user.getPayment().getPayment_date());
							cal.add(Calendar.MONTH, 1);
							manager.payment.setPayment_date(cal.getTime());
							manager.status.setPayment_status(false);
							manager.change();
							JOptionPane.showMessageDialog(null, "Payment date changed successfully");
						}else{
							JOptionPane.showMessageDialog(null, "The date has not been changed, but you can change the payment date after");
						}
					}else{
						JOptionPane.showMessageDialog(null, "The payment date is null, set a date of payment manually.");
					}
				}
			}
			}catch(Exception e){
				combo.setSelectedIndex(0);
				Manager manager = new Manager(line + 1);
				manager.status.setPayment_status(false);
				manager.change();
				JOptionPane.showMessageDialog(null,"This date is null, you must set a valid payment date");
				super.cancelCellEditing();
			}	
		}
		
		@Override
	    public boolean stopCellEditing() {
			Manager manager = new Manager(line + 1);
			manager.status.setPayment_status((combo.getSelectedIndex() == 1)?true:false);
			manager.change();			
			return super.stopCellEditing();
		}
		
		@Override
		public Object getCellEditorValue() {
			this.paymentDataChange(ATC.users.get(line),(!ATC.users.get(line).getStatus().getPayment_status()));
			Do.clearScreen();
			return this;
		}
		
		@Override
		public void cancelCellEditing(){
			super.cancelCellEditing();
		}

		public void itemStateChanged(ItemEvent e) {
			int teste = ATC.users.get(line).getStatus().getPayment_status()?1:0;
			if(teste == combo.getSelectedIndex()){
				super.cancelCellEditing();
			}
			
		}		
		
		
	}

}
	
	
	
	



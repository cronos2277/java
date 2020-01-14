package pkg.components;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class OrderByMenu{
	public static OrderByMenu menu;
	public JMenu order;
	private JMenuItem created;
	private JMenuItem alphabeticalMoreOrder;
	private JMenuItem alphabeticalLessOrder;
	private JMenuItem laptopMoreOrder;
	private JMenuItem laptopLessOrder;
	private JMenuItem byPaymentDate;	
	private JMenuItem byAccountHolder;	
	private JMenuItem byDob;
	public static Integer value = 0;	
	private OrderByMenu(){
		try{			
			order = new JMenu("Order by");		
			order.add(this.byCreatedBy());
			order.add(this.byAlphabeticalOrderName());
			order.add(this.byInverseAlphabeticalOrderName());
			order.add(this.byLaptopNumberOrder());
			order.add(this.byInverseLaptopNumberOrder());
			order.add(this.byPaymentOrder());
			order.add(this.byAccountHolder());
			order.add(this.funcByDob());
			System.out.println("OrderBy loaded successfully!");
		}catch(Exception e){
			System.out.println("Error loading orderBy menus, due to the error: "+e.toString());
		}
	}
	
	private JMenuItem byCreatedBy(){
		this.created = new JMenuItem("Order Of Creation (Default)");
		this.created.addActionListener(new Action());
		
		return this.created;
	}
	
	private JMenuItem byAlphabeticalOrderName(){
		this.alphabeticalMoreOrder = new JMenuItem("Ascending Alphabetical Order");
		this.alphabeticalMoreOrder.addActionListener(new Action());		
		return this.alphabeticalMoreOrder;
	}
	
	private JMenuItem byInverseAlphabeticalOrderName(){
		this.alphabeticalLessOrder = new JMenuItem("Descending alphabetically");
		this.alphabeticalLessOrder.addActionListener(new Action());		
		return this.alphabeticalLessOrder;
	}
	
	
	private JMenuItem byLaptopNumberOrder(){
		this.laptopMoreOrder = new JMenuItem("Increasing Numeric Laptop Order");
		this.laptopMoreOrder.addActionListener(new Action());		
		return this.laptopMoreOrder;
	}
	
	private JMenuItem byInverseLaptopNumberOrder(){
		this.laptopLessOrder = new JMenuItem("Decreasing Numeric Laptop Order");
		this.laptopLessOrder.addActionListener(new Action());		
		return this.laptopLessOrder;
	}
	
	private JMenuItem byPaymentOrder(){
		this.byPaymentDate = new JMenuItem("Payment Order");
		this.byPaymentDate.addActionListener(new Action());
		return this.byPaymentDate;
	}
	
	private JMenuItem byAccountHolder(){
		this.byAccountHolder = new JMenuItem("Account Holder");
		this.byAccountHolder.addActionListener(new Action());
		return this.byAccountHolder;
	}
	
	private JMenuItem funcByDob(){
		this.byDob = new JMenuItem("By DOB");
		this.byDob.addActionListener(new Action());
		return this.byDob;
	}
	
	private class Action implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == created && value != 0){				
				value = 0;
				new pkg.connection.Manager().refreshList();
			}else if(event.getSource() == alphabeticalMoreOrder && value != 1){				
				value = 1;
				new pkg.connection.Manager().refreshList();
			}else if(event.getSource() == alphabeticalLessOrder && value != 2){				
				value = 2;
				new pkg.connection.Manager().refreshList();
			}else if(event.getSource() == laptopMoreOrder && value != 3){				
				value = 3;
				new pkg.connection.Manager().refreshList();
			}else if(event.getSource() == laptopLessOrder && value != 4){				
				value = 4;
				new pkg.connection.Manager().refreshList();
			}else if(event.getSource() == byPaymentDate && value != 5){
				value = 5;
				new pkg.connection.Manager().refreshList();
			}else if(event.getSource() == byAccountHolder && value != 6){
				value = 6;
				new pkg.connection.Manager().refreshList();
			}else if(event.getSource() == byDob && value != 7){
				value = 7;
				new pkg.connection.Manager().refreshList();
			}
		}		
	}	
	
	static{
		menu = new OrderByMenu();
	}
	
}

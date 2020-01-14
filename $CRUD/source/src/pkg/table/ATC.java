package pkg.table;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import pkg.connection.Manager;
import pkg.entity.User;
import pkg.main.Do;
import pkg.main.Main;
public abstract class ATC extends MouseAdapter implements TableModelListener{	
	public static int clicked_row;
	public static int clicked_colunm;
	public static Long selected_id;	
	public static String selected_name;
	public static int user_in_list;
	public static User selected_user;
	public static Integer selected_tab;
	protected String[] rows;
	protected Object[][] coluns;
	protected DefaultTableModel model;
	protected JTable table;	
	protected static List<User> users;
	protected DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");	
	protected Object obj;	
	public ATC(String[] tmp, int param){
		try{
			System.out.println("Loading tables...");
			this.rows = tmp;			
			model = this.getLaptopTableModel();			
			table = new JTable(model);			
			this.defTable(param);
			this.run();			
			load();			
			System.out.println("Table loaded!");
		}catch(Exception e){
			System.out.println("Error loading table, due to the error: "+e.toString());
		}
	}		
	
	public static Integer checkPays_ToPayment_Date_Status(int key){
		Boolean check = users.get(key).getStatus().getPayment_status();
		Integer account = users.get(key).getStatus().getAccount_status();
		User user = users.get(key);
		Date registred = null;
		Date dates[] = new Date[6];
		if(user.getStatus().getAccount_status() == 0){
			return 0;
		}
		if(user.getPayment().getPayment_date() == null){
			return 4;
		}else{
			registred = user.getPayment().getPayment_date();
			dates = getSequenceDates(registred);
			System.out.println("date[0]: "+dates[0]+" now: "+dates[5]);
		}
		
		if(check && (account > 0)){
			return 3;
		}else if(!check && (account > 0)){
			if(registred.before(dates[5])){
				return 1;		
			}else if(dates[0].before(dates[5]) && !registred.before(dates[5])){
				return 2;
			}else if(dates[1].before(dates[5]) && !registred.before(dates[5])){				
				return 2;
			}else if(dates[2].before(dates[5]) && !registred.before(dates[5])){
				return 2;			
			}else if(dates[3].before(dates[5]) && !registred.before(dates[5])){
				return 2;
			}else if(dates[4].before(dates[5]) && !registred.before(dates[5])){
				return 2;
			}else{
				return 3;
			}			
		}else{
			
			return 0;
		}
	}
	
	public static Integer getShipmentStatus(int key){
		if( (users.get(key).getStatus().getAccount_status() == 0) && (users.get(key).getStatus().getShipment_status() == 0) ){
			return 0;
		}else if( (users.get(key).getStatus().getAccount_status() == 0) && (users.get(key).getStatus().getShipment_status() != 0) ){			
			return 0;
		}else if((users.get(key).getStatus().getAccount_status() != 0) && (users.get(key).getStatus().getShipment_status() == 0)){
			return 0;
		}else{
			switch(users.get(key).getStatus().getShipment_status()){
				case 1: return 1;
				case 2: return 2;
				case 3: return 3;			
				default: return 4;
			}
		}
	}
	
	protected void run(){
		Manager manager = new Manager(0);
		users = manager.getList();
		this.table.addMouseListener(this);
	}
	
	
	private void defTable(int param) {
		this.table = new JTable();		
		this.table.setModel(model);			
		this.table.setSelectionForeground(Color.BLUE);		
		this.table.getTableHeader().setReorderingAllowed(false);
		
		int size = (Main.dimension.width -10) / this.rows.length - 3;
		Double setStatusAndLaptopNumber_size = (Main.dimension.width -10) * 0.07;
		Double setName_size = (Main.dimension.width -10) * 0.10;
		
		this.table.getColumnModel().getColumn(0).setPreferredWidth(setStatusAndLaptopNumber_size.intValue());
		this.table.getColumnModel().getColumn(1).setPreferredWidth(setStatusAndLaptopNumber_size.intValue());
		this.table.getColumnModel().getColumn(2).setPreferredWidth(setName_size.intValue());
		
		this.table.getColumnModel().getColumn(0).setCellRenderer(new Conditions().Get(1));
		this.table.getColumnModel().getColumn(0).setCellEditor(new Conditions().GetEditor(0));
		this.table.getColumnModel().getColumn(1).setCellRenderer(new Conditions().Get(2));
		this.table.getColumnModel().getColumn(2).setCellRenderer(new Conditions().Get(3));		
		for(int i=3;i < this.rows.length;i++){			
			this.table.getColumnModel().getColumn(i).setPreferredWidth(size);			
		}
	}
	
	public JTable getTable() {
		return this.table;		
	}	
	
	
	protected void changedAccountStatus_C0(){
		//Pegar valor de um editor de valor. No caso esse valor capturado deixa de funcionar a cada atualização de tabela, a cada refresh ele deixa de funcionar.		
				
	}	
	
	
	protected void changedLPNumber_C1(){
		try{			
			int num = Integer.parseInt(this.model.getValueAt(clicked_row, clicked_colunm).toString());
			if(selected_user.getBrazilLaptop() != num){
				Manager manager = new Manager(clicked_row + 1);					
				manager.laptopNumber = num;
				manager.change();
				Do.clearScreen();
			}
		}catch(Exception e){				
			this.model.setValueAt(selected_user.getBrazilLaptop(), clicked_row, clicked_colunm);
			JOptionPane.showMessageDialog(null, "The reported value is not a valid number!");
			Do.clearScreen();
		}
	}
	
	protected void changedName_C2(){
		if(!selected_user.getName().equals(this.model.getValueAt(clicked_row, clicked_colunm))){
			Manager manager = new Manager(clicked_row + 1);
			try{
				Object obj = this.model.getValueAt(clicked_row, clicked_colunm);
				manager.name = obj.toString();
				manager.change();				
			}catch(Exception e){				
				this.model.setValueAt(selected_user.getName(), clicked_row, clicked_colunm);
				JOptionPane.showMessageDialog(null, "The name is invalid!");				
			}finally{
				Do.clearScreen();
			}
		}		
	}	
	
	protected String dataChange(Date date){		
			this.dateformat = new SimpleDateFormat("MM/dd/yyyy");
			return this.dateformat.format(date);	
	}
	
	private static Date[] getSequenceDates(Date date){
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		Calendar cal5 = Calendar.getInstance();
		Calendar nowc = Calendar.getInstance();
		Date[] dates = {date, date, date, date, date, new Date()};
		cal1.setTime(dates[0]);
		cal1.add(Calendar.DATE, -1);
		dates[0] = cal1.getTime();		
		cal2.setTime(dates[1]);
		cal2.add(Calendar.DATE, -2);
		dates[1] = cal2.getTime();
		cal3.setTime(dates[2]);
		cal3.add(Calendar.DATE, -3);
		dates[2] = cal3.getTime();
		cal4.setTime(dates[3]);
		cal4.add(Calendar.DATE, -4);
		dates[3] = cal4.getTime();
		cal5.setTime(dates[4]);
		cal5.add(Calendar.DATE, -5);
		dates[4] = cal5.getTime();
		nowc.setTime(dates[5]);
		dates[5] = nowc.getTime();		
		return dates;
	}	
	
	protected DefaultTableModel getLaptopTableModel(){		
		DefaultTableModel temp = new DefaultTableModel(this.coluns,this.rows){					
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				if(users.get(row).getStatus().getAccount_status() == 0){
					return false;
				}else{
					return true;
				}
			}
			
				};		
		return temp;
				
		}		
	
	
	public abstract void load();	
	public abstract void mouseClicked(MouseEvent ev);
		
	
	
}

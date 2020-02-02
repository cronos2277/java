package pkg.components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pkg.connection.Manager;
import pkg.entity.References;
import pkg.main.Do;
import pkg.main.Main;
import pkg.table.ATC;

public class Ref extends DefaultTableCellRenderer implements TableModelListener {	
	private static final long serialVersionUID = 1L;
	public static Ref instance;
	private JDialog frame = new JDialog(Window.window);	
	private String[] rows = {"Names","Notes"};
	private String[][] coluns;
	private DefaultTableModel model;
	private JTable table;
	private JButton add;
	private JButton remove;
	private Manager manager;
	private List <References> references;
	private References ref_info;
	private int ref_row;
	private int ref_colunm;
	private Long ref_id;
	private Ref(){
		try{			
			if(ATC.selected_user.equals(null) || ATC.clicked_row == -1) throw new NullPointerException();
			this.tableModelConf();
			this.defTable();
			this.run();
			this.model.addTableModelListener(this);
			this.table.getColumnModel().getColumn(0).setCellRenderer(this);
			this.table.getColumnModel().getColumn(1).setCellRenderer(this);
			System.out.println("References window loaded!");
		}catch(NullPointerException n){			
			JOptionPane.showMessageDialog(null, "You must select a contract!");
		}catch(Exception e){			
			System.out.println("Error loading the menu of references, due to the error:"+e.toString());
		}
	}	
	
	private void tableModelConf() {
		this.manager = new Manager(ATC.clicked_row + 1);
		this.references = this.manager.getREF();
		model =  this.getDTM();	
		for(References r: this.references){
			if(r.getUser().getId() == ATC.selected_id){
				model.addRow(new Object[]{r.getRef(),r.getNotes()});
			}
		}		
	}
	
	public JTable getTable() {
		return this.table;		
	}	
	
	private void defTable() {		
		this.table = new JTable();		
		this.table.setModel(model);
		this.table.addMouseListener(new Event());
		int size = (Main.dimension.width -10) / this.rows.length;
		
		for(int i=0;i < this.rows.length;i++){			
			this.table.getColumnModel().getColumn(i).setPreferredWidth(size);			
		}
	}
	
	private void run(){
		frame.setTitle(ATC.selected_name + " - References");		
		frame.setLayout(new BorderLayout());
		frame.add(BorderLayout.CENTER,new JScrollPane(this.table));
		frame.add(BorderLayout.SOUTH, this.buttons());
		frame.setLocationRelativeTo(null);
		frame.setSize(Main.dimension.width/2, Main.dimension.height/2);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setModal(true);
		frame.setDefaultCloseOperation(Do.CloseOperation());
	}
	
	private JPanel buttons(){
		JPanel panel = new JPanel();		
		this.add = new JButton("Add");		
		this.remove = new JButton("Remove");
		this.remove.addActionListener(new Event());
		this.add.addActionListener(new Event());
		panel.add(this.add);		
		panel.add(remove);
		panel.setLayout(new FlowLayout(1,2,2));
		return panel;
	}
	
	private DefaultTableModel getDTM(){
		if(ATC.selected_user.getStatus().getAccount_status() == 0){
			DefaultTableModel def = new DefaultTableModel(this.coluns,this.rows){				
				private static final long serialVersionUID = 1L;
				public boolean isCellEditable(int row, int column) {                                       
					return false;
				}			
			};
			return def;
		}else{
			return new DefaultTableModel(this.coluns,this.rows);
		}
	}
	
	private class Event extends MouseAdapter implements ActionListener{		
		public void actionPerformed(ActionEvent ev) {			
			try{
			if(ev.getSource() == remove){
				if(ATC.selected_id > -1){
					int opt = JOptionPane.showConfirmDialog(null, "Want to remove this reference: "+ref_info.getUser().getName()+".\nThis is an action that cannot be undone.\nAre you sure you want to proceed?","WARNING", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						new Manager(ATC.clicked_row + 1).deleteRef(ref_row + 1);
						JOptionPane.showMessageDialog(null, "Erased!");						
						transitionScreen();
					}
				}
			}else if(ev.getSource() == add){
				new Manager(ATC.clicked_row + 1).addReference("", "");
				transitionScreen();
			}			
			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Problem when deleting, this reference: "+e.toString());
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent ev) {
			ref_row = 	table.rowAtPoint(ev.getPoint());	
			ref_colunm = table.columnAtPoint(ev.getPoint());
			ref_id = references.get(ref_row).getId();
			ref_info = references.get(ref_row);			 
			System.out.println("Ref Row: "+ref_row+" Ref Colunm: "+ref_colunm + " ID: "+ref_id +" Reference: "+ref_info.getRef());
		}
		
	}
	
	private void transitionScreen(){
		frame.dispose();
		new Ref();
	}
	
	//Aqui é configurado as alterações na tabela.
	public void tableChanged(TableModelEvent ev) {
		if(ref_colunm == 0){
			try{
				String str = this.model.getValueAt(ref_row, ref_colunm).toString();
				String notes = this.model.getValueAt(ref_row, ref_colunm + 1).toString();
				if(!ref_info.getRef().equals(str)){
					Manager manager = new Manager(ATC.clicked_row + 1);
					References ref = new References();
					ref.setNotes(notes);
					ref.setRef(str);
					manager.editRef(ref_row + 1, ref);
					this.transitionScreen();
				}				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error persist data: "+e.toString());
				this.transitionScreen();
			}
		}else if(ref_colunm == 1){
			try{
				String str = this.model.getValueAt(ref_row, ref_colunm).toString();
				String name = this.model.getValueAt(ref_row, ref_colunm - 1).toString();
				if(!ref_info.getNotes().equals(str)){
					Manager manager = new Manager(ATC.clicked_row + 1);
					References ref = new References();
					ref.setRef(name);
					ref.setNotes(str);
					manager.editRef(ref_row + 1, ref);
					this.transitionScreen();
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error persist data: "+e.toString());
				this.transitionScreen();
			}
		}
		
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {	        
			Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 		
	        if(ATC.selected_user.getStatus().getAccount_status() == 0){
	        	comp.setBackground( Color.LIGHT_GRAY );       
	        }else{
	        	comp.setBackground(Color.WHITE);
	        }
	        return comp;
	    }
	
	public JDialog init(){
		if(!instance.frame.isVisible()){
			instance = new Ref();
		}				
		return this.frame;
	}
	
	static{
		instance = new Ref();
	}
}









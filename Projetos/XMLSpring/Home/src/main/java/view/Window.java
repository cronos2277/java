package view;
import java.awt.BorderLayout;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTable;

import controller.Database;

public class Window{
	private JFrame frame = new JFrame(title);	
	private static String title = "Janela";
	private JTable table;	
	private ModelTable model;
	private Database database;
	
	public Window(ModelTable model,Database database) {		
		this.model = model;
		this.database = database;
		this.window();		
		this.updateTable();
		this.charge();
	}
	
	private void window() {		
		frame.setSize(800,600);		
		frame.setTitle(Window.title);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}	
	
	private void updateTable() {				
		this.table = new JTable(this.model);			
		frame.getContentPane().add(BorderLayout.CENTER,this.table);
			
	}	
	
	public void add(int id, String name, Date date) {
		this.model.add(id, name, date);
	}
	
	public void charge() {
		for(int i=0;i<this.database.size();i++) {
			this.add(this.database.getIds().get(i), this.database.getNames().get(i), this.database.getRecords().get(i));
		}
	}
	
}

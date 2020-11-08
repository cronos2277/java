package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.Button;
import controller.Database;

public class Window{
	private JFrame frame = new JFrame(title);	
	private static String title = "Janela";
	private JTable table;	
	private ModelTable model;
	private Database database;
	private JPanel panel;
	private JButton generate;
	private JButton remove;
	private JButton change;
	private BorderLayout layout;
	private Button buttonsEvent;
	
	public Window(ModelTable model,Database database, Button buttonEvent) {		
		this.model = model;
		this.database = database;
		this.buttonsEvent = buttonEvent;
		this.window();		
		this.updateTable();
		this.charge();		
		this.panels();
		this.generateButton();
		this.changeButton();
		this.removeButton();
	}
	
	private void window() {		
		frame.setSize(800,600);		
		frame.setTitle(Window.title);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		this.layout = new BorderLayout();
		this.frame.setLayout(this.layout);
		
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
	
	private void panels() {
		this.panel = new JPanel();		
		this.panel.setVisible(true);
		this.panel.setBackground(Color.GRAY);
		this.panel.setSize(800, 100);				
		frame.getContentPane().add(BorderLayout.SOUTH,this.panel);
	}

	private void generateButton() {		
		this.generate = new JButton("Generate Data");		
		this.generate.setSize(50, 50);
		this.generate.setLocation(0, 0);
		this.generate.setVisible(true);
		this.generate.setBackground(Color.GREEN);
		this.generate.addActionListener(this.buttonsEvent);
		this.panel.add(generate);		
	}
	
	private void changeButton() {		
		this.change = new JButton("Change Data");		
		this.change.setSize(50, 50);
		this.change.setLocation(0, 0);
		this.change.setVisible(true);
		this.change.setBackground(Color.YELLOW);
		this.change.addActionListener(this.buttonsEvent);
		this.panel.add(change);		
	}
	
	private void removeButton() {		
		this.remove = new JButton("Remove Data");		
		this.remove.setSize(50, 50);
		this.remove.setLocation(0, 0);
		this.remove.setVisible(true);
		this.remove.setBackground(Color.RED);
		this.remove.addActionListener(this.buttonsEvent);
		this.panel.add(remove);		
	}	
}

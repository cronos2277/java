package controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import model.FakerData;
import javax.swing.JTable;

import model.FakerData;
import view.ModelTable;

public class Keyboard extends KeyAdapter{	
	private static final int ENTER = 10;		
	private static final int LEFT = 37;
	private static final int UP = 38;
	private static final int RIGHT = 39;
	private static final int DOWN = 40;
	private static final int F2 = 113;
	private static final int F5 = 116;
	private static final int DELETE = 127;
	
	private JTable table;
	private Database database;
	private int row;
	private int id = 0;
	private String name = "";
	private Date date = null;	
	private FakerData faker;
	public Keyboard(FakerData faker) {
		this.faker = faker;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {	
		try {
			this.update();			
			this.id = Integer.parseInt(table.getValueAt(row, ModelTable.ID).toString());
			this.name = table.getValueAt(row, ModelTable.NAME).toString();
			this.date = (Date) table.getValueAt(row, ModelTable.DATE);
			switch(event.getKeyCode()) {
				case ENTER:	this.generator();break;	
				case LEFT: this.update();break;
				case UP: this.update();break;
				case RIGHT: this.update();break;				
				case DOWN: this.update();break;
				case F2: this.change();break;
				case F5: this.refresh();break;
				case DELETE:this.remove();break;				
			}			
			
			
		}catch(Exception e) {
			System.err.println("Error on Keyboard, there is no row selected! "+e.getMessage());
		}
		
	}
	
	private void update() {
		this.database = App.spring.getBean(Database.class);
		this.table = App.spring.getBean(JTable.class);
		this.row = table.getSelectedRow();
		
	}
	
	private void refresh() {
		
	}
	
	private void generator() {
		String name = this.faker.getName();
		Date date = this.faker.getDate();
		this.database.insert(name,date);
		System.out.println("Row Created!");
		this.refresh();
	}
	
	private void change() {		
		String name = this.faker.getName();
		Date date = this.faker.getDate();
		this.database.update(this.id, name, date);
		System.out.println("Changed id:"+this.id+",name: "+this.name);
		this.refresh();
	}
	
	private void remove() {
		Mouse mouse = App.spring.getBean(Mouse.class);
		this.database.delete(mouse.getInt());
		System.out.println("Deleted id:"+this.id+",name: "+this.name);
		this.refresh();
	}
}

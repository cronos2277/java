package controller;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import model.FakerData;

public class Button implements ActionListener {
	private Database database;
	private FakerData faker;		
	public Button(Database database,FakerData faker) {
		this.database = database;
		this.faker = faker;		
	}
	
	private static final int REFRESH = 1;
	private static final int GENERATOR = 2;
	private static final int CHANGE = 3;
	private static final int REMOVE = 4;
	private JButton button;
	
	public void actionPerformed(ActionEvent event) {
		switch(this.getCode(event)) {
			case Button.REFRESH: this.refresh();break;
			case Button.GENERATOR: this.generator();break;
			case Button.CHANGE: this.change();break;
			case Button.REMOVE:this.remove();break;
		}
		this.log(event);		
	}

	private void log(ActionEvent event) {
		System.out.println("Button: "+event.getActionCommand());
	}
	
	private int getCode(ActionEvent event) {
		try {
			this.button = (JButton) event.getSource();
			String name = button.getName();
			if(name == "refresh") return Button.REFRESH;
			if(name == "generator") return Button.GENERATOR;
			if(name == "change") return Button.CHANGE;
			if(name == "remove") return Button.REMOVE;
			throw new java.lang.VerifyError("Button event: unknown event source");
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return 0;
		}		
	}
	
	private void refresh(){
		this.database.charge();
		//JFrame frame = (JFrame) App.spring.getBean(JFrame.class);		
		//frame.dispose();		
		//frame.repaint();
		//frame.validate();
		//App.main(new String[]{"On Button"});
	}
	
	private void generator() {		
		String name = this.faker.getName();
		Date date = this.faker.getDate();
		this.database.insert(name,date);		
		
	}
	
	private void change() {
		Mouse mouse = App.spring.getBean(Mouse.class);
		String name = this.faker.getName();
		Date date = this.faker.getDate();
		this.database.update(mouse.getInt(), name, date);
	}
	
	private void remove() {
		Mouse mouse = App.spring.getBean(Mouse.class);
		this.database.delete(mouse.getInt());
	}
}

package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import controller.Mouse;
import controller.Button;
import controller.Database;
import controller.Keyboard;

public class Window{
	private JFrame frame;	
	private static String title = "Janela";
	private JTable table;	
	private ModelTable model;
	private Database database;
	private JPanel panel;
	private JButton generate;
	private JButton remove;
	private JButton change;
	private JButton refresh;
	private BorderLayout layout;
	private Button buttonsEvent;
	private Mouse mouse;
	private Keyboard keyboard;
	
	public Window(JFrame frame, ModelTable model,Database database, Button buttonEvent, JTable table,Mouse mouse,Keyboard keyboard) {	
		this.frame = frame;
		this.model = model;
		this.database = database;
		this.buttonsEvent = buttonEvent;
		this.table = table;
		this.mouse = mouse;
		this.keyboard = keyboard;
		this.window();		
		this.charge();		
		this.panels();		
		this.loadButtons();
	}
	
	private void window() {		
		frame.setSize(800,600);		
		frame.setTitle(Window.title);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		this.layout = new BorderLayout();
		this.frame.setLayout(this.layout);		
		this.table.setModel(model);
		this.table.addMouseListener(mouse);
		this.table.addKeyListener(keyboard);
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
	
	public void loadButtons() {
		this.setButton(this.refresh, "Refresh (F5)","refresh",Color.CYAN);
		this.setButton(this.generate, "Generate (Enter)","generator",Color.GREEN);
		this.setButton(this.change, "Change (F2)","change",Color.YELLOW);
		this.setButton(this.remove, "Remove (Del)","remove",Color.RED);
	}	
	
	private void setButton(JButton button,String label, String name ,Color color) {		
		button = new JButton(label);		
		button.setSize(50, 50);
		button.setLocation(0, 0);
		button.setVisible(true);
		button.setBackground(color);
		button.setName(name);
		button.addActionListener(this.buttonsEvent);
		this.panel.add(button);		
	}	
}

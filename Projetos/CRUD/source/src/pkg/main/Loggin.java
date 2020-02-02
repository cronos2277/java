package pkg.main;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import pkg.components.Window;


public class Loggin{	
	public static Loggin instance;
	private JFrame frame;
	private JButton submit;	
	private JButton clean;	
	private JButton exit;
	private JLabel user_label;
	private JLabel url_label;
	private JLabel pass_label;
	private JTextField user;
	private JPasswordField pass;
	private JTextField url;
	
	private Loggin(){
		
	}
	
	private JFrame DefineFrame(){
		JFrame jframe = new JFrame("BLRS");		 
		jframe.setLayout(new BorderLayout());
		this.user_label = new JLabel("User: ");
		this.user_label.setFont(new Font("arial",20,20));		
		this.pass_label = new JLabel("Pass: ");
		this.pass_label.setFont(new Font("arial",20,20));		
		this.url_label = new JLabel("URL : ");
		this.url_label.setFont(new Font("arial",20,20));		
		this.user = new JTextField();
		this.user.addActionListener(new Action());
		this.user.setFont(new Font("arial",20,20));
		this.user.setSize(40, 40);
		this.pass = new JPasswordField();
		this.pass.addActionListener(new Action());
		this.pass.setFont(new Font("arial",20,20));
		this.url = new JTextField();	
		this.url.addActionListener(new Action());
		this.url.setFont(new Font("arial",20,20));
		this.submit = new JButton("Submit");
		this.submit.addActionListener(new Action());		
		this.clean = new JButton("Clean");
		this.clean.addActionListener(new Action());
		this.exit = new JButton("Exit");
		this.exit.addActionListener(new Action());		
		JPanel bigpanel = new JPanel();
		JPanel little = new JPanel();
		bigpanel.setLayout(new GridLayout(3,2));
		bigpanel.add(this.user_label);
		bigpanel.add(this.user);
		bigpanel.add(this.pass_label);
		bigpanel.add(this.pass);
		bigpanel.add(this.url_label);
		bigpanel.add(this.url);			
		little.add(this.clean);
		little.add(this.submit);
		jframe.add(BorderLayout.CENTER,bigpanel);
		jframe.add(BorderLayout.SOUTH, little);
		return jframe;
	}
	
	public void init(){
		frame = new JFrame("BLRS");
		frame = this.DefineFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);		
		frame.setSize(700, 160);
		this.url.setText(Main.ip);		
	}
	
	
	private class Action implements ActionListener{
		public void actionPerformed(ActionEvent event) {			
			if(event.getSource() == submit){
				this.submitMethod();
			}else if(event.getSource() == clean){
				this.cleanMethod();
			}
		}
		
		private void submitMethod(){
			try{
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.dispose();
				Main.username = user.getText();
				Main.password = new String(pass.getPassword());
				Main.url = Main.jdbc+url.getText()+Main.connection;
				Do.createDatabase();
				new Window(Main.dimension);
			}catch(Exception e){
				Do.logginError(e);
			}
		}
		
		private void cleanMethod(){
			user.setText("");
			pass.setText("");
			url.setText("127.0.0.1:3306");
		}		
	}
	
	static{
		instance = new Loggin();
	}
}

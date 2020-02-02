package pkg.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pkg.connection.Manager;
import pkg.entity.User;
import pkg.main.Do;
import pkg.main.Main;
import pkg.table.ATC;

public class Reasons extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public static Reasons instance;
	private JButton submit;
	private JButton cancel;
	private JButton clean;	
	private JTextArea field;
	private User user;
	private JPanel buttons;
	private Container cont;
	private JScrollPane scroll;
	private JDialog diag;
	private Manager manager;
	
	private Reasons(){
		this.user = ATC.selected_user;
		manager = new Manager(ATC.clicked_row + 1);
		this.diag = new JDialog(Window.window);
		this.diag.setTitle("Reasons fo close contract of "+ATC.selected_name);
		this.diag.add(getJTF());
		this.diag.setSize(Main.dimension.width/3, Main.dimension.height/3);
		this.diag.setLocationRelativeTo(null);
		this.diag.setVisible(true);		
		this.diag.setModal(true);
		this.diag.setDefaultCloseOperation(Do.CloseOperation());
		field.setText(this.user.getStatus().getTermination());		
	}	
	
	private Container getJTF(){
		this.field = new JTextArea();		
		this.scroll = new JScrollPane(this.field);
		this.cont = getContentPane();
		this.cont.add(BorderLayout.CENTER, scroll);	
		if(this.user.getStatus().getAccount_status() != 0){
			this.submit = new JButton("Submit");
			this.cancel = new JButton("Cancel");
			this.clean = new JButton("Clean");
			this.submit.addActionListener(new Action());
			this.cancel.addActionListener(new Action());
			this.clean.addActionListener(new Action());		
			this.buttons = new JPanel();
			this.buttons.add(this.clean);
			this.buttons.add(this.submit);
			this.buttons.add(this.cancel);
			this.cont.add(BorderLayout.SOUTH,buttons);	
		}else{
			this.field.setEditable(false);
			this.field.setBackground(Color.LIGHT_GRAY);
		}
		return cont;
	}

	private class Action implements ActionListener{
		public void actionPerformed(ActionEvent action) {			
			if(action.getSource() == submit){
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to terminate the contract?","ENDING "+ATC.selected_name.toUpperCase(), JOptionPane.YES_NO_OPTION);
				if(opt == 0)
					try{					
						manager.status.setAccount_status(0);
						manager.status.setTermination(field.getText());						
						manager.change();						
						Do.clearScreen();
					}catch(Exception error){
						Do.logginError(error);
					}
			}else if(action.getSource() == cancel){
				int opt1 = JOptionPane.showConfirmDialog(null, "Do you want to cancel ?","ENDING "+ATC.selected_name.toUpperCase(), JOptionPane.YES_NO_OPTION);
				if(opt1 == 0){
						diag.dispose();
						Do.clearScreen();
				}
			}else if(action.getSource() == clean){
				int opt2 = JOptionPane.showConfirmDialog(null, "Do you want to erase all unsaved text?","ENDING "+ATC.selected_name.toUpperCase(), JOptionPane.YES_NO_OPTION);
				if(opt2 == 0){
					field.setText(user.getStatus().getTermination());
				}
			}
		}
	
	}
	
	public JDialog init(){
		if(!instance.diag.isVisible()){
			instance = new Reasons();
		}				
		return instance.diag;
	}
	
	
	static{
		instance = new Reasons();
	}
}

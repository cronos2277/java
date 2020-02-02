package pkg.components;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import pkg.connection.Manager;
import pkg.main.Do;
import pkg.main.Main;
import pkg.table.ATC;

public class AdvanceMenu {
	public static AdvanceMenu instance;
	public JMenu menu;
	private JMenuItem createBackup;
	private JMenuItem eraseSelectedRegister;
	private JMenuItem restoreFromBackup;
	private AdvanceMenu(){
		this.menu = new JMenu("Advance Options");
		this.menu.add(this.getCreateBackup());
		this.menu.add(this.getEraseSelectedRegister());
		this.menu.add(this.getRestoreFromBackup());
	}
	
	private JMenuItem getCreateBackup(){
		this.createBackup = new JMenuItem("Create backup");
		this.createBackup.addActionListener(new Action());
		return this.createBackup;
	}
	
	private JMenuItem getEraseSelectedRegister(){
		this.eraseSelectedRegister = new JMenuItem("Erase this register");
		this.eraseSelectedRegister.addActionListener(new Action());
		return this.eraseSelectedRegister;
	}
	
	private JMenuItem getRestoreFromBackup(){
		this.restoreFromBackup = new JMenuItem("Restore from backup");
		this.restoreFromBackup.addActionListener(new Action());
		return this.restoreFromBackup;
	}	
	
	private class Action implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == createBackup){
				this.actionCreateBackup();
			}else if(event.getSource() == eraseSelectedRegister){
				this.actionErase();
			}else if(event.getSource() == restoreFromBackup){
				this.actionRestoreBackup();
			}
			
		}
		
		private void actionErase(){
			try{
				if(ATC.selected_id > -1){
					JLabel label = new JLabel("Please enter your password in the database:");
					JPasswordField jpf = new JPasswordField();
					JOptionPane.showConfirmDialog(null, new Object[]{label, jpf}, "Password",	JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
					String checkpass = new String(jpf.getPassword());
					if(checkpass.equals(Main.password)){
						int opt = JOptionPane.showConfirmDialog(null, "This action will finish the selected contract with: "+ATC.selected_name+".\nThis is an action that cannot be undone.\nAre you sure you want to proceed?","WARNING ERASING "+ATC.selected_name.toUpperCase(), JOptionPane.YES_NO_OPTION);
						if(opt == 0){
							new Manager().removeUser(ATC.selected_id);
							JOptionPane.showMessageDialog(null, "Erased!");
							Do.clearScreen();				
						}else{
							JOptionPane.showMessageDialog(null, "Canceled by user.");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Wrong password, the operation will not be done");
					}
				}
			}catch(NullPointerException e){
				JOptionPane.showMessageDialog(null, "Select in the table by clicking on the contract that you want to delete.");
			}
		}
		
		private void actionCreateBackup(){
			JLabel label = new JLabel("Please enter your password in the database:");
			JPasswordField jpf = new JPasswordField();
			JOptionPane.showConfirmDialog(null, new Object[]{label, jpf}, "Password",	JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			String checkpass = new String(jpf.getPassword());
			if(checkpass.equals(Main.password)){
				int opt = JOptionPane.showConfirmDialog(null,"You want to create a backup of the database? For this to be possible, make sure that this is the computer with the database.","Create Backup", JOptionPane.YES_NO_OPTION);
				if(opt == 0){
					try{
						Do.makeMysqlBackup();
						JOptionPane.showMessageDialog(null, "Operation completed successfully!");
					}catch(Exception error){
						JOptionPane.showMessageDialog(null, "Error creating backup");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Canceled by user.");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Wrong password, the operation will not be done");
			}
		}
		
		private void actionRestoreBackup(){
			JLabel label = new JLabel("Please enter your password in the database:");
			JPasswordField jpf = new JPasswordField();
			JOptionPane.showConfirmDialog(null, new Object[]{label, jpf}, "Password",	JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			String checkpass = new String(jpf.getPassword());
			if(checkpass.equals(Main.password)){
				int opt = JOptionPane.showConfirmDialog(null,"You want to restore a backup of the database, from a file?","Restore Backup", JOptionPane.YES_NO_OPTION);
				if(opt == 0){
					try{
						Do.restoreMysqlBackup();
						Do.clearScreen();
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Error restoring backup");
					}			
				}else{
					JOptionPane.showMessageDialog(null, "Canceled by user.");
				}			
			}else{
				JOptionPane.showMessageDialog(null, "Wrong password, the operation will not be done");
			}
		}	
	}
	
	static{
		instance = new AdvanceMenu();
	}
}
	


package pkg.main;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pkg.components.Window;
import pkg.table.ATC;


public class Do {	
	private static void createLogFile(Exception error){		
		try {
			FileWriter writer = new FileWriter("Error.log",true);
			if(error != null)
			writer.write(new Date().toString()+"\n Occurrence: "+error.toString());
			if(error.getCause() != null)
			writer.write("\n Cause: "+error.getCause().toString());
			if(error.getStackTrace() != null)
			writer.write("\n StackTrace: "+error.getStackTrace().toString());
			if(error.getSuppressed() != null)
			writer.write("\n Supressed: "+error.getSuppressed().toString());
			if(error.getClass() != null)
			writer.write("\n Class: "+error.getClass().toString());			
			writer.write("\n\nOS: "+System.getProperty("os.name")+", version: "+System.getProperty("os.version"));
			writer.write("\nJVM version: "+System.getProperty("java.vm.version")+", vendor: "+System.getProperty("java.vm.vendor")+", name: "+System.getProperty("java.vm.name"));
			writer.write("\nJRE version: "+System.getProperty("java.specification.version")+", vendor: "+System.getProperty("java.specification.vendor")+", name: "+System.getProperty("java.specification.name"));
			writer.write("\nLoaded libs: \n "+System.getProperty("java.library.path")+"\n");
			writer.write("\nUser logged: "+Main.username+"\nURL: "+Main.url+"\nProgram path: "+System.getProperty("user.dir"));
			writer.close();
			JOptionPane.showMessageDialog(null, "Log file created with success!");
		} catch (IOException e) {			
			JOptionPane.showMessageDialog(null,"Unable to create the log file");
		}
	}
	
	
	public static void notifyTechnicalError(Exception error){
		JOptionPane.showMessageDialog(null, "The following error occurred, this error will be added to a log file, for future analysis.");
		createLogFile(error);
	}
	
	public static void createDatabase(){
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");						
			connection = DriverManager.getConnection("jdbc:mysql://localhost/", Main.username, Main.password);				
			statement = connection.createStatement();				
			statement.executeUpdate("CREATE DATABASE blrs");				
			JOptionPane.showMessageDialog(null, "Database created successfully!");
		} catch (SQLException error) {
				System.out.println("Database found!");			
		} catch (ClassNotFoundException error) {
				Do.notifyTechnicalError(error);
		}finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				Do.notifyTechnicalError(e);
			}
			
		}
		
	}
	
	public static void logginError(Exception e){
		JOptionPane.showMessageDialog(null, 
				"   There was an error connecting to the database, a dry list of reasons:\n " +
				"*  Wrong password or login.(More likely!) \n " +
				"*  Database not installed. (It is installed?) \n " +
				"*  Problems with tcp port connection.\n" +
				"*  Check the occurrence of these problems and try again.\n" +
				"*  The program will now be closed, try again later!"+e.toString());
	}
			
	public static void clearScreen(){
		Window.window.dispose();
		ATC.clicked_colunm = -1;
		ATC.clicked_row = -1;
		ATC.selected_id = -1l;
		ATC.selected_name = "";
		new Window(Main.dimension);
		Window.jTabbedPane1.setSelectedIndex(ATC.selected_tab);
	}	
	
	public static void makeMysqlBackup(){
		if(System.getProperty("os.name").toLowerCase().equals("linux")){
			try {					
				String path = System.getProperty("user.dir")+"/";
				String[] cmd = {"/bin/sh","-c", "mysqldump -u "+Main.username+" -p"+Main.password+" blrs > "+path+"blrs.db"};
				Runtime.getRuntime().exec(cmd);
				System.out.println("making backup on: "+System.getProperty("os.name")+", kernel version: "+System.getProperty("os.version"));			
			}catch(IOException e) {			
				Do.logginError(e);
			}
		}else{
			try{
				String path = System.getProperty("user.dir")+"/";
				String[] cmd = {"cmd /c", "mysqldump -u "+Main.username+" -p"+Main.password+" blrs > "+path+"blrs.db"};
				Runtime.getRuntime().exec(cmd);
				System.out.println("making backup on: "+System.getProperty("os.name")+", version: "+System.getProperty("os.version"));
			}catch(IOException e){
				Do.logginError(e);
			}
		}
	}
	
	public static void restoreMysqlBackup(){
		String path = System.getProperty("user.dir")+"/";		
		String cmd = "mysql -u "+Main.username+" -p"+Main.password+" blrs < "+path+"blrs.db";		
		String[] linux = {"/bin/sh","-c",cmd}; 
		String[] windows = {"cmd /c","mysql",cmd};
		try {
			if(System.getProperty("os.name").toLowerCase().equals("linux")){
				Runtime.getRuntime().exec(linux);
			}else{
				Runtime.getRuntime().exec(windows);
			}
			new pkg.connection.Manager().refreshList();
			System.out.println(cmd);
		} catch (IOException e) {			
			Do.logginError(e);
		}
	}
	
	public static Integer CloseOperation(){		
		return JFrame.DISPOSE_ON_CLOSE;
	}
	
	
	
	private Do(){
		
	}
}

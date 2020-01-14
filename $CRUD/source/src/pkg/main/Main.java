package pkg.main;
import java.awt.Dimension;
import java.awt.Toolkit;

//url = "jdbc:mysql://127.0.0.1:3306/blrs?useSSL=false&amp;requireSSL=false";
public class Main {
	public static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); 
	public static String jdbc = "jdbc:mysql://";
	public static String ip = "127.0.0.1:3306";
	public static String connection = "/blrs?useSSL=false&amp;requireSSL=false";
	public static String url;
	public static String username;
	public static String password;	
	public static void main(String[] args) {		
		Loggin.instance.init();
		//login();
		//Do.createDatabase();
		//Do.makeMysqlBackup();
		//new Teste();
		//new Window(dimension);
	}	
	
	
}
	
	
		

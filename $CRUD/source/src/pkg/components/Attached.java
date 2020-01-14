package pkg.components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pkg.connection.Manager;
import pkg.entity.Attachments;
import pkg.main.Do;
import pkg.main.Main;
import pkg.table.ATC;


public class Attached extends DefaultTableCellRenderer implements TableModelListener{	
	private static final long serialVersionUID = 1L;
	public static Attached instance;
	private int att_row;
	private int att_colunm;
	private Long att_id;		
	private JDialog frame = new JDialog(Window.window);
	private Manager manager;	
	private List<Attachments> attachments;
	private Attachments attachment;
	private String[] rows = {"All attached documents","Notes"};
	private String[][] coluns;
	private DefaultTableModel model;
	private JTable table;
	private JButton add;	
	private JButton remove;	
	private String path;
	private String name;
	
	//Construtor
	private Attached() {
		try{
			if(ATC.selected_user.equals(null) || ATC.clicked_row == -1) throw new NullPointerException();			
			this.tableModelConf();			
			this.defTable();
			this.run();			
			this.model.addTableModelListener(this);			
			System.out.println("Attachment window loaded successfully!");
		}catch(NullPointerException e){			
			JOptionPane.showMessageDialog(null, "Select the contract you want to view the attachments.");
		}catch(Exception e){			
			System.out.println("Error loading attachment window, due to the error: "+e.toString());
		}
	}	
	
	//Configurações de tabela, nesse método é setado o funcionamento da tabela.
	private void tableModelConf(){
		//Pegando informações do usuário que se quer os anexos.
		this.manager = new Manager(ATC.clicked_row + 1);
		this.attachments = this.manager.getATT();
		
		//Criando regras para a tabela, com o DefaultTableModel. No caso a classe está sendo sobreescrita.
		model =  new DefaultTableModel(this.coluns,this.rows){			 
			private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {                                       
            	if(column == 0 ||ATC.selected_user.getStatus().getAccount_status() == 0){
            		return false;
            	}else{
            		return true;
            	}}};
        
         //Carregando em uma lista todos os anexos de um determinado usuário.
		for(Attachments att: this.attachments){				
			System.out.println(ATC.selected_id);
			if(att.getUser().getId() == ATC.selected_id){
				model.addRow(new Object[]{att.getName(), att.getNotes()});				
			}
		}
	}
	
	//A janela principal vai pegar a JTable configurada através desse método.
	public JTable getTable() {		
		return this.table;		
	}	
	
	/*
	 * Definições de tabela: Aqui é configurado como as tabelas deve-se comportar e o tamanho das colunas,
	 * quais campos são editáveis, aqui são adicionados também o eventos com o mouse.
	 * */
	private void defTable() {
		this.table = new JTable();
		this.table.setModel(model);
		this.table.addMouseListener(new Event());
		
		double size = ((Main.dimension.width -10) / this.rows.length)*0.4;		
		int sz = (int) size;			
		this.table.getColumnModel().getColumn(1).setPreferredWidth(sz);			
		this.table.getColumnModel().getColumn(0).setCellRenderer(this);	
		if(ATC.selected_user.getStatus().getAccount_status() == 0){
			this.table.getColumnModel().getColumn(1).setCellRenderer(this);
		}
	}
	
	//Aqui é configurado a JDIalog, como o tamanho da janela, título e layout.
	private void run(){		
		frame.setTitle(ATC.selected_name + " - Attachments");					
		frame.setLayout(new BorderLayout());
		frame.add(BorderLayout.CENTER,new JScrollPane(this.table));
		frame.add(BorderLayout.SOUTH, this.buttons());		
		frame.setSize(Main.dimension.width/2, Main.dimension.height/2);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setModal(true);
		frame.setDefaultCloseOperation(Do.CloseOperation());
	}
	
	//Aqui é configurado os botões e também é adicionado funcionalidade a eles.
	private JPanel buttons(){
		JPanel panel = new JPanel();		
		this.add = new JButton("Add folder");
		this.add.addActionListener(new Add());
		
		this.remove = new JButton("Remove folder");
		this.remove.addActionListener(new Event());
		panel.add(this.add);
		
		panel.add(this.remove);		
		panel.setLayout(new FlowLayout(1,2,2));
		return panel;
	}
	
	//Essa classe privada trata dos eventos do mouse.
	private class Event extends MouseAdapter implements ActionListener{		
		public void actionPerformed(ActionEvent ev) {			
			try{
			if(ev.getSource() == remove){
				if(ATC.selected_id > -1){
					int opt = JOptionPane.showConfirmDialog(null, "Want to remove this attachment of "+attachment.getUser().getName()+".\nAre you sure you want to proceed?","WARNING", JOptionPane.YES_NO_OPTION);
					if(opt == 0){
						new Manager(ATC.clicked_row + 1).deleteAtt(att_row + 1);
						JOptionPane.showMessageDialog(null, "Erased!");
						transitionScreen();		
					}
				}
			}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Select a field to be deleted!");
				System.out.println("Problem when deleting, this Annex:"+e.toString());
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent ev) {
			att_row = 	table.rowAtPoint(ev.getPoint());	
			att_colunm = table.columnAtPoint(ev.getPoint());
			att_id = attachments.get(att_row).getId();
			attachment = attachments.get(att_row);			 
			System.out.println("Att Row: "+att_row+" Att Colunm: "+att_colunm + " ID: "+att_id);
			if(att_colunm == 0 && ev.getClickCount() == 1){				
				try {
					File file = new File(attachment.getPath());
					Desktop.getDesktop().open(file);
				} catch (IOException e) {						
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//Essa classe privada está relacionada aos eventos dos botões, quando eles são clicados.
	private class Add implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			try{
				String directory_default = System.getProperty("user.home");		
				JFileChooser chooser = new JFileChooser();
				File file = new File(directory_default);
				chooser.setCurrentDirectory(file);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				Integer okey_button = chooser.showOpenDialog(null);
					if(okey_button.equals(JFileChooser.APPROVE_OPTION)){
						path = chooser.getSelectedFile().getAbsolutePath();
						name = chooser.getSelectedFile().getName();
						System.out.println(path);
						new Manager(ATC.clicked_row + 1).addAttachment(name,path, "");
						JOptionPane.showMessageDialog(null, "Added file path with success!");
						transitionScreen();
				}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.toString());
					transitionScreen();
				}
			}
			
		}
	
	//Transição de tela, ou seja aqui é configurado como será feito as trasições de tela.	
	private void transitionScreen(){
			frame.dispose();
			new Attached();
		}
	
	/*
	 * Essa classe está relacionadas as edições feita nas tabelas. Quando acontece alguma edição
	 * na tabela, ela sincroniza esses dados com o SGBD, porém existe uma condição para isso ser feito
	 * e essa condição é que os dados sejam diferentes dos contidos no SGBD.
	 * */
	public void tableChanged(TableModelEvent arg0) {
		if(att_colunm == 0){
			transitionScreen();
		}	
		
		try{
			if(att_colunm == 1){				
				String str = this.model.getValueAt(att_row, att_colunm).toString();				
				if(!attachment.getNotes().equals(str)){	
					Manager man = new Manager(ATC.clicked_row + 1);
					Attachments temp = new Attachments();
					temp.setName(man.getATT().get(att_row).getName());
					temp.setPath(man.getATT().get(att_row).getPath());
					temp.setNotes(str);
					man.editAtt(att_row + 1, temp);
					transitionScreen();
					System.out.println("Name: "+temp.getName()+" Notes: "+temp.getNotes()+" src: "+temp.getPath());
				}
			}			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error when posting notes to annex, due to the error: "+e.toString());
			transitionScreen();
		}
		
		
	}
	
	//Aqui é definido o comportamento do campo não editável, no caso apenas a cor de fundo.
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {	        
			Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 		
	        comp.setBackground( Color.LIGHT_GRAY );       
	        return comp;
	    }
	
	public JDialog init(){
		if(!instance.frame.isVisible()){
			instance = new Attached();
		}				
		return this.frame;
	}
	
	static{
		instance = new Attached();
	}
}

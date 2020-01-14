package javapackage;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class JotaTable {

public static void TableConf(DefaultTableModel model){	
modelo.addColumn("Código");
modelo.addColumn("Nome");
modelo.addColumn("E-mail");
modelo.addColumn("Telefone");
ClasseSQL.ConsultarContato();
}

static DefaultTableModel modelo = new DefaultTableModel();	
static JTable tabela = new JTable(modelo);
public static void TableDados(int codigo, String nome, String email, String telefone){
	String [] Lista = {Integer.toString(codigo),nome,email,telefone};
	modelo.addRow(Lista);}


public static void limparTabela() {
	 while (tabela.getRowCount() > 0) {
	 DefaultTableModel dm = (DefaultTableModel) tabela.getModel();
	 dm.getDataVector().removeAllElements();
	 Componentes.Nome_new = null;	
	 Componentes.Email_new = null;
	 Componentes.Tel_new = null;
	 Componentes.Nome_old = null;
	 Componentes.Email_old = null;
	 Componentes.Tel_old = null;
	 Componentes.nome_t.setText(null);Componentes.email_t.setText(null);Componentes.tel_t.setText(null);
	 Componentes.id = -1;
	 }
	 }
}

package pkg.main;
import pkg.entidade.Entidade;
import pkg.face.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Order {
//Valores est�ticos, acessados publicamente por todas as classes.	
public static JTable Tabela;
public static List<Entidade> ListaEntidades;
public static JFrame janela;
	public JFrame FrameMainWindow(String NomePrograma, int largura, int altura){ //Setando valores para o JFrame.
		janela = new JFrame(NomePrograma); //A String NomePrograma, corresponde ao nome que aparece no t�tulo da Janela.
		janela.setVisible(true); //Se false a tela n�o fica vis�vel. Util caso voc� queira esconder uma janela.
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //O Que acontece quando fecha o programa? No caso aqui ele encerra. Para Janelas que n�o sejam as principais, n�o � interessante definir essa enum para essa opera��o.
		janela.setSize(largura, altura); //O tamanho da janela, aqui tamb�m � aceito um atributo do tipo Dimension.
		janela.setLocationRelativeTo(null); //A posi��o ao qual a janela aparecer� quando for carregada. Se setado null ela aparece no centro da tela.
		return janela; //Aqui � nesse m�todo � feita a defini��es do JFrame, uma vez definido ele retorna um objeto JFrame devidamente configurado, isso � bom para deixar o c�digo mais leg�vel.
	}
	
	public JPanel PainelButtonsUp(Components comp){
	JPanel painel = new JPanel();
	painel.setBackground(Color.GRAY); //Aqui � setada a cor. O Color � uma enum, com diversos valores de cores, assim como voc� pode carregar uma cor, voc� tamb�m pode definir uma manulamente.
	painel.setLayout(new FlowLayout());	//O tipo de layout deste painel.
	painel.add(comp.label_nome); //neste painel s�o carregados JLabel,TextField, e JButtons e adicionado pelo m�to add ao painel. 
	painel.add(comp.text_nome);
	painel.add(comp.label_funcao);
	painel.add(comp.text_funcao);
	painel.add(comp.edit);
	painel.add(comp.del);
	return painel; //O mesmo esquema do JFrame. ;)
	}
	
	public JPanel PainelButtonsDown(Components comp){
		JPanel painel = new JPanel();
		painel.setBackground(Color.GRAY);
		painel.setLayout(new FlowLayout());	
		painel.add(comp.label_new_name);
		painel.add(comp.text_new_nome);
		painel.add(comp.label_new_func);
		painel.add(comp.text_new_func);
		painel.add(comp.button_new);
		return painel;
		}
	
	public JTable TableReturn(List<Entidade> entidades){
		int i = 1; //No caso o c�digo aparecido na JTable, e sim o valor desta vari�vel, caso tenha 20 dados, haver� 20 i. Ele come�a no um. A sua ordem � definida na query do EntidadeDao().
		DefaultTableModel modelo = new DefaultTableModel(); //Aqui � definido o modelo de tabela, neste caso o padr�o, primeiro voc� configura o modelo de tabela, insere as colunas e os dados, para por fim criar a tabela, propriamente dita.
		ListaEntidades = entidades;		
		modelo.addColumn("Codigo"); //O .addColumn, se refere ao cabe��rio da tabela, que aqui n�o est� configurado para aparecer.
		modelo.addColumn("Nome"); //Como a Entidade poss�i tr�s campos, nada melhor que moldar a sua sa�da em tr�s colunas.
		modelo.addColumn("Fun��o");
		for(Entidade ent: entidades){
		String [] pessoa = {Integer.toString(i),ent.getNome(),ent.getFuncao()};
		modelo.addRow(pessoa);i++;} //O addRow(), serve para adicionar valores na tabela, pelo menos em uma tabela aos Moldes do DefaultTableModel.
		JTable tabela = new JTable(modelo); //Uma tabela ela pode ser instanciada nula, ou com um modelo de tabela.
		Tabela = tabela;
		return tabela;
	}
	public static void ClassListener(Components comp){ //Aqui s�o adicionado os Actions Listener. o m�todo � vazio e recebe um objeto do tipo Components.
		comp.del.addActionListener(comp.listener); //Para que os bot�es possam funcionar e executar a��es, se faz necess�rio preparar o JFrame para ouvir-los.
		comp.edit.addActionListener(comp.listener); //Esse m�todo s� funciona para objetos, que possam ser programado alguma a��o, como o JButton e o JTextField. No caso o JLabel fica de fora.
		comp.button_new.addActionListener(comp.listener);
		comp.text_funcao.addActionListener(comp.listener);
		comp.text_nome.addActionListener(comp.listener);
		comp.text_new_func.addActionListener(comp.listener);
		comp.text_new_nome.addActionListener(comp.listener);		
	}
	public static void Refresh(){ //Aqui � executado uma limpeza no JFrame, para que os seus valores sejam atualizados.
		Order.Tabela.removeAll(); //Remove todos os valores do JTable.		
		Order.janela.removeAll(); //Remove todos os valores do JFrame.
		Order.janela.dispose(); //Fecha o JFrame.
		Principal.main(null); //Executa o m�todo main, carregando novamente a tabela e o JFrame, sendo assim atualizado.
	}
public static String Mensagem= "Verifique se os seguintes requisitos: "
		+ "\n*Verifique se o seu computador, aguenta a resolu��o 800X600, caso n�o altere isso no c�digo fonte."
		+ "\n*Se o banco de dados existe, ou se o MySQL est� instalado e configurado na porta TCP correta."
		+ "\n*Se o usu�rio e se senha correspondem ao do banco de dados."
		+ "\n*Se existe algum banco com o nome estipulado, com base no arquivo 'hibernate.cfg.xml'."
		+ "\n*Se a vers�o do java � ao menos a vers�o 6, recomenda-se o Jre 7 ou superior"
		+ "\n*Caso o Sistema seja um GNU/linux, n�o esque�a de informar a porta TCP na url do arquivo 'hibernate.cfg.xml'"
		+ "\n*Caso seja um Windows, verifique se existe justamente o TCP informado na url, isso � um requisito exclusivo do GNU/Linux"
		+ "\n*Tente recompilar novamente o programa, a caso da insist�ncia de erros, levando em considera��o as informa��es acimas. ";	
}	

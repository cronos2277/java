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
//Valores estáticos, acessados publicamente por todas as classes.	
public static JTable Tabela;
public static List<Entidade> ListaEntidades;
public static JFrame janela;
	public JFrame FrameMainWindow(String NomePrograma, int largura, int altura){ //Setando valores para o JFrame.
		janela = new JFrame(NomePrograma); //A String NomePrograma, corresponde ao nome que aparece no título da Janela.
		janela.setVisible(true); //Se false a tela não fica visível. Util caso você queira esconder uma janela.
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //O Que acontece quando fecha o programa? No caso aqui ele encerra. Para Janelas que não sejam as principais, não é interessante definir essa enum para essa operação.
		janela.setSize(largura, altura); //O tamanho da janela, aqui também é aceito um atributo do tipo Dimension.
		janela.setLocationRelativeTo(null); //A posição ao qual a janela aparecerá quando for carregada. Se setado null ela aparece no centro da tela.
		return janela; //Aqui é nesse método é feita a definições do JFrame, uma vez definido ele retorna um objeto JFrame devidamente configurado, isso é bom para deixar o código mais legível.
	}
	
	public JPanel PainelButtonsUp(Components comp){
	JPanel painel = new JPanel();
	painel.setBackground(Color.GRAY); //Aqui é setada a cor. O Color é uma enum, com diversos valores de cores, assim como você pode carregar uma cor, você também pode definir uma manulamente.
	painel.setLayout(new FlowLayout());	//O tipo de layout deste painel.
	painel.add(comp.label_nome); //neste painel são carregados JLabel,TextField, e JButtons e adicionado pelo méto add ao painel. 
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
		int i = 1; //No caso o código aparecido na JTable, e sim o valor desta variável, caso tenha 20 dados, haverá 20 i. Ele começa no um. A sua ordem é definida na query do EntidadeDao().
		DefaultTableModel modelo = new DefaultTableModel(); //Aqui é definido o modelo de tabela, neste caso o padrão, primeiro você configura o modelo de tabela, insere as colunas e os dados, para por fim criar a tabela, propriamente dita.
		ListaEntidades = entidades;		
		modelo.addColumn("Codigo"); //O .addColumn, se refere ao cabeçário da tabela, que aqui não está configurado para aparecer.
		modelo.addColumn("Nome"); //Como a Entidade possúi três campos, nada melhor que moldar a sua saída em três colunas.
		modelo.addColumn("Função");
		for(Entidade ent: entidades){
		String [] pessoa = {Integer.toString(i),ent.getNome(),ent.getFuncao()};
		modelo.addRow(pessoa);i++;} //O addRow(), serve para adicionar valores na tabela, pelo menos em uma tabela aos Moldes do DefaultTableModel.
		JTable tabela = new JTable(modelo); //Uma tabela ela pode ser instanciada nula, ou com um modelo de tabela.
		Tabela = tabela;
		return tabela;
	}
	public static void ClassListener(Components comp){ //Aqui são adicionado os Actions Listener. o método é vazio e recebe um objeto do tipo Components.
		comp.del.addActionListener(comp.listener); //Para que os botões possam funcionar e executar ações, se faz necessário preparar o JFrame para ouvir-los.
		comp.edit.addActionListener(comp.listener); //Esse método só funciona para objetos, que possam ser programado alguma ação, como o JButton e o JTextField. No caso o JLabel fica de fora.
		comp.button_new.addActionListener(comp.listener);
		comp.text_funcao.addActionListener(comp.listener);
		comp.text_nome.addActionListener(comp.listener);
		comp.text_new_func.addActionListener(comp.listener);
		comp.text_new_nome.addActionListener(comp.listener);		
	}
	public static void Refresh(){ //Aqui é executado uma limpeza no JFrame, para que os seus valores sejam atualizados.
		Order.Tabela.removeAll(); //Remove todos os valores do JTable.		
		Order.janela.removeAll(); //Remove todos os valores do JFrame.
		Order.janela.dispose(); //Fecha o JFrame.
		Principal.main(null); //Executa o método main, carregando novamente a tabela e o JFrame, sendo assim atualizado.
	}
public static String Mensagem= "Verifique se os seguintes requisitos: "
		+ "\n*Verifique se o seu computador, aguenta a resolução 800X600, caso não altere isso no código fonte."
		+ "\n*Se o banco de dados existe, ou se o MySQL está instalado e configurado na porta TCP correta."
		+ "\n*Se o usuário e se senha correspondem ao do banco de dados."
		+ "\n*Se existe algum banco com o nome estipulado, com base no arquivo 'hibernate.cfg.xml'."
		+ "\n*Se a versão do java é ao menos a versão 6, recomenda-se o Jre 7 ou superior"
		+ "\n*Caso o Sistema seja um GNU/linux, não esqueça de informar a porta TCP na url do arquivo 'hibernate.cfg.xml'"
		+ "\n*Caso seja um Windows, verifique se existe justamente o TCP informado na url, isso é um requisito exclusivo do GNU/Linux"
		+ "\n*Tente recompilar novamente o programa, a caso da insistência de erros, levando em consideração as informações acimas. ";	
}	

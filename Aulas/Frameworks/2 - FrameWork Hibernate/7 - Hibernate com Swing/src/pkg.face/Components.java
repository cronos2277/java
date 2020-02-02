package pkg.face;
import pkg.entidade.Entidade;
import pkg.main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Components {
public JLabel label_nome = new JLabel("Nome: "); //Pode ser instaciada sem par�meto ou com uma String.
public JTextField text_nome = new JTextField(20);
public JLabel label_funcao = new JLabel("Fun��o: ");
public JTextField text_funcao = new JTextField(20);
public JButton edit = new JButton("Modificar!");
public JButton del = new JButton("Excluir!");
/*Se faz necess�rio a instancia��o desse objeto. Esse objeto corresponde a classe,
ao qual se t�m os m�todos action Lister e MouseAdapter. Esse objeto ser� usado como par�metro
nos action Listener e no caso no mouse adapter tamb�m*/
public Action listener = new Action(); 

//Adicionando
public JLabel label_new_name = new JLabel("Novo nome: ");
public JTextField text_new_nome = new JTextField("Novo Nome",20); //Pode ser iniciada sem par�metro, com um ou com os dois par�metros, mas deve ser nessa ordem.
public JLabel label_new_func = new JLabel("Nova Func�o: ");
/*A String se refere ao valor inicial do objeto, ou seja o texto que ele exibe quando carregado, o inteiro a capacidade dele em largura para a exibi��o de caract�res.
No caso ele mostra 20 caracteres na tela, se acaso o nome tiver 21 caract�res o primeiro � ocultado da visuali��o, mas ainda assim computado.*/
public JTextField text_new_func = new JTextField("Nova Fun��o",20); 
public JButton button_new = new JButton("Adicionar!"); //No caso de um JButton a String se refere ao seu nome.
class Action extends MouseAdapter implements ActionListener { //No caso eu n�o quiz implementar todos os m�todos do Mouse Listener, ent�o eu extendi o MouseAdapter, ambas possui a mesma utilidade, mas quando extende n�o se torna obrigat�ria a implementa��o de todos os m�todos.
Entidade entidade;
int id = 0;
String nome = "null";
String funcao = "null";
String edt_nome = "null";
String edt_funcao = "null";
	@Override
	public void actionPerformed(ActionEvent evento) {	
	if(evento.getSource() == button_new){
		System.out.println("Pessionado adicionar!");
		if(nome != "null" && funcao != "null"){
		new Methods().SalvarEntidade(nome, funcao);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		Order.Refresh();
		}
		else if(nome == "null"){JOptionPane.showMessageDialog(null, "O campo Nome est� nulo! Ap�s informar o campo 'Nome', pressione enter para confirmar.");}
		else if(funcao == "null"){JOptionPane.showMessageDialog(null, "O campo Func�o, est� nulo! Ap�s informar o campo 'Fun��o', pressione enter para confirmar.");}
	}
	if(evento.getSource() == text_new_nome){
		nome = String.format("%s", evento.getActionCommand());
		JOptionPane.showMessageDialog(null, "Nome �: "+nome);
	}
	if(evento.getSource() == text_new_func){
		funcao = String.format("%s", evento.getActionCommand());
		JOptionPane.showMessageDialog(null, "Fun��o �: "+funcao);
	}
	if(evento.getSource() == text_nome){
		edt_nome = String.format("%s", evento.getActionCommand());
		JOptionPane.showMessageDialog(null, "O novo Nome �: "+edt_nome);
	}
	if(evento.getSource() == text_funcao){
		edt_funcao = String.format("%s", evento.getActionCommand());
		
		JOptionPane.showMessageDialog(null, "A nova Fun��o �: "+edt_funcao);
	}
	if(evento.getSource() == del){
		if(id > 0){
			new Methods().ExcluirEntidade(id);
			JOptionPane.showMessageDialog(null, "Exclu�do com Sucesso!");
			Order.Refresh();
		}else{JOptionPane.showMessageDialog(null, "Selecione um campo, antes de excluir");}
	}
	if(evento.getSource() == edit){
		if(id > 0){
			if(edt_nome == "null"){edt_nome = entidade.getNome();}
			if(edt_funcao == "null"){edt_funcao = entidade.getFuncao();}
			new Methods().EditarEntidade(id, edt_nome, edt_funcao);
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
			Order.Refresh();
		}else{JOptionPane.showMessageDialog(null, "Selecione um campo, para ser modificado");};
	}	
	}	
	@Override
	public void mouseClicked(MouseEvent evento){ //M�todo mouseClicked, � acionado uma vez que se se obtem um clique completo. Esse m�todo � acionado quando a tabela recebe um clique do mouse, como definido no mouseListener l� no m�todo Main. No caso esse m�todo trata o evento.		
			int row = Order.Tabela.getSelectedRow(); //Aqui, esse m�todo retona um inteiro, correspondente a coluna que voc� clicou. O cabe��rio no caso de uma JTable n�o conta, no entanto o inteiro come�a no zero e vai at� o numero de elementos que a tabela tiver. Conta o tamanho menos 1, igual se faz com array.
			entidade = Order.ListaEntidades.get(row); //Neste caso o valor de row, corresponde a posi��o do Objeto dentro do List. Por favor n�o confunda isto com o ID da entidade, essa � apenas a posi��o dentro do List<>. Para que voc� recupere um valor dentro do List<>, voc� tem que informar a posi��o dele dentro do m�todo get().
			text_nome.setText(entidade.getNome()); //O m�todo setText(). Esse m�todo imp�e determinado texto, dento do Objeto JTextField(). Se um JTextField, est� com o texto vazio, esse m�todo ele define como valor, a String definida ali dentro. 
			text_funcao.setText(entidade.getFuncao());
			id = entidade.getId();
			System.out.println(row);			
	}
	

}
}
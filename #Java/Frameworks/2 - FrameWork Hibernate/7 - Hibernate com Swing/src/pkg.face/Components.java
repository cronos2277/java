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
public JLabel label_nome = new JLabel("Nome: "); //Pode ser instaciada sem parâmeto ou com uma String.
public JTextField text_nome = new JTextField(20);
public JLabel label_funcao = new JLabel("Função: ");
public JTextField text_funcao = new JTextField(20);
public JButton edit = new JButton("Modificar!");
public JButton del = new JButton("Excluir!");
/*Se faz necessário a instanciação desse objeto. Esse objeto corresponde a classe,
ao qual se tém os métodos action Lister e MouseAdapter. Esse objeto será usado como parâmetro
nos action Listener e no caso no mouse adapter também*/
public Action listener = new Action(); 

//Adicionando
public JLabel label_new_name = new JLabel("Novo nome: ");
public JTextField text_new_nome = new JTextField("Novo Nome",20); //Pode ser iniciada sem parâmetro, com um ou com os dois parâmetros, mas deve ser nessa ordem.
public JLabel label_new_func = new JLabel("Nova Funcão: ");
/*A String se refere ao valor inicial do objeto, ou seja o texto que ele exibe quando carregado, o inteiro a capacidade dele em largura para a exibição de caractéres.
No caso ele mostra 20 caracteres na tela, se acaso o nome tiver 21 caractéres o primeiro é ocultado da visualição, mas ainda assim computado.*/
public JTextField text_new_func = new JTextField("Nova Função",20); 
public JButton button_new = new JButton("Adicionar!"); //No caso de um JButton a String se refere ao seu nome.
class Action extends MouseAdapter implements ActionListener { //No caso eu não quiz implementar todos os métodos do Mouse Listener, então eu extendi o MouseAdapter, ambas possui a mesma utilidade, mas quando extende não se torna obrigatória a implementação de todos os métodos.
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
		else if(nome == "null"){JOptionPane.showMessageDialog(null, "O campo Nome está nulo! Após informar o campo 'Nome', pressione enter para confirmar.");}
		else if(funcao == "null"){JOptionPane.showMessageDialog(null, "O campo Funcão, está nulo! Após informar o campo 'Função', pressione enter para confirmar.");}
	}
	if(evento.getSource() == text_new_nome){
		nome = String.format("%s", evento.getActionCommand());
		JOptionPane.showMessageDialog(null, "Nome é: "+nome);
	}
	if(evento.getSource() == text_new_func){
		funcao = String.format("%s", evento.getActionCommand());
		JOptionPane.showMessageDialog(null, "Função é: "+funcao);
	}
	if(evento.getSource() == text_nome){
		edt_nome = String.format("%s", evento.getActionCommand());
		JOptionPane.showMessageDialog(null, "O novo Nome é: "+edt_nome);
	}
	if(evento.getSource() == text_funcao){
		edt_funcao = String.format("%s", evento.getActionCommand());
		
		JOptionPane.showMessageDialog(null, "A nova Função é: "+edt_funcao);
	}
	if(evento.getSource() == del){
		if(id > 0){
			new Methods().ExcluirEntidade(id);
			JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
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
	public void mouseClicked(MouseEvent evento){ //Método mouseClicked, é acionado uma vez que se se obtem um clique completo. Esse método é acionado quando a tabela recebe um clique do mouse, como definido no mouseListener lá no método Main. No caso esse método trata o evento.		
			int row = Order.Tabela.getSelectedRow(); //Aqui, esse método retona um inteiro, correspondente a coluna que você clicou. O cabeçário no caso de uma JTable não conta, no entanto o inteiro começa no zero e vai até o numero de elementos que a tabela tiver. Conta o tamanho menos 1, igual se faz com array.
			entidade = Order.ListaEntidades.get(row); //Neste caso o valor de row, corresponde a posição do Objeto dentro do List. Por favor não confunda isto com o ID da entidade, essa é apenas a posição dentro do List<>. Para que você recupere um valor dentro do List<>, você tem que informar a posição dele dentro do método get().
			text_nome.setText(entidade.getNome()); //O método setText(). Esse método impõe determinado texto, dento do Objeto JTextField(). Se um JTextField, está com o texto vazio, esse método ele define como valor, a String definida ali dentro. 
			text_funcao.setText(entidade.getFuncao());
			id = entidade.getId();
			System.out.println(row);			
	}
	

}
}
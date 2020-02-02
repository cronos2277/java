//O método .isSelected() retorna true caso o checkbox teja marcado, false se não estiver.
//O método .getSelectedItem() retorna um objeto, com o array que o JComboxBox está selecionado;
//O método .getSelectedItem()+"" dai ao invés de retornar um Object, retorna uma string.
//depois de digitar cada dado nos campos pressione enter. Tem que aparecer uma janela informando o que você digitou.
//Se não o programa não vai resgistrar.
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class checkboxEjcomboboxExercicio{
	public static void main(String [] args){
	int width = 100;
	int height = 100;
	complementos comp = new complementos();
	Tarjas tarja = new Tarjas();
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame janela = new JFrame("Cadastro");
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.setSize(900, 250);
	janela.getContentPane().setLayout(new GridLayout(8,2));
	
	//Linha de funcionamento dos campus.
	comp.arquivo.addActionListener(comp.l);
	comp.nome.addActionListener(comp.l);
	comp.cidade.addActionListener(comp.l);
	comp.idade.addActionListener(comp.l);
	comp.funcao.addActionListener(comp.l);
	comp.salvar.addActionListener(comp.l);
	
	//Linha do arquivo para carregar.
	comp.arquivo.setSize(width,height);
	janela.getContentPane().add(tarja.arquivo);
	tarja.arquivo.setSize(width, height);
	janela.getContentPane().add(comp.arquivo);
	
	//Linha dos dados dos Nomes.
	comp.nome.setSize(width, height);
	janela.getContentPane().add(tarja.nome);
	tarja.nome.setSize(width, height);
	janela.getContentPane().add(comp.nome);
	
	//Linha da cidade.
	comp.cidade.setSize(width, height);
	janela.getContentPane().add(tarja.cidade);
	tarja.cidade.setSize(width, height);
	janela.getContentPane().add(comp.cidade);
	
	//Linha da idade.
	tarja.idade.setSize(width, height);
	comp.idade.setSize(width, height);
	janela.getContentPane().add(tarja.idade);
	janela.getContentPane().add(comp.idade);
	
	//Linha do Gênero.
	tarja.sexo.setSize(width, height);
	comp.sexo.setSize(width, height);
	janela.getContentPane().add(tarja.sexo);
	janela.getContentPane().add(comp.sexo);
	
	//Linha da funcao.
	tarja.funcao.setSize(width, height);
	comp.funcao.setSize(width, height);
	janela.getContentPane().add(tarja.funcao);
	janela.getContentPane().add(comp.funcao);
	
	//Linha do fumante.
	tarja.fumante.setSize(width, height);
	comp.fumante.setSize(width, height);
	janela.getContentPane().add(tarja.fumante);
	janela.getContentPane().add(comp.fumante);
	
	//Setando os Botões
	comp.reset.setSize(width, height);
	comp.salvar.setSize(width, height);
	janela.getContentPane().add(comp.reset);
	janela.getContentPane().add(comp.salvar);
		}
	}

class complementos{
	String[] Sexo = {"Defina o sexo","Gênero Masculino", "Gênero Feminino"};
	//Cmomponentes.
	JTextField arquivo = new JTextField("NovoArquivo",20);
	JTextField nome = new JTextField(50);
	JTextField cidade = new JTextField(30);
	JTextField idade = new JTextField(3);
	JComboBox sexo = new JComboBox(Sexo);
	JTextField funcao = new JTextField(30);
	JCheckBox fumante = new JCheckBox("Marque sim, caso seja fumante.");
	JButton salvar = new JButton("Salvar");
	JLabel reset = new JLabel("PRESSIONE ENTER NOS CAMPOS, DEPOIS DE DIGITAR!");
	metodos l = new metodos();
	
	private class metodos implements ActionListener{
		String Arquivo = "NovoArquivo";
		String Nome = "";
		String Cidade = "";
		String Idade = "";
		String Funcao = "";
		int id;
		String cigarro;
		
	public void actionPerformed(ActionEvent evento){
	   if(evento.getSource()==arquivo){
		   Arquivo = String.format("%s", evento.getActionCommand());
		   JOptionPane.showMessageDialog(null,"O nome do arquivo a ser salvo, será '"+Arquivo+".txt'");
	   }else if(evento.getSource()==nome){
		   Nome = String.format("%s", evento.getActionCommand());
		   JOptionPane.showMessageDialog(null, "O Nome é: "+Nome);
	   }else if(evento.getSource()==cidade){
		   Cidade = String.format("%s", evento.getActionCommand());
		   JOptionPane.showMessageDialog(null,"A Cidade é: "+Cidade);
	   }else if(evento.getSource()==idade){
		   try{
			id = Integer.parseInt(String.format("%s", evento.getActionCommand()));
			Idade = Integer.toString(id);
			JOptionPane.showMessageDialog(null, "A idade é: "+Idade);
		   }catch(Exception e){JOptionPane.showMessageDialog(null,"Erro! o valor digitado, é inválido!");}
	   }else if(evento.getSource()==funcao){
		   Funcao = String.format("%s", evento.getActionCommand());
		   JOptionPane.showMessageDialog(null, "Profissão: "+Funcao);
	   }else if(evento.getSource()==salvar){
		 if(Arquivo == ""){Arquivo = "NovoArquivo";}
		 if(Funcao == ""){Funcao = "Cliente Desempregado";}
		 if(Nome != "" && Cidade != "" && Idade != "" && sexo.getSelectedItem() != Sexo[0] && id >= 0){
			 if(fumante.isSelected()){ //Função que retorna um Boolean, se estiver ou não marcada.
			 cigarro = "Cliente Fumante.";}
			 else{
			 cigarro = "Não Fumante.";}
			 File file = new File(Arquivo+".txt");
			 try{
			 file.createNewFile();
			 FileWriter fw = new FileWriter(Arquivo);
			 BufferedWriter buffer = new BufferedWriter(fw);
			 buffer.write("\n\nNome: "+Nome+"\nCidade: "+Cidade+"\nIdade: "+Idade+"\nSexo: "+sexo.getSelectedItem()+""+"\nFunção: "+Funcao+"\n"+cigarro);
			 buffer.close();
			 fw.close();
			 }catch(Exception e){JOptionPane.showMessageDialog(null,"Erro! ao criar o arquivo: "+Arquivo+".txt");}
			  }else{JOptionPane.showMessageDialog(null,"Nome cidade e Idade, são campos obrigatórios, Além disso informe corretamente o sexo do cliente");}
		 
			 
	   }
		
			
			
		}
	}
}
class Tarjas{
	JLabel arquivo = new JLabel("Nome do Arquivo, que irá conter os dados: ");
	JLabel nome = new JLabel("Qual é o nome completo do cliente?");
	JLabel cidade = new JLabel("Qual é a cidade natal do cliente? ");
	JLabel idade = new JLabel("Quantos anos tem o cliente? (Apenas numeros inteiros)");
	JLabel sexo = new JLabel("Qual é o gênero do cliente?");
	JLabel funcao = new JLabel("Qual é a profissão do cliente? ");
	JLabel fumante = new JLabel("O Cliente é fumante? ");
}



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PrimeiroProgramaGrafico{
	public static void main(String [] args){
		definicao def = new definicao();
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame janela = new JFrame("Janela");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(800,600);
		janela.setLocationRelativeTo(null);
		
		//Quando o objeto é instanciado é bom colocar depois de carregar o JFrame
		//Se os componentes tivessem na mesma classe seria bom antes.
		//Isso evita, o bug da Janela vazia, que só carrega os componentes quando maximiniza.
		//
		//Adicionando componentes da classe definição.
		def.texto.setText("SemNome"); //Setando JButton da classe definicao
		def.salvar.setText("Salvar");
		def.add(def.texto); //adicionando o JButton.
		def.texto.addActionListener(def.acao); //Implementando comandos usando o objeto acao como parametro.
		def.campo.addActionListener(def.acao);
		def.salvar.addActionListener(def.acao);
		janela.getContentPane().setLayout(new BorderLayout());
		janela.getContentPane().add(def.texto,BorderLayout.NORTH);
		janela.getContentPane().add(def.campo,BorderLayout.CENTER);
		janela.getContentPane().add(def.salvar,BorderLayout.SOUTH);
	}
}

class definicao extends JFrame{
	JTextField texto = new JTextField();
	JTextField campo = new JTextField();
	JButton salvar = new JButton();
	Acao acao = new Acao();
	
	
	private class Acao implements ActionListener{ //classe usada para definir ações para os botões.
		String str = "SemNome";
		 String stx = "";
		//Obrigatório a implementacao do ActionListener
		 public void actionPerformed(ActionEvent evento){ 
			 		 
			 if (evento.getSource()==texto){ 
				 //um if booleano, a função getSource, retorna um boolean,
				 //caso o objeto setado seja o mesmo do verificador da função
				 
				 str = String.format("%s", evento.getActionCommand()); //Função String.format(String, object)
				 //getActionCommand, retorna os valores das ações dos componentes, por exemplo o texto
				 //digitado dentro de um JTextField.
				 JOptionPane.showMessageDialog(null,"Nome alterado para:"+str);
				 }else if (evento.getSource()==campo){ 
					 stx = String.format("%s", evento.getActionCommand()); 
					 JOptionPane.showMessageDialog(null,"Você Digitou:\n\n"+stx);
				 }else if (evento.getSource()==salvar){
					try{
					File arquivo = new File(str+".txt");	
					FileWriter file = new FileWriter(arquivo);
					BufferedWriter buffer = new BufferedWriter(file);
					buffer.write("Nome do Arquivo: "+str+"\n\n\n!!!CONTEÚDO DO ARQUIVO!!!\n\n\n"+stx);
					buffer.close();
					file.close();
					}catch(Exception e){}
					 
					 
					 
				 }
		 }
		}
	
}
//Esse programa, cria um arquivo .txt, com o nome em base no que foi digitado no primeiro JTextField, e contendo o nome no cabeçalho
//Mais o conteúdo do texto, uma clicado em salvar. Esse programa é um programa gráfico, decorado pelo swing.


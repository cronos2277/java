package br.com.treinaweb.parte1;
import java.awt.*;
import javax.swing.*;
public class exemploFlow{
	public static void main(String [] args){
		//Declarando o visual do Frame
		JFrame.setDefaultLookAndFeelDecorated(true);//Aqui mexe no visual da Janela,
		//desabilitando esta linha, é o decorador do sistema que decora a janela.
		
		//criando a Janela e os botões.
		JFrame janela = new JFrame("Minha Janela");
		JButton bt1 = new JButton("Botão 1");
		JButton bt2 = new JButton("Botão 2");
		JButton bt3 = new JButton("Botão 3");
		JButton bt4 = new JButton("Botão 4");
		//definições da Janela.
		janela.setSize(1024,768);
		janela.setLocation(0,0);
		janela.setVisible(true);
		
		//Este aqui é o decorador, que poẽ os botões em ordem.
		janela.getContentPane().setLayout(new FlowLayout());//alinhado no cento e 
		//na parte superior da Janela.
		
		//Método para fechar a janela, e encerrar todas as atividades.
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//com este método, a janela
		//sendo fechada o programa deixa de funcionar. Veja que quando o programa abre,
		//exibe uma mensagem na tela, mais graças a este método ao fechar a janela, fecha
		//a interface gráfica também.
		
		//adicionando botões na Janela.
		janela.add(bt1);
		janela.add(bt2);
		janela.add(bt3);
		janela.add(bt4);
		
		while(true){
			System.out.println("Mensagem.");
			//Obs: esse programa só funciona no ambiente integrado do Eclipse, javac
			//talvez não rode.
		}
	}
}

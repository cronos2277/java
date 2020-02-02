package br.com.treinaweb.parte1;
import java.awt.*;
import javax.swing.*;
public class gridFlow{
	public static void main(String [] args){
		JButton bt1 = new JButton("Botão 1");
		JButton bt2 = new JButton("Botão 2");
		JButton bt3 = new JButton("Botão 3");
		JButton bt4 = new JButton("Botão 4");
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame janela = new JFrame("Exemplo de Grid");
		janela.setSize(1024,768);
		janela.setLocation(0, 0);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(new GridLayout(2,2));//(2,2)==>(Vertical,horizontal).
		//O parâmetro decide a ordem dos botões, o primeiro quanto na vertical,
		//O segundo quanto na horizontal. Os botões ocupam a janela toda.
		janela.getContentPane().add(bt1);
		janela.getContentPane().add(bt2);
		janela.getContentPane().add(bt3);
		janela.getContentPane().add(bt4);
		while(true){
			System.out.println("Mensagem.");
			//Obs: esse programa só funciona no ambiente integrado do Eclipse, javac
			//talvez não rode.
		}
	}
}
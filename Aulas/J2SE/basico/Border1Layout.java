package br.com.treinaweb.parte1;
import java.awt.*;
import javax.swing.*;
public class Border1Layout{
	public static void main(String [] args){
		JFrame janela = new JFrame("Exemplo BorderLayout");
		janela.setVisible(true);
		janela.setSize(1024,768);
		janela.setLocation(0, 0);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JButton bt1 = new JButton("Botão CENTER");
		JButton bt2 = new JButton("Botão SOUTH");
		JButton bt3 = new JButton("Botão NORTH");
		JButton bt4 = new JButton("Botão WEST");
		JButton bt5 = new JButton("Botão EAST");
		
		janela.getContentPane().setLayout(new BorderLayout());
		
		//posição dos botões. O centro é o maior, leste e oeste são médios e o Norte sul pequenos.
		//janela.getContentPane().add(o objeto, a posição na tela).
		janela.getContentPane().add(bt1,BorderLayout.CENTER);
		janela.getContentPane().add(bt2,BorderLayout.SOUTH);
		janela.getContentPane().add(bt3,BorderLayout.NORTH);
		janela.getContentPane().add(bt4,BorderLayout.WEST);
		janela.getContentPane().add(bt5,BorderLayout.EAST);
		while(true){
			System.out.println("Mensagem.");
			//Obs: esse programa só funciona no ambiente integrado do Eclipse, javac
			//talvez não rode.
		}
	}
}
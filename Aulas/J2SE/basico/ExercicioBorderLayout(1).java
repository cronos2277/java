package br.com.treinaweb.parte1;
import javax.swing.*;
import java.awt.*;
public class ExercicioBorderLayout{
		
	public static void main(String [] args){
	
		//criando Janelas.
	JFrame janela = new JFrame("Minha Janela");
	janela.setVisible(true);
	janela.setSize(1024,768);
	janela.setLocation(0,0);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//definições da Janela.
	JFrame.setDefaultLookAndFeelDecorated(true);
	janela.getContentPane().setLayout(new BorderLayout());
	
	//criando Botões.
	JButton botao1 = new JButton("Botao 1");
	JButton botao2 = new JButton("Botao 2");
	JButton botao3 = new JButton("Botao 3");
	JButton botao4 = new JButton("Botao 4");
	JButton botao5 = new JButton("Botao 5");
	
	//Definindo posições dos botões.
	janela.getContentPane().add(botao1, BorderLayout.NORTH);
	janela.getContentPane().add(botao2, BorderLayout.SOUTH);
	janela.getContentPane().add(botao3, BorderLayout.CENTER);
	janela.getContentPane().add(botao4, BorderLayout.EAST);
	janela.getContentPane().add(botao5, BorderLayout.WEST);
	
	}
}

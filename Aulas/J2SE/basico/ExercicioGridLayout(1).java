package br.com.treinaweb.parte1;
import javax.swing.*;
import java.awt.*;
public class ExercicioGridLayout{
	public static void main(String [] args){
		//Janela
		
		JFrame janela = new JFrame("GridLayout");
		janela.setVisible(true);
		janela.setSize(1024,760);
		janela.setLocation(0,0);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setDefaultLookAndFeelDecorated(true);
		
		//Botões.
		JButton botao1 = new JButton("Botão 1");
		JButton botao2 = new JButton("Botão 2");
		JButton botao3 = new JButton("Botão 3");
		JButton botao4 = new JButton("Botão 4");
		
		janela.getContentPane().setLayout(new GridLayout(4,1));
		//janela.getContentPane().setLayout(new GridLayout(Botões na vertical, botões na horizontal));
		//janela.getContentPane().setLayout(new GridLayout()); a função pode ser inscrita sem
		//parametros. ficando os botões na horizontal, e ocupando toda a tela.
		janela.getContentPane().add(botao1);
		janela.getContentPane().add(botao2);
		janela.getContentPane().add(botao3);
		janela.getContentPane().add(botao4);
		
		
	}
}

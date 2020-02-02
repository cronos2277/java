package br.com.treinaweb.parte1;
import javax.swing.*;
import java.awt.*;

public class ExercicioFlowLayout{
public static void main(String [] args){
	JFrame janela = new JFrame("FlowLayout");
	janela.setVisible(true);
	janela.setSize(800,600);
	janela.setLocation(0,0);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	JButton botao1 = new JButton("Botão 1");
	JButton botao2 = new JButton("Botão 2");
	JButton botao3 = new JButton("Botão 3");
	JButton botao4 = new JButton("Botão 4");
	
	JFrame.setDefaultLookAndFeelDecorated(true);
	janela.getContentPane().setLayout(new FlowLayout());
	//Tambem poderia ser janela.getContentPane().setLayout(new FlowLayout(0,Espaçamento,Eixo y));
	//esse pelo menos não precisa adicionar pelo getContentPane().
	//A função acima pode ser uma void ou ser implementada com três valores Integer.
	
	janela.add(botao1);
	janela.add(botao2);
	janela.add(botao3);
	janela.add(botao4);
}
	
}

package br.com.treinaweb.parte2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //Mesmo importando todo o java.awt, essa classe é obrigada a ser importada.
import java.awt.event.ActionListener; //Mesmo importando todo o java.awt, essa classe é obrigada a ser importada.
public class TesteKeyListener{
	public static void main(String [] args){
	Teclado teclado = new Teclado();//Instanciando a classe Teclado, que será usada como parâmetro.
	JFrame janela = new JFrame("Minha Janela.");
	janela.setVisible(true);
	janela.setSize(300, 300);
	janela.setLocationRelativeTo(null);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.addKeyListener(teclado); //Adicionando o componente KeyListener na Janela.
		
	}
}

class Teclado implements KeyListener{
public void keyPressed(KeyEvent evento){ //Esse método diz respeito das ações, caso uma tecla seja pressionada.
	//use os IF para definir o que cala tecla faz.
	JOptionPane.showMessageDialog(null, evento);
}
public void keyReleased(KeyEvent evento){}
public void keyTyped(KeyEvent evento){}
}

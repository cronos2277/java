package br.com.treinaweb.parte1;
 import java.awt.*;
 import javax.swing.*;

 
public class formulario{
public static void main(String [] args){
	String [] lista1 = new String [2];
	lista1[0] = "primeira opção Combo Box";
	lista1[1] = "Segunda opção  Combo Box";
	String[] lista2 = new String [2];
	lista2[0] = "primeira opção Lista";
	lista2[1] = "primeira opção Lista";
	JPanel painel = new JPanel();
	JLabel tarja = new JLabel("Label");//palavras a serem exibidas na tela.
	JTextField texto = new JTextField("Campo para textos"); //campo para texo, void caso queiro o campo em branco
	JButton botao = new JButton("Botão"); //Botão comum.
	JCheckBox caixa = new JCheckBox("Check Box"); //Check Box trabalha com booleano
	JRadioButton radio = new JRadioButton("Botão Radio"); //Botão com opções
	JComboBox combo = new JComboBox(lista1); //Caixa com opções, só aceita arrays do tipo String como parâmetro.
	JList listad = new JList(lista2);//Lista com opções, só aceita arrays do tipo String como parâmetro.
	
	painel.add(tarja);
	painel.add(texto);
	painel.add(botao);
	
	JFrame janela = new JFrame("Janela");
	janela.setVisible(true);
	janela.setSize(10274,768);
	janela.setLocationRelativeTo(null);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.getContentPane().setLayout(new GridLayout(2,2));
	janela.getContentPane().add(painel);
	janela.getContentPane().add(tarja);
	janela.getContentPane().add(texto);
	janela.getContentPane().add(botao);
	janela.getContentPane().add(caixa);
	janela.getContentPane().add(radio);
	janela.getContentPane().add(combo);
	janela.getContentPane().add(listad);
	
		}
	
	}
//Ai está todos os componentes básicos do Javax, menu entre outros fica para a próxima.
 
      
      
      
 

package br.com.treinaweb.parte1;
import javax.swing.*;

import java.awt.*;

 

public class ExemploGridBagLayout extends JFrame {

 

    private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8;

   

    public ExemploGridBagLayout(){

        super("Exemplo de GridBagLayout");

    }

   

    public void AdicionaItem(int Linha, int Coluna, int Largura, int Altura, int EscalaX, int EscalaY, JComponent componente){

        GridBagConstraints ItemGrade = new GridBagConstraints();

        ItemGrade.gridx = Coluna;

        ItemGrade.gridy = Linha;

        ItemGrade.gridwidth = Largura;

        ItemGrade.gridheight = Altura;

        ItemGrade.weightx = EscalaX;

        ItemGrade.weighty = EscalaY;

        ItemGrade.fill = GridBagConstraints.BOTH;

        ItemGrade.anchor = GridBagConstraints.CENTER;

        getContentPane().add(componente, ItemGrade);

    }

   

    public void ExecutaGrid(){

       

        bt1 = new JButton("Botão 1");

        bt2 = new JButton("Botão 2");

        bt3 = new JButton("Botão 3");

        bt4 = new JButton("Botão 4");

        bt5 = new JButton("Botão 5");

        bt6 = new JButton("Botão 6");

        bt7 = new JButton("Botão 7");

        bt8 = new JButton("Botão 8");

       

        setSize(500,300);

        setLocation(200,200);

        setLayout(new GridBagLayout());

       

        AdicionaItem(0,0,4,1,0,0,bt1);

        AdicionaItem(1,0,1,1,0,0,bt2);

        AdicionaItem(1,1,1,1,0,0,bt3);

        AdicionaItem(1,2,1,1,0,0,bt4);

        AdicionaItem(1,3,1,1,0,0,bt5);

        AdicionaItem(2,0,1,1,0,1,bt6);

        AdicionaItem(3,0,1,1,0,1,bt7);

        AdicionaItem(2,1,3,4,1,1,bt8);

       

        setVisible(true);

    }

   

    public static void main(String[] args){

        JFrame.setDefaultLookAndFeelDecorated(true);

        new ExemploGridBagLayout().ExecutaGrid();

    }

}




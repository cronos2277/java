import javax.swing.*;
public class janelaSimples{
public static void main(String [] args){
JFrame janela = new JFrame();
janela.setSize(800,600); //Tamanho da Janela
janela.setLocation(800,600); //Local aonde a janela, aparecerá.
janela.setTitle("Minha Java Janela"); //Título da Janela.
janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //O que fazer quando sair.
janela.setVisible(true); //Se a janela ficará visível.
}
}
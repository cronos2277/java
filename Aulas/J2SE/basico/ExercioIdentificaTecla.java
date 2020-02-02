import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;

public class ExercioIdentificaTecla{
public static void main(String [] args){
JFrame janela = new JFrame("O programa diz que tecla você pressionou.");
janela.setVisible(true);
janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
janela.setSize(200,200);
janela.setLocationRelativeTo(null);
Teclado teclado = new Teclado();
janela.addKeyListener(teclado);
}
}

class Teclado implements KeyListener{
public void keyPressed(KeyEvent evento){
int temp1 = evento.getKeyCode(); //Essa função retorna o valor númerico em integer da tecla.
String temp2 = evento.getKeyText(temp1); //Converte um valor Integer em uma tecla.
JOptionPane.showMessageDialog(null,"A tecla que você digitou: "+temp2);
}
public void keyTyped(KeyEvent evento){}
public void keyReleased(KeyEvent evento){}
}
//A classe KeyListener, no método keyPressed, pega o valor da tecla do Objeto KeyEvent e converte para um
//Integer no método .getKeyCode(), depois usamos o método .getKeyText(usando o valor do .getKeyCode), como
//Parametro, para descobrir que tecla foi pressionada. Os nomes são apresentados e escritos na String em
//Português Brasil.
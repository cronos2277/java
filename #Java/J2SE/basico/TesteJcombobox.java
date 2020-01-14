import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //Essa tem que importar de qualquer jeito.
import java.util.ArrayList;

public class TesteJcombobox{
public static void main(String [] args){
Componentes comp = new Componentes();
JFrame janela = new JFrame("Combo Box");
janela.setVisible(true);
janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
janela.setSize(400,400);
janela.setLocationRelativeTo(null);

comp.botao.addActionListener(comp.acao); //Adicionando funcionabilidade aos botões na janela.
janela.getContentPane().setLayout(new GridLayout(3,1));
janela.getContentPane().add(comp.label);
janela.getContentPane().add(comp.combo);
janela.getContentPane().add(comp.botao); 
}
}

class Componentes{
	
String [] str = {"Opção padrão","Primeira Opção","Segunda Opção"}; //Fora do método main, é só dessa forma para preencher array.
 	JComboBox combo = new JComboBox(str); 
	JLabel label = new JLabel("Escolha uma opção e de okey");
	JButton botao = new JButton("Okey");
Acao acao = new Acao();

private class Acao implements ActionListener{
public void actionPerformed(ActionEvent evento){
if(evento.getSource()==botao){
if(combo.getSelectedItem()==str[0]) //A função .getSelectedItem() retorna o array que está selecionado na JComboBox.
JOptionPane.showMessageDialog(null,"Selecionado Opçao Zero");
if(combo.getSelectedItem()==str[1])
JOptionPane.showMessageDialog(null,"Selecionado Opçao Um");
if(combo.getSelectedItem()==str[2])
JOptionPane.showMessageDialog(null,"Selecionado Opçao Dois");
}
}


	
}


}

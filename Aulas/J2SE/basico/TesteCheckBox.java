import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TesteCheckBox{
public static void main (String [] args){
Componentes comp = new Componentes(); //O primeiro objeto a ser instanciado, para evitar o bug do maximinizar.
JFrame janela = new JFrame("Conhecendo o CheckBox");
janela.setSize(400,100);
janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
janela.setLocationRelativeTo(null);
janela.setVisible(true);
comp.check.addActionListener(comp.acao); //é assim que é adicionado funcionalidade aos componentes.
comp.certo.addActionListener(comp.acao);//Repare que o objeto ação é usado como Parâmetro.
janela.getContentPane().setLayout(new GridLayout(3,1)); //configuração do layout setado como Grid.
janela.getContentPane().add(comp.tarjaC); //Adicionando os componentes na janela.
janela.getContentPane().add(comp.check);
janela.getContentPane().add(comp.certo);
} 
}

class Componentes{
	JLabel tarjaC = new JLabel("Marque a opção do check box e clique em OK"); //Criando um label. 
	JCheckBox check = new JCheckBox("Marque aqui e clique em OK."); //Criando CheckBox
	JButton certo = new JButton("Botão OK.");//Criando Botão
	Acao acao = new Acao(); //A instanciação dessa classe é necessária, aqui aonde está os componentes, ela contém o ActionListener.
private class Acao implements ActionListener{
	
public void actionPerformed(ActionEvent evento){//classe que vai lidar com as ações dos botões.
if(evento.getSource()==certo && check.isSelected()==true){JOptionPane.showMessageDialog(null,"O CheckBox está sim selecionado.");}
else if(evento.getSource()==certo && check.isSelected()==false){JOptionPane.showMessageDialog(null,"O CheckBox não está selecionado");}
//O método .isSelected() retorna true se o check box estiver selecionado, false se não.
// O método .getSource() retorna um objeto, se o nome do objeto for igual ao setado no if, entra no laço.
}

}

}
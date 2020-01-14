import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
public class ExercicioDefinindoTecla{
	public static void main(String [] args){
		Teclado tecla = new Teclado();
		JFrame janela = new JFrame("Mostra o Número que você está dígitando");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setSize(200, 200);
		janela.addKeyListener(tecla);
	}
}
class Teclado implements KeyListener{
	
	public void keyPressed(KeyEvent evento){
	try{
	int hope = Integer.parseInt(evento.getKeyText(evento.getKeyCode()));
	//evento.getKeyCode() ==> Valor numérico da tecla, em integer.
	//evento.getKeyText() ==> Valor numérico da tecla,convertido para uma string.
	//se possivel tirar um número da String.getKeyText, após convertido para String, 
	//é um número, então entra no desvio do switch, caso não cai no catch.
	switch(hope){
	case 0:{JOptionPane.showMessageDialog(null, "Número Zero");break;}
	case 1: {JOptionPane.showMessageDialog(null, "Número Um");break;}
	case 2:{JOptionPane.showMessageDialog(null, "Número Dois");break;} 
	case 3:{JOptionPane.showMessageDialog(null, "Número Três");break;}
	case 4:{JOptionPane.showMessageDialog(null, "Número Quatro");break;}
	case 5:{JOptionPane.showMessageDialog(null, "Número Cinco");break;}	
	case 6:{JOptionPane.showMessageDialog(null, "Número Seis");break;}
	case 7:{JOptionPane.showMessageDialog(null, "Número Sete");break;}
	case 8:{JOptionPane.showMessageDialog(null, "Número Oito");break;}
	case 9:{JOptionPane.showMessageDialog(null, "Número Nove");break;}
	 }
	}catch(Exception e){JOptionPane.showMessageDialog(null, "Pressione apenas as teclas númericas.");}
	}
	public void keyTyped(KeyEvent evento){
		
	}
	public void keyReleased(KeyEvent evento){
		
	}
}


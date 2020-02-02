import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
public class ExercicioKeyTypedEKeyRealeased{
	public static void main(String [] args){
	Teclado tecla = new Teclado();
	JFrame janela = new JFrame("Exibe uma mensagem, se o número > 0");
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setSize(400, 100);
	janela.setLocationRelativeTo(null);
	janela.addKeyListener(tecla);
	}
}
class Teclado implements KeyListener{
	int num;
	public void keyPressed(KeyEvent evento){}
	public void keyTyped(KeyEvent evento){
	//Aqui define o que ocorre, quando uma tecla é pressionada, semelhante ao
	//método keyPresses(KeyEvent e), só é chamado se a tecla for um caractere. 
	//As teclas Fs, Ctrl, Shift, Space, Tab, etc;, não geram uma chamada do keyTyped.
	//JOptionPane.showMessageDialog(null, evento);	
	}
	public void keyReleased(KeyEvent evento){
	//Aqui o processo é o contrário ao do Key Pressed	
	//Aqui é definido quando a tecla é solta.	
	try{
	num = Integer.parseInt(evento.getKeyText(evento.getKeyCode()));
	}catch(Exception e){}
	if(num != 0){
	JOptionPane.showMessageDialog(null, "A tecla de um número, maior que zero, foi solta");
	num = 0;} //Num volta a ter zero do contrário, após o primeiro número apertado,
	//o if perde o controle e exibe a msg para todos.
	}
}





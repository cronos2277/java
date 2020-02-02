import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;

public class ExplicandoMouseWheelListener{
	public static void main(String [] args){
	Eventos eventos = new Eventos(); //Objeto a ser usado como parâmetro no método .addMouseWheelListener(eventos) 
	JFrame janela = new JFrame("Mouse Motion");
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.setSize(800, 600);
	janela.addMouseWheelListener(eventos);	//Comando para implementar o MouseWheelListener.
	//repare que o comando é diferente do AddMouseListener();
	}
}
class Eventos implements  MouseWheelListener{

	
	public void mouseWheelMoved(MouseWheelEvent e) {
		//Aqui é quando a rodinha do mouse é movimentado.
		//Cliques com o botão do meio, já é no MouseListener mesmo.
		//Aqui só é detectado o movimento,da rodinha do mouse.
	System.out.println("Evento ativado: mouseWheelMoved");
	
	
}
}

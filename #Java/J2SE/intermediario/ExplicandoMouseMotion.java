import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class ExplicandoMouseMotion{
	public static void main(String [] args){
	Eventos eventos = new Eventos(); //Objeto a ser usado como parâmetro no método .addMouseMotionListener(eventos) 
	JFrame janela = new JFrame("Mouse Motion");
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.setSize(800, 600);
	janela.addMouseMotionListener(eventos);	//Comando para implementar o MouseMotionListener.
	//repare que o comando é diferente do AddMouseListener();
	}
}
class Eventos implements  MouseMotionListener{

	
	public void mouseDragged(MouseEvent e) {
		System.out.println("Evento ativado: mouseDragged");
		//Aqui quando o mouse é pressionado e movido, entra nesse campo.
		//Ou seja esse é o campo do arrastar, bom se quiser mover objetos no JFrame.
	}

	
	public void mouseMoved(MouseEvent e) {
		System.out.println("Evento ativado: mouseMoved");
		//Aqui entra quando o mouse é movimentado sem ser pressionado, ou seja simplismente movimentado.
		//Aqui é captado o movimento do cursor.
	}
	
}

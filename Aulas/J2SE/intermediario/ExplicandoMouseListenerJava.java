import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ExplicandoMouseListenerJava{
	public static void main(String [] args){
	JFrame janela = new JFrame("Mouse Listener");
	Acao listen = new Acao();
	janela.addMouseListener(listen);
	janela.setVisible(true);
	janela.setLocationRelativeTo(null);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setSize(800, 600);
	}
}
class Acao implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) { //
		System.out.println("Evento ativado: MouseClicked");	
		//O mouseClicked é semelhante ao mousePressed, mais a diferença entre eles é que
		//para entrar neste evento, além de ser pressionado tem que ser solto também.
		//Ou seja mouseClicked = mousePressed + mouseReleased
	}

	@Override
	public void mousePressed(MouseEvent e) { //ativa quando você pressiona o botão do mouse.
		System.out.println("Evento ativado: MousePressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) { //ativa quando o botão do mouse é solto.
		System.out.println("Evento ativado: MouseReleased");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) { 
	//Esse evento é ativado, quando o cursor está no componente
	//Nesse caso no JFrame, que é o que está configurado na classe principal.
		System.out.println("Evento ativado: MouseEntered");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//Esse evento é ativado, quando o cursor está fora do componente
		//Nesse caso no JFrame, que é o que está configurado na classe principal.
		System.out.println("Evento ativado: MouseExited");
		
	}
	/*MouseEnterd e Mouse Exited, são ótimos para alterar a cor de determinado campo, quando se passar o mouse neles.
	 Agora os outros três acima, um é quando solta, o outro quando pressiona, e o clique que é quando faz o movimento 
	 de clique.   */
}

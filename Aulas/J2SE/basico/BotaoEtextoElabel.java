import javax.swing.*;
import java.awt.*;
public class BotaoEtextoElabel{
	public static void main(String [] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame janela = new JFrame("Janela");
		JLabel label = new JLabel("Programa feito em java, código de: BotaoEtextoElabel");
		label.setSize(100,600);
		JTextField texto = new JTextField();
		texto.setSize(600, 600);
		JButton botao = new JButton("Botão comando");
		botao.setSize(100,600);
		janela.setVisible(true);
		janela.setSize(800,600);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(new BorderLayout());
		janela.getContentPane().add(texto, BorderLayout.CENTER);
		janela.getContentPane().add(botao, BorderLayout.SOUTH);
		janela.getContentPane().add(label, BorderLayout.NORTH);
		
	}
}
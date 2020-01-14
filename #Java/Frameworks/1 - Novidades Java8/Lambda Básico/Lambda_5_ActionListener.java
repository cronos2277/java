//Requer o Java 8 ou superior para funcionar.

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Lambda_5_ActionListener {
	public static void main(String args[]){
		JFrame janela = new JFrame("Janela de exemplo");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(800,600);
		JButton botao = new JButton("Aperta o botão sem JOptionPane");
		JButton botao2 = new JButton("Aperta o botão com JOptionPane");
		janela.getContentPane().setLayout(new BorderLayout(2,2));
		janela.getContentPane().add(botao, BorderLayout.NORTH);
		janela.getContentPane().add(botao2, BorderLayout.SOUTH);
		
		//Preste a atenção na linha abaixo, a explicação abaixo se refere a ela.
		botao.addActionListener((ActionEvent e) -> System.out.println("Botão pressionado."));
		botao2.addActionListener((f) -> {System.out.println("Botão pressionado.");JOptionPane.showMessageDialog(null, "Botão pressionado.");});
	}

}
/*				Lambda Java avançado.
 * 	Primeiro vamos analisar a linha: botao.addActionListener((ActionEvent e) -> System.out.println("Botão pressionado."));
 * Muito bem, que tipo de objeto aceita a função addActionListener? Resposta: Um objeto instanciado de uma classe, que contenha
 * uma implementação ActionListener. No caso de uma implementação de uma classe ActionListener, a mesma só tem um método e esta
 * aceita como parâmetro um Objeto ActionEvent. Logo como explicado anteriormente, o objeto Action Event está dentro dos parenteses
 * porque o mesmo é requerito no método ActionPerformed, que é o único método do ActionListener, logo usando esse objeto como parâmetro.]
 * vocẽ pode especificar na lambda que evento vai ocorrer, caso o botão seja pressionado.
 * Perceba, que ali eu não precisei fazer como eu fiz ao instanciar outras interfaces, pois a JVM sabe que o único método que pode ter ali
 * é apenas um ActionPerformed e o mesmo requer um ActionEvent, então assim sendo a JVM interpreta, que o que está dentro dos parenteses do
 * método AddActionListener é de fato um metodo ActionPerformed e que o "e", se trata de um ActionEvent.  
 * 	Agora vamos analisar a linha: botao2.addActionListener((e) -> {System.out.println("Botão pressionado.");JOptionPane.showMessageDialog(null, "Botão pressionado.");});
 * Veja que agora não foi expecíficado que o 'f' é uma ActionEvent, isso acontece porque a JVM já sabe que esse "e", corresponde a um ActionEvent,
 * o que prova a veridicidade do que foi afirmado na linha anterior. Após as seta indicando a lambda, poderia se fosse o caso colocar um if e criar
 * condições por exemplo, ou especificar todo o conteúdo que teria dentro de um metodo ActionPerformed, mas como tem mais de um comando, o mesmo
 * necessita de um ";" para separar, e estar dentro de chaves "{}".
 * 
 * SuaClasse implements ActionListener{
 * public void ActionPerformed(ActionEvent e){
 * 
 * System.out.println("Botão pressionado.");
 * 
 * 	}
 * }
 * Bom o "e" ou o "f" corresponderia a uma representação do ActionEvent.
 * Todo conteúdo após o "->" corresponderia ao conteúdo do método ActionPerformed
 * O Objeto da SuaClasse é usado como parâmetro na hora, que é acionado o método AddActionListener.
 * Nessa hora o mesmo cria o objeto apartir das instruções da lambda e executa a sua função.
 */

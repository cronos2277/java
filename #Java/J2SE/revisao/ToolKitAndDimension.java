import java.awt.Dimension;
import java.awt.Toolkit;

public class ToolKitAndDimension{
	
	public static void main(String[] args){
		Dimension janela = new Dimension();
		Toolkit tool = Toolkit.getDefaultToolkit();		
		janela.setSize(tool.getScreenSize());
		main(janela);
	}
	
	public static void main(Dimension var){
		System.out.printf("A resolução de tela do seu monitor é: %d por %d.",var.width,var.height);
	}	
}
/*								DIMENSION
 * Temos importado a classe Dimension, a dimension ela é uma classe que
 * criptografa a largura e a altura da janela, o seu método setSize()
 * aceita dois valores inteiros correspondente a largura e a altura 
 * respectivamente ou um objeto de dimensão em 2D. É uma classe muito
 * útil quando nós queremos trabalhar com criptografia, envolvendo a
 * biblioteca swing. ela também permite o acesso público aos seus valores
 * caso seja necessário.
 * 
 * 								TOOLKIT
 * Essa classe lida com a parte gráfica do Swing, ela trata o windows e
 * o Linux de maneira diferente, mas isso acontece de baixo dos panos.
 * Você não pode instanciar essa classe, logo você deve pegar uma instancia
 * dela da seguinte forma: Toolkit.getDefaultToolkit(); Aqui nós usamos
 * esse objeto para descobrir a resolução do monitor que o usuário usa
 * através desse método: tool.getScreenSize(); Esse método retorna um
 * objeto do tipo Dimension.	
 * 
 * */

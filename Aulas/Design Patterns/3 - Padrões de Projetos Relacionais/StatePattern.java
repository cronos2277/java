import javax.swing.*;
public class StatePattern{
public static String contexto = "Deseja exibir os resultados usando o Swing?"; 
public static String titulo = "Exibindo valores";
	public static void main(String args[]){
		Bean bean = new Bean();
		bean.setName(JOptionPane.showInputDialog(null,"Informe um nome : "));		
		bean.setAge(JOptionPane.showInputDialog(null,"Informa a idade  : "));
		bean.setCity(JOptionPane.showInputDialog(null,"Informa a cidade: "));
		//Caixa de dialogo, perguntando sim ou não.
		int i = JOptionPane.showConfirmDialog(null,contexto,titulo,JOptionPane.YES_NO_OPTION);
		if(i == 0)
			bean.sysout(true);
		else
			bean.sysout(false);
	}
}

//A interface state, ela implementará um método e será usada para
//tipificar os valores das instancias das classes que implementam esse
//padrão.
interface State{
	public void sysout();	
}

class Bean{
	private String name;
	private int age;
	private String city;
//A Exibição de dados na tela será feita usando o padrão State.
	private State state;	
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(String age){
		try{
			this.age = Integer.parseInt(age);
		}catch(Exception e){e.printStackTrace();}
	}
	
	public void setCity(String city){
		this.city = city;
	}	
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getCity(){
		return this.city;
	}
//Aqui que entra o padrão State. Se verdadeiro a instancia vira um objeto
//tipo Window e o resultado é impresso usando a bibliote Swing, se falso
//o objeto fica do Tipo Prompt e o resultado é exibido em um terminal.
//Por isso é interessante que o tipo seja criado usando a interface ou a
//classe abstrata.
	public void sysout(boolean bool){
		if(bool)
			this.state = new Window(this);
		else
			this.state = new Prompt(this);
		this.state.sysout();
	}
	
}

//Se acionada imprime os resultados usando a bilioteca Swing.
class Window implements State{
	private Bean bean;
	
	public Window(Bean bean){
		this.bean = bean;
	}	
	
	@Override
	public void sysout(){
		JOptionPane.showMessageDialog(null,"Nome  : "+bean.getCity());
		JOptionPane.showMessageDialog(null,"Idade : "+bean.getAge());
		JOptionPane.showMessageDialog(null,"Cidade: "+bean.getCity());
	}
}

//Se acionada imprime o resultado no terminal.
class Prompt implements State{
	private Bean bean;
	
	public Prompt(Bean bean){
		this.bean = bean;
	}
		
	@Override
	public void sysout(){
		System.out.println("Nome  : "+bean.getCity());
		System.out.println("Idade : "+bean.getAge());
		System.out.println("Cidade: "+bean.getCity());
	}
}
/*
 * Pense no state como um simple factory funcionando dentro de uma classe.
 * Dentro da classe você tem uma instancia da interface ou da classe
 * abstrata, e o conteudo dela se altera de acordo com os parametros informados.
 * É interessante quando você quer ter um objeto dentro de um grupo de objetos
 * que pode variar de comportamento. Ou seja um simple factory dentro de uma
 * classe.
 *  * 
 * */

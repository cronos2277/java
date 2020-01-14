import java.util.HashMap;
public class ProjetoMultiton{
	public static void main(String [] args){
		Multiton exemple = Multiton.getMultiton(3);
		System.out.println("|Chave: ->"+exemple.key+" |Valor: ->"+exemple.value);
	}
}

abstract class Rules{
	protected static int id = 0;
	protected static int key = 0;
	protected String value = " ";
	protected abstract void setValue(int id, String var);
}

class Multiton extends Rules{
	private Multiton(){} //Assim como o Singleton esse padrão requer um construtor privado.
	protected static HashMap<Integer,Multiton> instances = new HashMap<Integer,Multiton>();	
	protected static void addElements(Multiton c){
		Multiton.key += 1;
		instances.put(key,c);
	}
	@Override
	protected void setValue(int id, String var){		
		this.id = id;
		this.value = var;
	}
	public static Multiton getMultiton(int num){
		return Multiton.instances.get(num);
	}
	static{ 
//Essa é a parte estática da classe, apenas aqui que será adicionado todos os objetos possíveis da classe Multiton.
		Multiton multi1 = new Multiton();
		multi1.setValue(1,"root");
		multi1.addElements(multi1);
		Multiton multi2 = new Multiton();	
		multi2.setValue(2,"user");
		multi2.addElements(multi2);
		Multiton multi = new Multiton();
		multi.setValue(3,"Olá Mundo!");
		multi.addElements(multi);
	}
}
/*Pense nessa classe como um List de Singleton, ela não pertence ao padrão GoF. Essa classe,
 tem um número de objetos previamente estabelecido. Nesse padrão de projeto você cria um Map,
 ou ArrayList ou HashSet privado contendo com um índice e o conteúdo de cada objeto que será criado,
assim como no singleton, você define o construtor como privado, e cria métodos estáticos para o acesso
ao Map que você criou, no caso eu coloquei um setter e um getter, ambos estátidos com o setter privado,
e com um getter público para o usuario pode pegar o objeto. Além de ter um setter para o Map, que é o estático,
eu também coloquei um setter, para que eu possa adicionar valor aos atributos de meu objeto criado,
é válido ressaltar que ambos os setter estão privados, porém o setter do Map está estático e o setter do
objeto instanciado está não estático, o carregamento do Map é feito na parte estática da classe, lembrando
que apenas ali poderá ser adicionado objetos ao Map e em nenhum outro lugar poderá ser feito isso.
O Multiton é basicamente o Singleton com lista de objetos instanciados.
 */

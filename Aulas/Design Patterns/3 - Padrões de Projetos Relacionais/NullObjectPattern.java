public class NullObjectPattern{
	public static void main(String args[]){
		NullObject obj = new NullObject();
		obj.anythink("?");
	}
}

interface Strategy{
	public void anythink(String str);
}

class NullObject implements Strategy{
	@Override
	public void anythink(String str){
		//Esse padrão é usado para evitar um NullPointerException ou
		//para encapsular os valores mesmos quando nulos. Não se pode
		//implementar nada aqui, se não ela deixará de ser Null Object
		//Para ser uma Strategy... e é mostrando serviço que encerro 
		//o curso de padrões de projetos em java. =D
	}
}

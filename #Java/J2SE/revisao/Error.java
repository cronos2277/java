public class Error{
	public static void main(String args[]){		
		try{
			throw new NewError("Olá mundo");
		}catch(NewError ne){ne.printStackTrace();}
	}

}

class NewError extends Exception{	
	public NewError(){
		super();
		}
	public NewError(String msg){
		
		super(msg);		
	}
}

/*
 * Aqui são criadas as novas Exceptions. Quando você cria uma Exception
 * você deve extender a sua da classe da classe Exception, e deve ser 
 * criado no construtor e esse construtor deve chamar a exception através
 * do super(), passando uma String ou não.
 * */



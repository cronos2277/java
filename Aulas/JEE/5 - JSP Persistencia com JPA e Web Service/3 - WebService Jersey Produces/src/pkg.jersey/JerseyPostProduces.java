package pkg.jersey;

import javax.ws.rs.FormParam; //Importação obrigatória para o funcionamento do @FormParam
import javax.ws.rs.POST; //Importação obrigatória para o funcionamento do POST
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/Jesey/Post/Produces")
	public class JerseyPostProduces {
	@POST //Aqui já é usado o método Post.
	
	//Repare que aqui, o texto já sai plano, não HTML, isso ocorre pelo valor String "text/plan",
	//alem disso o texto sai formatado, isso ocorre por conta da formatação. 
	//Após o ";", a cada parâmetro de configuração, use o ";" como delimitador.
	@Produces("text/plan;charset=UTF-8")  
		public String funcao(@FormParam("nome")String var1, @FormParam("frase")String var2){
			return "O nome digitado foi: "+var1+", a frase digitada foi: "+var2;
		}
	
	}
//O @FormParam tem a sintaxe semelhante, ao @QueryPara. No caso a fução recebe dois
//parâmetros, mas a mesma pode receber quantos for necessário, basta separarlos com
//uma vírgula, seguindo a sintaxe acima.
package pkg.jersey;
//Todas as bibliotecas abaixo, são obrigatórias a sua importação, além disso os jar do Jersey devem estar instalado na pasta lib e em Java Bild Path.
import javax.ws.rs.GET; //Essa biblioteca é obrigatória para o funcionamento do método get.
import javax.ws.rs.Path; //Essa biblioteca é necessária para a criação da anotação path, e para que o recurso desta classe java ganhe uma url.
import javax.ws.rs.Produces; //Produces, esse é o conteúdo que esta classe produz, ela também pode consumir recursos, mais isso será explicado mais a seguir.
import javax.ws.rs.QueryParam; //Aqui corresponde a entrada de dados, ao qual será utilizado para a produção de recursos. Não funciona com o método Post.

@Path("/Jersey/Get/Produces") //Esse é o caminho que o formulário deve correr até chegar aqui,sendo: http://EndereçoIP:PortaTCP/NomeDoProjeto/a definicao da <url-patern> no web.xml/o conteúdo dessa anotação.
public class JerseyGetProduces {
@GET //Aqui especifica que essa função é acessada, pelo método get. No caso um formulário.
@Produces("Text/Html") //Aqui é o tipo de retorno, que esse recurso vai oferecer, podendo ser também "Text/Plain", mas em texto Plano, as tags html contidos no retorno, desse método são ignoradas.
	public String funcao(@QueryParam("textoGet")String QualquerCoisaServe){
	return "<h1 align='center'>Você digitou: "+QualquerCoisaServe+"</h1>"; //Formatado para html, digamos que acentuação, não é o ponto forte desse método.
	}
}
//Saiba que a anotação QueryParam não funciona com o método Post. No caso do Post para executar essa função, seria @FormParam, no lugar de @QueryParam.
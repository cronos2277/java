
abstract class AbstractSql{ //Essa classe será a herdada.
	public String Sgbd;
	public abstract AbstractSql Creator();	//Esse método será rescrito conforme a classe, que irá herdar-lo.
	public AbstractSql getReturn(){
		 AbstractSql sql = Creator();
		 return sql;
	}
}
/*Analise que cada classe faz a escrita do atributo Sgbd, através do método Creator. Essa é a diferença desse padrão de projeto, aonde
 * tudo é feito dentro de métodos que as classes tem em comum herdada da Classe abstrata.*/
class Oracle extends AbstractSql{	
	@Override
	public AbstractSql Creator(){
		Oracle oracle = new Oracle();
		oracle.Sgbd = "Banco de dados Oracle";	
		return oracle;
	}	
}

class Mysql extends AbstractSql{
	@Override 
	public AbstractSql Creator(){
		Mysql mysql = new Mysql();
		mysql.Sgbd  = "Banco de dados MySql";
		return mysql;
	}
}

class Postgree extends AbstractSql{
	@Override
	public AbstractSql Creator(){
		Postgree postgree = new Postgree();
		postgree.Sgbd = "Banco de dados PostGree";
		return postgree;
		}
}

class Sqlserver extends AbstractSql{
	@Override
	public AbstractSql Creator(){
		Sqlserver sqlserver = new Sqlserver();
		sqlserver.Sgbd = "Banco de dados SqlServer";
		return sqlserver;
	}
}

class Firebird extends AbstractSql{
	@Override 
	public AbstractSql Creator(){
		Firebird firebird = new Firebird();
		firebird.Sgbd = "Banco de dados Firebird";
		return firebird;
	}
}

public class FactoryMethod{
	public static void main(String args[]){
		/*O método Creator() é o responsável por dar características exclusivas dos métodos de cada classe
		 * No caso o método reescreve a String "Sgbd"*/
		AbstractSql oracle = new Oracle().Creator();
		/*Como visto anteriormente instancia uma classe abstrata com base na classe desejada, é exatamente isso o Factory Method*/
		AbstractSql mysql = new Mysql().Creator();	
		AbstractSql postgree = new Postgree().Creator();	
		AbstractSql sqlserver = new Sqlserver().Creator();	
		AbstractSql firebird = new Firebird().Creator();				
		System.out.println(oracle.Sgbd);
		System.out.println(mysql.Sgbd);
		System.out.println(postgree.Sgbd);
		System.out.println(sqlserver.Sgbd);
		System.out.println(firebird.Sgbd);
	}
}
/*No simples Factory você instancia diferentes classes com base em argumentos, aqui você instancia um objeto baseado na classe
 * abstrata, usando a classe que herda os seus valores como base, a lógica é essa: "ClasseAbstrata Objeto = new ClasseHerdadaDaAbstrata()"*/

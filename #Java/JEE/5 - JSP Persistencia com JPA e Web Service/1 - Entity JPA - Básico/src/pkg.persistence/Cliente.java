//Abaixo essas as classes a serem importadas.
package pkg.persistence; 

//é importante frisar que as anotações são obrigatórias em uma entidade, 
//pois é na @Entity que a classe é vista pela JVM como uma entidade.
//@id, logo abaixo dela é colocada a variável que vai corresponder a chave primaria da tabela.
import javax.persistence.Column; //importa a anotação da linha 14.
import javax.persistence.Entity; //importa a anotação da linha 09.
import javax.persistence.GeneratedValue; //importa a anotação da linha 12.
import javax.persistence.GenerationType; //importa o valor da linha 12. "strategy = GenerationType.IDENTITY é o valor gerado pelo bando de dados.
import javax.persistence.Id; //importa a anotação da linha 11. Defindo a variável abaixo dela, como primary key. Chave primária no sql, ou seja o valor mais importante de uma tabela.

@Entity //Aqui é indicado que essa classe é uma entidade.
public class Cliente {
@Id //Informa que a variável privada, logo abaixo dela é a chave primaria, no caso a id do tipo long.
@GeneratedValue(strategy = GenerationType.IDENTITY)//Essa anotação informa ao provedor como o valor é gerado. strategy = GenerationType.IDENTITY, isso significa que o valor gerado é pelo próprio banco de dados.  
private Long id; //aqui está definida a chave primária do SGBD
@Column(nullable = false, length=250) //Aqui temos dois valores, primeiro é a possibilidade de se implementar no banco de dados um valor nulo, e o segundo o tamanho do campo. Esse campo não é obrigatório.
private String nome; //Importante lembrar que o nome das variáveis aqui, são as mesmas do banco de dados.
private String login; //Para a criação de entidade todas variáveis devem ser privadas, e com seus getters e setters.
private String senha; //Evite sempre que possível usar os seus getters ou setters.

public void setId (Long id){
	this.id = id;
}

public Long getId(){
	return id;
}

public void setNome(String nome){
	this.nome = nome;
}

public String getNome(){
	return nome;
}

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}


}
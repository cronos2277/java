package pkg.all;
import javax.persistence.Column;// <-- Classe necessária para a anotação: Column. 
import javax.persistence.Entity; // <-- Classe necessária para a anotação: Entity. 
import javax.persistence.GeneratedValue; // <-- Classe necessária para a anotação: GeneratedValue.
import javax.persistence.GenerationType; //Essa classe possue os valores a ser usado na estratégia de criação de ID.
import javax.persistence.Id; // <-- Classe necessária para a anotação: Id.
import javax.persistence.Table; // <-- Classe necessária para a anotação: Table.

@Entity (name = "Entidade") //Caso você queira que a entidade tenha um nome diferente da Classe, você pode definir o nome entidade com o valor de name.
@Table(name="tabela") //Aqui define o nome da tabela no banco de dados.
public class Classe {
@Id //Aqui é identificado o ID.
@GeneratedValue(strategy = GenerationType.AUTO) // A forma ao qual é gerado o ID, aqui é definido como é gerado o ID, que no caso será gerado automaticamente.
@Column(name="codigo", nullable=false) //Aqui se refere ao nome da coluna no banco de dados.
private int id;
private String texto;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
}
/*
 *	@Entity(name="String"). Essa anotação é Obrigatória, pois é através dela que a JVM, 
 sabe que se trata de uma entidade. Caso o name seja omitido, o nome da entidade passa 
 a ser o nome da Classe Java.
 
 *	@Table(name="tabela"). Essa anotação corresponde ao nome da tabela no banco de dados,
caso essa anotação seja omitida, a tabela terá o mesmo nome que a entidade. Sua declaração
não é obrigatória.

*	@Id. Anotação obrigatória. Pois é o atributo logo abaixo dela, é identificado como chave primária.
* 	@GeneratedValue(). Aqui especifica como que é definida a criação de chave primária, que é feita
sem a necessidade de um setId() e sim de maneira automática, o valor de Strategy define o como.
A estratégia está definida como "AUTO", que no caso o provedor de persistencia, analiza a melhor forma
de se criar uma chave primária, "IDENTITY" o provedor identifica um estratégia oriunda do banco de dados.
"SEQUENCE" segue uma sequencia criada dentro da classe. "TABLE" definido através de Triggers no SGBD,
"NONE" = nenhuma, no caso seria pelo método set mesmo.

 *	@Column(name="String", nullable="Boolean"). Define a propriedade da coluna no banco de dados, caso
o name seja omitido, a entidade assume que a coluna tem o mesmo nome do atributo, nullable é se aceita
valores nulos, por padrão aceita. Isso seria o atributo de not null das tabelas. Essa anotação pode ser omitida. 
 */

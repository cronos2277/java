package pkg.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pessoas")
public class Pessoas {
public Pessoas(){}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int idpessoa;
private String nome;
@OneToOne(cascade=CascadeType.ALL)  //Veja mais abaixo.
private Salario salario;
public int getIdpessoa() {
	return idpessoa;
}
public void setIdpessoa(int idpessoa) {
	this.idpessoa = idpessoa;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Salario getSalario() {
	return salario;
}
public void setSalario(Salario salario) {
	this.salario = salario;
}
}
/*
*	No caso aqui temos um relacionamento, um para um unidirecional. Recomenda-se n�o mexer com c�digos sql e deixar o hibernate trabalhar sozinho.
No caso de uma rela��o um para um, colocamos a anota��o OneToOne, mas como � uma rela��o unilateral, apenas a entidade com a parte forte do
relacionamento tem as anota��es, sendo que a sal�rio, que � a entidade mais fraca desse relacionamento. Apenas a entidade pessoa tem as anota��es
referentes a cardinalidade um para um, pois se tivesse a mesma cardinalidade a salario tamb�m seria um relacionamento um para um bi-lateral. 
*	Agora n�s temos o tipo de cascade. Nesse campo � definido a sincroniza��o entre as tabelas, neste caso se um valor � apagado em uma tabela, logo sera apagada em outra.	
*/
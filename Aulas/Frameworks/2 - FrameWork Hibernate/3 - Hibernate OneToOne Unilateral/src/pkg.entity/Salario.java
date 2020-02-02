package pkg.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salarios")
public class Salario {
@Id
@GeneratedValue(strategy = GenerationType.AUTO) //Aqui � explicado a estrat�gia de gera��o de ID.
private int idsalario;
private double salario;
public int getIdsalario() {
	return idsalario;
}
public void setIdsalario(int idsalario) {
	this.idsalario = idsalario;
}
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}
public Salario(){};
}
/*
*	Aqui tem uma strategy para a cria��o de ID. No caso do auto � definido a melhor maneira para a cria��o do ID,
* segundo os crit�rios do Hibernate, recomenda-se a usar ele, salvo em casos especiais.
*/
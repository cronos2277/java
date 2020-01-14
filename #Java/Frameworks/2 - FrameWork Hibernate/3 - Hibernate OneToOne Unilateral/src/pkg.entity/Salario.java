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
@GeneratedValue(strategy = GenerationType.AUTO) //Aqui é explicado a estratégia de geração de ID.
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
*	Aqui tem uma strategy para a criação de ID. No caso do auto é definido a melhor maneira para a criação do ID,
* segundo os critérios do Hibernate, recomenda-se a usar ele, salvo em casos especiais.
*/
package pkg;

import com.opensymphony.xwork2.ActionSupport;

public class Calc extends ActionSupport {	
	private static final long serialVersionUID = 1L;
private double num1;
private double num2;
private double soma;
private double subt;
private double mult;
private double divi;
private String result;
public void setNum1(double num1) {
	this.num1 = num1;
}
public void setNum2(double num2) {
	this.num2 = num2;
}
@Override
public String execute() throws Exception {
	soma = num1 + num2;
	subt = num1 - num2;
	mult = num1 * num2;
	divi = num1/num2;
	result = "Resultados: A soma (A+B): "+soma+", Subtra��o (A-B): "+subt+", Multiplica��o (A*B): "+mult+", Divis�o (A/B): "+divi;
	return super.execute();
}
public String getResult() {
	return result;
}
/*
 * 	Quando se tem entrada de dados, se faz necess�rio criar os sets. Os setters s�o entradas de dados e os Getters sa�das. 
 */


}

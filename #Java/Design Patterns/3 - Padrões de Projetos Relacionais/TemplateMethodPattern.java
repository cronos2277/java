import java.util.ArrayList;
public class TemplateMethodPattern{
	public static void main(String args[]){
		Template templateMethod = new Method();
		templateMethod.setNumbers(300,200,-50,-4);
		templateMethod.start();
	}
}

//a classe abstrata que executa os métodos que irá herdar em sequencia.
abstract class Template{
	protected boolean isOn;
	protected ArrayList<Double> numbers;
	protected double soma = 0;
	protected double subt = 0;
	protected double mlt = 1;
	protected double div = 1;	

//Repare que dentro desses métodos tem todos os métodos que essa classe
//vai herdar.Enfim é essa a característica desse padrão de projeto.
	protected void run(){
		isOn = true;		
		sum_method();
		mlt_method();
		div_method();
		sub_method();
		sysout();
	}
	
//Aqui está as classes a serem herdadas.			
	protected abstract void sum_method();
	protected abstract void mlt_method();
	protected abstract void div_method();
	protected abstract void sub_method();
	protected abstract void sysout();
	public abstract void start();
	public abstract void setNumbers(double... num);	
	public abstract boolean ItIsOn();
}

class Method extends Template{	
	public Method(){
		super();
		numbers = new ArrayList<Double>();
	}
	
	@Override	
	protected void sum_method(){
		for(Double num: numbers)
			super.soma += num;
	}
	
	@Override
	protected void mlt_method(){
		for(Double num: numbers)
			super.mlt *= num;
	}
	
	@Override
	protected void div_method(){
		for(Double num: numbers)
			super.div /= num;
	}
	
	@Override
	protected void sub_method(){
		for(Double num: numbers)
			super.subt -= num;
	}
	
	@Override
	protected void sysout(){
		System.out.println("A soma eh      : "+soma);
		System.out.println("A subtracao    : "+subt);
		System.out.println("A multiplicacao: "+mlt);
		System.out.println("A divisao eh:  : "+div);
	}
	
	@Override
	public void start(){
		super.run();
	}
	
	public void setNumbers(double... num){
		for(Double n: num)
			super.numbers.add(n);
	}
	
	public boolean ItIsOn(){
		return super.isOn;
	}
}
/*
 * O modo template executa todos os métodos implementado nas classes filhas
 * em sequencia, então todos os métodos que ele extende para as filhas
 * o mesmo executa em sequencia.
 * */

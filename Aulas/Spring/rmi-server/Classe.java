package Spring.rmi.server;

import java.util.Date;

public class Classe implements Contrato{
	
	private static double numero = Math.random();	
	private Date data = new Date();

	public double aleatorio() {		
		return Classe.numero;
	}
	
	public Date getDate() {		
		return this.data;
	}

}

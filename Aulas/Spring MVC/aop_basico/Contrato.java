package Springann.aop;

public interface Contrato {
	public void antes();
	public void depois();
	public void erro();
	public void depois(boolean b);	
}

package pkg.main;
import java.awt.BorderLayout;
import java.util.List;

import pkg.dao.EntidadeDao;
import pkg.dao.Hibernate;
import pkg.entidade.Entidade;
import pkg.face.Components;

import javax.swing.*;
public class Principal {
public static String ProgramaNome = "Hibernate Project";	
public static int largura = 800;
public static int altura = 600;
	public static void main(String args[]){
		try{		
		List<Entidade> entidades = new EntidadeDao().GetAll();	//Se faz necess�rio que seja carregado o Hibernate antes da biblioteca Swing. Primeiro se carrega o hibernate, depois voc� carrega os objetos do Swing com os seus valores.
		Components comp = new Components(); //Aqui � carregado o Swing.		
		JFrame janela = new Order().FrameMainWindow(ProgramaNome, largura, altura);		
		Order.ClassListener(comp);
		janela.getContentPane().setLayout(new BorderLayout());
		janela.getContentPane().add(new Order().PainelButtonsUp(comp), BorderLayout.NORTH);
		janela.getContentPane().add(new Order().TableReturn(entidades), BorderLayout.CENTER);
		janela.getContentPane().add(new Order().PainelButtonsDown(comp), BorderLayout.SOUTH);
		/* Aten��o como eu quero que o MouseListener funcione em uma tabela, se faz necess�rio 
		tornar-la est�tica e adicionar a fun��o mouse listener, direto nela. */
		Order.Tabela.addMouseListener(comp.listener); //V�lido lembrar que o Mouse Listener vai no JTable e n�o no modelo de tabela.
		System.out.println(Hibernate.Status);
	}catch(Exception e){JOptionPane.showMessageDialog(null, "Erro! \nM�todo Main: "+e.toString()+"\nHibernate Status: "+Hibernate.Status+"\n\n"+Order.Mensagem);}
	}
}

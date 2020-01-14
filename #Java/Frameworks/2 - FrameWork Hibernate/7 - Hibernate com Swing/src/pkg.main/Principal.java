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
		List<Entidade> entidades = new EntidadeDao().GetAll();	//Se faz necessário que seja carregado o Hibernate antes da biblioteca Swing. Primeiro se carrega o hibernate, depois você carrega os objetos do Swing com os seus valores.
		Components comp = new Components(); //Aqui é carregado o Swing.		
		JFrame janela = new Order().FrameMainWindow(ProgramaNome, largura, altura);		
		Order.ClassListener(comp);
		janela.getContentPane().setLayout(new BorderLayout());
		janela.getContentPane().add(new Order().PainelButtonsUp(comp), BorderLayout.NORTH);
		janela.getContentPane().add(new Order().TableReturn(entidades), BorderLayout.CENTER);
		janela.getContentPane().add(new Order().PainelButtonsDown(comp), BorderLayout.SOUTH);
		/* Atenção como eu quero que o MouseListener funcione em uma tabela, se faz necessário 
		tornar-la estática e adicionar a função mouse listener, direto nela. */
		Order.Tabela.addMouseListener(comp.listener); //Válido lembrar que o Mouse Listener vai no JTable e não no modelo de tabela.
		System.out.println(Hibernate.Status);
	}catch(Exception e){JOptionPane.showMessageDialog(null, "Erro! \nMétodo Main: "+e.toString()+"\nHibernate Status: "+Hibernate.Status+"\n\n"+Order.Mensagem);}
	}
}

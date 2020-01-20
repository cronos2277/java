import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class ExcluirAlunos {
	//Hibernate: update alunos set alu_nome=?, alu_cidade=?, alu_fone=? where alu_codigo=?
    public static void main(String args[]){
        try{    	
        	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();            
            Session session = factory.openSession();
            List<Aluno> lista = new ArrayList<Aluno>();
            lista = session.createQuery("from Aluno").list();
            Aluno aluno = lista.get(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID a ser excluido")));
            session.getTransaction().begin();
            session.delete(aluno);
            session.getTransaction().commit();            
            session.close();            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na listagem: "+erro.toString());
            System.out.println(erro.toString());
        }
    }
}

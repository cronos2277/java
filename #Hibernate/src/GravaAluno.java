import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class GravaAluno {
    public static void main(String args[]){
        try{
        	String nome = JOptionPane.showInputDialog("Informe um nome");
        	String cidade = JOptionPane.showInputDialog("Informe uma cidade");
        	String fone = JOptionPane.showInputDialog("Informe um Telefone");
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();            
            Session session = factory.openSession();
            Aluno aluno = new Aluno(nome,cidade,fone);
            Transaction transaction = session.beginTransaction();
            session.save(aluno);
            transaction.commit();
            session.close();
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na inserção: "+erro.toString());
            System.out.println(erro.toString());
        }
    }
}

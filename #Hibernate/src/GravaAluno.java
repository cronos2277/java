import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class GravaAluno {
    public static void main(String args[]){
        try{
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();            
            Session session = factory.openSession();
            Aluno aluno = new Aluno("Neiri","Carazinho","04143394823");
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

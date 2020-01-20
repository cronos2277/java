import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class editarAluno {
	//Hibernate: update alunos set alu_nome=?, alu_cidade=?, alu_fone=? where alu_codigo=?
    public static void main(String args[]){
        try{
        	String nome = JOptionPane.showInputDialog("Informe um novo nome");
        	String cidade = JOptionPane.showInputDialog("Informe um novo cidade");
        	String fone = JOptionPane.showInputDialog("Informe um novo Telefone");
        	int id = Integer.parseInt(JOptionPane.showInputDialog("Qual voce quer editar?"));
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();            
            Session session = factory.openSession();
            Aluno aluno = new Aluno(nome,cidade,fone);
            aluno.setAlu_codigo(id);
            Transaction transaction = session.beginTransaction();
            session.update(aluno);
            transaction.commit();
            session.close();
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na inserção: "+erro.toString());
            System.out.println(erro.toString());
        }
    }
}


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class Gerente {
	//Essa constante contem a String que o session.createQuery vai executar
	private final String consulta = "from Aluno";
	private SessionFactory factory;
	private Session session;
	private List<Aluno> alunos;
	public Gerente() {
		sessionFactory();
		this.alunos = new ArrayList<Aluno>();
	}
	
	private void sessionFactory() {
		try {
			this.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e) {			
			System.err.println("Lançado na função sessionFactory");
			formatError(e);
		}
	}
	
	private void getSession() {
		try {
			if(this.factory.isClosed()) {
				this.sessionFactory();
			}
			this.session = factory.openSession();
		}catch(Exception e) {
			System.err.println("Lançado na função getSession");
			formatError(e);
		}
	}
	
	private void closeSession() {
		try {
			this.session.close();
			this.factory.close();
		}catch(Exception e) {
			System.err.println("Lançado na função closeSession");
			formatError(e);
		}
	}
	
	/* 	
	  Aqui retorna a lista de alunos, se a lista de alunos estiver vazia, ou se o booleano
		isUpdate estiver verdadeiro, ele acessa o banco e pega os dados atualizados, do contrario
		é pego da lista salva, isso evita um excesso de requisição ao banco de dados. 
	*/
	public List<Aluno> getAlunos(boolean isUpdate){
		try {
			if(this.alunos.isEmpty() || isUpdate) {
				this.fillAlunos();				
			}
			return this.alunos;			
		}catch(Exception e) {
			System.err.println("Lançado na função getAlunos");
			formatError(e);
			return null;
		}
	}
	public List<Aluno> getAlunos(){
		try {
			if(this.alunos.isEmpty()) {
				this.fillAlunos();
			}			
			return this.alunos;			
		}catch(Exception e) {
			System.err.println("Lançado na função getAlunos");
			formatError(e);
			return null;
		}
	}
	
	
	public Aluno getAluno(int id) {
		return this.alunos.get(id);
	}
	
	public Aluno getAluno(int id, boolean forceUpdate) {		
		if(forceUpdate) {
			this.getAlunos(forceUpdate);
			return this.alunos.get(id);
		}else {
			return this.alunos.get(id);
		}
	}
	
	@Override
	public String toString() {
		return "Existem: "+this.alunos.size()+", alunos registrados!";
	}
	
	private void formatError(Exception exception) {
		System.out.println(exception);
		JOptionPane.showMessageDialog(null, exception);
	}
	
	public void fillAlunos() {
		this.getSession();
		this.alunos = session.createQuery(consulta).list();
		this.closeSession();
	}
	
}

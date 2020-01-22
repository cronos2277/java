/*
 * ATRIBUTOS
 * String consulta => � a query que ser� executado no hibernate, se o nome da tabela no Banco de dados n�o bater, mude aqui.
 * SessionFactory factory => A factory para toda a instancia.
 * Session session; => A sess�o para toda as instancias.
 * List<Aluno> alunos; => Aqui aonde fica armazenado todos os registros pego do banco de dados.
 * 
 * M�TODOS
 * Construtor => ele abre a primeira fabrica de sess�o e depois inicializa o Array de alunos vazio, ambos para evitar Java.Lang.NullPointerExeption.
 * sessionFactory() => Abre a sess�o fabrica.
 * getSession() => Abre uma sess�o, reabrindo a sess�o fabrica se estiver fechado.
 * closeSession() => fecha a sess�o e a sess�o fabrica.
 * getAlunos(boolean) ou getAlunos() => se tiver um booleano verdadeiro ou a lista de alunos vazia acessa o banco de dados
 e pega todos os registros atualizados. Padr�o sem parametro, � falso.
 
 * getAluno(int id) => pega o aluno da lista com base no id for�ando a atualiza��o se vazia, caso o segundo parametro seja true, for�a a atualiza��o da lista. Padr�o falso.
 * toString() => retorna a quantidade de registros se o Objeto for tratado como uma String.
 * formatError(Exception exception) => metodo que lida com os erros, exibindo-os no console e no JOptionPane tamb�m.
 * fillAlunos() => Fun��o usada pelo getAlunos() para preencher um array de Alunos.
 * 
 * */


/*
 * Criar um metodo para abrir transa��o, usuando o metodo getSession().
 * Criar um metodo para comitar transa��o usando a sess�o do getSession().
 * criar um metodo para fechar a transa��o.
 * Criar CRUD.
 * */


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
		this.sessionFactory();
		this.alunos = new ArrayList<Aluno>();
	}
	
	private void sessionFactory() {
		try {
			this.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e) {			
			System.err.println("Lan�ado na fun��o sessionFactory");
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
			System.err.println("Lan�ado na fun��o getSession");
			formatError(e);
		}
	}
	
	private void closeSession() {
		try {
			this.session.close();
			this.factory.close();
		}catch(Exception e) {
			System.err.println("Lan�ado na fun��o closeSession");
			formatError(e);
		}
	}	
	
	public List<Aluno> getAlunos(boolean isUpdate){
		try {
			if(this.alunos.isEmpty() || isUpdate) {
				this.fillAlunos();				
			}
			return this.alunos;			
		}catch(Exception e) {
			System.err.println("Lan�ado na fun��o getAlunos");
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
			System.err.println("Lan�ado na fun��o getAlunos");
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
	
	private void fillAlunos() {
		this.getSession();
		this.alunos = session.createQuery(consulta).list();
		this.closeSession();
	}
	
}

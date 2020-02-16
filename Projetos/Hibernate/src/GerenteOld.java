/*
 * ATRIBUTOS
 * String consulta => é a query que será executado no hibernate, se o nome da tabela no Banco de dados não bater, mude aqui.
 * SessionFactory factory => A factory para toda a instancia.
 * Session session; => A sessão para toda as instancias.
 * List<Aluno> alunos; => Aqui aonde fica armazenado todos os registros pego do banco de dados.
 * Transaction transaction => aqui é aonde fica salvo toda a Transação.
 * 
 * MÉTODOS
 * Construtor => ele abre a primeira fabrica de sessão e depois inicializa o Array de alunos vazio, ambos para evitar Java.Lang.NullPointerExeption.
 * sessionFactory() => Abre a sessão fabrica.
 * getSession() => Abre uma sessão, reabrindo a sessão fabrica se estiver fechado.
 * closeSession() => fecha a sessão e a sessão fabrica.
 * getAlunos(boolean) ou getAlunos() => se tiver um booleano verdadeiro ou a lista de alunos vazia acessa o banco de dados
 e pega todos os registros atualizados. Padrão sem parametro, é falso.
 
 * getAluno(int id) => pega o aluno da lista com base no id forçando a atualização se vazia, caso o segundo parametro seja true, força a atualização da lista. Padrão falso.
 * alunoForId(id) => Faz uma busca e retorna o registro que tem esse ID.
 * toString() => retorna a quantidade de registros se o Objeto for tratado como uma String.
 * formatError(Exception exception) => metodo que lida com os erros, exibindo-os no console e no JOptionPane também.
 * fillAlunos() => Função usada pelo getAlunos() para preencher um array de Alunos.
 * transactionManager(operacao,objeto aluno) => Executa a exclusão, edição ou adição de cadastro.
 * saveTransaction(Aluno aluno) => Salvará um novo registro no banco de dados. 
 *
 * */


/* Tarefas.
 * setar saveTransaction para privado e criar um metodo para tratar dados.
 * setar removeTransaction para privado e criar um metodo para tratar dados.
 * setar editTransaction para privado e criar um metodo para tratar dados.
 * criar removeTransaction aos mesmos moldes do save.
 * criar editTransaction aos mesmos moldes do save.
 * Criar CRUD.
 * */


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class GerenteOld {	
	//Essa constante contem a String que o session.createQuery vai executar
	private final String consulta = "from Aluno order by alu_codigo";
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private List<Aluno> alunos;
	public GerenteOld() {		
		this.sessionFactory();
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
	
	private void transactionManager(int operation, Aluno aluno) {
		try {			
			if(!this.session.isOpen()) {
				this.getSession();			
			}
			this.transaction = this.session.beginTransaction();
			switch(operation) {
				case 1: {this.session.save(aluno);break;}
				case 2: {this.session.update(aluno);break;}
				case 3: {this.session.delete(aluno);break;}
			}
			this.transaction.commit();								
			this.closeSession();			
							
			
		}catch(Exception e) {
			this.transaction.rollback();
			this.closeSession();
			System.err.println("Lançado na função transactionManager");
			formatError(e);
		}
	}
	
	public void saveTransaction(Aluno aluno) {
		this.transactionManager(1, aluno);
	}
	
	public void updateTransaction(Aluno aluno) {
		this.transactionManager(2, aluno);
	}
	
	public void deleteTransaction(Aluno aluno) {
		this.transactionManager(3, aluno);
	}
	
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
		return alunoForId(id);
	}
	
	public Aluno getAluno(int id, boolean forceUpdate) {		
		if(forceUpdate) {
			this.getAlunos(forceUpdate);			
		}		
		return alunoForId(id);
	}
	
	private Aluno alunoForId(int id) {
		try {
			for(Aluno aluno: this.alunos) {
				if(aluno.getAlu_codigo() == id) {				
					return aluno;
				}
			}
				return null;	
		}catch(Exception e) {
			System.err.println("Lançado na função alunoFor");
			formatError(e);
			return null;
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
	
	@SuppressWarnings("unchecked")
	private void fillAlunos() {
		this.getSession();
		this.alunos = session.createQuery(consulta).list();
		this.closeSession();
	}
	
}

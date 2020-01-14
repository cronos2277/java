package pkg.dao;
import java.util.List;
import org.hibernate.Session;
import pkg.entidade.Entidade;
public class EntidadeDao extends Hibernate<Entidade> {

	@Override //Salvar pessoa;
	public Entidade save(Entidade entidade) {
	Session sessao = getSessao();
		try{
			sessao.beginTransaction();
			sessao.persist(entidade);
			sessao.getTransaction().commit();
			return entidade;
		}catch(Exception e){Status = "Erro ao salvar uma nova pessoa, "+e.toString();return null;}
		finally{sessao.close();}
	
	}

	@Override //Atualizar pessoa;
	public void update(Entidade entidade) {
		Session sessao = getSessao();
		try{
			sessao.beginTransaction();
			sessao.merge(entidade);
			sessao.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao atualizar a pessoa, "+e.toString();}
		finally{sessao.close();}
	}

	@Override //Excluir Pessoa;
	public void delete(Entidade entidade) {
		Session sessao = getSessao();
		try{
			sessao.beginTransaction();
			sessao.delete(entidade);
			sessao.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao Excluir uma pessoa, "+e.toString();}
		finally{sessao.close();}
	}

	@Override //procurar por ID;
	public Entidade GetById(int id) {
		Session sessao = getSessao();
		Entidade entidade = new Entidade();
		try{
			entidade = (Entidade) sessao.createQuery("from Entidade where id="+id).uniqueResult();
			return entidade;
		}catch(Exception e){Status = "Erro ao procurar por determinada pessoa"+e.toString();return null;}
		finally{sessao.close();}
		
	}

	@SuppressWarnings("unchecked")
	@Override //Retornar tudos os valores;
	public List<Entidade> GetAll() {
		Session sessao = getSessao();
		List<Entidade> lista = null;
		try{ //Essa parte ser� melhor explicada.
			sessao.beginTransaction();
			lista = (List<Entidade>) sessao.createQuery("from Entidade order by nome asc, funcao asc").list();
			sessao.getTransaction().commit();
			return lista;
		}catch(Exception e){Status = "Erro ao carregar lista de pessoas, "+e.toString();return null;
		}finally{sessao.close();}
		
	}
}
/*
* 	Session.createQyery(Object) -> Dento do objeto voc� coloca a query referente a sua consulta. No caso uma query 
HQL(Hibernate Query Language). Por exemplo: from Entidade where id="Integer/Long", no caso ali a query usa como par�metro
um integer ou um Long, para realizar a consulta. Abaixo temos a clausura "order by" ao qual � estabelecido uma ordem.
tem os o asc = que � por ordem alfab�tica ou num�rica, e desc que � o inverso de asc. No caso daquela query a ordem primeiro
� por nome, se os nomes forem iguais ai ocorre uma ordem por funcao. A fun��o createQuery retorna um List<Object>. Nesse caso,
exigi-se que se fa�a um "cast", para que o Objeto seja moldado com base na Classe, ao qual o Objeto foi criado.
*	Session.createQuery("Object").list() -> ele pode retornar um ou mais de um Objeto do tipo da classe, que voc� criou, inclusive ele permite o retorno de valores nulos. N�o recomendado o seu uso, para casos que o uniqueResult(), possa ser usado.
*	Session.createQuery("Object").uniqueResult() -> Ele retorna apenas um objeto. No caso da execu��o da Query, aconte�a dele retornar mais de um valor, ou um nenhum, um nulo no caso,o m�todo lan�a uma exce��o. uniqueResult() retorna apenas um objeto, n�o nulo.
*/
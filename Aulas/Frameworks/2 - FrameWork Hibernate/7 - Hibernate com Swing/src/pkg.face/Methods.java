package pkg.face;
import pkg.dao.EntidadeDao;
import pkg.entidade.Entidade;

public class Methods {
	public void SalvarEntidade(String nome, String funcao){
		Entidade entidade = new Entidade();
		entidade.setNome(nome);
		entidade.setFuncao(funcao);
		new EntidadeDao().save(entidade);
	}
	public void EditarEntidade(int id, String NovoNome, String NovaFuncao){
		Entidade entidade = new EntidadeDao().GetById(id);
		entidade.setNome(NovoNome);
		entidade.setFuncao(NovaFuncao);
		new EntidadeDao().update(entidade);
	}
	public void ExcluirEntidade(int id){
		Entidade entidade = new EntidadeDao().GetById(id);
		new EntidadeDao().delete(entidade);
	}
	
}

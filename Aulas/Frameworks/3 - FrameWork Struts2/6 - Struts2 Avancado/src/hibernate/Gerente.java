package hibernate;
import java.util.List;

import pkg.Entidade;

public class Gerente extends Methods{
public static int id;
	public void Salvar(String nome, String login, String senha, String cargo, String genero){
		Entidade entidade = new Entidade();
		entidade.setNome(nome);
		entidade.setLogin(login);
		entidade.setSenha(senha);
		entidade.setCargo(cargo);
		entidade.setGenero(genero);
		save(entidade);
	}
	
	public void Excluir(int id){
		Entidade entidade = findById(id);
		delete(entidade);
	}
	
	public void Modificar(int id, String nome, String login, String senha, String cargo, String genero){
		Entidade entidade = findById(id);
		boolean bool = false;
		if(!nome.isEmpty()){entidade.setNome(nome);bool = true;}
		if(!login.isEmpty()){entidade.setLogin(login);bool = true;}
		if(!senha.isEmpty()){entidade.setSenha(senha);bool = true;}
		if(!cargo.isEmpty()){entidade.setCargo(cargo);bool = true;}
		if(!genero.isEmpty()){entidade.setGenero(genero);bool = true;}
		if(bool){edit(entidade);}
	}
	
	public Entidade Localizar(int id){
		Entidade entidade = findById(id);
		return entidade;
	}
	
	public List<Entidade> Carregar(){
		return returnList();
	}
	public boolean Validade(String login, String senha){
		boolean val = false;
		List<Entidade> lista = Carregar();
		for(Entidade e: lista){
			if(e.getLogin().equals(login) && e.getSenha().equals(senha)){
				 val = true;
				 id = e.getId();
			}
		}
		return val;
	}
}

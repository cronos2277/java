package pkg;
import hibernate.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.TextProvider;

public class StrutsClass extends ActionSupport  implements TextProvider {
	private static final long serialVersionUID = 1L;
private String nome;
private String login;
private String senha;
private String[] sexo = {getText("genre.man"),getText("genre.woman") , getText("genre.gay")};
private String selected_sex;
private String[] cargo = {getText("class.func1"),getText("class.func2"), getText("class.func3"), getText("class.func4")};
private String selected_cargo;

/* 
 * No caso, analise a função getText("String"). Essa função, é fruto da implementação do TextProvider.
 * O valor a ser passado como parâmetro, nessa função, é o nome na chave do arquivo properties.
 * Essa função retorna uma String ou um array de String.
 * */
@Override
public String execute() throws Exception {
	
	return super.execute();
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String[] getSexo() {
	return sexo;
}
public void setSexo(String[] sexo) {
	this.sexo = sexo;
}
public String[] getCargo() {
	return cargo;
}
public void setCargo(String[] cargo) {
	this.cargo = cargo;
}

public String getSelected_sex() {
	return selected_sex;
}
public void setSelected_sex(String selected_sex) {
	this.selected_sex = selected_sex;
}
public String getSelected_cargo() {
	return selected_cargo;
}
public void setSelected_cargo(String selected_cargo) {
	this.selected_cargo = selected_cargo;
}
public String cadastrar(){
	try{
	new Gerente().Salvar(nome, login, senha, selected_cargo, selected_sex);
		return SUCCESS;
	}catch(Exception e){
		return ERROR;
	}
}

public String enter(){
	if(new Gerente().Validade(login, senha)){
		return SUCCESS;
	}else{
		Hibernate.Status = getText("class.error");
		return ERROR;
	}
}

public String drop(){
	try{
		new Gerente().Excluir(Gerente.id);
		return SUCCESS;
	}catch(Exception e){
		return ERROR;
	}
}

public String modify(){
	try{
		new Gerente().Modificar(Gerente.id, nome, login, senha, selected_cargo, selected_sex);
		nome = null;
		login = null;
		senha = null;
		selected_cargo = null;
		selected_sex = null;
		return SUCCESS;
	}catch(Exception e){
		return ERROR;
	}
}
public String localizar(){
	try{
		Entidade entidade = new Gerente().Localizar(Gerente.id);
		nome = entidade.getNome();
		login = entidade.getLogin();
		selected_cargo = entidade.getCargo();
		selected_sex = entidade.getGenero();
		return SUCCESS;
	}catch(Exception e){
		return ERROR;
	}
}

}

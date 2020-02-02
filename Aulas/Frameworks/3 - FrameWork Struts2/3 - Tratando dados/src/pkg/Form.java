package pkg;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class Form extends ActionSupport {	
	private static final long serialVersionUID = 1L;
	private String erro = "null";
	private String nome;
	private String funcao;
	private double salario;
	private Date cadastrado;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String execute() throws Exception {
		cadastrado = new Date();
		return super.execute();
	}
	public Date getCadastrado() {
		return cadastrado;
	}
	public String getErro() {
		return erro;
	}
	public String check(){ //Esse método ele é específicado no campo Method, no arquivo struts xml. Ao executar a action, esse método é executado assim que a action, ao qual ele foi implementado, é chamado.
		if(nome.isEmpty() || funcao.isEmpty()){ //O método isEmpty() retorna true se a variável estiver vazia. O método .equals(null), não é recomendado para Strings, pois o null é um objeto.
			erro = "Tanto nome, quanto Função não pode ficar em Branco";
			return ERROR;} //Caso o nome ou a função seja nulo, ocorre o retorno dessa string constante. Ela retorna uma String com o seguinte valor "error".
		else{return SUCCESS;} //Caso o nome ou a função não seja nulo, ocorre o retorno da String constante SUCCESS. A mesma contém o seguinte valor, "success".
	}
}

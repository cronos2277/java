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
	public String check(){ //Esse m�todo ele � espec�ficado no campo Method, no arquivo struts xml. Ao executar a action, esse m�todo � executado assim que a action, ao qual ele foi implementado, � chamado.
		if(nome.isEmpty() || funcao.isEmpty()){ //O m�todo isEmpty() retorna true se a vari�vel estiver vazia. O m�todo .equals(null), n�o � recomendado para Strings, pois o null � um objeto.
			erro = "Tanto nome, quanto Fun��o n�o pode ficar em Branco";
			return ERROR;} //Caso o nome ou a fun��o seja nulo, ocorre o retorno dessa string constante. Ela retorna uma String com o seguinte valor "error".
		else{return SUCCESS;} //Caso o nome ou a fun��o n�o seja nulo, ocorre o retorno da String constante SUCCESS. A mesma cont�m o seguinte valor, "success".
	}
}

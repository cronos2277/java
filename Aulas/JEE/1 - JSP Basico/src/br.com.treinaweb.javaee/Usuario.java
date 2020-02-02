package br.com.treinaweb.javaee;

public class Usuario {
  private int idUsuarios;
  private String nome;
  private String login;
  private String senha;
  private String status;

  public int getIdUsuarios() {
    return idUsuarios;
  }

  public void setIdUsuarios(int idUsuarios) {
    this.idUsuarios = idUsuarios;
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

  public String getStatus(){
    return this.status;
  }

  public void setStatus(String status){
    this.status = status;
  }

  public void save(){
    UsuarioDAO dao = new UsuarioDAO();
    if(dao.salvar(this))
      this.status = "Usuário cadastrado com sucesso!";
    else
      this.status = "Ocorreu um erro durante o castrado de usuário!";
  }
}
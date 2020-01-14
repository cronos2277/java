package br.com.treinaweb.javaee;

import java.util.ListResourceBundle;

public class Recurso_pt extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return contents;
  }

  static final Object[][] contents ={
    {"login.apresentacao","Bem vindo"},
    {"login.usuario","Usuário:"},
    {"login.senha","Senha:"},
    {"login.correto","Login Correto"},
    {"login.incorreto","Login incorreto"},
  };
}
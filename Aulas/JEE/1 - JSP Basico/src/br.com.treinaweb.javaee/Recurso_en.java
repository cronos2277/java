package br.com.treinaweb.javaee;

import java.util.ListResourceBundle;

public class Recurso_en extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return contents;
  }

  static final Object[][] contents ={
    {"login.apresentacao","Welcome"},
    {"login.usuario","User:"},
    {"login.senha","Password:"},
    {"login.correto","Correct Login"},
    {"login.incorreto","Incorrect Login"},
  };
}
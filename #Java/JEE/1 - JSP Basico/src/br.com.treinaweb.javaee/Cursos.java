package br.com.treinaweb.javaee;

import java.io.Serializable;

public class Cursos implements Serializable {
  private static final long serialVersionUID = 1L;

  public String[] getListaCursos(){
    String[] lista = {"Java SE", "Java EE", "Java ME","Java FX"};
    return lista;
  }
}
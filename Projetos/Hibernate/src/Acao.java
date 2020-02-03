import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Acao {
	protected Gerente gerente;
	protected Formulario formulario;
	public Acao(Gerente gerente, Formulario formulario) {
		this.gerente = gerente;
		this.formulario = formulario;		
	}
	
	//Atualiza a tela quando ocorre uma opeacao de crud.
	protected void atualizarTela() {
		this.formulario.gerente.getAlunos(true);
		this.formulario.show(false);
		Inicio.main(new String[]{});
	}
	
	//preenche uma tabela com as informacoes do banco de dados.
	  public void fillTable(javax.swing.table.DefaultTableModel defaultTable,Gerente gerente) {
		  for(Aluno aluno: gerente.getAlunos(true)) { 	
			  defaultTable.addRow(aluno.getAllValues());
		    }
	  }
	  
	  //Cria uma classe de Mouse Listener
	  public Mouse getMouseListener() {
		  return new Mouse();
	  }  
	  
	  public Events getEventListener() {
		  return new Events();
	  }
	  
	  //pega todos os campos do input e transforma em aluno
	  protected Aluno toAlunoUpdatingOrCreating(boolean isUpdating) {
		  Aluno aluno = new Aluno();
		  aluno.setAlu_nome(this.formulario.jTextField2.getText());
		  aluno.setAlu_cidade(this.formulario.jTextField3.getText());
		  aluno.setAlu_fone(this.formulario.jTextField4.getText());
		  if(isUpdating) {
			  int id = Integer.parseInt(this.formulario.jTextField1.getText());
			  aluno.setAlu_codigo(id);
		  }else {
			  if(!this.isAlunoReady(aluno)) {
				  output("Esse nome ja esta cadastrado");
				  return null;
			  };
		  }

		  return aluno;
	  }
	  
	  //Verificando se nome existe
	  private boolean isAlunoReady(Aluno aluno) {
		  for(Aluno cada: this.gerente.getAlunos(true)) {
			  if(cada.getAlu_nome().toUpperCase().trim() == aluno.getAlu_nome().toUpperCase().trim()) {				  
				  return false;
			  }
		  }
		  return true;
	  }
	  
	  //Esse metodo coloca os dados do aluno selecionado nos inputs do formulario.
	  protected void putIntoFields(Aluno aluno) {
		  try {
			  String id = Integer.toString(aluno.getAlu_codigo());
			  formulario.jTextField1.setText(id);
			  formulario.jTextField2.setText(aluno.getAlu_nome());
			  formulario.jTextField3.setText(aluno.getAlu_cidade());
			  formulario.jTextField4.setText(aluno.getAlu_fone());
		  }catch(Exception e) {
			  formatError(e);
		  }
	  } 
	  
	//Classe que controla os eventos dos botoes e da tabela  
	 private class Events implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getSource() instanceof javax.swing.JButton) {
					String cmd = String.valueOf(e.getActionCommand());
					if(cmd == formulario.buttons_names[0]){ //Adicionado novo
						Aluno aluno = toAlunoUpdatingOrCreating(false);
						if(aluno.isRight()) {
							gerente.saveTransaction(aluno);
							output(aluno.getAlu_nome() + " Cadastrado com Sucesso!");
						}else {
							output("Erro ao inserir, Cidade e nome nao podem estar vazio");
						}
					}else if(cmd == formulario.buttons_names[1]) { //alterar
						Aluno aluno = toAlunoUpdatingOrCreating(true);
						if(aluno.isRight()) {
							gerente.updateTransaction(aluno);
							output(aluno.getAlu_nome() + " Atualizado com Sucesso!");
						}else {
							output("Erro ao editar, Cidade e nome nao podem estar vazio");
						}
					}else if(cmd == formulario.buttons_names[2]) {//pesquisar
						//Pesquisar
					}else if(cmd == formulario.buttons_names[3]) {//excluir
						int id = Integer.parseInt(formulario.jTextField1.getText());
						 Aluno aluno = gerente.getAluno(id);
						 if(aluno.isRight()) {
							 gerente.deleteTransaction(aluno);
							 output(aluno.getAlu_nome() + " Excluido com Sucesso!");
						 }else {
							 output("Erro ao excluir, Cidade e nome nao podem estar vazio");
						 }
					}
				}
				atualizarTela();
			}catch(Exception erro) {
				System.out.println("Erro lancado na classe Events");
				formatError(erro);
			}
		}
		 
	 }
		
	
	//Classe que controla o evento do mouse  
	  private class Mouse implements java.awt.event.MouseListener{		
		  
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			if(e.getSource() instanceof javax.swing.JTable) {
				javax.swing.JTable jtable = (javax.swing.JTable) e.getSource();
				int line = jtable.getSelectedRow();				
				Aluno aluno = gerente.getAlunos().get(line);
				putIntoFields(aluno);				
			}			
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
		}

		
	  }
	  
	  protected void formatError(Exception exception) {
			System.out.println(exception);
			JOptionPane.showMessageDialog(null, exception);
		}
	  
	  protected void output(String exception) {
			System.out.println(exception);
			JOptionPane.showMessageDialog(null, exception);
		}
}

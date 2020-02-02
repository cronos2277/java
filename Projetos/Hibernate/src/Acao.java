import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Acao {
	protected Gerente gerente;
	protected Formulario formulario;
	public Acao(Gerente gerente, Formulario formulario) {
		this.gerente = gerente;
		this.formulario = formulario;		
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
			if(e.getSource() instanceof javax.swing.JButton) {
				String cmd = String.valueOf(e.getActionCommand());
				if(cmd == formulario.buttons_names[0]){ //Adicionado novo
					System.out.println("criar novo");
				}else if(cmd == formulario.buttons_names[1]) { //alterar
					
				}else if(cmd == formulario.buttons_names[2]) {//salvar
					
				}else if(cmd == formulario.buttons_names[3]) {//excluir
					
				}else {
					formatError("Opcao Invalida");
				}
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
	  
	  protected void formatError(String exception) {
			System.out.println(exception);
			JOptionPane.showMessageDialog(null, exception);
		}
}

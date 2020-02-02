public class Acao {
	protected Gerente gerente;
	public Acao(Gerente gerente) {
		this.gerente = gerente;
	}
	
	  public void fillTable(javax.swing.table.DefaultTableModel defaultTable,Gerente gerente) {
		  for(Aluno aluno: gerente.getAlunos(true)) { 	
			  defaultTable.addRow(aluno.getAllValues());
		    }
	  }
	
	  public Mouse getMouseListener() {
		  return new Mouse();
	  }  
	  
	  
	  private class Mouse implements java.awt.event.MouseListener{
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			if(e.getSource() instanceof javax.swing.JTable) {
				javax.swing.JTable jtable = (javax.swing.JTable) e.getSource();
				int line = jtable.getSelectedRow();				
				Aluno aluno = gerente.getAlunos().get(line);
				System.out.println(aluno);
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
}

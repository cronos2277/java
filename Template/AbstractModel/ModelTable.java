package view;
import model.Person;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<Person> people = new ArrayList<Person>();
	public final String[] columns = new String[] {"ID", "Name","Date"};
	public static final int ID = 0;
	public static final int NAME = 1;
	public static final int DATE = 2;	
	
	public int getRowCount() {		
		return this.people.size();
	};

	public int getColumnCount() {		
		return columns.length;
	};
	
	@Override
	public String getColumnName(int columnIndex) {
	    return this.columns[columnIndex];
	};
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    switch (columnIndex) {
	    case ID:
	        return Integer.class;
	    case NAME:
	        return String.class;
	    case DATE:
	    	return Date.class;
	    default:	       
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return (columnIndex > 0)?true:false;
	}	

	public Object getValueAt(int rowIndex, int columnIndex) {		
	    Person person = people.get(rowIndex);	 
	    switch (columnIndex) {
	    case ID:
	        return person.getId();
	    case NAME:
	        return person.getName();
	    case DATE:
	    	return person.getDate();
	    default:	        
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	};
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {	    
		 Person person = people.get(rowIndex);		 
	    switch (columnIndex) {
	    case ID:{
	    	person.setId((Integer) aValue);
	    	this.people.add(person);
	    	break;
	    }
	    case NAME:{
	        person.setName((String) aValue);
	        this.people.add(person);
	        break;
	    }
	    case DATE:{
	        person.setDate((Date) aValue);
	        this.people.add(person);
	        break;
	    }
	    default:	    	
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	     
	    fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	public void add(int id, String name, Date date) {
		this.people.add(new Person(id,name,date));
		super.fireTableDataChanged();
	}
}

/*		
	Segue a lista dos métodos:
	Quais são os métodos da interface TableModel?	
	getRowCount: retorna a quantidade total de linhas. Com esta informação, a JTable sabe quantas linhas devem ser exibidas;
	getColumnCount: retorna a quantidade total de colunas que a JTable deve usar para montar a tabela;
	getColumnName(int columnIndex): retorna o nome da coluna referente ao índice especificado por parâmetro. O nome da coluna é usado para definir o texto do cabeçalho;
	getColumnClass(int columnIndex): retorna o tipo de dado associado a coluna especificada. Esta informação é utilizada para definir o “renderer” e o “editor” que serão associados às células pertencentes a coluna em questão;
	isCellEditable(int rowIndex, int columnIndex): retorna um valor booleano que diz se a célula especificada pode ter seu valor alterado ou não. Isto significa que o método “setValueAt” só terá efeito se o retorno deste método for true;
	getValueAt(int rowIndex, int columnIndex): retorna o conteúdo da célula especificada;
	setValueAt(Object value, int rowIndex, int columnIndex): define um novo valor para célula especificada;
	addTableModelListener(TableModelListener l): adiciona o TableModelListener especificado na lista de listeners a serem notificados das mudanças nos dados da tabela;
	removeTableModelListener(TableModelListener l): remove o TableModelListener especificado da lista de listeners a serem notificados.
	
	metodos do AbstractTableModel
	fireTableDataChanged: notifica que todos os dados da tabela podem ter sido alterados. A JTable usa esta informação para redesenhar todas as células, atualizando seu conteúdo;
	fireTableStructureChanged: notifica que a estrutura da tabela foi modificada. Isto significa que a quantidade, o nome ou tipo das colunas podem ter sido alteradas. Este tipo de evento faz com que a JTable reconstrua sua estrutura na tela;
	fireTableRowsInserted(int firstRow, int lastRow): notifica que as linhas na faixa especificada foram adicionadas, fazendo com que a JTable redesenhe apenas as linhas que foram afetadas;
	fireTableRowsUpdated(int firstRow, int lastRow): notifica que as linhas na faixa especificada tiveram seu valor atualizado;
	fireTableRowsDeleted(int firstRow, int lastRow): notifica que as linhas na faixa especificada foram removidas;
	fireTableCellUpdated(int row, int column): notifica que o conteúdo da célula especificada foi atualizado, fazendo com que a JTable redesenhe apenas a célula em questão.
 */

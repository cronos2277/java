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
	
	public ModelTable() {
		super();
	}
	
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
	    return false;
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
	
	@Override
	public void fireTableDataChanged() {		
		super.fireTableDataChanged();
	}
}


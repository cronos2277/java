package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JTable;

import view.ModelTable;
public class Mouse extends MouseAdapter {
	private int id = 0;
	private String name = "";
	private Date date = null;	
	
	@Override
	public void mouseClicked(MouseEvent event) {
		JTable table = App.spring.getBean(JTable.class);		
		int row = table.getSelectedRow();		
		this.id = Integer.parseInt(table.getValueAt(row, ModelTable.ID).toString());
		this.name = table.getValueAt(row, ModelTable.NAME).toString();
		this.date = (Date) table.getValueAt(row, ModelTable.DATE);
		System.out.println("Clicked on: "+table.getValueAt(row, table.getSelectedColumn()));
	}
	
	public int getInt() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getRecord() {
		return this.date;
	}

}

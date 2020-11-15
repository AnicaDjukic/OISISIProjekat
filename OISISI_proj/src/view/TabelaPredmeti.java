package view;

//Importi : 

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import model.Student;

import java.awt.Color;
import java.util.*;

public class TabelaPredmeti extends JTable { 
	
	public TabelaPredmeti() {
		Object[] colNames = {"Sifra predmeta : ", "Naziv predmeta : ", "ESPB : ", "Godina : ", "Semestar : "};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colNames);
		this.setModel(model);
		
		this.setRowHeight(25);
		this.setAutoCreateRowSorter(true);
		this.setFont(this.getFont().deriveFont(16F));
		
		//Poravnanje :
		DefaultTableCellRenderer poravnanje = new DefaultTableCellRenderer();
		poravnanje.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0; i < colNames.length; i++)
			getColumnModel().getColumn(i).setCellRenderer(poravnanje);
		//Test primer!
		
;		Object[] row = {"OISISI", "Oisisi", "8", "3", "5"};
		model.addRow(row);
		
	}

}

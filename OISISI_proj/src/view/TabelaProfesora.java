package view;

//Importi : 

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import model.Student;

import java.awt.Color;
import java.util.*;

public class TabelaProfesora extends JTable { 
	
	public TabelaProfesora() {
		Object[] colNames = {"Ime : ", "Prezime : ", "Titula : ", "Zvanje : "};
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
		
;		Object[] row = {"Nikola", "Milosavljevic", "Stalni profesor", "Doktor"};
		model.addRow(row);
		
	}

}

package view;

//Importi : 

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import model.Student;

import java.awt.Color;
import java.util.*;

public class TabelaStudenti extends JTable { 
	
	public TabelaStudenti() {
		Object[] colNames = {"Indeks : ", "Ime : ", "Prezime : ", "Godina studija : ", "Status : ", "Prosek : "};
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
		
;		Object[] row = {"RA5/2018", "Nikola", "Milosavljevic", "3", "B", "9.29"};
		model.addRow(row);
		
	}

}

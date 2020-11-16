package view;

//Importi : 

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.Student;

import java.awt.Color;
import java.util.*;

public class TabelaPredmeti extends JTable { 
	
	public TabelaPredmeti() {
		Object[] colNames = {"Sifra predmeta : ", "Naziv predmeta : ", "ESPB : ", "Godina : ", "Semestar : ", "Profesor : ", "Studenti : "};
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.setColumnIdentifiers(colNames);
		this.setModel(model);
		
		this.setRowHeight(35);
		this.setAutoCreateRowSorter(true);
		this.setFont(this.getFont().deriveFont(16F));
		
		//Poravnanje :
		NasCellRenderer poravnanje = new NasCellRenderer(NasCellRenderer.PREDMET_RENDER);
		for(int i = 0; i < colNames.length; i++)
			getColumnModel().getColumn(i).setCellRenderer(poravnanje);
		//Test primer!
		
		TableCellRenderer buttonRenderer = new TableButtonRenderer();
		getColumn("Studenti : ").setCellRenderer(buttonRenderer);
		
		JButton btn = new JButton("Dugme");
		
;		Object[] row = {"OISISI", "Oisisi", "8", "3", "5", "Nikola Milosavljevic", btn};
		model.addRow(row);
		
	}

}

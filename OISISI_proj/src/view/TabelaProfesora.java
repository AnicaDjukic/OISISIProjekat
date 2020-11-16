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

public class TabelaProfesora extends JTable { 
	
	public TabelaProfesora() {
		Object[] colNames = {"Ime : ", "Prezime : ", "Datum rodjenja : ", "Adresa stanovanja : ",
				             "Kontakt telefon : ", "Email : ", "Adresa kancelarije : ", "Broj licne karte : ",
				             "Titula : ", "Zvanje : ", "Spisak predmeta : "};
		DefaultTableModel model = new DefaultTableModel(){
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
		NasCellRenderer poravnanje = new NasCellRenderer(NasCellRenderer.PROFESOR_RENDER);
		for(int i = 0; i < colNames.length; i++)
			getColumnModel().getColumn(i).setCellRenderer(poravnanje);
		//Test primer!
		
		TableCellRenderer buttonRenderer = new TableButtonRenderer();
		getColumn("Spisak predmeta : ").setCellRenderer(buttonRenderer);
		
		JButton btn = new JButton("Dugme");
		
;		Object[] row = {"Nikola", "Milosavljevic", "-", "-", "-", "-", "-", "-", "-", "-", btn};
		model.addRow(row);
		
	}

}

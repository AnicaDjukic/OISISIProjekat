package view;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ControllerStudent;

public class TabelaStudenti extends JTable {
	
	public TabelaStudenti () {
		Object[] cols = {"Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
		DefaultTableModel tabela = new DefaultTableModel() {
			
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabela.setColumnIdentifiers(cols);
		setModel(tabela);
		
		setRowHeight(35);
		setAutoCreateRowSorter(true);
		setFont(getFont().deriveFont(16f));
		
		// Centriranje
		NasCellRenderer prikaz = new NasCellRenderer(NasCellRenderer.STUDENT_RENDER);
		for(Object o : cols) {
			getColumn(o).setCellRenderer(prikaz);
		}
		
		// Primer
		Object[] prvi = {"RA15/2018", "Pera", "Peric", "3", "B" , "9.5"};
		tabela.addRow(prvi);
	}
}

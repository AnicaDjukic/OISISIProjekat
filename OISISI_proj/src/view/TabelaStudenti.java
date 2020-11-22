package view;

//import controller.ControllerStudent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerStudent;
import model.Student;

public class TabelaStudenti extends JTable {
	
	
	private static DefaultTableModel tabela;
	
	public TabelaStudenti () {
		Object[] cols = {"Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
		tabela = new DefaultTableModel() {
			
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
		/*Object[] prvi = {"RA15/2018", "Pera", "Peric", "3", "B" , "9.5"};
		tabela.addRow(prvi);
		
		azurirajTabelu();*/
	}
	
	public static boolean dodajStudentaUTabelu(Student s, ControllerStudent cs) {
		String[] data = { s.getBrIndexa(), s.getIme(), s.getPrezime(), "", "", ""};
		data[3] = Integer.toString(s.getTrenutnaGodStud());;
		data[4] = s.getStatus();
		data[5] = Double.toString(s.getPosecnaOcena());

		if(!cs.dodajStudenta(s))
			return false;
		
		tabela.addRow(data);
		return true;
	}
	
}

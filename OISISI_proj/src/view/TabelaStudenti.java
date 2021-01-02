package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.ControllerStudent;
import model.Profesor;
import model.Student;

public class TabelaStudenti extends JTable {
	
	static ControllerStudent controller;
	
	private static String[] cols = {"Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
	static DefaultTableModel model;
	public static TabelaStudenti table;
	
	public TabelaStudenti() {
		table = this;
		controller = GlavniProzor.getControllerStudent();
		
		initializeTable(table);		

		updateTable();
	}
	
	public void initializeTable(TabelaStudenti table) {
		
		model = new DefaultTableModel() {
			
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		model.setColumnIdentifiers(cols);
		table.setModel(model);
		
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.setFont(table.getFont().deriveFont(16f));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Centriranje
		NasCellRenderer prikaz = new NasCellRenderer(NasCellRenderer.studentRenderer);
		for(Object o : cols) {
			table.getColumn(o).setCellRenderer(prikaz);
		}
	}
	
	public void updateTable() {
		ArrayList<Student> listaStudenata = controller.getListaStudenata();

		initializeTable(table);
		
		for(Student s : listaStudenata) {
			String[] data = { s.getBrIndexa(), s.getIme(), s.getPrezime(), "", "", ""};
			data[3] = Integer.toString(s.getTrenutnaGodStud());;
			data[4] = s.getStatus();
			data[5] = String.format("%.2f", s.getProsecnaOcena());
			
		    model.addRow(data);
		}
	}
	
}

package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.ControllerStudent;
import model.GlobalConstants;
import model.Student;

public class TabelaStudenti extends JTable {
	
	static ControllerStudent controller;
	
	private static String[] cols = {GlobalConstants.tabStudInd, GlobalConstants.tabStudIme, GlobalConstants.tabStudPrez, GlobalConstants.tabStudGS, GlobalConstants.tabStudStat, GlobalConstants.tabStudPros};
	static DefaultTableModel model;
	public static TabelaStudenti table;
	
	public TabelaStudenti() {
		cols[0] = GlobalConstants.tabStudInd;
		cols[1] = GlobalConstants.tabStudIme;
		cols[2] = GlobalConstants.tabStudPrez;
		cols[3] = GlobalConstants.tabStudGS;
		cols[4] = GlobalConstants.tabStudStat;
		cols[5] = GlobalConstants.tabStudPros;
		table = this;
		controller = GlavniProzor.getControllerStudent();
		
		initializeTable(table);		

		updateTable();
	}
	
	public void initializeTable(TabelaStudenti table) {
		
		model = new DefaultTableModel(new Object[0][], cols) {
			Class[] types = { String.class, String.class, String.class, Integer.class, String.class, Double.class};
			
			@Override
            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		model.setColumnIdentifiers(cols);
		table.setModel(model);
		
		table.setRowHeight(35);
		table.setFont(table.getFont().deriveFont(16f));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		
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

	public void izlistajStudente(ArrayList<String> foundStudents) {
		ArrayList<Student> listaStudenata = controller.getListaStudenata();

		initializeTable(table);
		
		for(Student stud : listaStudenata) {
			for(String s : foundStudents) {
				if(stud.getBrIndexa().equals(s)) {
					String[] data = { stud.getBrIndexa(), stud.getIme(), stud.getPrezime(), "", "", ""};
					data[3] = Integer.toString(stud.getTrenutnaGodStud());
					data[4] = stud.getStatus();
					data[5] = String.format("%.2f", stud.getProsecnaOcena());
					
				    model.addRow(data);
				}
			}
		}
	}
}

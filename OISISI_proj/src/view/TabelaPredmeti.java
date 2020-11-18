package view;

//Importi : 

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.Predmet;
import model.Profesor;
import controller.ControllerPredmet;

import java.awt.Color;
import java.util.*;

public class TabelaPredmeti extends JTable { 
	
	private static Object[] colNames = {"Sifra predmeta : ", "Naziv predmeta : ", "ESPB : ", "Godina : ", "Semestar : "};
	private DefaultTableModel model;
	private ControllerPredmet controllerPredmet;
	
	public TabelaPredmeti() {
		controllerPredmet = new ControllerPredmet();
		model = new DefaultTableModel() {
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
		
;		azurirajTabelu();
	}

	//Metoda za izlistavanje profesora : 
	
	void azurirajTabelu() {
		ArrayList<Predmet> listaPredmeta = controllerPredmet.getListaPredmeta();
		
		String sifra,naziv,espb,godina,semestar;
		Object[] row = {"", "", "", "", ""};
		
		for(Predmet p : listaPredmeta) {
			sifra = p.getSif_pred();
			naziv = p.getNaziv();
			espb = ""+p.getEspb_bod();
			godina = ""+p.getGodIzv();
			semestar = ""+p.getSemestar();
			
			row[0] = sifra;
			row[1] = naziv;
			row[2] = espb;
			row[3] = godina;
			row[4] = semestar;
			
			model.addRow(row);
		}
	}
	
}

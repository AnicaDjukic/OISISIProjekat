package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import controller.PredmetFocusListeners;
import model.GlobalConstants;
import model.Predmet;
import model.Profesor;

public class AddProfToPredDialog extends JDialog {

	JList<String> list;
	JButton potvrdi, odustani;
	
	
	public AddProfToPredDialog(Predmet predmet) {
		
		setResizable(true);
		setSize(320,250);
		setModal(true);
		setLocationRelativeTo(AddOrEditPredmet.inst);
		setTitle(GlobalConstants.dodavanjeProfPredDialog);
		
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		ArrayList<Profesor> profesori = GlavniProzor.getControllerProfesor().getListaProfesora(); 
		
		String[] data  =  new String[profesori.size()];
		int i = 0;
		for(Profesor prof : profesori) {
			data[i] = prof.getBrLicKart() + " " + prof.getIme() + " " + prof.getPrezime();
			i++;
		}
		
		list = new JList<String>(data); //data has type Object[]
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		//list.setPreferredSize(new Dimension(300,150));
		
		JScrollPane center = new JScrollPane(list);
		center.setMaximumSize(new Dimension(300,150));
		glavni.add(center,BorderLayout.CENTER);
		add(glavni);
		
		
		//glavni.add(list, BorderLayout.CENTER);
		
		/*JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 25));
		glavni.add(lab, BorderLayout.CENTER);*/
		
		add(glavni);
		
		JPanel dugmad = new JPanel();
		
		potvrdi = new JButton(GlobalConstants.btnOkName);
		//potvrdi.setEnabled(false);
		dugmad.add(potvrdi);
		
		odustani = new JButton(GlobalConstants.btnCncName);
		dugmad.add(odustani);
		
		add(dugmad,BorderLayout.SOUTH);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = new String();
				if(list.getSelectedIndex() != -1) {
					value = list.getSelectedValue();
					String id = value.substring(0,9);
					for(Profesor p : profesori)
						if(id.equals(p.getBrLicKart())) {
							predmet.setProf(p);
							AddOrEditPredmet.tProf.setText(p.getIme() + " " + p.getPrezime());
						}
					potvrdi.setEnabled(true);
					setVisible(false);
					PredmetFocusListeners.enableOrDisableButton();
					AddOrEditPredmet.tProf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					AddOrEditPredmet.minus.setEnabled(true);
					AddOrEditPredmet.plus.setEnabled(false);
				}
				potvrdi.setEnabled(false);
			}
			
		});
		
	}
	
}

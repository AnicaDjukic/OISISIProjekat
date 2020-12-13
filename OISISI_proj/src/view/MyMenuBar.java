package view;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.*;
import model.GlobalConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;

public class MyMenuBar extends JMenuBar {

	ControllerProfesor cProf;
	ControllerPredmet cPred;
	ControllerStudent cStud;
	
	public MyMenuBar() {
		
		JMenu mFile = new JMenu(GlobalConstants.menuFile);
		JMenuItem miNew = new JMenuItem(GlobalConstants.menuNew, new ImageIcon(GlobalConstants.addImg));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.addActionListener(new AddButtonListener());
		JMenuItem miClose = new JMenuItem(GlobalConstants.menuClose, new ImageIcon(GlobalConstants.closeImg));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] options = {"Da","Ne"};
				int code = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

		         if(code == JOptionPane.YES_OPTION){
		        	System.exit(0);
		         }
			}
		});
		
		mFile.setMnemonic(KeyEvent.VK_F);
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miClose);
		
		JMenu mEdit = new JMenu(GlobalConstants.menuEdit);
		JMenuItem miEdit = new JMenuItem(GlobalConstants.menuEdit, new ImageIcon(GlobalConstants.editImg));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem miDelete = new JMenuItem(GlobalConstants.menuDelete, new ImageIcon(GlobalConstants.delImg));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		mEdit.setMnemonic(KeyEvent.VK_E);
		mEdit.add(miEdit);
		mEdit.addSeparator();
		mEdit.add(miDelete);
		
		JMenu mHelp = new JMenu(GlobalConstants.menuHelp);
		JMenuItem miHelp = new JMenuItem(GlobalConstants.menuHelp, new ImageIcon(GlobalConstants.helpImg));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDialog help = new HelpDialog();
			    help.pack();
			    help.setLocationRelativeTo(null);
			    help.setVisible(true);
			}
		});
		
		
		JMenuItem miAbout = new JMenuItem(GlobalConstants.menuAbout, new ImageIcon(GlobalConstants.aboutImg));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				AboutDialog about = new AboutDialog();
				about.pack();
				about.setLocationRelativeTo(null);
				about.setVisible(true);
			}
		});

		
		mHelp.setMnemonic(KeyEvent.VK_H);
		mHelp.add(miHelp);
		mHelp.addSeparator();
		mHelp.add(miAbout);
		
		
		add(mFile);
		add(mEdit);
		add(mHelp);
	}
}
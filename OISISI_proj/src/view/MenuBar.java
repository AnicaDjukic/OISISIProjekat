package view;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;

public class MenuBar extends JMenuBar {
	
	public MenuBar() {
		
		JMenu mFile = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New", new ImageIcon("images/add_button.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem miClose = new JMenuItem("Close", new ImageIcon("images/icons8-close-window-24.png"));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		mFile.setMnemonic(KeyEvent.VK_F);
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miClose);
		
		JMenu mEdit = new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit", new ImageIcon("images/edit_button.png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("images/bin_button.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		mEdit.setMnemonic(KeyEvent.VK_E);
		mEdit.add(miEdit);
		mEdit.addSeparator();
		mEdit.add(miDelete);
		
		JMenu mHelp = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help", new ImageIcon("images/icons8-help-24.png"));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem miAbout = new JMenuItem("About", new ImageIcon("images/icons8-about-24.png"));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		mHelp.setMnemonic(KeyEvent.VK_H);
		mHelp.add(miHelp);
		mHelp.addSeparator();
		mHelp.add(miAbout);
		
		
		add(mFile);
		add(mEdit);
		add(mHelp);
		
		
	}
}
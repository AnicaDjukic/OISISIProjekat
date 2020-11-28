package view;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class MenuBar extends JMenuBar {
	
	public MenuBar() {
		
		JMenu mFile = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New", new ImageIcon("images/add_button.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem miClose = new JMenuItem("Close", new ImageIcon("images/close_button.png"));
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
		JMenuItem miHelp = new JMenuItem("Help", new ImageIcon("images/help_button.png"));
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
			
		
		JMenuItem miAbout = new JMenuItem("About", new ImageIcon("images/about_button.png"));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = "Aplikacija \"Studentska služba\"  \n"
					    + "Verzija: 1.0\n"
					    + "Aplikacija \"Studentska služba\" omogućava evidenciju studenata,"
					    + " profesora i predmeta,\n"
					    + "kako bi olakšala rad šalterskim radnicima studentske službe Fakulteta tehničkih nauka,\n"
					    + "Univerziteta u Novom Sadu.\n\n"
					    + "Autori: Anica Đukić i Nikola Milosavljević \n"
					    + "Studenti 3. godine smera \"Računarstvo i automatika\" Fakulteta tehničkih nauka,\n"
					    + "Univerziteta u Novom Sadu.\n";
					
				JTextArea textArea = new JTextArea(6, 25);
				textArea.setText(text);
				textArea.setEditable(false);

				JScrollPane scrollPane = new JScrollPane(textArea);
				scrollPane.setPreferredSize(new Dimension(500, scrollPane.getPreferredSize().height));
				     
				JOptionPane.showMessageDialog(null, scrollPane, "About", JOptionPane.INFORMATION_MESSAGE);
				
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

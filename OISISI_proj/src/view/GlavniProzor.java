package view;

//importi :
import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GlavniProzor extends JFrame {
	
	private Toolkit kit;
	
	public GlavniProzor() {
		kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 3/4;
		int screenWidth = screenSize.width * 3/4;
		
		setSize(screenWidth,screenHeight);
		
		setTitle("Studentska služba");
		
		addWindowListener(new MyWindowListener());
		
		setLocationRelativeTo(null);
		
		//Menu bar :
	    view.MenuBar menu = new view.MenuBar();
	    setJMenuBar(menu);
		
		//Toolbar :
		Toolbar toolbar = new Toolbar();
		add(toolbar,BorderLayout.NORTH);
		
		// Status bar
		JPanel statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
	}
	
	public class MyWindowListener implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) {
		
			JFrame mainFrame = (JFrame) e.getComponent();
			String [] options = {"Da","Ne"};
			int code = JOptionPane.showOptionDialog(mainFrame, "Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			
			if(code == JOptionPane.YES_OPTION) {
				mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			} else
				mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}
	}
	
}

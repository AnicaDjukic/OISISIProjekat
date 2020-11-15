package view;

//importi :
import javax.swing.*;

import java.awt.*;

public class GlavniProzor extends JFrame {
	
	public GlavniProzor() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 3/4;
		int screenWidth = screenSize.width * 3/4;
		
		setSize(screenWidth,screenHeight);
		
		setTitle("Studentska služba");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		//Sminkanje :
		Dimension d = statusBar.getSize();
		
		JPanel separatorEast = new JPanel();
		separatorEast.setSize(d.height,200);
		add(separatorEast,BorderLayout.EAST);
		
		JPanel separatorWest = new JPanel();
		separatorWest.setSize(d.height,200);
		add(separatorWest,BorderLayout.WEST);
		
		//Tabbed pane:
		JTabbedPane tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
	}
	
}

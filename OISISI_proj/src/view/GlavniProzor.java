package view;

//importi :
import javax.swing.*;

import java.awt.*;

public class GlavniProzor extends JFrame {
	
	private Toolkit kit;
	
	public GlavniProzor() {
		kit = Toolkit.getDefaultToolkit();
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
		
	}
	
}

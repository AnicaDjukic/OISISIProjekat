package view;

//importi :
import javax.swing.*;
import java.awt.*;

import controller.*;
import model.GlobalConstants;

public class GlavniProzor extends JFrame {
	
	private Toolkit kit;
	static view.MenuBar menu;
	static Toolbar toolbar;
	static JPanel statusBar;
	static TabbedPane tabbedPane;
	static GlavniProzor inst;
	
	static ControllerProfesor cProf;
	static ControllerPredmet cPred;
	static ControllerStudent cStud;
	
	public GlavniProzor() {
		inst = this;
		kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 3/4;
		int screenWidth = screenSize.width * 3/4;
		
		setSize(screenWidth,screenHeight);
		setTitle(GlobalConstants.mfName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Incijalizacija kontrolera:
		cProf = new ControllerProfesor();
		cPred = new ControllerPredmet();
		cStud = new ControllerStudent();
		
		//Menu bar :
	    menu = new MenuBar();
	    setJMenuBar(menu);
		
		//Toolbar :
		toolbar = new Toolbar();
		add(toolbar,BorderLayout.NORTH);
		
		// Status bar
		statusBar = new StatusBar();
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
		tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
	}
	//Geteri : 
	public static TabbedPane getTabbedPane() {
		if(tabbedPane == null)
			tabbedPane = new TabbedPane();
		return tabbedPane;
	}
	public static GlavniProzor getGlavniProzor() {
		if(inst == null)
			inst = new GlavniProzor();
		return inst;
	}
	
	//Geteri za kontrolere :
	public static ControllerProfesor getControllerProfesor() {
		return cProf;
	}
	public static ControllerPredmet getControllerPredmet() {
		return cPred;
	}
	public static ControllerStudent getControllerStudent() {
		return cStud;
	}
}

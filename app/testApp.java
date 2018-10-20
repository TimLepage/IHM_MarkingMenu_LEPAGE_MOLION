package app;


import javax.swing.SwingUtilities;

import view.View;

public class testApp {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
		
	private static void createAndShowGUI(){
		new View();
	}

}

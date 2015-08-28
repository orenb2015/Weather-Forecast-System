package gui;

import java.awt.EventQueue;

public class MainApplication {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplicationController controller = new MainApplicationController();
					controller.control();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

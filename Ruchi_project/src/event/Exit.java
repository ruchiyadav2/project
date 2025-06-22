package event;

import javax.swing.JFrame;

public class Exit extends JFrame {
	public Exit() {
		
		setSize(400,400);
		setVisible(true);
		new Login();
		dispose();
	}
	public static void main(String[] args) {
		new Exit();
	}

}

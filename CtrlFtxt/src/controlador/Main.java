package controlador;

import visual.Frame;
import visual.Panel;

public class Main {
	
	Frame frame;
	Panel panel;
	ControladorPanel cp;
	
	public Main() {
		panel = new Panel();
		frame = new Frame(panel);
		cp = new ControladorPanel(panel, frame);
	}

	public static void main(String[] args) {
		new Main();
	}

}

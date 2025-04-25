package visual;

import javax.swing.JFrame;

public class Frame extends JFrame{

	public Frame(Panel panel) {
		super();
		this.add(panel);
		this.setTitle("Ctrl+F em txt");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setVisible(true);
	}
}

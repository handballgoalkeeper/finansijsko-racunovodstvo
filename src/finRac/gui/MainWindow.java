package finRac.gui;

import java.awt.*;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainWindow() throws HeadlessException {
		super();
	}

	public MainWindow(GraphicsConfiguration gc) {
		super(gc);
	}

	public MainWindow(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	public MainWindow(String title) throws HeadlessException {
		super(title);
	}

	public void init() {
		JFrame frame = new JFrame();
		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setTitle("Finansijsko racunovodstvo - Dimitrije Jelic");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		device.setFullScreenWindow(frame);
	}
}

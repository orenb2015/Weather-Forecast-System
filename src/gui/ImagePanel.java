package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

/**
 * we use this class for background
 * taken from http://stackoverflow.com/questions/1064977/setting-background-images-in-jframe
 */
class ImagePanel extends JComponent {
	private Image image;

	public ImagePanel(Image image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, this);
	}
}

package uy.edu.um.ui.clasesAuxiliares;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(URL dirFondo) {
		this(new ImageIcon(dirFondo).getImage());
	}

	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.setClip(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		this.paintComponent(g);
		this.paintChildren(g);
	}

}

package com.github.brockstar17;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.github.brockstar17.util.BoardSpaces;
import com.github.brockstar17.util.ImageUtils;

@SuppressWarnings("serial")
public class CardWars extends JFrame implements MouseMotionListener, MouseListener {

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenX;
	public static int screenY = (int) screenSize.getHeight() - 40;

	public static BufferedImage board = null;
	public static BufferedImage yin = null;
	public static BufferedImage hl = null;

	public static int cellW, cellH;
	public static int mx, my;

	public CardWars() {

		try {
			board = ImageIO.read(new File("src/resources/board.png"));

			screenX = ImageUtils.calcWidth(board.getHeight(), screenY, board.getWidth());

			board = ImageUtils.scale(board, screenX, screenY);

			yin = ImageIO.read(new File("src/resources/yin.png"));
			yin = ImageUtils.scale(yin, ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()),
					(int) (screenY * .2));

			hl = ImageIO.read(new File("src/resources/highlight.png"));
			hl = ImageUtils.scale(hl, ImageUtils.calcWidth(hl.getHeight(), screenY * .233, hl.getWidth()),
					(int) (screenY * .232));

			cellW = hl.getWidth();
			cellH = hl.getHeight();
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}

		BoardSpaces.initCorners();

		Container c = getContentPane();
		c.add(new Paint());
		c.addMouseMotionListener(this);
		c.addMouseListener(this);
	}

	public static void main(String[] args) {

		JFrame frame = new CardWars();

		frame.setSize(screenX, screenY);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	// -------------------------------------------------------------------------------------\\

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	// this function will be for hovering
	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		repaint();
	}

	// -------------------------------------------------------------------------------------\\

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	// this is the other click function
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	// this is the click function
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}

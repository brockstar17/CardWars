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

import com.github.brockstar17.util.ImageUtils;

@SuppressWarnings("serial")
public class CardWars extends JFrame implements MouseMotionListener, MouseListener
{

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenX;
	public static int screenY = (int) screenSize.getHeight() - 40;

	public static BufferedImage board = null;
	public static BufferedImage yin = null;

	// .7111756168359942

	public CardWars()
	{

		try
		{
			board = ImageIO.read(new File("src/resources/board.png"));

			screenX = ImageUtils.calcWidth(board.getHeight(), screenY, board.getWidth());

			board = ImageUtils.scale(board, screenX, screenY);

			yin = ImageIO.read(new File("src/resources/yin.png"));
			yin = ImageUtils.scale(yin, (int) (screenX * .13), ImageUtils.cardScale(screenX * .13));
		} catch (IOException e)
		{

		}

		Container c = getContentPane();
		c.add(new Paint());
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
	public void mouseDragged(MouseEvent arg0) {
	}

	// this function will be for hovering
	@Override
	public void mouseMoved(MouseEvent arg0) {
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

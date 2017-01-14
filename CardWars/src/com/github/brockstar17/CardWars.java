package com.github.brockstar17;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class CardWars extends JFrame implements MouseMotionListener, MouseListener, KeyListener {

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenX;
	public static int screenY = (int) screenSize.getHeight() - 40;

	public static BufferedImage board = null;
	public static BufferedImage yin = null;
	public static BufferedImage hl = null;
	public static BufferedImage sel = null;
	public static BufferedImage turn = null;

	public static int cellW, cellH;
	public static int mx, my;
	
	public static boolean deckClicked; //true if deck spaces are clicked
	public static boolean player1 = true; //true when it is player 1's turn
	public static boolean select = false;
	public static boolean highlight = true;

	public CardWars() {

		super("Card Wars");
		
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
			
			sel = ImageIO.read(new File("src/resources/selector.png"));
			sel = ImageUtils.scale(sel, ImageUtils.calcWidth(sel.getHeight(), screenY * .233, sel.getWidth()), (int) (screenY * .232));
			
			turn = ImageIO.read(new File("src/resources/turn.png"));
			turn = ImageUtils.scale(turn, ImageUtils.calcWidth(turn.getHeight(), screenY * .233, turn.getWidth()), (int) (screenY * .232));
			
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
		addKeyListener(this);
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
		if(player1)
		{
			int cell = BoardSpaces.getCell(mx, my);
			if((cell == 10 || cell == 5 || cell == 16 || cell == 17 || cell == 18) && deckClicked)
			{
				spawnCard(BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), cell);
			}
			else if(cell == 15)
			{
				//System.out.println("Deck Clicked");
				deckClicked = !deckClicked;
			}
			else if(cell != 4)
			{
				if(Paint.pCards[cell] != null && !select)
				{
					select = true;
					highlight = false;
					Paint.setClicked(cell);
				}
				else if(Paint.pCards[cell] == null && select)
				{
					select = false;
					highlight = true;
					Paint.pCards[Paint.clicked].setX(BoardSpaces.getCellX(cell) + Paint.cardSpaceX);
					Paint.pCards[Paint.clicked].setY(BoardSpaces.getCellY(cell) + Paint.cardSpaceY);
					Paint.pCards[cell] = Paint.pCards[Paint.clicked];
					Paint.pCards[Paint.clicked] = null;
				}
				else if(Paint.pCards[cell] != null && select)
				{
					select = false;
					highlight = true;
				}
				
			}
		}
			
		repaint();
	}
	
	public void spawnCard(int x, int y, int i){
		if(Paint.pCards[i] == null)
		{
			//System.out.println("Placed");
			Paint.pCards[i] = (new PlayerCard(x, y, cellW, cellH));
		}
	}

	// -------------------------------------------------------------------------------------\\
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key)
		{
		case KeyEvent.VK_ENTER:
			player1 = !player1;
			break;
			
		case KeyEvent.VK_ESCAPE:
			select = false;
			highlight = true;
			break;
		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}

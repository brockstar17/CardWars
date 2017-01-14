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
	public static BufferedImage[] hearts = new BufferedImage[13];
	public static BufferedImage[] spades = new BufferedImage[13];
	public static BufferedImage[] clubs = new BufferedImage[13];
	public static BufferedImage[] diamonds = new BufferedImage[13];
	public static BufferedImage cardSel = null;

	public static int cellW, cellH;
	public static int mx, my;
	
	public static boolean deckClicked; //true if deck spaces are clicked
	public static boolean player1 = true; //true when it is player 1's turn
	public static boolean select = false;
	public static boolean highlight = true;
	private static int turnCount;
	private boolean cardMoved;
	private boolean cardSpawned;
	private int totCards;

	public CardWars() {

		super("Card Wars");
		
		try {
			board = ImageIO.read(new File("src/resources/board.png"));

			screenX = ImageUtils.calcWidth(board.getHeight(), screenY, board.getWidth());

			board = ImageUtils.scale(board, screenX, screenY);

			yin = ImageIO.read(new File("src/resources/yin.png"));
			
			for(int i = 0; i < hearts.length; i++)
			{
				hearts[i] = ImageIO.read(new File("src/resources/hearts/" + (i+1) + ".png"));
				
				spades[i] = ImageIO.read(new File("src/resources/spades/" + (i+1) + ".png"));
				
				clubs[i] = ImageIO.read(new File("src/resources/clubs/" + (i+1) + ".png"));
				
				diamonds[i] = ImageIO.read(new File("src/resources/diamonds/" + (i+1) + ".png"));
				
				spades[i] = ImageUtils.scale(spades[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()),
					(int) (screenY * .2));
				clubs[i] = ImageUtils.scale(clubs[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()),
					(int) (screenY * .2));
				diamonds[i] = ImageUtils.scale(diamonds[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()),
					(int) (screenY * .2));
				hearts[i] = ImageUtils.scale(hearts[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()),
					(int) (screenY * .2));
			}
			
			
			
			yin = ImageUtils.scale(yin, ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()),
					(int) (screenY * .2));

			hl = ImageIO.read(new File("src/resources/highlight.png"));
			hl = ImageUtils.scale(hl, ImageUtils.calcWidth(hl.getHeight(), screenY * .233, hl.getWidth()),
					(int) (screenY * .232));
			
			sel = ImageIO.read(new File("src/resources/selector.png"));
			sel = ImageUtils.scale(sel, ImageUtils.calcWidth(sel.getHeight(), screenY * .233, sel.getWidth()), (int) (screenY * .232));
			
			turn = ImageIO.read(new File("src/resources/turn.png"));
			turn = ImageUtils.scale(turn, ImageUtils.calcWidth(turn.getHeight(), screenY * .233, turn.getWidth()), (int) (screenY * .232));
			
			cardSel = ImageIO.read(new File("src/resources/cardHighlight.png"));
			cardSel = ImageUtils.scale(cardSel, yin.getWidth(), yin.getHeight());
			
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
				cardSpawned = true;
				countTurn();
				//System.out.println(totCards);
			}
			else if(cell == 15 && !cardSpawned && totCards < 5)
			{
				//System.out.println("Deck Clicked");
				
				deckClicked = !deckClicked;
				
			}
			else if(cell != 4)
			{
				if(Paint.pCards[cell] != null && !select && !cardMoved)
				{
					select = true;
					highlight = false;
					Paint.setClicked(cell);
				}
				else if(Paint.pCards[cell] == null && select)
				{
					if(!cardMoved)
					{
						select = false;
						highlight = true;
						Paint.pCards[Paint.clicked].setX(BoardSpaces.getCellX(cell) + Paint.cardSpaceX);
						Paint.pCards[Paint.clicked].setY(BoardSpaces.getCellY(cell) + Paint.cardSpaceY);
						Paint.pCards[cell] = Paint.pCards[Paint.clicked];
						Paint.pCards[Paint.clicked] = null;
						
						cardMoved = true;
						countTurn();
						
					}
				}
				else if(Paint.pCards[cell] != null && select)
				{
					select = false;
					highlight = true;
				}
				
			}
		}
		
		if(!player1)
		{
			cardMoved = false;
			cardSpawned = false;
		}
		
		
			
		repaint();
	}
	
	public void spawnCard(int x, int y, int i){
		if(Paint.pCards[i] == null)
		{
			//System.out.println("Placed");
			Paint.pCards[i] = (new PlayerCard(x, y, cellW, cellH));
			deckClicked = !deckClicked;
			if(totCards < 5)
			{
				totCards++;
			}
			
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
			cardMoved = false;
			cardSpawned = false;
			turnCount = 0;
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
	
	private void countTurn(){
		if(turnCount < 1 && totCards < 5)
		{
			turnCount++;
		}
		else
		{
			turnCount=0;
			player1 = !player1;
		}
	}
}

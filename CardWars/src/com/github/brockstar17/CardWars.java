package com.github.brockstar17;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.brockstar17.attack.AttackFrame;
import com.github.brockstar17.deck.DeckFrame;
import com.github.brockstar17.rules.RulesFrame;
import com.github.brockstar17.util.BoardSpaces;
import com.github.brockstar17.util.CardFrame;
import com.github.brockstar17.util.GameUtils;
import com.github.brockstar17.util.ImageUtils;

@SuppressWarnings("serial")
public class CardWars extends JFrame implements MouseMotionListener, MouseListener, KeyListener
{

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenX;
	public static int screenY = (int) screenSize.getHeight() - 40;

	public static BufferedImage board = null;
	public static BufferedImage yin = null;
	public static BufferedImage paris = null;
	public static BufferedImage celtic = null;
	public static BufferedImage geo = null;
	public static BufferedImage tesselate = null;
	public static BufferedImage pretzel = null;
	public static BufferedImage brighty = null;
	public static BufferedImage hl = null;
	public static BufferedImage sel = null;
	public static BufferedImage turn = null;
	public static BufferedImage[] hearts = new BufferedImage[13];
	public static BufferedImage[] spades = new BufferedImage[13];
	public static BufferedImage[] clubs = new BufferedImage[13];
	public static BufferedImage[] diamonds = new BufferedImage[13];
	public static BufferedImage cardSelBack = null;
	public static BufferedImage attackBack = null;
	public static BufferedImage flame1 = null;
	public static BufferedImage flame2 = null;
	public static BufferedImage behFlame = null;
	public static BufferedImage rules = null;

	public static int cellW, cellH;
	public static int mx, my;

	public static boolean deckClicked; // true if deck spaces are clicked
	public static boolean player1 = true; // true when it is player 1's turn
	public static boolean select = false;
	public static boolean highlight = true;
	private static int turnCount;
	private boolean cardMoved;
	private boolean cardSpawned;
	private int playCards;
	private int oppCards;
	private boolean cardSelected;
	private PlayingCard selectedCard;
	public static boolean canPlaceCard;
	public String winner;

	public static int backDeck = 5;
	public static int userDeck;

	public static ArrayList<PlayingCard> playerDeck = new ArrayList<PlayingCard>();
	public static ArrayList<PlayingCard> otherDeck = new ArrayList<PlayingCard>();
	public static ArrayList<PlayingCard> playerDiscard = new ArrayList<PlayingCard>();
	public static ArrayList<PlayingCard> otherDiscard = new ArrayList<PlayingCard>();

	public static Font QSB;

	public CardWars()
	{

		super("Card Wars");

		// setUndecorated(true);
		JPanel p = (JPanel) getContentPane();
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

		try
		{

			board = ImageIO.read(new File("src/resources/parchBoard.png"));

			screenX = ImageUtils.calcWidth(board.getHeight(), screenY, board.getWidth());

			board = ImageUtils.scale(board, screenX, screenY);

			yin = ImageIO.read(new File("src/resources/cards/grace.png"));

			for(int i = 0; i < hearts.length; i++)
			{
				hearts[i] = ImageIO.read(new File("src/resources/hearts/" + (i + 1) + ".png"));

				spades[i] = ImageIO.read(new File("src/resources/spades/" + (i + 1) + ".png"));

				clubs[i] = ImageIO.read(new File("src/resources/clubs/" + (i + 1) + ".png"));

				diamonds[i] = ImageIO.read(new File("src/resources/diamonds/" + (i + 1) + ".png"));

				spades[i] = ImageUtils.scale(spades[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()), (int) (screenY * .2));
				clubs[i] = ImageUtils.scale(clubs[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()), (int) (screenY * .2));
				diamonds[i] = ImageUtils.scale(diamonds[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()), (int) (screenY * .2));
				hearts[i] = ImageUtils.scale(hearts[i], ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()), (int) (screenY * .2));
			}

			yin = ImageUtils.scale(yin, ImageUtils.calcWidth(yin.getHeight(), screenY * .2, yin.getWidth()), (int) (screenY * .2));

			paris = ImageIO.read(new File("src/resources/cards/circuit.png"));
			paris = ImageUtils.scale(paris, yin.getWidth(), yin.getHeight());

			celtic = ImageIO.read(new File("src/resources/cards/celtic.png"));
			celtic = ImageUtils.scale(celtic, yin.getWidth(), yin.getHeight());
			geo = ImageIO.read(new File("src/resources/cards/geometric.png"));
			geo = ImageUtils.scale(geo, yin.getWidth(), yin.getHeight());
			pretzel = ImageIO.read(new File("src/resources/cards/pretzel.png"));
			pretzel = ImageUtils.scale(pretzel, yin.getWidth(), yin.getHeight());
			tesselate = ImageIO.read(new File("src/resources/cards/tesselate.png"));
			tesselate = ImageUtils.scale(tesselate, yin.getWidth(), yin.getHeight());
			brighty = ImageIO.read(new File("src/resources/cards/brighty.png"));
			brighty = ImageUtils.scale(brighty, yin.getWidth(), yin.getHeight());

			hl = ImageIO.read(new File("src/resources/highlight.png"));
			hl = ImageUtils.scale(hl, ImageUtils.calcWidth(hl.getHeight(), screenY * .233, hl.getWidth()), (int) (screenY * .232));

			sel = ImageIO.read(new File("src/resources/selector.png"));
			sel = ImageUtils.scale(sel, ImageUtils.calcWidth(sel.getHeight(), screenY * .233, sel.getWidth()), (int) (screenY * .232));

			turn = ImageIO.read(new File("src/resources/turn.png"));
			turn = ImageUtils.scale(turn, ImageUtils.calcWidth(turn.getHeight(), screenY * .233, turn.getWidth()), (int) (screenY * .232));

			flame1 = ImageIO.read(new File("src/resources/flames/flame5.png"));
			flame2 = ImageIO.read(new File("src/resources/flames/flame6.png"));
			flame1 = ImageUtils.scale(flame1, yin.getWidth(), ImageUtils.calcWidth(flame1.getWidth(), yin.getWidth(), flame1.getHeight()));
			flame2 = ImageUtils.scale(flame2, flame1.getWidth(), flame1.getHeight());
			behFlame = ImageIO.read(new File("src/resources/flames/behindFlame.png"));
			behFlame = ImageUtils.scale(behFlame, yin.getWidth(), yin.getHeight());

			cardSelBack = ImageIO.read(new File("src/resources/cardSelectBackParch.png"));
			attackBack = ImageIO.read(new File("src/resources/attackBackParch.png"));

			rules = ImageIO.read(new File("src/resources/RulesParch.png"));
			rules = ImageUtils.scale(rules, screenX, ImageUtils.calcWidth(rules.getWidth(), screenX, rules.getHeight()));

			cellW = hl.getWidth();
			cellH = hl.getHeight();

		} catch (IOException e)
		{
			System.out.println("Something went wrong");
		}

		BoardSpaces.initCorners();
		GameUtils.initShuffle();

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
		int cell = BoardSpaces.getCell(mx, my);

		if(player1)
		{

			if((cell == 10 || cell == 5 || cell == 16 || cell == 17 || cell == 18) && deckClicked && cardSelected)
			{
				spawnCard(BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), cell);
				cardSpawned = true;
				countTurn();
				// System.out.println(playCards);
			}
			else if(cell == 15 && !cardSpawned && playCards < 5)
			{
				// System.out.println("Deck Clicked");

				deckClicked = !deckClicked;

				if(deckClicked)
				{

					this.setEnabled(false);
					new CardFrame(this);
				}

			}
			else if(cell != 4 && cell != -1)
			{
				if(Paint.pCards[cell] != null && !select && !cardMoved)
				{
					select = true;
					highlight = false;

					Paint.setClicked(cell);
				}
				else if(Paint.pCards[cell] == null)
				{
					if(!cardMoved)
					{
						if(Paint.pCards[Paint.clicked] != null)
						{
							if(GameUtils.canMove(cell, Paint.clicked) && canPlaceCard)
							{

								if(Paint.oCards[cell] == null)
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
								else if(Paint.oCards[cell] != null)// attacking
								{
									this.setEnabled(false);

									new AttackFrame(this, Paint.pCards[Paint.clicked], Paint.oCards[cell], cell);

								}

							}

						}

					}
				}
				else if(Paint.pCards[cell] != null && select)
				{
					select = false;
					highlight = true;
				}

			}
		}
		else
		{
			if((cell == 9 || cell == 14 || cell == 1 || cell == 2 || cell == 3) && deckClicked && cardSelected)
			{
				spawnCard(BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), cell);
				cardSpawned = true;
				cardSelected = false;
				countTurn();
				// System.out.println(playCards);
			}

			else if(cell == 4 && !cardSpawned && oppCards < 5)
			{
				// System.out.println("Deck Clicked");

				deckClicked = !deckClicked;

				if(deckClicked)
				{

					this.setEnabled(false);
					new CardFrame(this);
				}

			}
			else if(cell != 15 && cell != -1)
			{
				if(Paint.oCards[cell] != null && !select && !cardMoved)
				{
					select = true;
					highlight = false;

					Paint.setClicked(cell);
				}
				else if(Paint.oCards[cell] == null)
				{
					if(!cardMoved)
					{
						if(Paint.oCards[Paint.clicked] != null)
						{
							if(GameUtils.canMove(cell, Paint.clicked) && canPlaceCard)
							{
								if(Paint.pCards[cell] == null)
								{
									select = false;
									highlight = true;

									Paint.oCards[Paint.clicked].setX(BoardSpaces.getCellX(cell) + Paint.cardSpaceX);
									Paint.oCards[Paint.clicked].setY(BoardSpaces.getCellY(cell) + Paint.cardSpaceY);
									Paint.oCards[cell] = Paint.oCards[Paint.clicked];
									Paint.oCards[Paint.clicked] = null;

									cardMoved = true;
									countTurn();
								}
								else if(Paint.pCards[cell] != null)// attacking
								{
									this.setEnabled(false);

									new AttackFrame(this, Paint.pCards[cell], Paint.oCards[Paint.clicked], cell);

								}
							}

						}

					}
				}
				else if(Paint.oCards[cell] != null && select)
				{
					select = false;
					highlight = true;
				}

			}
		}

		repaint();

	}

	public void spawnCard(int x, int y, int i) {
		if(player1)
		{
			if(Paint.pCards[i] == null)
			{
				// System.out.println("Placed");
				Paint.pCards[i] = (selectedCard);
				deckClicked = !deckClicked;

				if(playCards < 5)
				{
					playCards++;
				}

			}
		}
		else
		{
			if(Paint.oCards[i] == null)
			{
				// System.out.println("Placed");
				Paint.oCards[i] = (selectedCard);
				deckClicked = !deckClicked;

				if(oppCards < 5)
				{
					oppCards++;
				}

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
			if(select)
			{
				select = false;
				highlight = true;
			}
			else
			{

				// bring up rules
				this.setEnabled(false);
				new RulesFrame(this);

			}
			break;
		case KeyEvent.VK_G:
			for(int i = 0; i < otherDiscard.size(); i++)
			{
				System.out.println("Other Disc " + i + " " + otherDiscard.get(i).getName());
			}

			for(int i = 0; i < playerDiscard.size(); i++)
			{
				System.out.println("Player Disc " + i + " " + playerDiscard.get(i).getName());
			}
			break;
		case KeyEvent.VK_D:
			this.setEnabled(false);
			new DeckFrame(this);
			break;
		case KeyEvent.VK_F1:
			// rules
			this.setEnabled(false);
			new RulesFrame(this);
			break;

		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void countTurn() {
		if(turnCount < 1 && ((playCards < 5 && player1) || (oppCards < 5 && !player1)))
		{
			turnCount++;
		}
		else
		{
			turnCount = 0;
			player1 = !player1;
			cardMoved = false;
			cardSpawned = false;
		}

	}

	public void setCardSelected(boolean selected) {
		this.cardSelected = selected;
	}

	public void setSelectedCard(PlayingCard card) {
		this.selectedCard = card;
	}

	public void decrPlayCard() {
		this.playCards--;
	}

	public void decrOppCards() {
		this.oppCards--;
	}

}

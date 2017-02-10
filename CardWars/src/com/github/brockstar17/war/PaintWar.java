package com.github.brockstar17.war;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.util.BoardSpaces;

@SuppressWarnings("serial")
public class PaintWar extends JPanel implements MouseMotionListener
{

	public static int cardSpaceX = (int) (CardWars.screenX * .034),
			cardSpaceY = (int) (CardWars.screenY * .0165);
	public static int clicked;
	protected int mx = 0, my = 0;
	// private boolean highlight;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		addMouseMotionListener(this);

		g.drawImage(CardWars.board, 0, 0, null);

		// drawDeck(g);

		drawCards(g);

		highlight(g);

		// g.drawImage(CardWars.hearts[11], BoardSpaces.getCellX(0) + cardSpaceX, BoardSpaces.getCellY(0) + cardSpaceY, null);

	}

	private void drawCards(Graphics g) {

		for(int i = 0; i < Paint.pCards.length; i++)
		{
			if(Paint.pCards[i] != null && i != 4 && i != 15)
			{
				g.drawImage(getDeckBack(CardWars.userDeck, 0), BoardSpaces.getCellX(i) + cardSpaceX, BoardSpaces.getCellY(i) + cardSpaceY, null);
			}
		}

		for(int i = 0; i < Paint.oCards.length; i++)
		{
			if(Paint.oCards[i] != null && i != 4 && i != 15)
			{
				g.drawImage(getDeckBack(CardWars.backDeck, CardWars.userDeck), BoardSpaces.getCellX(i) + cardSpaceX, BoardSpaces.getCellY(i) + cardSpaceY, null);
			}
		}

	}

	private void highlight(Graphics g) {

		int cell = BoardSpaces.getCell(this.mx, this.my);

		if(CardWars.player1)
		{
			if(Paint.cellHighCard && cell != -1)
			{
				BufferedImage[] suit = getSuitArray(Paint.pCards[cell].getSuit());

				if(suit != null)
				{
					g.drawImage(suit[Paint.pCards[cell].getValue() - 1], BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);

				}

			}
			else if(cell != -1 && cell != 4 && cell != 15)
			{
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), null);

			}
		}
		else
		{
			if(Paint.cellHighCard && cell != -1)
			{
				BufferedImage[] suit = getSuitArray(Paint.oCards[cell].getSuit());

				if(suit != null)
				{
					g.drawImage(suit[Paint.oCards[cell].getValue() - 1], BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);

				}

			}
			else if(cell != -1 && cell != 4 && cell != 15)
			{
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), null);

			}
		}

	}

	public static BufferedImage[] getSuitArray(String suit) {
		switch(suit)
		{
		case "hearts":
			return CardWars.hearts;
		case "clubs":
			return CardWars.clubs;
		case "spades":
			return CardWars.spades;
		case "diamonds":
			return CardWars.diamonds;
		default:
			return null;
		}
	}

	public static BufferedImage getDeckBack(int user, int opp) {
		switch(user)
		{
		case 1:
			if(opp != user)
			{
				return CardWars.yin;
			}
			return CardWars.paris;

		case 2:
			if(opp != user)
			{
				return CardWars.tesselate;
			}
			return CardWars.geo;
		case 3:
			if(opp != user)
			{
				return CardWars.geo;
			}
			return CardWars.celtic;
		case 4:
			if(opp != user)
			{
				return CardWars.celtic;
			}
			return CardWars.pretzel;
		case 5:
			if(opp != user)
			{
				return CardWars.paris;
			}
			return CardWars.brighty;
		case 6:
			if(opp != user)
			{
				return CardWars.brighty;
			}
			return CardWars.tesselate;
		default:
			if(opp != user)
			{
				return CardWars.pretzel;
			}
			return CardWars.yin;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	// this function will be for hovering
	@Override
	public void mouseMoved(MouseEvent e) {
		this.mx = e.getX();
		this.my = e.getY();
		repaint();
	}
}

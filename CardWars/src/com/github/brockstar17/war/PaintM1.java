package com.github.brockstar17.war;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;
import com.github.brockstar17.util.BoardSpaces;

@SuppressWarnings("serial")
public class PaintM1 extends JPanel
{
	public static PlayingCard[] pCards = Paint.pCards;
	public static PlayingCard[] oCards = Paint.oCards;
	public static int cardSpaceX = (int) (CardWars.screenX * .034),
			cardSpaceY = (int) (CardWars.screenY * .0165);
	public static int clicked;

	public static boolean cellHighCard;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(CardWars.board, 0, 0, null);

		// drawDeck(g);

		drawCards(g);

		if(CardWars.highlight)
		{

			highlight(g);
		}

		// g.drawImage(CardWars.hearts[11], BoardSpaces.getCellX(0) + cardSpaceX, BoardSpaces.getCellY(0) + cardSpaceY, null);

	}

	private void drawCards(Graphics g) {

		for(int i = 0; i < pCards.length; i++)
		{
			if(pCards[i] != null && i != 4 && i != 15)
			{
				g.drawImage(getDeckBack(CardWars.userDeck, 0), BoardSpaces.getCellX(i) + cardSpaceX, BoardSpaces.getCellY(i) + cardSpaceY, null);
			}
		}

		for(int i = 0; i < oCards.length; i++)
		{
			if(oCards[i] != null && i != 4 && i != 15)
			{
				g.drawImage(getDeckBack(CardWars.backDeck, CardWars.userDeck), BoardSpaces.getCellX(i) + cardSpaceX, BoardSpaces.getCellY(i) + cardSpaceY, null);
			}
		}

	}

	private void highlight(Graphics g) {

		int cell = BoardSpaces.getCell(CardWars.mx, CardWars.my);

		if(CardWars.player1)
		{
			if(cellHighCard && cell != -1)
			{
				BufferedImage[] suit = getSuitArray(pCards[cell].getSuit());

				if(suit != null)
				{
					g.drawImage(suit[pCards[cell].getValue() - 1], BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);

				}

			}
			else if(cell != -1 && cell != 4 && cell != 15)
			{
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), null);

			}
		}
		else
		{
			if(cellHighCard && cell != -1)
			{
				BufferedImage[] suit = getSuitArray(oCards[cell].getSuit());

				if(suit != null)
				{
					g.drawImage(suit[oCards[cell].getValue() - 1], BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);

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
}

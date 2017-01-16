package com.github.brockstar17;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.github.brockstar17.util.BoardSpaces;
import com.github.brockstar17.util.GameUtils;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static PlayingCard[] pCards = new PlayingCard[20];
	public static PlayingCard[] oCards = new PlayingCard[20];
	public static int cardSpaceX = (int)(CardWars.screenX *.034), cardSpaceY = (int)(CardWars.screenY*.0165);
	public static int clicked;
	
	public static boolean cellHighCard;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(CardWars.board, 0, 0, null);

		if(CardWars.player1)
		{
			
			g.drawImage(CardWars.turn, BoardSpaces.getCellX(15), BoardSpaces.getCellY(15), null);
		}
		else
		{
			g.drawImage(CardWars.turn, BoardSpaces.getCellX(4), BoardSpaces.getCellY(4), null);
		}
		
		drawDeck(g);
		
		drawCards(g);
		
		
		
		if(CardWars.highlight)
		{
			highlight(g);
		}
		
		
		if(CardWars.deckClicked)
		{
			drawSpawn(g);
		}
		
		if(CardWars.select)
		{
			movHighlight(g, GameUtils.adjMoves(clicked));
		}
		
		//g.drawImage(CardWars.hearts[11], BoardSpaces.getCellX(0) + cardSpaceX, BoardSpaces.getCellY(0) + cardSpaceY, null);
		
	}

	private void drawCards(Graphics g) {
		
		for(int i = 0; i < pCards.length; i++)
		{
			if(pCards[i] != null && i != 4 && i != 15)
			{
				g.drawImage(CardWars.yin, BoardSpaces.getCellX(i) + cardSpaceX, BoardSpaces.getCellY(i)+ cardSpaceY, null);
			}
		}
	
		for(int i = 0; i < oCards.length; i++)
		{
			if(oCards[i] != null && i != 4 && i != 15)
			{
				g.drawImage(CardWars.yin, BoardSpaces.getCellX(i) + cardSpaceX, BoardSpaces.getCellY(i)+ cardSpaceY, null);
			}
		}
		
	}

	private void highlight(Graphics g) {
		
		int cell = BoardSpaces.getCell(CardWars.mx, CardWars.my);
		
		if(CardWars.player1)
		{
			if(cellHighCard)
			{
				BufferedImage[] suit = getSuitArray(pCards[cell].getSuit());
				
				if(suit != null)
				{
					g.drawImage(suit[pCards[cell].getValue()-1], BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);

				}
				else
				{
					g.drawImage(CardWars.cardSel, BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);
				}
			}
			else if(cell!= -1 && cell != 4 && cell != 15)
			{
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), null);
				
			}
		}
		else
		{
			if(cellHighCard)
			{
				BufferedImage[] suit = getSuitArray(oCards[cell].getSuit());
				
				if(suit != null)
				{
					g.drawImage(suit[oCards[cell].getValue()-1], BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);

				}
				else
				{
					g.drawImage(CardWars.cardSel, BoardSpaces.getCellX(cell) + cardSpaceX, BoardSpaces.getCellY(cell) + cardSpaceY, null);
				}
			}
			else if(cell!= -1 && cell != 4 && cell != 15)
			{
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(cell), BoardSpaces.getCellY(cell), null);
				
			}
		}
		
	}

	private void movHighlight(Graphics g, int[] cells){
		
		if(CardWars.player1)
		{
			for(int i = 0; i < cells.length; i++)
			{
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(cells[i]), BoardSpaces.getCellY(cells[i]), null);
				
			}
		}
		else
		{
			for(int i = 0; i < cells.length; i++)
			{
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(cells[i]), BoardSpaces.getCellY(cells[i]), null);
				
			}
		}
	}
	
	private void drawDeck(Graphics g){
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(4) + cardSpaceX, BoardSpaces.getCellY(4) + cardSpaceY, null);
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(15)+ cardSpaceX, BoardSpaces.getCellY(15)+ cardSpaceY, null);
	}
	
	private void drawSpawn(Graphics g){
		if(CardWars.player1)
		{
			if(!BoardSpaces.hasCard(5))
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(5), BoardSpaces.getCellY(5), null);
			if(!BoardSpaces.hasCard(10))
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(10), BoardSpaces.getCellY(10), null);
			if(!BoardSpaces.hasCard(16))
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(16), BoardSpaces.getCellY(16), null);
			if(!BoardSpaces.hasCard(17))
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(17), BoardSpaces.getCellY(17), null);
			if(!BoardSpaces.hasCard(18))
				g.drawImage(CardWars.hl, BoardSpaces.getCellX(18), BoardSpaces.getCellY(18), null);
		}
		else
		{
			if(!BoardSpaces.hasCard(9))
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(9), BoardSpaces.getCellY(9), null);
			if(!BoardSpaces.hasCard(14))
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(14), BoardSpaces.getCellY(14), null);
			if(!BoardSpaces.hasCard(1))
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(1), BoardSpaces.getCellY(1), null);
			if(!BoardSpaces.hasCard(2))
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(2), BoardSpaces.getCellY(2), null);
			if(!BoardSpaces.hasCard(3))
				g.drawImage(CardWars.sel, BoardSpaces.getCellX(3), BoardSpaces.getCellY(3), null);
		}
	}
	
	public static void setClicked(int cell){
		clicked = cell;
	}
	
	private BufferedImage[] getSuitArray(String suit){
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
	
	
}

package com.github.brockstar17;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.github.brockstar17.util.BoardSpaces;
import com.github.brockstar17.util.GameUtils;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static PlayerCard[] pCards = new PlayerCard[20];
	public static int cardSpaceX = (int)(CardWars.screenX *.034), cardSpaceY = (int)(CardWars.screenY*.0165);
	public static int clicked;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(CardWars.board, 0, 0, null);
		
		if(CardWars.player1)
		{
			g.drawImage(CardWars.turn, BoardSpaces.getCellX(15), BoardSpaces.getCellY(15), null);
			if(CardWars.highlight)
				highlight(g);
		}
		else
		{
			g.drawImage(CardWars.turn, BoardSpaces.getCellX(4), BoardSpaces.getCellY(4), null);
		}


		drawDeck(g);
		
		drawCards(g);
		
		if(CardWars.deckClicked && CardWars.player1)
		{
			drawSpawn(g);
		}
		
		if(CardWars.select)
		{
			movHighlight(g, GameUtils.adjMoves(clicked));
		}
		
		g.drawImage(CardWars.hearts[11], BoardSpaces.getCellX(0) + cardSpaceX, BoardSpaces.getCellY(0) + cardSpaceY, null);
		
	}

	private void drawCards(Graphics g) {
		for(int i = 0; i < pCards.length; i++)
		{
			if(pCards[i] != null && i != 4 && i != 15)
			{
				g.drawImage(CardWars.yin, BoardSpaces.getCellX(i) + cardSpaceX, BoardSpaces.getCellY(i)+ cardSpaceY, null);
			}
		}
	}

	private void highlight(Graphics g) {
		
		
		if(BoardSpaces.getCell(CardWars.mx, CardWars.my) != -1 &&
				BoardSpaces.getCell(CardWars.mx, CardWars.my) != 4 &&
				BoardSpaces.getCell(CardWars.mx, CardWars.my) != 15)
		{
			g.drawImage(CardWars.sel, BoardSpaces.getCellX(BoardSpaces.getCell(CardWars.mx, CardWars.my)), BoardSpaces.getCellY(BoardSpaces.getCell(CardWars.mx, CardWars.my)), null);
			
		}
		
	}

	private void movHighlight(Graphics g, int[] cells){
		for(int i = 0; i < cells.length; i++)
		{
			g.drawImage(CardWars.sel, BoardSpaces.getCellX(cells[i]), BoardSpaces.getCellY(cells[i]), null);
			
		}
	}
	
	private void drawDeck(Graphics g){
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(4) + cardSpaceX, BoardSpaces.getCellY(4) + cardSpaceY, null);
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(15)+ cardSpaceX, BoardSpaces.getCellY(15)+ cardSpaceY, null);
	}
	
	private void drawSpawn(Graphics g){
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
	
	public static void setClicked(int cell){
		clicked = cell;
	}
	
	
}

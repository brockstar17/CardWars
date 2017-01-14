package com.github.brockstar17;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.github.brockstar17.util.BoardSpaces;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static PlayerCard[] pCards = new PlayerCard[20];
	private int cardSpaceX = (int)(CardWars.screenX *.034), cardSpaceY = (int)(CardWars.screenY*.0165);

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(CardWars.board, 0, 0, null);

		//drawCards(g);

		highlight(g);
		
		drawDeck(g);
		
		drawCards(g);
	}

	private void drawCards(Graphics g) {
		for(int i = 0; i < pCards.length - 2; i++)
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
			g.drawImage(CardWars.hl, BoardSpaces.getCellX(BoardSpaces.getCell(CardWars.mx, CardWars.my)), BoardSpaces.getCellY(BoardSpaces.getCell(CardWars.mx, CardWars.my)), null);
			
		}
		
	}
	
	private void drawDeck(Graphics g){
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(4) + cardSpaceX, BoardSpaces.getCellY(4) + cardSpaceY, null);
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(15)+ cardSpaceX, BoardSpaces.getCellY(15)+ cardSpaceY, null);
	}
}

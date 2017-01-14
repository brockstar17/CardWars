package com.github.brockstar17;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.github.brockstar17.util.BoardSpaces;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static ArrayList<PlayerCard> pCards = new ArrayList<PlayerCard>();

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(CardWars.board, 0, 0, null);

		//drawCards(g);

		highlight(g);
		
		drawDeck(g);
	}

	private void drawCards(Graphics g) {
		g.drawImage(CardWars.yin, (int) (CardWars.screenX * .07), (int) (CardWars.screenY * .066), null);
	}

	private void highlight(Graphics g) {
		//g.drawImage(CardWars.hl, (int) (CardWars.screenX * .222), (int) (CardWars.screenY * .049), null);
		// System.out.println("Debug");
		/*for(int i = 0; i <=19; i++)
		{
			g.drawImage(CardWars.hl, BoardSpaces.getCellX(i), BoardSpaces.getCellY(i), null);
		}*/
		
		if(BoardSpaces.getCell(CardWars.mx, CardWars.my) != -1 &&
				BoardSpaces.getCell(CardWars.mx, CardWars.my) != 4 &&
				BoardSpaces.getCell(CardWars.mx, CardWars.my) != 15)
		{
			g.drawImage(CardWars.hl, BoardSpaces.getCellX(BoardSpaces.getCell(CardWars.mx, CardWars.my)), BoardSpaces.getCellY(BoardSpaces.getCell(CardWars.mx, CardWars.my)), null);
			
		}
		
	}
	
	private void drawDeck(Graphics g){
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(4) + (int)(CardWars.screenX *.034), BoardSpaces.getCellY(4) + (int)(CardWars.screenY*.017), null);
		g.drawImage(CardWars.yin, BoardSpaces.getCellX(15)+ (int)(CardWars.screenX *.034), BoardSpaces.getCellY(15)+ (int)(CardWars.screenY*.016), null);
	}
}

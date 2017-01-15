package com.github.brockstar17.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class SelectionPanel extends JPanel{

	private int x,y;
	private int cardX, cardY;
	
	public SelectionPanel(CardFrame frame)
	{
		this.x = frame.getW();
		this.y = frame.getH();
		this.cardX = CardWars.hearts[0].getWidth();
		this.cardY = CardWars.hearts[0].getHeight();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(ImageUtils.scale(CardWars.cardSelBack, x, y), 0, 0, null);
		
		for(int i = 0; i < 5; i++)
		{
			int val = CardWars.playerDeck.get(i).getValue();
			String s = CardWars.playerDeck.get(i).getSuit();
			g.drawImage(getSuit(s)[val - 1], (int)(x * .03 + (x * .19 * i)), (int)(y * .1), null);
			
		}
	}
	
	private BufferedImage[] getSuit(String suit){
		switch(suit)
		{
		case "hearts":
			return CardWars.hearts;
		case "diamonds":
			return CardWars.diamonds;
		case "clubs":
			return CardWars.clubs;
		default:
			return CardWars.spades;
		}
	}
	
	public int getCardX(){
		return this.cardX;
	}
	
	public int getCardY(){
		return this.cardY;
	}
}

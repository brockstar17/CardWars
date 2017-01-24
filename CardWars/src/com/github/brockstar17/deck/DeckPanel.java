package com.github.brockstar17.deck;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.util.ImageUtils;

@SuppressWarnings("serial")
public class DeckPanel extends JPanel{

	private DeckFrame d;
	private int w, h;
	
	
	public DeckPanel(DeckFrame d)
	{
		this.d= d;
		this.w = d.getWidth();
		this.h = d.getHeight();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(ImageUtils.scale(CardWars.attackBack, d.getWidth(), d.getHeight()), 0, 0, null);
		
		g.drawImage(CardWars.yin, (int)(w*.1), (int)(h*.05), null);
		g.drawImage(CardWars.tesselate, (int)(w*.4), (int)(h*.05), null);
		g.drawImage(CardWars.geo, (int)(w*.7), (int)(h*.05), null);
		g.drawImage(CardWars.celtic, (int)(w*.1), (int)(h*.35), null);
		g.drawImage(CardWars.paris, (int)(w*.4), (int)(h*.35), null);
		g.drawImage(CardWars.pretzel, (int)(w*.7), (int)(h*.35), null);
		g.drawImage(CardWars.brighty, (int)(w*.1), (int)(h*.65), null);
	}
}

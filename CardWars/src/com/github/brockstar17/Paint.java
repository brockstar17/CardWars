package com.github.brockstar17;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static ArrayList<PlayerCard> pCards = new ArrayList<PlayerCard>();

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(CardWars.board, 0, 0, null);

		drawCards(g);
	}

	private void drawCards(Graphics g) {
		g.drawImage(CardWars.yin, (int) (CardWars.screenX * .07), (int) (CardWars.screenY * .066), null);
	}
}

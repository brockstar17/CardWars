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

		highlight(g);
	}

	private void drawCards(Graphics g) {
		g.drawImage(CardWars.yin, (int) (CardWars.screenX * .07), (int) (CardWars.screenY * .066), null);
	}

	private void highlight(Graphics g) {
		g.drawImage(CardWars.hl, (int) (CardWars.screenX * .223), (int) (CardWars.screenY * .05), null);
		// System.out.println("Debug");
	}
}

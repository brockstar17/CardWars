package com.github.brockstar17;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(CardWars.board, 0, 0, null);
	}
}

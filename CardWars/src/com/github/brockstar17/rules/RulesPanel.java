package com.github.brockstar17.rules;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RulesPanel extends JPanel
{
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.WHITE);
	}
}

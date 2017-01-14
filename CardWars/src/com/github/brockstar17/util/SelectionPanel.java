package com.github.brockstar17.util;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectionPanel extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setBackground(Color.BLACK);
		
		for(int i = 0; i < 5; i++)
		{
			
		}
	}
}

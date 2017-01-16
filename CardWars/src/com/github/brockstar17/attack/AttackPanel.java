package com.github.brockstar17.attack;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AttackPanel extends JPanel{

	private AttackFrame af;
	
	public AttackPanel(AttackFrame frame)
	{
		this.af = frame;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	}
}

package com.github.brockstar17.attack;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.util.ImageUtils;

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
		
		g.drawImage(ImageUtils.scale(CardWars.attackBack, af.getWidth(), af.getHeight()), 0, 0, null);
	}
}

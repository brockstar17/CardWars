package com.github.brockstar17.rules;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class RulesPanel extends JPanel
{
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.WHITE);
		displayRules(g);
	}
	
	private static Scanner s;
	
	private void displayRules(Graphics g){

		
		try {
			s = new Scanner(CardWars.rules);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: CWRules.txt");
		}
		
		String d;
		
		int h = this.getHeight();
		int i = 1;
		
		Font bold = new Font("Quicksand-Bold", Font.PLAIN, 20);
		Font norm = new Font("Quicksand-Bold", Font.PLAIN, 12);
		
		while(s.hasNextLine())
		{
			d = s.nextLine();
			if(d.contains(":"))
			{
				g.setFont(bold); 
				drawCenteredString(d, this.getWidth(), (int)(h*.1*i), g);
			}
			else
			{
				g.setFont(norm); 
				drawCenteredString(d, this.getWidth(), (int)(h*.1*i), g);
			}
			i++;
		}
		
	}
	
	
	private void drawCenteredString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s)) / 2;
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(s, x, y);
	}
}

package com.github.brockstar17.deck;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JFrame;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class DeckFrame extends JFrame implements MouseListener, WindowListener{
	
	private int w, h;
	private CardWars cw;
	protected int user;
	private Random rn = new Random();
	
	public DeckFrame(CardWars cw)
	{
		super("Choose a Deck");
		this.cw = cw;
		
		
		w = (int)(cw.getWidth()*.9); h = (int)(cw.getHeight()*.9);
		
		setSize(w, h);
		
		DeckPanel panel = new DeckPanel(this);
		Container c = getContentPane();
		c.add(panel);
		c.addMouseListener(this);
		addWindowListener(this);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		CardWars.userDeck = this.user;
		CardWars.backDeck = rn.nextInt(6)+1;
		cw.setVisible(true);
		cw.setEnabled(true);
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(getCell(mx, my) != 0)
		{
			this.dispose();
			this.user = getCell(mx, my);
		}
		
	}
	
	private int getCell(int mx, int my){
		
		int y1 = (int)(h*.05), y2 = (int)(h*.35);
		
		if(mx > (int)(w*.1) && mx < (int)(w*.1) + CardWars.yin.getWidth())
		{
			if(my > y1 && my < y1 + CardWars.yin.getHeight())
			{
				
				return 1;
			}
			if(my > y2 && my < y2 + CardWars.yin.getHeight())
			{
				return 4;
			}
		}
		else if(mx > (int)(w*.4) && mx < (int)(w*.4) + CardWars.yin.getWidth())
		{
			if(my > y1 && my < y1 + CardWars.yin.getHeight())
			{
				return 2;
			}
			if(my > y2 && my < y2 + CardWars.yin.getHeight())
			{
				return 5;
			}
		}
		else if(mx > (int)(w*.7) && mx < (int)(w*.7)+CardWars.yin.getWidth())
		{
			if(my > y1 && my < y1 + CardWars.yin.getHeight())
			{
				return 3;
			}
			if(my > y2 && my < y2 + CardWars.yin.getHeight())
			{
				return 6;
			}
		}
		
		return 0;
	}

}

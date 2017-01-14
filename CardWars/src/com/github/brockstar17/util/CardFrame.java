package com.github.brockstar17.util;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class CardFrame extends JFrame implements MouseListener, KeyListener, WindowListener{

	private CardWars cardWars;
	
	private int x;
	private int y;
	private int w;
	private int l;
	
	
	
	public CardFrame(CardWars cw)
	{
		super("Select a Card");
		
		this.cardWars = cw;
		
		this.w = (int)(cw.getWidth()*.75);
		this.l = (int)(cw.getHeight()*.5);
		
		Container c = getContentPane();
		c.add(new SelectionPanel());

		addMouseListener(this);
		addKeyListener(this);
		addWindowListener(this);
		
		setSize(w, l);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		
		
		this.x = getX();
		this.y = getY();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key)
		{
		case KeyEvent.VK_ENTER:
			System.out.println("I am CardFrame");
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(mx > this.x && mx < this.x + this.w && my > this.y && my < this.y + this.l)
		{
			System.out.println("You have clicked a CardFrame");
		}
		
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
		
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.cardWars.setEnabled(true);
		this.cardWars.setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}

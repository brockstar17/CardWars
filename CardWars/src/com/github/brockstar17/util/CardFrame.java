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
	private SelectionPanel selPan;
	
	//private int x;
	private int y;
	private int w;
	private int l;
	
	//(int)(w * .03 + (w * .19 * i));
	private int cardH = (int)(y * .1);
	
	public CardFrame(CardWars cw)
	{
		super("Select a Card");
		
		this.cardWars = cw;
		
		
		this.w = (int)(cw.getWidth()*.75);
		this.l = ImageUtils.calcWidth(300, this.w, 180);
		
		this.selPan = new SelectionPanel(this);
		
		Container c = getContentPane();
		c.add(this.selPan);

		addMouseListener(this);
		addKeyListener(this);
		addWindowListener(this);
		
		
		
		setSize(w, l);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		
		
		//this.x = getX();
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
		
		if(getCardClicked(mx, my) != -1)
		{
			int cell = getCardClicked(mx, my);
			cardWars.setSelectedCard(CardWars.playerDeck.get(cell));
			CardWars.playerDiscard.add(CardWars.playerDeck.get(cell));
			CardWars.playerDeck.remove(cell);
			cardWars.setCardSelected(true);
			this.dispose();
			
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
		
		this.cardWars.setVisible(true);
		this.cardWars.setEnabled(true);
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
		cardWars.setEnabled(false);
		
	}

	public int getW(){
		return this.w;
	}
	
	public int getH(){
		return this.l;
	}
	
	
	private int getCardClicked(int x, int y)
	{
		int cardX = 0;
		
		for(int i = 0; i < 5; i++)
		{
			cardX = (int)(w * .03 + (w * .19 * i));
			if(x > cardX && x < cardX + selPan.getCardX() && y > cardH && y < cardH + selPan.getCardY())
			{
				//System.out.println("i " + i);
				return i;
			}
			
		}
		//System.out.println("Fell Through");
		return -1;
	}
}

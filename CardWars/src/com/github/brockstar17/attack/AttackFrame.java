package com.github.brockstar17.attack;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.PlayingCard;
import com.github.brockstar17.util.ImageUtils;

@SuppressWarnings("serial")
public class AttackFrame extends JFrame implements WindowListener{
	
	private CardWars cw;
	private AttackPanel ap;
	private int w;
	private int l;
	
	protected String winner;
	
	private PlayingCard player, opp;
	
	public AttackFrame(CardWars cw, PlayingCard player, PlayingCard other)
	{
		super("Battle Commences");
		
		this.cw = cw;
		this.player = player;
		this.opp = other;
		
		this.w = (int)(cw.getWidth()*.75);
		this.l = ImageUtils.calcWidth(400, this.w, 200);

		addWindowListener(this);
		
		setSize(w, l);
		
		this.ap = new AttackPanel(this);
		Container c = getContentPane();
		c.add(ap);
		
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
		
		if(winner == "p2")
		{
			System.out.println("Lost: P1");
			CardWars.playerDiscard.add(player);
		}
		else if(winner == "p1")
		{
			System.out.println("Lost: P2");
			CardWars.otherDiscard.add(opp);
		}
		this.cw.setVisible(true);
		this.cw.setEnabled(true);
		
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
	
	public PlayingCard getPlayerCard(){
		
		return this.player;	
	}
	
	public PlayingCard getOppCard(){
		return this.opp;
	}
	
	public int getW(){
		//System.out.println("w " + this.w);
		return this.w;
	}
	public int getL(){
		//System.out.println("l " + this.l);
		return this.l;
	}

}

package com.github.brockstar17.attack;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.util.ImageUtils;

@SuppressWarnings("serial")
public class AttackFrame extends JFrame implements WindowListener{
	
	private CardWars cw;
	private AttackPanel ap;
	private int w;
	private int l;
	
	public AttackFrame(CardWars cw)
	{
		super("Battle Commences");
		
		this.cw = cw;
		
		this.w = (int)(cw.getWidth()*.75);
		this.l = ImageUtils.calcWidth(400, this.w, 200);
		
		this.ap = new AttackPanel(this);
		Container c = getContentPane();
		c.add(ap);
		
		addWindowListener(this);
		
		setSize(w, l);
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

}

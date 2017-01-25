package com.github.brockstar17.rules;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class RulesFrame extends JFrame implements WindowListener, KeyListener
{

	private CardWars cw;

	public RulesFrame(CardWars cw)
	{
		super("Rules de la CardWars");

		this.cw = cw;
		addKeyListener(this);
		addWindowListener(this);

		Container c = getContentPane();
		c.add(new RulesPanel());

		setSize(this.cw.getWidth(), this.cw.getHeight());
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
		cw.setEnabled(true);
		cw.setVisible(true);
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
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_ESCAPE:
			this.dispose();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}

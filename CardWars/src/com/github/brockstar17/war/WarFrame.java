package com.github.brockstar17.war;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class WarFrame extends JDialog implements WindowListener
{

	private CardWars cw;
	private int x, y;

	public WarFrame(CardWars cw)
	{
		this.cw = cw;
		this.x = (int) (cw.getWidth() * .5);
		this.y = (int) (cw.getHeight() * .5);
		setSize(x, y);

		Container c = getContentPane();
		c.add(new WarStartPanel(this, this.getWidth(), this.getHeight()));

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

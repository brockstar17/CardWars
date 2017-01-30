package com.github.brockstar17.rules;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class RulesFrame extends JDialog implements WindowListener, KeyListener
{

	private CardWars cw;

	// private Font norm = new Font("Quicksand-Bold", Font.PLAIN, 20);

	public RulesFrame(CardWars cw)
	{
		setUndecorated(true);

		this.cw = cw;
		addWindowListener(this);

		setSize(this.cw.getWidth(), this.cw.getHeight());
		setLocationRelativeTo(null);

		JScrollPane scroll = new JScrollPane(new JLabel(new ImageIcon(CardWars.rules)));
		scroll.getVerticalScrollBar().setUnitIncrement(5);
		scroll.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll);

		addKeyListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// System.out.println("Closing");
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

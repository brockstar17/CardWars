package com.github.brockstar17.war.types;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.war.PaintWar;

@SuppressWarnings("serial")
public class War1 extends War implements WindowListener, MouseListener, MouseMotionListener
{

	public War1(CardWars cw)
	{
		this.cw = cw;

		setTitle("War Method 1");
		setSize(cw.getWidth(), cw.getHeight());

		Container c = getContentPane();
		c.add(new PaintWar(this));

		addWindowListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		cw.setVisible(true);
		cw.setEnabled(true);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
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
		System.out.println("Mx " + mx);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	// this function will be for hovering
	@Override
	public void mouseMoved(MouseEvent e) {
		this.mx = e.getX();
		this.my = e.getY();
		repaint();
	}
}

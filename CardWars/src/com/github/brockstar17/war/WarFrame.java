package com.github.brockstar17.war;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;

@SuppressWarnings("serial")
public class WarFrame extends JDialog implements WindowListener
{

	private CardWars cw;
	private int x, y;
	protected int method;

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
		this.cw.method = this.method;
		if(method == 1)
		{
			new WarResults(cw);
		}
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
		if(!canMethod1() && !canMethod2())
		{
			cw.method = 0;
			this.dispose();
		}
		if(!canMethod1() && canMethod2())
		{
			cw.method = 2;
			this.dispose();
		}
		if(!canMethod2() && canMethod1())
		{
			cw.method = 1;
			this.dispose();
		}
	}

	protected boolean canMethod1() {
		if(CardWars.player1)
		{
			int n = 0;
			for(int i = 0; i < Paint.pCards.length; i++)
			{
				if(Paint.pCards[i] != null)
				{
					n++;
				}
			}
			if(n > 3)
			{
				return true;
			}
		}
		else
		{
			int n = 0;
			for(int i = 0; i < Paint.oCards.length; i++)
			{
				if(Paint.oCards[i] != null)
				{
					n++;
				}
			}
			if(n > 3)
			{
				return true;
			}
		}
		return false;
	}

	protected boolean canMethod2() {
		if(CardWars.player1)
		{
			int n = 0;
			for(int i = 0; i < Paint.pCards.length; i++)
			{
				if(Paint.pCards[i] != null)
				{
					n++;
				}
			}
			if(n > 1)
			{
				return true;
			}
		}
		else
		{
			int n = 0;

			for(int i = 0; i < Paint.oCards.length; i++)
			{
				if(Paint.oCards[i] != null)
				{
					n++;
				}
			}
			if(n > 1)
			{
				return true;
			}
		}
		return false;
	}
}

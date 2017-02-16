package com.github.brockstar17.war;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;
import com.github.brockstar17.war.types.War1;
import com.github.brockstar17.war.types.War2;

@SuppressWarnings("serial")
public class WarFrame extends JDialog implements WindowListener
{

	private CardWars cw;
	private int x, y;
	protected int method;
	private PlayingCard p, o;

	public WarFrame(CardWars cw, PlayingCard p, PlayingCard o)
	{
		this.cw = cw;
		this.p = p;
		this.o = o;
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
		System.out.println("This is method " + method);
		this.cw.method = this.method;
		if(method == 1)
		{
			new War1(cw);
		}
		else if(method == 2)
		{
			new War2(cw, p, o);
		}
		else
		{
			System.out.println("Null war");
			cw.setVisible(true);
			cw.setEnabled(true);
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
			System.out.println("Both false");
			method = 0;
			this.dispose();
		}
		if(!canMethod1() && canMethod2())
		{
			System.out.println("1 false");
			method = 2;
			this.dispose();
		}
		if(!canMethod2() && canMethod1())
		{
			System.out.println("2 false");
			method = 1;
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

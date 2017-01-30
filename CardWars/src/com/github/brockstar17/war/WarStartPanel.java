package com.github.brockstar17.war;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WarStartPanel extends JPanel implements MouseListener
{
	private int x, y;

	private WarFrame wf;

	public WarStartPanel(WarFrame wf, int w, int h)
	{
		this.wf = wf;
		this.x = w;
		this.y = h;
		addMouseListener(this);

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.DARK_GRAY);

		g.setColor(Color.BLACK);
		g.fillRect(0, y / 3, x / 2, y);

		g.setColor(Color.WHITE);
		g.fillRect(x / 2, y / 3, x / 2, y);

		g.setFont(new Font("Calibri", Font.BOLD, 15));

		g.setColor(Color.WHITE);
		g.drawString("Method 1", (int) (x * .2), (int) (y * .6));
		g.drawString("War has Begun", (int) (x * (3.3 / 8.0)), y / 10);

		g.setColor(Color.BLACK);
		g.drawString("Method 2", (int) (x * .2) + x / 2, (int) (y * .6));
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
		int mx = e.getX();
		int my = e.getY();

		if(my > y / 3)
		{
			if(mx < x / 2)
			{
				System.out.println("Method 1");
				wf.remove(this);

			}
			else
			{
				System.out.println("Method 2");
				wf.remove(this);

			}
		}
	}
}

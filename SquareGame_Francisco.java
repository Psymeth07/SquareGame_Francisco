import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SquareGame_Francisco extends JPanel implements ActionListener, KeyListener{
	Timer t = new Timer(3,this);
	int x = 0, y = 0, velx = 0, vely = 0;
	
	public SquareGame_Francisco() {
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setBackground(Color.BLACK);
		setFocusTraversalKeysEnabled(false);
		
	}
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.GREEN);
	g.fillRect(x,y,50,30);
	if(x ==0) {
		g.setColor(new Color(0,255,255));
		g.fillRect(x,y,50,30);
	}
	if(x==533) {
		g.setColor(new Color(139,0,139));
		g.fillRect(x, y, 50, 30);
	}
	if(y==0) {
		g.setColor(new Color(255,245,238));
		g.fillRect(x, y, 50, 30);
	}
	if(y==330) {
		g.setColor(new Color(255,102,255));
		g.fillRect(x, y, 50, 30);
	}
	}
	public void actionPerformed(ActionEvent e) {
		if(x<0) {
			velx = 0;
			x = 0;
		}
		if(x>533) {
			velx = 0;
			x = 533;						
		}
		if(y<0) {
			vely = 0;
			y = 0;
		}
		if(y>330) {
			vely = 0;
			y = 330;
		}
	x += velx;
	y += vely;
	repaint();
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_DOWN) {
			vely = 1;
			velx = 0;
		}
		if(code == KeyEvent.VK_UP) {
			vely = -1;
			velx = 0;
		}
		if(code == KeyEvent.VK_LEFT) {
			vely = 0;
			velx = -1;
		}
		if(code == KeyEvent.VK_RIGHT) {
			vely = 0;
			velx = 1;
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		
	}
	public static void  main(String []args) {
		JFrame f = new JFrame();
		SquareGame_Francisco s = new SquareGame_Francisco();
		f.add(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,400);
		f.setVisible(true);
	}
}

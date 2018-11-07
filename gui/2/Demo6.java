import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo6 extends JFrame{
	
	private class DemoPanel extends JPanel implements MouseListener{
		
		private int x = -50;
		private int y = -50;
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.fillRect(x-5,y-5,40,20);
		}
		
		public void mouseClicked(MouseEvent e){
			x = e.getX();
			y = e.getY();
			repaint();
		}
		
		public void mouseEntered(MouseEvent e) {}		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}		public void mouseReleased(MouseEvent e) {}
	}
	
	public Demo6(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setLocation(300,100);
		
		DemoPanel panel = new DemoPanel();
		panel.addMouseListener(panel);
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Demo6 frame = new Demo6();
	}
}
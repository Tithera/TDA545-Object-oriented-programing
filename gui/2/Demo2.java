import java.awt.*;
import javax.swing.*;

//draw lotsa stuff

public class Demo2 extends JFrame{
	
	private class DemoPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawRect(10,10,30,30); //(x,y)-koordinater, storlek
			g.drawRect(50,10,50,30);
			
			g.setColor(Color.GREEN);
			g.fillRect(110,10,80,30);
			
			g.setColor(Color.BLUE);
			g.drawOval(10, 50, 30, 30);
			g.drawOval(50, 50, 50, 30);
			
			g.setColor(Color.RED);
			g.fillOval(110, 50, 80, 30);
			
			g.setColor(Color.MAGENTA);
			g.drawLine(10,90,80,130);
			
			g.drawString("Hej!",80,130);
		}
	}
	
	public Demo2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,180);
		DemoPanel panel = new DemoPanel();
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Demo2 frame = new Demo2();
	}
}
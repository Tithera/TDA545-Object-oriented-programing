import java.awt.*;
import javax.swing.*;

//Draw rectangles

public class Demo1 extends JFrame{
	
	private class DemoPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawRect(10, 10, 10, 10);
			g.drawRect(30, 10, 20, 10);
			
			int x = getWidth();
			int y = getHeight();
			
			g.drawRect(x/5, y/5, x-2*x/5, y/3); //anpassas efter fönstrets storlek
		}
	}
	
	public Demo1(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		DemoPanel panel = new DemoPanel();
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Demo1 frame = new Demo1();
	}
}
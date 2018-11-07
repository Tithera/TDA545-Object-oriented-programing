import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
//10 dots
	
public class Demo5 extends JFrame{
	
	private class DemoPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			for (int i = 0; i < 10; i++){
				int x = 15*i;
				int y = 0;
				g.fillOval(195+x, 195+y, 10, 10);
			}
		}
	}
	
	public Demo5(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		DemoPanel panel = new DemoPanel();
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Demo5 frame = new Demo5();
	}
}
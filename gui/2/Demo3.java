import javax.swing.*;
import java.awt.*;
import java.util.*;

//RandomDots: tentauppgift
/*

	Rita ut 50000 random punkter i ett fönster om 400x400 pixlar. Varje punkt 
	ska vara 2x2 pixlar stor

*/

public class Demo3 extends JFrame{
	
	private class DemoPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Random generator = new Random();
			
			for(int i = 0; i < 50000; i++){
				int x = generator.nextInt(getWidth()+1); //400: 0-399, så 400+1: 0-400
				int y = generator.nextInt(getHeight()+1);
				g.fillOval(x,y,2,2);
			}
		}
	}
	
	public Demo3(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		DemoPanel panel = new DemoPanel();
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Demo3 frame = new Demo3();
	}
}
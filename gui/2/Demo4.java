import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
//a thousand colorful balls :3
public class Demo4 extends JFrame{
	
	private class DemoPanel extends JPanel implements ActionListener{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Random generator = new Random();
			
			for(int i = 0; i < 1000; i++){
				int red = generator.nextInt(256);
				int green = generator.nextInt(256);
				int blue = generator.nextInt(256);
				int x = generator.nextInt(getWidth()+1);
				int y = generator.nextInt(getHeight()+1);
				
				int size = generator.nextInt(31)+10;
				
				g.setColor(new Color(red,green,blue));
				g.fillOval(x,y,size, size);
			}
		}
		
		public void actionPerformed(ActionEvent e){
			revalidate();
			repaint();
		}
	}
	
	public Demo4(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		DemoPanel panel = new DemoPanel();
		JButton button = new JButton("Ny utskrift");
		button.addActionListener(panel);
		panel.add(button);
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Demo4 frame = new Demo4();
	}
}
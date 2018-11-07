import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// A thoudsand ballllllls at once

class ballPanel extends JPanel implements ActionListener{
	
	public ballPanel(){
		setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent e){
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Random generator = new Random();
		
		for (int i = 0; i < 1000; i++){
			int colorRed = generator.nextInt(256);
			int colorGreen = generator.nextInt(256);
			int colorBlue = generator.nextInt(256);
			
			g.setColor(new Color(colorRed, colorGreen, colorBlue));
			int size = generator.nextInt(21)+10;
			int x = generator.nextInt(getWidth());
			int y = generator.nextInt(getHeight());
			g.fillOval(x, y, size, size);	
		}
	}
}

public class Demo19 extends JFrame{
	
	public Demo19(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		ballPanel panel = new ballPanel();
		
		JButton button = new JButton("New color");
		button.addActionListener(panel);
		
		panel.add(button);
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Demo19 frame = new Demo19();
	}	
}
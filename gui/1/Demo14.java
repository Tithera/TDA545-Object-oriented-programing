import java.awt.*;
import javax.swing.*;

//Panamas flagga

public class Demo14{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Demo 14: Panamas flagga");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLocation(50,50);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,2));
		
		JPanel white1 = new JPanel();
		white1.setBackground(Color.white);
		
		JPanel red = new JPanel();
		red.setBackground(Color.red);
		
		JPanel blue = new JPanel();
		blue.setBackground(Color.blue);
		
		JPanel white2 = new JPanel();
		white2.setBackground(Color.white);
		
		mainPanel.add(white1);
		mainPanel.add(red);
		mainPanel.add(blue);
		mainPanel.add(white2);
		
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
}
import java.awt.*;
import javax.swing.*;

public class Demo8{
	
	public static void main(String[] args){
		JFrame f = new JFrame("Demo 8");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,200);
		f.setLocation(50,50);
		
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.yellow);
		myPanel.setLayout(new GridLayout(5,1)); // rader, kolumner
		
		JButton b1 = new JButton ("Knapp 1");
		JButton b2 = new JButton ("Knapp 2");
		JButton b3 = new JButton ("Knapp 3");
		JButton b4 = new JButton ("Knapp 4");
		JButton b5 = new JButton ("Knapp 5");
		
		myPanel.add(b1);
		myPanel.add(b2);
		myPanel.add(b3);
		myPanel.add(b4);
		myPanel.add(b5);
		
		
		f.add(myPanel);
		//f.pack();
		f.setVisible(true);
		
	}
}
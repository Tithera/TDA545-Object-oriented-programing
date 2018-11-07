import java.awt.*;
import javax.swing.*;

public class Demo7{
	
	public static void main(String[] args){
		JFrame f = new JFrame("Demo 7");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,200);
		f.setLocation(100,100);
		
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.red);
		myPanel.setLayout(new FlowLayout()); //den här raden kan tas bort
		
		JButton b1 = new JButton ("Knapp 1");
		JButton b2 = new JButton ("Knapp 2");
		JButton b3 = new JButton ("Knapp 3");
		JButton b4 = new JButton ("Knapp 4");
		JButton b5 = new JButton ("Knapp 5");
		
		//Behöver inte ange någon location eftersom de dyker upp i tur och ordning
		myPanel.add(b1);
		myPanel.add(b2);
		myPanel.add(b3);
		myPanel.add(b4);
		myPanel.add(b5);
		
		f.add(myPanel);
		f.pack();
		f.setVisible(true);
	}
}
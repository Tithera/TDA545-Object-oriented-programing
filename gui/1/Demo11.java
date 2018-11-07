import java.awt.*;
import javax.swing.*;

public class Demo11{
	
	public static void main(String[] args){
		
		JFrame f = new JFrame("Demo 11");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200,200);
		f.setLocation(50,50);
		
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.yellow);
		myPanel.setLayout(new GridLayout(3,1));
		
		JLabel label = new JLabel ("Skriv en siffra");
		JTextField txt = new JTextField("57");
		JButton button = new JButton("Skicka!");
		
		myPanel.add(label);
		myPanel.add(txt);
		myPanel.add(button);
		
		f.add(myPanel);
		f.setVisible(true);
	}
}

/*
	Frame
	Panel
	Button
	Label
	TextField
*/
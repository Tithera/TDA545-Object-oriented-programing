import java.awt.*;
import javax.swing.*;

//Frankrikes flagga v2.0

public class Demo10{

	public static void main(String[] args){
		JFrame f = new JFrame("France");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize (300,200);
		f.setLocation(50,50);
		
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridLayout(1,3));
		
		
		JPanel white = new JPanel();
		white.setBackground(Color.white);
		
		JPanel blue = new JPanel();
		blue.setBackground(Color.blue);
		
		JPanel red = new JPanel();
		red.setBackground(Color.red);
		
		
		myPanel.add(blue);
		myPanel.add(white);
		myPanel.add(red);
		
		f.add(myPanel);
		f.setVisible(true);		
	}
}
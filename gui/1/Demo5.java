import java.awt.*;
import javax.swing.*;

//Att lägga till flera knappar, med BorderLayout kommer knapparna hamna i en 
//speciell ordning

public class Demo5{
	
	public static void main(String[] args){
		JFrame f = new JFrame("Demo 5");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,300);
		f.setLocation(420,230);
		
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.blue);
		myPanel.setLayout(new BorderLayout());
		
		JButton n = new JButton("North");
		JButton c = new JButton("Center");
		JButton r = new JButton("Right");
		JButton l = new JButton("Left");
		JButton s = new JButton("South");
		
		myPanel.add(n, BorderLayout.NORTH);
		myPanel.add(c, BorderLayout.CENTER);
		myPanel.add(r, BorderLayout.EAST);
		myPanel.add(l, BorderLayout.WEST);
		myPanel.add(s, BorderLayout.SOUTH);
		
		f.add(myPanel);
		f.setVisible(true);
	}
}
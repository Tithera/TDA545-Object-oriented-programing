import java.awt.*;
import javax.swing.*;

//Men bara för att BorderLayout har plats för 5 saker behöver man inte använda alla fem

public class Demo6{
	
	public static void main(String[] args){
		JFrame f = new JFrame("Demo 6");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,300);
		f.setLocation(50,50);
		
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.blue);
		myPanel.setLayout(new BorderLayout());
		
		JButton b1 = new JButton("North");
		JButton b2 = new JButton("Center");
		JButton b3 = new JButton("West");
		
		myPanel.add(b1, BorderLayout.NORTH);
		myPanel.add(b2, BorderLayout.CENTER);
		myPanel.add(b3, BorderLayout.WEST);
		
		f.add(myPanel);
		f.pack(); //ger en mindre, mer komprimerad storlek från början 
		f.setVisible(true);
	}
}
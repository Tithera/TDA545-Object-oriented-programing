import java.awt.*;
import javax.swing.*;

//Frankrikes flagga :3 
//placerar in tre panels i min Frame

public class Demo9{
	
	public static void main(String[] args){
		JFrame f = new JFrame("France");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,200);
		f.setLocation(50,50);
		f.setLayout(new GridLayout(1,3));
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.blue);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.red);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.setVisible(true);
		
	}
}
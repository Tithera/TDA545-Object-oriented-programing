import java.awt.*;
import javax.swing.*;

//Att lägga till knappar

public class Demo4{

	public static void main(String[] args){
		JFrame f = new JFrame("Demo 4");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,300);
		f.setLocation(420,230);
		
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.magenta);
		myPanel.setLayout(new BorderLayout());
		
		//Om man skriver f.add(button1..) istället så kommer knappen hamna på 
		//vit bakgrund istället för blå
		
		JButton button1 = new JButton("Knapp 1");
		myPanel.add(button1, BorderLayout.NORTH);
	
		
		f.add(myPanel);
		f.setVisible(true);
		
		
				
	}

}

/*
	Har skapat 	
		-JFrame
		-JPanel
		-JButton
*/
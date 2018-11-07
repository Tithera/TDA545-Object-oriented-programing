import java.awt.*;
import javax.swing.*;

//Lägg till en panel

public class Demo3{

	public static void main(String[] args){
		JFrame f = new JFrame("Demo 3");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,400);
		f.setLocation(50,50);
		
		JPanel myPanel = new JPanel();
		//green/red/blue/yellow/black
		myPanel.setBackground(Color.red);
		myPanel.setLayout(new BorderLayout());
		f.add(myPanel); //säger att panelen ska ligga i ett JFrame-fönster 
	
		
		f.setVisible(true);
	}
	
}

/*
	När vi skapar en ny JPanel så kommer standard-layouten vara flowLayout
*/
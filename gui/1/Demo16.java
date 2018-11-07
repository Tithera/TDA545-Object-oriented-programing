import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//gör istället panelen till en YBP där man sätter färgen i konstruktorn

class YellowBluePanel extends JPanel implements ActionListener{
	private boolean isBlue = false;
	
	public YellowBluePanel(){
		setBackground(Color.yellow);
	}
	
	public void actionPerformed(ActionEvent e){
		if(isBlue){
			//I slide: this.setBackground()
			setBackground(Color.yellow);
			isBlue = false;
		} else {
			setBackground(Color.blue);
			isBlue = true;
		}
	}
}

public class Demo16{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Demo 16");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLocation(500,200);
		
		YellowBluePanel panel = new YellowBluePanel();
		
		JButton button = new JButton("Byt färg");
		panel.add(button);
		button.addActionListener(panel); //nu behövs inte new i parentesen eftersom panel redan är av rätt typ
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Med en knapp ändrar man fönstrets färg mellan gul/blå

class DemoListener implements ActionListener{
	private final JPanel panel;
	private boolean isBlue = false;
	
	public DemoListener(JPanel panel){
		this.panel = panel;
	}
	
	public void actionPerformed(ActionEvent e){
		if(isBlue){
			panel.setBackground(Color.yellow);
			isBlue = false;
		} else {
			panel.setBackground(Color.blue);
			isBlue = true;
		}
	}
}

public class Demo15{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Demo15");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setLocation(500,200);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		
		JButton button = new JButton("Byt färg");
		button.addActionListener(new DemoListener(panel));
		panel.add(button);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
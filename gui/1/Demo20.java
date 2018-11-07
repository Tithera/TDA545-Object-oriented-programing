import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//En panel som byter färg varje gång vi klickar på knappen

class colorPanel extends JPanel implements ActionListener{
	
	public colorPanel(){
		setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent e){
		Random generator = new Random();
		
		int r = generator.nextInt(256);
		int g = generator.nextInt(256);
		int b = generator.nextInt(256);
		
		setBackground(new Color(r,g,b));
	}
}

public class Demo20{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Demo 20");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		
		colorPanel panel = new colorPanel();
		
		JButton button = new JButton("New color");
		button.addActionListener(panel);
		panel.add(button);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
	

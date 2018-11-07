import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//A different way to do Demo17, doesn't need getters and setters

class YellowBluePanel extends JPanel implements ActionListener{

	public YellowBluePanel(){
		setBackground(Color.yellow);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj instanceof JButton){
			JButton b = (JButton) obj;	
			String str = b.getText();
			if(str.equals("Yellow")){
				setBackground(Color.yellow);
			} else {
				setBackground(Color.blue);
			}
		}
	}
}

public class Demo18{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Demo 18");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setLocation(50,50);
		
		YellowBluePanel panel = new YellowBluePanel();
		
		JButton b1 = new JButton("Yellow");
		JButton b2 = new JButton("Blue");
		b1.addActionListener(panel);
		b2.addActionListener(panel);
		
		panel.add(b1);
		panel.add(b2);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
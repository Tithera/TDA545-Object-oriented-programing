import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class DemoClose implements ActionListener{
	private final JFrame f;
	
	public DemoClose(JFrame f){
		this.f = f;
	}
	
	public void actionPerformed(ActionEvent e){
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
	}
}

public class Demo12{
	
	public static void main(String[] args){
		JFrame frame = new JFrame ("Demo 12");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,200);
		frame.setLocation(50,50);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.magenta);
		mainPanel.setLayout(new GridLayout(3,1));
		
		JLabel label = new JLabel("Skriv en siffra");
		mainPanel.add(label);
		
		JTextField txt = new JTextField();
		mainPanel.add(txt);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.cyan);
		
		JButton button1 = new JButton("Skicka");
		JButton button2 = new JButton("Avbryt");
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		
		button2.addActionListener(new DemoClose(frame));
		
		
		mainPanel.add(buttonPanel);
		frame.add(mainPanel);
		frame.setVisible(true);
	}
}
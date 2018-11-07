import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class DemoListener implements ActionListener{
	private final JFrame f;
	
	public DemoListener(JFrame f){
		this.f = f;
	}
	
	public void actionPerformed(ActionEvent e){
		String str = e.getActionCommand();
		if(str.equals("Hej") || str.equals("Då")){
			System.out.println(str);
		} else{
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		}
	}
}

public class Demo13{
	
	public static void main(String[] args){
		JFrame frame = new JFrame ("Demo 13");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,200);
		frame.setLocation(50,50);
		
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.yellow);
		myPanel.setLayout(new GridLayout(4,1));
		
		JButton b1 = new JButton ("Hej");
		myPanel.add(b1);
		b1.setActionCommand("Hej");
		
		JButton b2 = new JButton ("Då");
		myPanel.add(b2);
		b2.setActionCommand("Då");
		
		JButton b3 = new JButton("Avbryt");
		myPanel.add(b3);
		b3.setActionCommand("Avbryt");
		
		frame.add(myPanel);
		frame.setVisible(true);
	}
}
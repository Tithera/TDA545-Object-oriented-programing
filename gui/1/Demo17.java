import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Använder nu istället två knappar för att byta färg, mha set/getActionCommand

class YellowBluePanel extends JPanel implements ActionListener{		
	private JFrame frame;
	
	public YellowBluePanel(){
		setBackground(Color.yellow);
		setLayout(new GridLayout(5,1));
	}
	
	public YellowBluePanel(JFrame frame){
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e){
		String str = e.getActionCommand();
		if(str.equals("yellow")){
			setBackground(Color.yellow);			
		} else if(str.equals("blue")){
			setBackground(Color.blue);
		} else {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
}

public class Demo17{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Demo 17");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setLocation(50,50);
		
		YellowBluePanel panel = new YellowBluePanel();
		
		JButton b1 = new JButton("Gul");
		b1.addActionListener(panel);
		b1.setActionCommand("yellow");
		
		JButton b2 = new JButton("Blå");
		b2.addActionListener(panel);
		b2.setActionCommand("blue");
		
		JButton b3 = new JButton("Avbryt");
		b3.addActionListener(new YellowBluePanel(frame));
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
}
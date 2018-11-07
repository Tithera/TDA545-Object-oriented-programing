import java.awt.*;
import javax.swing.*;

public class Calc extends JFrame{
	
	public Calc(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(230,170);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel pN = new JPanel();
		pN.setBackground(Color.WHITE);
		mainPanel.add(pN, BorderLayout.NORTH);
		
		JPanel pC = new JPanel();
		pC.setBackground(Color.YELLOW);
		pC.setLayout(new GridLayout(4,4));
		mainPanel.add(pC, BorderLayout.CENTER);
		
		JButton b;
		b = new JButton("7");
		pC.add(b);
		b = new JButton("8");
		pC.add(b);
		b = new JButton("9");
		pC.add(b);
		b = new JButton("+");
		pC.add(b);
		b = new JButton("4");
		pC.add(b);
		b = new JButton("5");
		pC.add(b);
		b = new JButton("6");
		pC.add(b);
		b = new JButton("-");
		pC.add(b);
		b = new JButton("1");
		pC.add(b);
		b = new JButton("2");
		pC.add(b);
		b = new JButton("3");
		pC.add(b);
		b = new JButton("*");
		pC.add(b);
		b = new JButton("0");
		pC.add(b);
		b = new JButton("C");
		pC.add(b);
		b = new JButton("=");
		pC.add(b);
		b = new JButton("/");
		pC.add(b);
		
		JLabel l = new JLabel("17");
		pN.add(l);
		
		JButton b1;
		
		add(mainPanel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Calc frame = new Calc();
	}
}
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

/*
	Laboration 4
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

public class Memory implements ActionListener{
	
	private Kort[] k;
	private Kort[] activeCards;
	private Kort kort1;
	private Kort kort2;
	private JFrame frame;
	private JPanel memoryBoard;
	private JPanel north;
	private JPanel south;
	private JLabel score1;
	private JLabel score2;
	private int nbrOfRows;
	private int nbrOfColumns;
	private int shownCards = 0;
	private int newScore1 = 0;
	private int newScore2 = 0;
	private boolean active = false;
	private boolean playerTurn = true;
	
		
	private class CardListener implements ActionListener{
		private Kort kort1;
		private Kort kort2;
		
		public CardListener(Kort kort1, Kort kort2){
			this.kort1 = kort1;
			this.kort2 = kort2;
		}
		
		public void actionPerformed(ActionEvent e){
			/*Om korten har samma ikon skall deras status sättas till SAKNAS,
			samt att spelaren vars tur det är skall få sina poäng ökade med 1*/
			if(kort1.sammaBild(kort2)){
				kort1.setStatus(Kort.Status.SAKNAS);
				kort2.setStatus(Kort.Status.SAKNAS);
				if(playerTurn){
					newScore1++;
					score1.setText(Integer.toString(newScore1));
				} else{
					newScore2++;
					score2.setText(Integer.toString(newScore2));
				}
				
			/*Annars så skall turen skifta, detta görs med att vi byter färg 
			på respektive panel och ändrar status på playerTurn*/
			} else {
				kort1.setStatus(Kort.Status.DOLT);
				kort2.setStatus(Kort.Status.DOLT);
				
				if(playerTurn){
					north.setBackground(Color.lightGray);
					south.setBackground(Color.yellow);
					playerTurn = false;
				} else {
					north.setBackground(Color.yellow);
					south.setBackground(Color.lightGray);
					playerTurn = true;
				}
			}
			
			checkGameStatus();
			active = false; //visar att händelsen har tagit slut
		}
		
		
		public void checkGameStatus(){
			/*Vi skapar en räknare antSaknas som ökas för varje kort som har 
			status SAKNAS*/
			int antSaknas = 0;
			for(int i = 0; i < activeCards.length; i++){
				if(activeCards[i].getStatus().equals(Kort.Status.SAKNAS)){
					antSaknas++;
				}
			}
			/*Om antSaknas sedan har samma värde som antalet kort på brädet,
			så innebär det att spelet är slut och spelaren får ett val om att
			fortsätta eller ej*/
			if(antSaknas == activeCards.length){
				int reply = JOptionPane.showConfirmDialog(null, "Finished game! Do you want to start a new game?", "", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION){
					nyttSpel(nbrOfRows*nbrOfColumns);
				} else {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
		} 

	}
		
	public void actionPerformed(ActionEvent e){
		/*Fölande if-sats körs om användaren klickade på en 'vanlig' knapp*/
		Object o = e.getSource();
		if(o.getClass() == JButton.class){
			JButton b = (JButton) o;
			String str = b.getText();
			if(str.equals("Nytt")){
				nyttSpel(nbrOfRows*nbrOfColumns); 
			} else if(str.equals("Avsluta")){
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		}
		else if (o.getClass() == Kort.class){
			/*Om spelaren klickade på ett kort så kommer följande köras endast
			om vi inte redan har två kort synliga på brädet*/
			if(!active){
				/*Om det är det första kortet vi klickar på så kommer det visas
				endast om status inte blivit satt till SAKNAS, dvs "försvunnit"*/
				if(shownCards == 0){
					kort1 = (Kort) o;
					if(kort1.getStatus() != Kort.Status.SAKNAS){
						kort1.setStatus(Kort.Status.SYNLIGT);
						shownCards++; 
					}
				/*Annars om det är det andra kortet gäller samma krav OCH att 
				det inte är det första kortet vi klickade på. Händelsen ovan 
				startas sedan mha en timer och CardListener*/
				} else if(shownCards == 1) {
					kort2 = (Kort) o;
					if(kort1 != kort2 && kort2.getStatus() != Kort.Status.SAKNAS){
						active = true;
						kort2.setStatus(Kort.Status.SYNLIGT);
						shownCards = 0;
						CardListener c = new CardListener(kort1, kort2);
						Timer timer = new Timer(1500, c);
						timer.setRepeats(false);
						timer.start();
					}
				}
			} 
		}
	}
			
	
	public Memory() {
		loadIcons();
		/*Spelaren får möjlighet att fylla i antalet radar och kolumner så länge
		som de inte överskrider antalet bilder som finns i mappen*/
		do {
			String ans1 = JOptionPane.showInputDialog("Please enter number of rows:");
			String ans2 = JOptionPane.showInputDialog("Number of columns: ");
			nbrOfRows = Integer.parseInt(ans1);
			nbrOfColumns = Integer.parseInt(ans2);
			if(nbrOfRows*nbrOfColumns/2 > k.length){
				JOptionPane.showMessageDialog(null, "Board too big!");
			} else if ((nbrOfRows*nbrOfColumns)%2 == 1){
				JOptionPane.showMessageDialog(null, "Uneven number!");
			}
		} while(nbrOfRows*nbrOfColumns/2 > k.length || (nbrOfRows*nbrOfColumns)%2 == 1);
	
		createBoard(); //brädet skapas
		
		nyttSpel(nbrOfRows*nbrOfColumns); //och ett nytt spel initieras
	}
	
	private void loadIcons(){
		//vi sparar alla bilder från mappen i en array
		File bildmapp = new File("bildmapp");
		File[] bilder = bildmapp.listFiles();
		
		k = new Kort[bilder.length];
		
		/*Arrayen k kommer laddas med alla bilder som ligger i mappen*/
		for (int i = 0; i < bilder.length; i++){
			String path = bilder[i].getPath();
			ImageIcon icon = new ImageIcon(path);
			k[i] = new Kort(icon, Kort.Status.DOLT);
		}
	}
	
	public void nyttSpel(int n){
		memoryBoard.removeAll(); //alla paneler som ligger i memoryBoard tas bort
		//Vid varje nytt spel ska poängen nollställas
		newScore1 = 0;
		newScore2 = 0;
		score1.setText(Integer.toString(newScore1));
		score2.setText(Integer.toString(newScore2));
		//en ny array förbereds och den tidigare listan shufflas om
		activeCards = new Kort[n];
		Verktyg.slumpOrdning(k);
		
		/*Den första for-loopen står för att flytta över antaler rader*kolumner/2
		bilder till activeCards och den andra kopierar dessa så att vi får en array
		men två kort av varje som skall täcka hela spelplanen*/
		for(int i = 0; i < n/2; i++){
			activeCards[i] = k[i].copy();
		}

		for(int i = n/2; i < n; i++){
			activeCards[i] = activeCards[i-n/2].copy();
		}
		
		Verktyg.slumpOrdning(activeCards);
		
		/*Varje kort läggs ut på vår panel memoryBoard och vår instans av Memory 
		lyssnar på varje kort*/
		for(int i = 0; i < activeCards.length; i++){
			memoryBoard.add(activeCards[i]);
			activeCards[i].addActionListener(this);
		}
		frame.revalidate();
		frame.repaint();
	}
	
	
	
	public void createBoard (){
		/*En frame skapas med en huvudpanel*/
		frame = new JFrame("Memory");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(350,200);
		frame.setSize(500,500);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		/*Huvudpanelen kommer delas upp i tre delar: den vänstra delen där spelarnas
		poäng står, mittendelen (memoryBoard)kommer vara själva spelplanen och 
		den längst ner (buttonPanel) kommer vara panelen för knapparna "nytt"
		samt "avsluta"*/
		JPanel leftSidePanel = new JPanel();
		leftSidePanel.setLayout(new GridLayout(2,1));
		
		/*Sedan kommer leftSidePanel att delas upp i en nord- samt en syddel
		(för spelare 1 samt spelare 2)*/
		north = new JPanel();
		north.setLayout(new GridLayout(2,1));
		north.setBackground(Color.yellow);
		JLabel player1 = new JLabel("Spelare 1");
		score1 = new JLabel("0");
		score1.setHorizontalAlignment(SwingConstants.CENTER);
		north.add(player1);
		north.add(score1);
		leftSidePanel.add(north);
		
		
		south = new JPanel();
		south.setLayout(new GridLayout(2,1));
		south.setBackground(Color.lightGray);
		JLabel player2 = new JLabel("Spelare 2");
		score2 = new JLabel("0");
		score2.setHorizontalAlignment(SwingConstants.CENTER);
		south.add(player2);
		south.add(score2);
		
		leftSidePanel.add(south);
		
		
		memoryBoard = new JPanel();
		memoryBoard.setLayout(new GridLayout(nbrOfRows, nbrOfColumns));
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		
		JButton button1 = new JButton("Nytt");
		JButton button2 = new JButton("Avsluta");
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		/*Här lyssnar även vår instans av memory på knapparna*/
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		mainPanel.add(leftSidePanel, BorderLayout.WEST);
		mainPanel.add(memoryBoard, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args){
		Memory m = new Memory();
	}
}
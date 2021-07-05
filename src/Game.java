import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	public JFrame window;
	public Container container;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	public JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font ("Candara", Font.PLAIN, 24);
	public Font normalFont2 = new Font ("Candara", Font.PLAIN, 23);
	public Font shortFont = new Font ("Times New Roman", Font.PLAIN, 10);
	public JButton startButton, choice1, choice2, choice3, choice4;
	public JTextArea mainTextArea;
	static Font pixelMplus;
	
	Color blue = new Color(100,100,133);
	
	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();	
	ChoiceHandler choiceHandler = new ChoiceHandler();	
	
	
	Timer timer = new Timer();
//	TimerTask task = new TimerTask(){
//
//		@Override
//		public void run() {			
//			timer.schedule(task, 3000);
//		}
//		
//	};
	
	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	int playerHP;
	String playerName, position;
	String playerWeapon;
	String specialPower;
	String enemyName;
	String bag;
	int choice;
	int monsterHP;
	int barbaroHP;
	int enemyHP;
	int playerPotions;	
	int bagSlots;

	int dragonRing;
	boolean goblinIsDead = false;
	boolean guardIsDead = false;
	boolean enteredCityAlready = false;
	boolean oldManFinished = false;
	boolean mageFinished = false;
	boolean badKidFinished = false;
	boolean isPlayerGuilty = false;
	boolean callHappened = false;

	public static void main(String[] args) {		
		
		new Game(); 
		
		
		
		
	}
	
	public Game() {
		
		try{
	        // load a custom font in your project folder
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("dragonwarrior.ttf")).deriveFont(25f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dragonwarrior.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}	
				
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);		
		window.setResizable(false);
		
		container = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont2);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		container.add(titleNamePanel);
		container.add(startButtonPanel);
		window.setVisible(true);
	}

	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
				
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		container.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 400);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(blue);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		container.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(blue);
		choice1.setForeground(Color.white);
		choice1.setFont(pixelMplus);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(blue);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont2);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(blue);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont2);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(blue);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont2);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(Color.black);
	    playerPanel.setLayout(new GridLayout(1,4));
		container.add(playerPanel);
		
		hpLabel = new JLabel("Vida:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Arma:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetUp();

	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
		
	}
	
	public class ChoiceHandler implements ActionListener{
		/*	
		 * 
		 * Button Handler	  
		 * 
		 * 
		 * */
		public void actionPerformed(ActionEvent event) {
			String userChoice = event.getActionCommand();
			
			
			if (position.equals("townGate") && userChoice.equals("c1")) {
				talkGuard();		
				}
			else if (position.equals("talkGuard") && userChoice.equals("c1")) {
				talkGuard2();		
				}		
			else if  (position.equals("townGate") && userChoice.equals("c2")) {						
				attackGuard();		
			}
			else if (position.equals("townGate") && userChoice.equals("c3")) {						
				crossRoad();		
			}
			else if (position.equals("talkGuard2") && userChoice.equals("c1") 
					|| position.equals("attackGuard") && userChoice.equals("c1") 
					|| position.equals("crossRoad") && userChoice.equals("c3") ) {						
				townGate();				
			}
			else if (position.equals("crossRoad") && userChoice.equals("c1")) {
				north();
			}
			
			else if (position.equals("north") && userChoice.equals("c1")) {
				north2();
			}
			else if (position.equals("crossRoad") && userChoice.equals("c2")) {
				east();
			}
			else if (position.equals("east") && userChoice.equals("c1")) {
				east2();
			}
			else if (position.equals("killedGuard") && userChoice.equals("c1")) {
				city1();
			}
			else if (position.equals("city1") && userChoice.equals("c1")) {
				city2();
			}
			
			else if (position.equals("pulled") && userChoice.equals("c4")
					||position.equals("!pulled") && userChoice.equals("c2")) {
				crossRoad();
			}
			else if (position.equals("!pulled") && userChoice.equals("c1")) {
				east2();
			}
			
			else if (position.equals("crossRoad") && userChoice.equals("c4")) {
				west();
			}
			
			else if (position.equals("east3") && userChoice.equals("c1")) {
				east4();
			}
			else if (position.equals("east4") && userChoice.equals("c1")) {
				attackEnemy("B�rbaro");
			}
			else if (position.equals("east4") && userChoice.equals("c2")) {
				cantRun();
			}
			else if (position.equals("cantRun") && userChoice.equals("c1")) {
				east4();
			}			
			else if (position.equals("attackingEnemy") && userChoice.equals("c1")) {
				attackEnemy("B�rbaro");
			}
			else if (position.equals("attackingEnemy") && userChoice.equals("c3")){
				usePotion2();
				}
			else if (position.equals("ending") && userChoice.equals("c4")){
				city1();
				}
			
			
			else if (position.equals("north2") && userChoice.equals("c1") 
					|| position.equals("east2") && userChoice.equals("c2")
					|| position.equals("east3") && userChoice.equals("c2")					
					|| position.equals("east") && userChoice.equals("c2")
					|| position.equals("staringGoblin") && userChoice.equals("c2")
					|| position.equals("fightGoblin") && userChoice.equals("c2")
					|| position.equals("attackingGoblin") && userChoice.equals("c2")
					|| position.equals("win") && userChoice.equals("c1")
					|| position.equals("afterDestruction") && userChoice.equals("c1")
					|| position.equals("usingPotion") && userChoice.equals("c2")
					|| position.equals("townGate2") && userChoice.equals("c2")
					|| position.equals("townGate3") && userChoice.equals("c3")
					|| position.equals("east3_1") && userChoice.equals("c2")) {
				crossRoad();
			}	
			
			else if (position.equals("staringGoblin") && userChoice.equals("c1")){
				fightGoblin();				
			}
			
			else if (position.equals("fightGoblin") && userChoice.equals("c1")){
				attack();				
			}
			
			else if (position.equals("attackingGoblin") && userChoice.equals("c1") 
					|| position.equals("usingPotion") && userChoice.equals("c1")){
				attack();				
			}
			
			
			
			else if (position.equals("attackingGoblin") && userChoice.equals("c3")
					|| position.equals("usingPotion") && userChoice.equals("c3")					
					|| position.equals("fightGoblin") && userChoice.equals("c3")
					){
				usePotion();			
			}
			
			else if (position.equals("usingPotion2") && userChoice.equals("c3")) {
				usePotion2();
			}
			else if (position.equals("usingPotion2") && userChoice.equals("c1")) {
				attackEnemy("B�rbaro");
			}
			
			else if (position.equals("dead") && userChoice.equals("c1")){
				playerSetUp();				
			}
			
			// ----------------------INSIDE CITY INTERATIONS -----------------		
			
			else if (position.equals("oldMan1") && userChoice.equals("c2")
					|| position.equals("oldMan3") && userChoice.equals("c2")
					|| position.equals("townGate2") && userChoice.equals("c1")
					|| position.equals("oldManFinished") && userChoice.equals("c1")
					|| position.equals("badKid1") && userChoice.equals("c2")
					|| position.equals("badKid3") && userChoice.equals("c2")
					|| position.equals("badKidFinished") && userChoice.equals("c1")
					|| position.equals("mage1") && userChoice.equals("c2")
					|| position.equals("mageFinished") && userChoice.equals("c2")
					|| position.equals("call4") && userChoice.equals("c1")
					){
				city2();				
			}
			else if (position.equals("enteredCityAlready") && userChoice.equals("c1")) {
				townGate();
			}
			else if (position.equals("townGate3") && userChoice.equals("c1")) {
				talkGuard();
			}
			else if (position.equals("townGate3") && userChoice.equals("c2")) {
				city1();
			}
			else if (position.equals("talkGuard2") && userChoice.equals("c1")) {
				townGate();
			}
			
			// ----------------------CITY2 DIRECTIONS -----------------			
			else if (position.equals("city2") && userChoice.equals("c1")){
				oldMan1();				
			}			
			else if (position.equals("city2") && userChoice.equals("c2")){
				badKid1();			
			}			
			else if (position.equals("city2") && userChoice.equals("c3")){
				mage1();				
			}			
			else if (position.equals("city2") && userChoice.equals("c4")){
				townGate();				
			}
			
			// ----------------------OLDMAN INTERATIONS -----------------	
			else if (position.equals("oldMan1") && userChoice.equals("c1")){
				oldMan2();				
			}
			else if (position.equals("oldMan2") && userChoice.equals("c1")){
				oldMan3();				
			}
			else if (position.equals("oldMan3") && userChoice.equals("c1")){
				oldMan4();				
			}
			else if (position.equals("oldMan4") && userChoice.equals("c1")){
				oldMan5();				
			}
			else if (position.equals("oldMan5") && userChoice.equals("c1")){
				city2();				
			}
			
			// ----------------------BAD KID INTERATIONS -----------------	
			else if (position.equals("badKid1") && userChoice.equals("c1")){
							badKid2();				
						}
			else if (position.equals("badKid2") && userChoice.equals("c1")){
							badKid3();				
						}
			else if (position.equals("badKid3") && userChoice.equals("c1")){
							badKid4();				
						}
			else if (position.equals("badKid4") && userChoice.equals("c1")){
							city2();				
						}
			
			// ----------------------MAGO INTERATIONS -----------------	
			else if (position.equals("mage1") && userChoice.equals("c1")){
							mage2();
						}
			else if (position.equals("mage2") && userChoice.equals("c1")){
				mage3();
			}
			else if (position.equals("mage3") && userChoice.equals("c1")){
				mage4();
			}
			else if (position.equals("mage4") && userChoice.equals("c1")){
				mage4_1();
			}
			else if (position.equals("mage4_1") && userChoice.equals("c1")){
				mage4_2();
			}
			else if (position.equals("mageGuardKilled") && userChoice.equals("c1")) {
				mage4_2();
			}
			else if (position.equals("mage4_2") && userChoice.equals("c1")){
				mage4_3();
			}
			else if (position.equals("mage4_3") && userChoice.equals("c1")){
				mage5();
			}
			else if (position.equals("mage5") && userChoice.equals("c1")){
				city2();
			}
			else if (position.equals("mageFinished") && userChoice.equals("c1")){
				mageFutureRead();
			}
			else if (position.equals("mageFutureRead") && userChoice.equals("c1")){
				city2();
			}
							
			
			// THE KING CALLING			
			else if (position.equals("call") && userChoice.equals("c1")){
				call2();				
			}
			
			else if (position.equals("call2") && userChoice.equals("c1")){
				call3();				
			}
			else if (position.equals("call3") && userChoice.equals("c1")){
				call4();				
			}
			else if (position.equals("captured") && userChoice.equals("c1")){
				captured2();				
			}
			else if (position.equals("captured2") && userChoice.equals("c1")){
				dead();				
			}			
			else if (position.equals("east3_1") && userChoice.equals("c1")){
				newJourney();
			}
			
			// NEW JOURNEY!!!
			else if (position.equals("newJourney") && userChoice.equals("c1")){
				newJourney2();
			}
			else if (position.equals("newJourney2") && userChoice.equals("c1")){
				newJourney3();
			}
			else if (position.equals("newJourney3") && userChoice.equals("c1")){
				newJourney4();
			}
			
		}
	}
	
	
	
	public void playerSetUp() {

		playerHP = 10;
		monsterHP = 30;
		barbaroHP = 40;
		playerPotions = 0;
		specialPower = "";	
		bag = "Bolso";	
		bagSlots = 4;
		guardIsDead = false;
		enteredCityAlready = false;
		oldManFinished = false;
		badKidFinished = false;	
		
		position = "playerSetUp";
		playerWeapon = "Nenhuma";	
		weaponLabelName.setText(playerWeapon);
		hpLabelNumber.setText(""+playerHP);
		
		townGate();
	} 
	
	

	public void townGate() {
		
		if (guardIsDead) {
		position = "townGate2";
			
		mainTextArea.setText("Voc� est� no port�o da cidade.\n");
			
		choice1.setText("Entrar na cidade");
		choice2.setText("Ir embora");
		choice3.setText("");
		choice4.setText("");
		}
		
		else if (enteredCityAlready) {
			
			position = "townGate3";					
			mainTextArea.setText("Voc� est� no port�o da cidade.\nUm guarda est� parado na sua frente.\n\nO que voc� ir� fazer?");
			choice1.setText("Falar com o guarda");
			choice2.setText("Entrar na cidade");
			choice3.setText("Ir embora");
			choice4.setText("");
		
		}
		
		else {
		position = "townGate";
		
		mainTextArea.setText("Voc� est� no port�o de uma cidade.\nUm guarda est� parado na sua frente.\n\nO que voc� ir� fazer?");
		
		choice1.setText("Falar com o guarda");
		choice2.setText("Atacar o guarda");
		choice3.setText("Ir embora");
		choice4.setText("");
		}
		
		
		
	}
	
	public void talkGuard() {
		position = "talkGuard";
		if (dragonRing == 1) {
			ending();
		}
		else if (enteredCityAlready) {
			position = "talkGuard2";
			mainTextArea.setText("Guarda: ''Ol� Nobre Guerreiro. Obrigado pelos seus \nservi�os prestados para nossa comunidade.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		else {
			
			position = "talkGuard";
			mainTextArea.setText("Guarda: ''Ol� estrangeiro. Desculpe...'' \n\n''N�o te conhe�o, n�o posso permitir que \nestranhos entrem na cidade.''\n");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");	
			
			
		}	
			
	}
	
	public void talkGuard2() {		
				
		position = "talkGuard2";		
		mainTextArea.setText("Guarda: ''Mas ou�a... Existe um monstro solto por a�. \n\nMate-o e retorne para c�. Prove seu valor! \n\nEnt�o, o deixarei entrar na cidade...''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		}	
			
	
	
	public void attackGuard() {
		if (playerWeapon.equals("Excalibur")) {
			position = "killedGuard";
			guardIsDead = true;
			isPlayerGuilty = true;
			mainTextArea.setText("Guarda: ''Argh... Essa �urea azul na sua espada. \n� a Excalibur! N�o pode ser... Minha morte ser� \nvingada!''\n\nO Guarda morreu. \n\nO caminho para entrar na cidade est� livre agora.");
			choice1.setText("Entrar");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");		}
		
		else {
		position = "attackGuard";
		mainTextArea.setText("Guarda: ''Ei, n�o seja est�pido.''\n\nO guarda te acertou t�o forte que voc� decidiu \nn�o atacar mais.\n\n(Voc� recebeu 3 pontos de dano)");
		playerHP -= 3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		if (playerHP <= 0) {
			dead();	}}
				
	}
	

	public void crossRoad() {
		
		position = "crossRoad";
		mainTextArea.setText("Agora voc� est� em uma encruzilhada. \n\nSe voc� for para o SUL, retornar� para \no port�o da cidade.\n\n");
		choice1.setText("Ir para o NORTE.");
		choice2.setText("Ir para o LESTE.");
		choice3.setText("Ir para o SUL.");
		choice4.setText("Ir para o OESTE.");

		
	}
	
	public void north() {
		position = "north";
		if (bag.equals("Bolso") && playerPotions == 4 || bag.equals("Cinto") && playerPotions == 10) {
			playerPotions--;		
			}	
		
		playerPotions++;
		mainTextArea.setText("Voc� encontrou um lindo rio. Aproveitou para \nbeber �gua e descansar um pouco. \n\nTamb�m colheu algumas folhas m�gicas e criou uma \npo��o de vida.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
		
	}
	
	public void north2() {
		position = "north2";		
		mainTextArea.setText("Voc� guardou a Po��o de Vida em seu "+bag+"\n\nVoc� poder� beber Po��es de Vida em momentos de \ndesespero. \n\nPo��es de vida equipadas: "+playerPotions+"\n"+bag+" ("+bagSlots+" Slots)");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void waitt() {
		try {TimeUnit.SECONDS.sleep(3);} 
		catch (InterruptedException e1) {e1.printStackTrace();}
	}

	public void east() {		
		
		if (playerWeapon.equals("Excalibur")) {
			east3();
		} else {
		position = "east";
		mainTextArea.setText("Voc� andou um pouco pela floresta e encontrou \numa gigante pedra, com uma espada atravessada \ndentro dela. \n\nA espada est� enferrujada, parece que esteve ali por \nMUITO tempo. Na pedra est� escrito: ''Excalibur''");
		choice1.setText("Pegar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");}	
	}
	
	public void east2() {		
		position = "east2";
			
		double pull = new java.util.Random().nextDouble()*5;
		System.out.println(pull);
		
		if (pull > 4.90) {	
			position = "pulled";
			mainTextArea.setText("Sua alma se uniu com seus bra�os, voc� juntou \nfor�as e...CONSEGUIU! \n\nVoc� retira a espada e aponta para o alto, em sinal de \nvit�ria. Uma �urea azul clara rodeia o metal da espada.\n\n(Excalibur equipada - Inflige 0-8 Pontos de Dano)");
			playerWeapon = "Excalibur";
			weaponLabelName.setText(playerWeapon);
			choice1.setText("");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("Voltar");}	
		
		else if (pull > 2.0){
		position = "!pulled";	
		mainTextArea.setText("Voc� firmou os p�s no ch�o colocando toda sua for�a em seus bra�os, e... \nN�o conseguiu. \n\nMas a espada se moveu minimamente, o suficiente \npara lhe dar esperan�as de tentar novamente.");
		choice1.setText("Tentar");
		choice2.setText("Desistir");
		choice3.setText("");
		choice4.setText("");}	
		else {
			position = "!pulled";	
			mainTextArea.setText("Voc� se apoiou na pedra, puxou a espada para tr�s e...N�o conseguiu. \n\nA espada nem se moveu.\n\n''Talvez eu devesse tentar v�rias vezes seguidas \nsem parar, sem desistir, uma hora ela sai!''");
			choice1.setText("Tentar");
			choice2.setText("Desistir");
			choice3.setText("");
			choice4.setText("");
		}
		
		}		
	
	
	
	public void east3() {
		if (callHappened) {
			position = "east3_1";	
			mainTextArea.setText("Voc� observa a densa floresta na sua frente. \n\nNota tamb�m que existem 1 rapaz e 2 garota em volta de uma fogueira.");
			choice1.setText("Falar");		
			choice2.setText("Voltar");
			choice3.setText("");
			choice4.setText("");
		}
		else {
			position = "east3";	
		mainTextArea.setText("Voc� observa a densa floresta na sua frente. \n\nSeria perigoso adentrar nela sem uma grande \nquantidade de mantimentos para semanas. \n\nOu sem uma equipe para lhe ajudar nas \nposs�veis amea�as.");
		choice1.setText("Entrar");		
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");
		}
		
		
	}
	
	public void east4() {
		position = "east4";	
		mainTextArea.setText("Voc� encontrou um B�rbaro!");
		choice1.setText("Atacar");		
		choice2.setText("Fugir");
		choice3.setText("");
		choice4.setText("");		
	}
	
	public void cantRun() {
		position = "cantRun";	
		mainTextArea.setText("Seu inimigo � muito mais r�pido que voc�. \n\nTentar fugir agora � suicidio!");
		choice1.setText("Atacar");		
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}

	public void west() {
		
		position = "west";
		
		if (!goblinIsDead) {
			
			position = "staringGoblin";
			
			mainTextArea.setText("Voc� encontrou um Goblin Assustador!\n\nVoc� olha para sua arma ("+ playerWeapon +") e pensa no \nque fazer.");
			choice1.setText("Lutar");
			choice2.setText("Fugir");
			choice3.setText("");
			choice4.setText("");
			
		}		
		else {
			position = "afterDestruction";
			mainTextArea.setText("Voc� olha ao redor e v� apenas destrui��o, \ncausada pela tua feroz batalha com o Goblin.");
			choice1.setText("Voltar");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			
			}
		
		
	}

	public void fightGoblin() {
		
	position = "fightGoblin";		
		
		mainTextArea.setText("O Goblin est� na sua frente. Ele � gigantesco e \naterrorizante.\n\n''Ser� que tenho ferramentas para venc�-lo?''\n\nPontos de Vida do Goblin: " + monsterHP + "\nSua arma: "+playerWeapon);
		choice1.setText("Lutar!");
		choice2.setText("Correr");
		choice3.setText("Po��o de Vida "+"("+playerPotions+")");
		choice4.setText("");		
		
	}

	public void attack() {
		position = "attackingGoblin";
		int playerDamage = 0;

		if (playerWeapon.equals("Nenhuma")) {
			playerDamage = new java.util.Random().nextInt(3);
		} else if (playerWeapon.equals("Excalibur")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		monsterHP -= playerDamage;		

		if (monsterHP < 1) {
			win();
			
		} else if (monsterHP > 0) {
			
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(4);			
			
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			
			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				mainTextArea.setText("Voc� o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do Goblin: " + monsterHP+""+"\n\nO monstro lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
				choice1.setText("Atacar!");
				choice2.setText("Correr");
				choice3.setText("Po��o de Vida "+"("+playerPotions+")");
				choice4.setText("");
			}
		}

	}
	
	public void attackEnemy(String enemyName) {
		enemyHP = barbaroHP;
		position = "attackingEnemy";
		int playerDamage = 0;

		if (playerWeapon.equals("Nenhuma")) {
			playerDamage = new java.util.Random().nextInt(3);
		} else if (playerWeapon.equals("Excalibur")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		enemyHP -= playerDamage;		

		if (enemyHP < 1) {
			win2(enemyName, enemyHP);
			
		} else if (enemyHP > 0) {
			
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(4);			
			
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			
			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				mainTextArea.setText("Voc� o atacou e infligiu " + playerDamage + " pontos de dano!\n\n" + "Seus Pontos de Vida: " + playerHP+""+ "\nPontos de Vida do "+enemyName+":"+ monsterHP+""+"\n\nO inimigo lhe atacou e infligiu " + monsterDamage + " pontos de dano!");
				choice1.setText("Atacar!");
				choice2.setText("Correr");
				choice3.setText("Po��o de Vida "+"("+playerPotions+")");
				choice4.setText(""+specialPower);
			}
		}

	}
	
	public void usePotion() {
		position = "usingPotion";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(2);
		
		if (playerPotions > 0) {
			
			playerHP +=3;
			playerHP -= monsterDamage;
			playerPotions--;
			hpLabelNumber.setText(""+playerHP);
			
			mainTextArea.setText("Voc� desesperadamente bebeu uma Po��o de Vida.\n(Voc� recuperou 3 pontos de vida)\n\nO monstro ficou furioso e lhe atacou, por�m o dano \nfoi minimo. (Voc� tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Po��o de Vida "+"("+playerPotions+")");
			choice4.setText("");
		}
		else {
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Voc� tentou beber uma Po��o de Vida, mas n�o tem \nnenhuma.\n\nO monstro ficou furioso e lhe atacou, por�m o dano \nfoi minimo. (Voc� tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Po��o de Vida "+"("+playerPotions+")");
			choice4.setText("");
		}
	}
	
	public void usePotion2() {
		position = "usingPotion2";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(2);
		
		if (playerPotions > 0) {
			
			playerHP +=3;
			playerHP -= monsterDamage;
			playerPotions--;
			hpLabelNumber.setText(""+playerHP);
			
			mainTextArea.setText("Voc� desesperadamente bebeu uma Po��o de Vida.\n(Voc� recuperou 3 pontos de vida)\n\nO monstro ficou furioso e lhe atacou, por�m o dano \nfoi minimo. (Voc� tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Po��o de Vida "+"("+playerPotions+")");
			choice4.setText("");
		}
		else {
			playerHP -= monsterDamage;
			hpLabelNumber.setText(""+playerHP);
			mainTextArea.setText("Voc� tentou beber uma Po��o de Vida, mas n�o tem \nnenhuma.\n\nO monstro ficou furioso e lhe atacou, por�m o dano \nfoi minimo. (Voc� tomou "+monsterDamage+" de dano)");
			choice1.setText("Atacar");
			choice2.setText("Correr");
			choice3.setText("Po��o de Vida "+"("+playerPotions+")");
			choice4.setText("");
		}
	}

	public void dead() {
		position = "dead";
		playerHP = 0;
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("Voc� Morreu...");
		choice1.setText("Recome�ar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}

	public void win() {
		
		position = "win";
		mainTextArea.setText("Voc� matou o monstro! Ele virou cinzas. \n\nAgora s� restou um anel dourado ca�do no ch�o, \ncom a face de um drag�o. Voc� pega e guarda ele.\n\n''Talvez agora o guarda enxergue o meu valor!''");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		

		dragonRing = 1;
		playerWeapon = "DragonRing";
		weaponLabelName.setText(playerWeapon);
		
		goblinIsDead = true;		

	}
	
		public void win2(String enemyName, int enemyHP) {
		
		position = "win";
		mainTextArea.setText("Voc� matou o "+enemyName+"!");
		choice1.setText("Voltar");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		

	}

	public void ending() {
		
		position = "ending";
		mainTextArea.setText("Guarda: Duvido. Voc� matou o Goblin que tanto \nnos atormentava? Prove.\n\n...Esse � o lend�rio Anel do Drag�o!!! \n\nVoc� matou ele mesmo! Voc� realmente � algu�m que \npodemos confiar. Seja bem-vindo � cidade! ");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Entrar");
		playerWeapon = "Excalibur";
		weaponLabelName.setText(playerWeapon);
		enteredCityAlready = true;
		dragonRing--;
		
		} 
	
	/*
	 * 
	 * CITY EVENTS
	 * 
	 * */
	
	public void city1() {
					
		position = "city1";
		mainTextArea.setText("� quase um vilarejo, com ruas bem estreitas, cheio \nde casinhas e pequenos com�rcios. \n\nAs pessoas andam para todos os lados decidindo o \nque comprar. \n\nBarulho para todo lado, parece uma grande feira.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
				
	}
	
	public void city2() {
		
		if (oldManFinished == true && mageFinished == true && !callHappened) {
			call();
		}
		
		else if (oldManFinished == true && badKidFinished == true && guardIsDead == true) {
			captured();
		}		
		
		else {
			position = "city2";
		mainTextArea.setText("Voc� est� agora no centro da cidade. \n\nPara onde voc� ir�? Se voc� for para o SUL, retornar� para o port�o da cidade.");
		choice1.setText("Ir para o NORTE");
		choice2.setText("Ir para o LESTE");
		choice3.setText("Ir para o OESTE");
		choice4.setText("Ir para o SUL");
		}
		
	}
	
	public void oldMan1() {
		
		if (oldManFinished && !callHappened) {
			position = "oldManFinished";
			mainTextArea.setText("Senhorzinho: ''Filho, tendo sua ajuda, meu com�rcio \nprosperou.'' \n\n''V� e viva um pouco! Te dou uma folga de 1 m�s.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			}
		
		else if (callHappened) {
			position = "oldManFinished";
			mainTextArea.setText("Senhorzinho: ''Filho, muito orgulho de ti. V� e mude o \nfuturo de todos n�s!''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			}
		
		else {
			position = "oldMan1";
		mainTextArea.setText("Enquanto caminhava, algo chamou sua aten��o. \nUm cheiro de sushi muito bom. \n\nVoc� d� uma espiada e observa um senhorzinho l� \ndentro preparando as comidas.");
		choice1.setText("Entrar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");}		
		
	}
	
	public void oldMan2() {
		
		position = "oldMan2";
		mainTextArea.setText("Senhorzinho: ''Ol� filho! Voc� � novo na cidade?'' \n''Nunca te vi antes.'' \n\n''Hmm... Entendi. N�o tem onde ficar certo?''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void oldMan3() {
		
		position = "oldMan3";
		mainTextArea.setText("Senhorzinho: ''Bom, voc� me lembra muito meu \nfalecido filho. Gostei muito de voc�.'' \n\n''Quer me ajudar no trabalho em troca de moradia \ne um lar?''");
		choice1.setText("Aceitar");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	public void oldMan4() {
		
		position = "oldMan4";
		mainTextArea.setText("O senhorzinho ficou muito feliz com tua escolha. \nImediatamente te colocou para trabalhar com ele. \nComo rotina, depois do longo dia de trabalho, voc�s \nconversavam sobre a vida durante a noite. \n\nO senhorzinho lhe contava hist�rias de sua juventude \ne como ele costumava sair em miss�es pelas florestas.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void oldMan5() {
		
		position = "oldMan5";
		specialPower = "Arroz";		
		mainTextArea.setText("Depois de algumas semanas vivendo neste estilo de \nvida, voc� adquiriu dinheiro. \n\nComprou um cinto que ser� muito �til para levar \nmais Po��es de Vida em batalhas. \n\nCinto Equipado (10 Slots)");
		bag = "Cinto";
		bagSlots = 10;
		oldManFinished = true;
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void call() {
		
		position = "call";
		mainTextArea.setText("...! ...! ...! \n\nBarulhos de trombetas na rua! O que ser� que est� \nacontecendo? \n\nVoc� vai para o centro da cidade descobrir.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void call2() {			
		
		position = "call2";
		mainTextArea.setText("Rei: ''Este � um grande evento para celebrar a morte \ndo terr�vel Goblin!'' \n\n''Poucas pessoas sabem, mas foi este rapaz ali que \nmatou ele!!!'' - diz o rei, enquanto aponta para voc�.\n\nAs pessoas correm em sua dire��o para lhe agradecer.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void call3() {			
		
		position = "call3";
		mainTextArea.setText("Rei: ''Guerreiro! N�o aguentamos mais viver nesta guerra \ncom os Goblins.'' \n\n''Sua Excalibur � a chave para acabarmos com isso. Criei \numa equipe com nossos melhores guerreiros.'' \n\n''Encontre eles na Floresta, fora da Cidade, ao LESTE.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void call4() {			
		
		position = "call4";
		mainTextArea.setText("Todas as pessoas lhe abra�avam e gritavam seu nome, \npedindo para que voc� finalmente colocasse um FIM \nnesta guerra com os Goblins.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		callHappened = true;
	}
	
	public void captured() {
			position = "captured";
			mainTextArea.setText("...! ...! ...! \n\nBarulhos de trombetas na rua! O que ser� que est� \nacontecendo? \n\nVoc� vai para o centro da cidade descobrir.");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
	public void captured2() {
		position = "captured2";
		mainTextArea.setText("Voc� cai no ch�o, ap�s tomar um flechada na perna.\n\nGuerreiro: ''Finalmente te pegamos, assassino! Voc� \npagar� com sua vida pela morte do nosso Guarda!''\n\nVoc� ouve estas palavras enquanto recebe outra \nflechada no cora��o.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
/* MOBILE CREATION */
	
	public void mage1() {
		if (mageFinished) {
			
			position = "mageFinished";
			mainTextArea.setText("Mago: ''Voce j� est� pronto para cumprir seu destino, fa�a bom uso de tudo que aprendeu por aqui.''\n''Deseja uma leitura de m�os?''");
			choice1.setText("Aceitar");
			choice2.setText("Voltar");
			choice3.setText("");
			choice4.setText("");
			}
			else {
		position = "mage1";
		mainTextArea.setText("Enquanto caminhava, algo chamou sua aten��o. \n\nEra uma casa bem grande, azul clara, com uma cor \nparecida com a luz emitida pela tua Excalibur.");
		choice1.setText("Entrar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText("");}
	}
	public void mage2() {
		
		position = "mage2";
		mainTextArea.setText("???: ''Ol� querido! Voc� � novo na cidade?'' \n''Nunca te vi antes.'' \n\n''Hmm... Entendi. N�o tem onde ficar certo?''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void mage3() {
		
		position = "mage3";
		mainTextArea.setText("Mago: ''Bom, pelas muitas encarna��es, eu sou chamado \nde Mago. Se eu solto magia? HAHAHA... O que � magia para ti?'' \n''N�o... Magia pode ser um olhar, um pensamento, uma \nenergia, uma ora��o. Uma po��o de cura. Voc� ja � um ser m�gico. Qualquer um pode se tornar um Mago.'' \n\n''Deseja aprender?''");
		choice1.setText("Aceitar");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	public void mage3_1() {
		
		position = "mage3_1";
		mainTextArea.setText("Mago: ''Olhe para a luz da tua espada, para sua tecnica em po��es. Estes seus dons vem de muitas vidas passadas. Posso lhe mostrar o caminho para que voc� tenha todas as respostas que precise. J� est�o todas a� dentro. Fique tranquilo, eu s� trabalho com magia branca.");
		choice1.setText("Aceitar");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mage4() {
		if (isPlayerGuilty || guardIsDead) {
			position = "mage4";
			mainTextArea.setText("Mago: ''Voc� j� andou aprontando por a� n�? Coisa feia. Mas fico feliz pelo teu aceite. Vamos come�ar sua inicia��o.'' \n\n''Que o Deus-Luz esteja com voc� e lhe mostre tudo que \nprecise ser revelado.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {
		position = "mage4";
		mainTextArea.setText("Mago: ''Fico feliz! Vamos come�ar sua inicia��o.'' \n\n''Que o Deus-Luz esteja com voc� e lhe mostre tudo que \nprecise ser revelado.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
	    
	}
	
	public void mage4_1() {
	    
		position = "mage4_1";
		mainTextArea.setText("Voc� entrou na inicia��o e tomou uma bebida m�gica. \n\nDurante horas voc� visitou diversas vidas passadas e \nentrou em contato intimo contigo mesmo. \n\nTodas as respostas que voc� precisava, foram aparecendo.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mageGuardKilled() {
		if (guardIsDead) {
		position = "mageGuardKilled";
		mainTextArea.setText("Um ser m�gico apareceu na tua frente, com uma forte luz branca para cobrar a morte do pobre Guarda. \n\nVoc� se assustou e se arrependeu do fundo de sua alma \npelo ocorrido. Foi perdoado...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		guardIsDead = false;
		isPlayerGuilty = false;
		}
		else {
			position = "mageGuardKilled";
			mainTextArea.setText("Um ser m�gico apareceu na tua frente, com uma forte luz branca para cobrar as coisas erradas que voc� fez. \n\nVoc� se assustou e se arrependeu do fundo de sua alma \npelo ocorrido. Foi perdoado...");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			guardIsDead = false;
			isPlayerGuilty = false;
		}		
	    
	}
	
	public void mage4_2() {
		
		if (guardIsDead || isPlayerGuilty) {
			mageGuardKilled();
		}
		else {
		position = "mage4_2";
		mainTextArea.setText("Em tua ultima vida passada, voc� foi um Goblin Feiticeiro, \nque causou muita destrui��o e sofrimento por in�meras \ncidades. \n\nAgora � sua chance de fazer o bem. Encerrar a guerra de \nHumanos e Goblins, pois tu ja vivenciou os dois lados...");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		}
	    
	}
	
	public void mage4_3() {
		
	    position = "mage4_3";
		mainTextArea.setText("Depois destas vis�es, voc� ficou semanas vivendo com o \nMago, aprendendo sobre o universo, sobre magia, sobre \nti mesmo. \n\nDescobriu tamb�m que tua espada � fortalecida por um \nAnjo Guerreiro de Luz Azul.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mage5() {
		
		position = "mage5";
		specialPower = "Tubo de Luz";
		mageFinished = true;
		mainTextArea.setText("Depois de algumas semanas vivendo neste estilo de \nvida, voc� adquiriu um novo poder. \n\nTubo de Luz branca. Uma rapida ora��o trazendo a \nprote��o do Deus-Luz. \n\nTubo de Luz Branca (+50 pontos de vida quando usado)");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mageFutureRead() {
		if (callHappened) {
			position = "mageFutureRead";		
			mainTextArea.setText("Mago: ''Hmm...Interessante...''\n\n''Se prepare bem, recolha o m�ximo de Po��es que puder ao NORTE fora da cidade, para esta sua nova miss�o. Encontrar� tamb�m uma linda \ngarota. Bem brava, espinhenta.''\n\n''Uma grande decis�o sua no futuro ir� decidir o futuro \ndela e de todos n�s.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		else {		
		position = "mageFutureRead";		
		mainTextArea.setText("Mago: ''Hmm...Interessante...''\n\n''Logo voc� ser� convocado para uma grande miss�o. Se \nprepare bem, recolha o m�ximo de Po��es que puder. \n''Encontrar� tamb�m uma linda garota. Bem brava, espinhenta.''\n''Uma grande decis�o sua no futuro ir� decidir o futuro \ndela e de todos n�s.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");}
	}
	
	public void badKid1() {
		if (badKidFinished && isPlayerGuilty) {
			position = "badKidFinished";
			mainTextArea.setText("Jovem: ''Haha, veja se n�o � meu ladr�o favorito, tudo bem?'' \n\n''Pronto para outro grande roubo?'' \n\n''Quando eu tiver algo, te aviso.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		else if(badKidFinished && !isPlayerGuilty) {
			position = "badKidFinished";
			mainTextArea.setText("Jovem: ''Haha, veja se n�o � meu ladr�o favorito, tudo bem?'' \n\n''Pronto para outro grande roubo?'' \n\n''N�o? Agora voc� � o SR. Certinho? N�o ouse mais \ndirigir a palavra para mim.''");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		else {
		position = "badKid1";
		mainTextArea.setText("Enquanto caminhava, algo chamou sua aten��o. \nEra uma casinha muito pequena, com uma �rvore \ndo lado.");
		choice1.setText("Entrar");
		choice2.setText("Voltar");
		choice3.setText("");
		choice4.setText(""); }
	}
	public void badKid2() {
		
		position = "badKid2";
		mainTextArea.setText("Jovem: ''Voc� � o rapaz novo na cidade! J� ouvi \nfalarem mal de voc�. Tenho meus contatos hehe.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	
	public void badKid3() {
		
		position = "badKid3";
		mainTextArea.setText("Jovem: ''Cara, essa cidade � podre. N�o se deixe \nenganar. Todos aqui ir�o tentar se aproveitar de voc�, uma hora ou outra.'' \n\n''Por isso eu devolvo na mesma moeda.'' \n''Vou roubar uma casa rica hoje, vem comigo?''");
		choice1.setText("Ir");
		choice2.setText("Declinar");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void badKid4() {
		
		position = "badKid4";
		mainTextArea.setText("...\n\nDe noite, voc�s sorrateiramente roubaram uma casa \nde um Conde. \n\nCom o dinheiro roubado, voc� se alimentou por \nalgumas semanas. Mas voc� se sente culpado...");
		badKidFinished = true;
		isPlayerGuilty = true;
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	/*NEWWWWWWWWWWWWWWWWWW JOURNEEEEEEEEEEEEEY*/
	
	public void newJourney() {
		
		position = "newJourney";
		mainTextArea.setText("Voc� chega perto deles e se apresenta. L� em suas armaduras que o \nnome das garotas s�o: Iaycha e Shiva. Do rapaz: Ravi. ");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	
	
	public void newJourney2() {
		
		position = "newJourney2";
		mainTextArea.setText("Shiva: ''Ent�o voc� � o escolhido pelo Rei, certo? \nEstavamos te esperando!!! Me d� um abra�o!!! O Goblin que voc� matou, tinha matado meus pais.\n\nShiva sai correndo e te derruba no ch�o com um abra�o \ncarinhoso.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void newJourney3() {
		
		position = "newJourney3";
		mainTextArea.setText("Ravi continua focado na fogueira. Iaycha apenas olha de \nlonge, quieta, enquanto fuma seu cachimbo.\n\nShiva: ''Vem! Vou te apresentar o pessoal.''");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	public void newJourney4() {
		
		position = "newJourney4";
		mainTextArea.setText("Voc�s se apresentam e decidem assar peixes, dormir e amanh� cedo adentrar a densa foresta.\n\n� luz da fogueira, voc�s ficam, enquanto Ravi canta uma \nm�sica com seu viol�o.");
		choice1.setText("Falar com Shiva");
		choice2.setText("Falar com Iaycha");
		choice3.setText("Falar com Ravi");
		choice4.setText("Dormir");
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	public JFrame window;
	public Container container;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
	public JLabel titleNameLabel;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font ("Times New Roman", Font.PLAIN, 30);
	public JButton startButton;
	public JTextArea mainTextArea;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();	
	
	
	/* Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	int playerHP;
	String playerName;
	String playerWeapon;
	int choice;
	int monsterHP;

	int dragonRing;
	boolean goblinIsDead = false; */

	public static void main(String[] args) {		
		
		new Game();
		
		//Game newGame();
		//newAdventure = new Game();

		//newAdventure.playerSetUp();
		//newAdventure.townGate();
	}
	
	public Game() {
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		//window.setResizable(false);		
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
		startButton.setFont(normalFont);
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
		mainTextPanel.setBackground(Color.blue);
		container.add(mainTextPanel);
		
		mainTextArea = new JTextArea("THIS IS ASS");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);	
	
	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	
	
	
	/* public void playerSetUp() {

		playerHP = 10;
		monsterHP = 15;

		playerWeapon = "Canivete";

		System.out.println("Pontos de Vida: " + playerHP);
		System.out.println("Sua Arma: " + playerWeapon);

		System.out.println("Por favor entre seu nome:");

		playerName = myScanner.nextLine();

		System.out.println("Ol� " + playerName + ", vamos come�ar!");

	}

	public void townGate() {

		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Voc� est� no port�o de uma cidade.");
		System.out.println("Um guarda est� parado na sua frente.");
		System.out.println("");
		System.out.println("O que voc� ir� fazer?");
		System.out.println("");
		System.out.println("1: Falar com o guarda");
		System.out.println("2: Atacar o guarda");
		System.out.println("3: Ir embora");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			if (dragonRing == 1) {
				ending();
			} else {
				System.out.println("Guarda: Ol� estrangeiro. Ent�o seu nome � " + playerName
						+ "? \nDesculpe... N�o te conhe�o, n�o posso permitir que estranhos entrem na cidade.");
				enterScanner.nextLine();
				townGate();
			}

		} else if (choice == 2) {
			playerHP = playerHP - 1;
			System.out.println(
					"Guarda: Ei, n�o seja est�pido.\n\nO guarda te acertou t�o forte que voc� decidiu n�o atacar mais.\n(Voc� recebeu 1 ponto de dano)\n");
			System.out.println("Seu Pontos de Vida: " + playerHP);
			enterScanner.nextLine();
			townGate();
		} else if (choice == 3) {
			crossRoad();
		} else {
			townGate();
		}
	}

	public void crossRoad() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Agora voc� est� em uma encruzilhada. Se voc� for para o SUL, retornar� para o port�o da cidade.\n\n");
		System.out.println("1: Ir para o NORTE.");
		System.out.println("2: Ir para o LESTE.");
		System.out.println("3: Ir para o SUL.");
		System.out.println("4: Ir para o OESTE.");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			north();
		} else if (choice == 2) {
			east();
		} else if (choice == 3) {
			townGate();
		} else if (choice == 4) {
			west();
		} else {
			crossRoad();
		}
	}

	public void north() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Voc� encontrou um lindo rio. Aproveitou para beber �gua e descansar um pouco, enquanto observa a �gua fluindo.");
		System.out.println("Seus Pontos de Vida foram recuperados.");
		playerHP = playerHP + 1;
		System.out.println("Seus Pontos de Vida: " + playerHP);
		System.out.println("\n\n1: Voltar para a encruzilhada.");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			crossRoad();
		} else {
			north();
		}
	}

	public void east() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Voc� andou um pouco pela floresta e encontrou uma Espada de Madeira!");
		playerWeapon = "Espada de Madeira";
		System.out.println("Sua Arma: " + playerWeapon);
		System.out.println("\n\n1: Voltar para a Encruzilhada");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			crossRoad();
		} else {
			east();
		}
	}

	public void west() {
		
		if (!goblinIsDead) {
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Voc� encontrou um Goblin!\n");
			System.out.println("Voc� saca sua arma ("+ playerWeapon + ") e pensa no que fazer.");
			System.out.println("1: Lutar");
			System.out.println("2: Fugir");
			System.out.println("\n------------------------------------------------------------------\n");

			choice = myScanner.nextInt();
			
			if (choice == 1) {
				fight();
			} else if (choice == 2) {
				crossRoad();
			} else {
				west();
			}
		}		
		else {
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Voc� olha ao redor e v� apenas destrui��o, causada pela tua feroz batalha com o Goblin.");
			System.out.println("------------------------------------------------------------------\n");
			System.out.println("\n1: Voltar para a Encruzilhada");
			
			choice = myScanner.nextInt();

			if (choice == 1) {
				crossRoad();
			} else {
				west();
			}
		}
		
		
	}

	public void fight() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Pontos de Vida: " + playerHP);
		System.out.println("Pontos de Vida do Goblin: " + monsterHP);
		System.out.println("\n1: Atacar!");
		System.out.println("2: Correr");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			attack();
		} else if (choice == 2) {
			crossRoad();
		} else {
			fight();
		}
	}

	public void attack() {
		int playerDamage = 0;

		if (playerWeapon.equals("Canivete")) {
			playerDamage = new java.util.Random().nextInt(4);
		} else if (playerWeapon.equals("Espada de Madeira")) {
			playerDamage = new java.util.Random().nextInt(8);
		}

		System.out.println("Voc� atacou o monstro e infligiu " + playerDamage + " pontos de dano!");

		monsterHP -= playerDamage;

		System.out.println("Pontos de Vida do Goblin: " + monsterHP);

		if (monsterHP < 1) {
			win();
		} else if (monsterHP > 0) {
			int monsterDamage = 0;

			monsterDamage = new java.util.Random().nextInt(4);

			System.out.println("O monstro lhe atacou e infligiu " + monsterDamage + " pontos de dano!");

			playerHP -= monsterDamage;

			System.out.println("Seus Pontos de Vida: " + playerHP);

			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				fight();
			}
		}

	}

	public void dead() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Voc� morreu.");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");

	}

	public void win() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Voc� matou o monstro!");
		System.out.println("O monstro virou cinzas. S� restou um anel cinza e dourado ca�do no ch�o, com a face de um drag�o.");
		System.out.println("Voc� se abaixa e guarda o Anel em teu bolso.");
		System.out.println("**Voc� obteve o ANEL DO DRAG�O!**\n\n");
		System.out.println("1: Voltar para a encruzilhada");
		System.out.println("\n------------------------------------------------------------------\n");

		dragonRing = 1;
		goblinIsDead = true;

		choice = myScanner.nextInt();
		if (choice == 1) {
			crossRoad();
		} else {
			win();
		}

	}

	public void ending() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Guarda: S�rio? Voc� matou o Goblin que tanto nos atormentava? Prove.");
		System.out.println("Guarda: ...Esse � o lend�rio Anel do Drag�o!!! Voc� matou o Goblin mesmo!");
		System.out.println("Guarda: Voc� realmente � algu�m que podemos confiar. Seja bem-vindo � cidade!");
		System.out.println("\n\n             FIM                    ");
		System.out.println("\n------------------------------------------------------------------\n");
	} */
}
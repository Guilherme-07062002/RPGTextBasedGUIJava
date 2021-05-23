package jogogui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;
    Container cont;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, HPLabel, HPLabelNumber, WeaponLabel, WeaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP,silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        cont = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("AVENTURA");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        //startButton.setFocusPainted(false);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        cont.add(titleNamePanel);
        cont.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        cont.add(mainTextPanel);

        mainTextArea = new JTextArea("Essa é a area do texto principal.");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        cont.add(choiceButtonPanel);

        choice1 = new JButton("Opção 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Opção 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Opção 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Opção 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        cont.add(playerPanel);
        HPLabel = new JLabel("HP: ");
        HPLabel.setFont(normalFont);
        HPLabel.setForeground(Color.white);
        playerPanel.add(HPLabel);
        HPLabelNumber = new JLabel();
        HPLabelNumber.setFont(normalFont);
        HPLabelNumber.setForeground(Color.white);
        playerPanel.add(HPLabelNumber);
        WeaponLabel = new JLabel("Arma: ");
        WeaponLabel.setFont(normalFont);
        WeaponLabel.setForeground(Color.white);
        playerPanel.add(WeaponLabel);
        WeaponLabelName = new JLabel();
        WeaponLabelName.setFont(normalFont);
        WeaponLabelName.setForeground(Color.white);
        playerPanel.add(WeaponLabelName);

        playerSetup();

    }

    public void playerSetup() {
        playerHP = 15;
        monsterHP = 20;
        weapon = "Faca";
        WeaponLabelName.setText(weapon);
        HPLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate() {
        position = "townGate";
        mainTextArea.setText("Você está no portão da cidade\nUm guarda está na sua frente.\n\nO que você faz?");
        choice1.setText("Falar com o guarda");
        choice2.setText("Atacar o guarda");
        choice3.setText("Ir embora");
        choice4.setText(" ");
    }

    public void talkGuard() {
        position = "talkGuard";
        mainTextArea.setText("Guarda: Ola estrangeiro eu nunca vi você antes\ndesculpe mas você não pode entrar na cidade.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("Guarda: Não seja estupido!!\nO guarda bate em você\nVocê perde 3 HP.");
        this.playerHP = playerHP - 3;
        HPLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("Você esta numa trilha\nSe você for para o sul voltará para a cidade");
        choice1.setText("Ir para norte");
        choice2.setText("Ir para leste");
        choice3.setText("Ir para sul");
        choice4.setText("Ir para oeste");

    }

    public void north() {
        position = "north";
        mainTextArea.setText("Você encontra um rio\nVocê bebe agua e descansa na margem\n(Sua HP se aumenta 2 pontos)");
        playerHP = playerHP + 2;
        HPLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east() {
        position = "east";
        mainTextArea.setText("Você caminha na floresta e encontra uma espada\n(Obteve uma espada longa)");
        weapon = "EspadaLonga";
        WeaponLabelName.setText(weapon);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void west() {
        position = "west";
        mainTextArea.setText("Você encontrou um monstro!!");
        choice1.setText("Lutar");
        choice2.setText("Correr");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight() {
        position = "fight";
        mainTextArea.setText("HP Monstro: " + monsterHP + "\n\nO que você faz?");
        choice1.setText("Atacar");
        choice2.setText("Correr");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack() {
        position = "playerAttack";

        int playerDamage = 0;

        if (weapon.equals("Faca")) {
            playerDamage = new java.util.Random().nextInt(5);
        } else if (weapon.equals("EspadaLonga")) {
            playerDamage = new java.util.Random().nextInt(8);
        }
        mainTextArea.setText("Você atacou o monstro e deu: " + playerDamage + " de dano");

        monsterHP = monsterHP - playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }public void monsterAttack(){
        position ="monsterAttack";
        
        int monsterDamage=0;
        
        monsterDamage = new java.util.Random().nextInt(4);
        
        mainTextArea.setText("O monstro te ataca\nVocê recebe: "+monsterDamage+" de dano");
        monsterHP = monsterHP - monsterDamage;
        HPLabelNumber.setText(""+playerHP);
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void win(){
        position = "win";
        
        mainTextArea.setText("Você derrotou o monstro\nO monstro deixou um anel cair\n(Obteve Anel de Prata)");
   
        silverRing = 1;
        
        choice1.setText("Voltar pra trilha");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void lose(){
        position = "lose";
        
        mainTextArea.setText("Você morreu!!\n <<GAME OVER>>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void ending(){
        position = "ending";
        mainTextArea.setText("Guarda:Oh!! Você matou o monstro!!\nVocê é um verdadeiro heroi!!\nPode entrar na cidade!!\n\n<<THE END>>");
    
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            createGameScreen();

        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            if(silverRing>0){
                            ending();
                            }else{
                                talkGuard();
                            }
                            break;
                        case "c2":attackGuard();break;
                        case "c3":crossRoad();break;
                        case "c4": ;break;

                    }
                    break;
                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":townGate();break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":townGate();break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":north();break;
                        case "c2":east();break;
                        case "c3":townGate();break;
                        case "c4":west();break;
                    }
                    break;
                case "north":
                    switch (yourChoice) {
                        case "c1":crossRoad();break;

                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "c1":crossRoad();break;

                    }
                    break;
                case "west":
                    switch (yourChoice) {
                        case "c1":fight();break;
                        case "c2":crossRoad();break;
                    }
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":playerAttack();break;
                        case "c2":crossRoad();break;
                    }
                    break;
                case "playerAttack":
                    switch(yourChoice){
                       
                     case "c1":
                          if(monsterHP<1){
                              win();
                          }else{
                              monsterAttack(); 
                          }
                          break;
                    }
                    break;
                 case "monsterAttack":
                    switch(yourChoice){
                     case "c1":
                         if(playerHP< 1){
                             lose();
                         }else{
                             fight(); 
                         }
                         break; 
                    }    
                    break;
                 case "win":
                     switch(yourChoice){
                         case"c1": crossRoad();
                     }
            }

        }
    }
}


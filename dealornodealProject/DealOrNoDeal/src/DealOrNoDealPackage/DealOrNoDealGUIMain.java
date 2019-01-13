package DealOrNoDealPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This was for the GUI part of the assignment. This is the main that runs the
 * whole code.
 */

public class DealOrNoDealGUIMain extends JFrame {
    JButton cases[] = new JButton[26];
    JLabel amountLabel[] = new JLabel[26];
    JLabel title = new JLabel(new ImageIcon("Images/title.png"));
    JLabel label = new JLabel("Choose your case to start");
    JLabel caseLabel = new JLabel("YOUR CASE");
    JLabel yourChoosenCase = new JLabel();

    JPanel panel = new JPanel(null);// for background
    JPanel rightPanel = new JPanel(new GridLayout(13, 2, 5, 5));
    JPanel leftPanel = new JPanel(new GridLayout(13, 2, 5, 5));
    JPanel centerPanel = new JPanel(new GridLayout(4, 6, 7, 10));
    JPanel bottomPanel = new JPanel(new GridLayout(1, 4, 2, 5));
 
    int caseLeftArray[] = {1, 5, 10, 15, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
    int newCaseValueArray[] = {1, 5, 10, 15, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};

    int realCaseValue = 0;
    int casesSumvalue = 0;
    int bankerAmount = 0;
    String yourCase = "";

    int openedCases = 0;
    int countOpenCases = 0;
    int round = 0;

    public DealOrNoDealGUIMain() {
        add(panel);
        panel.setBackground(Color.white);
        panel.add(title);
        title.setBounds(0, 0, 1000, 120);
        panel.add(centerPanel);
        panel.add(bottomPanel);
        
        centerPanel.setBounds(220, 160, 550, 280);
        bottomPanel.setBounds(170, 445, 660, 90);
        yourChoosenCase.setBounds(25, 550, 100, 80);
        yourChoosenCase.setHorizontalAlignment(SwingConstants.CENTER);
        yourChoosenCase.setFont(new Font("Calibri", Font.BOLD, 40));
        
        
        panel.add(label);
        label.setBounds(250, 580, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.red);
        label.setFont(new Font("Calibri", Font.BOLD, 25));
        panel.add(leftPanel);
        panel.add(rightPanel);
        leftPanel.setBounds(5, 115, 150, 430);
        rightPanel.setBounds(845, 115, 150, 430);
        leftPanel.setBackground(Color.orange);
        rightPanel.setBackground(Color.ORANGE);
        
        // This line calls a method down below that starts the game.
        DealOrNoDealGUIMain.game play = new DealOrNoDealGUIMain.game();

        //loop thru cases
        for (int i = 0; i < 26; i++) {
            cases[i] = new JButton(Integer.toString(i + 1));
            cases[i].setBackground(Color.WHITE);
            cases[i].setFont(new Font("Arial", Font.BOLD, 30));
            cases[i].setIcon(new ImageIcon("Images/cases.png"));
            cases[i].setHorizontalTextPosition(SwingConstants.CENTER);
            cases[i].addActionListener(play);

            if (i <= 19) {
                centerPanel.add(cases[i]);
            } 
            else {
                bottomPanel.add(cases[i]);
            }
            
            amountLabel[i] = new JLabel(Integer.toString(newCaseValueArray[i]));
            amountLabel[i].setIconTextGap(-50);

            if (i < 13) {
                leftPanel.add(amountLabel[i]);
            } 
            else {
                rightPanel.add(amountLabel[i]);
            }
        }
            

        Random rng = new Random();

        for (int i = newCaseValueArray.length - 1; i > 0; i--) {  
            int randomNumber = rng.nextInt(i + 1);
            int theCase = newCaseValueArray[randomNumber];
            newCaseValueArray[randomNumber] = newCaseValueArray[i];
            newCaseValueArray[i] = theCase;
        
        }     
    }

    public class game implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (yourCase.isEmpty()) {
                for (int i = 0; i < 26; i++) {
                    if (e.getSource() == cases[i]) {
                        yourCase = Integer.toString(i + 1);
                    }
                }
                
                String userInput[] = {"Yes", "No"};

                int userAnswer = JOptionPane.showOptionDialog(null, "Your choosing case: " + yourCase + "?", "Pick a case", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, userInput, userInput[1]);

                if (userAnswer == JOptionPane.YES_OPTION) {
                    panel.add(yourChoosenCase);
                    yourChoosenCase.setText(yourCase);

                    for (int i = 0; i < 26; i++) {
                        if (e.getSource() == cases[i]) {
                            cases[i].setEnabled(false);
                            cases[i].setVisible(false);
                            cases[i].setBounds(50, 630, 100, 15);
                        }
                    }

                    panel.add(caseLabel);
                    caseLabel.setBounds(50, 630, 100, 15);

                    label.setText("Open 6 Cases Now");

                } 
                else {
                    yourCase = "";
                }
            } 
            else {              
                openedCases = openedCases + 1;
                countOpenCases = countOpenCases - 1;

                if (openedCases < 25) {
                    for (int i = 0; i < 26; i++) {
                        if (e.getSource() == cases[i]) {
                            JOptionPane.showMessageDialog(null, "Case: " + Integer.toString(i + 1) + " has an amount of $" + newCaseValueArray[i], "CASE" + Integer.toString(i + 1), JOptionPane.DEFAULT_OPTION);
                            cases[i].setEnabled(false);
                            cases[i].setVisible(false);
                            realCaseValue = newCaseValueArray[i];
                            newCaseValueArray[i] = 0;
                            label.setText("Open " + (countOpenCases - round) + " cases now!");
                        }
                    }
                    
                    for (int i = 0; i < 26; i++) {
                        if (caseLeftArray[i] == realCaseValue) {
                            amountLabel[i].setVisible(false);
                            amountLabel[i].setIcon(null);
                        }
                    }
                }
                
                if (openedCases == 6 || openedCases == 11 || openedCases == 15 || openedCases == 18 || openedCases == 20 || openedCases == 21 || openedCases == 22 || openedCases == 23 || openedCases == 24) {
                    label.setText("<><><><><> Incoming offer from the banker <><><><><>");
                    round = round + 1;
                    
                    for (int i = 0; i < 26; i++){                      
                        bankerAmount = bankerAmount + newCaseValueArray[i]*10/100;
                    }
                    
                    String acceptOffer[] = {"DEAL", "NO DEAL"};
                    int bankerOffer = JOptionPane.showOptionDialog(null, "The banker is offering $" + Integer.toString(bankerAmount) + "\r\nDEAL or no DEAL\n", "Banker's Offer Time", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, acceptOffer, acceptOffer[1]);
                    
                    //user accepts banker offer
                    if (bankerOffer == JOptionPane.YES_OPTION) {
                        for (int i = 0; i < 26; i++) {
                            amountLabel[i].setText(Integer.toString(bankerAmount));
                        }
                        
                        JOptionPane.showMessageDialog(null, "Congrats, you won\n $" + Integer.toString(bankerAmount), "Deal Done", JOptionPane.DEFAULT_OPTION, null);
                        JOptionPane.showMessageDialog(null, "Your case value was $" + Integer.toString(newCaseValueArray[Integer.parseInt(yourCase) - 1]), "Case Value:" + yourCase, JOptionPane.DEFAULT_OPTION, null);
                        JOptionPane.showMessageDialog(null, "Thank you for playing Deal or no Deal", "Game Over", JOptionPane.DEFAULT_OPTION, null);
                        System.exit(0);
                    }

                    countOpenCases = 6;
                    if (round < 5) {
                        label.setText("Open " + Integer.toString(countOpenCases - round) + " cases now!");
                    } 
                    else {
                        label.setText("Open 1 case");
                    }
                }

                //last case
                if (openedCases == 25) {
                    label.setText("1 Case Left");

                    String uInput[] = {"Yes", "No"};

                    int answer = JOptionPane.showOptionDialog(null, "Would you like to keep your choosen case:", "Deal or no Deal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, uInput, uInput[1]);

                    if (answer == JOptionPane.YES_OPTION) {
                        for (int i = 0; i < 26; i++) {
                            amountLabel[i].setText(Integer.toString(newCaseValueArray[(Integer.parseInt(yourCase) - 1)]));
                        }
                        JOptionPane.showMessageDialog(null, "You are going home with $ " + Integer.toString(newCaseValueArray[Integer.parseInt(yourCase) - 1]), "Deal or no Deal", JOptionPane.DEFAULT_OPTION, null);

                    } 
                    else {
                        for (int i = 0; i < 26; i++) {
                            amountLabel[i].setText(Integer.toString(bankerAmount));
                        }
                        for (int i = 0; i < 26; i++) {

                            if (e.getSource() == cases[i]) {
                                JOptionPane.showMessageDialog(null, "Congratulations!, You win $" + Integer.toString(bankerAmount), "Congratulations", JOptionPane.DEFAULT_OPTION, null);
                                openedCases = i;
                            }
                        }
                    }

                    label.setText("GAME OVER!");
                    JOptionPane.showMessageDialog(null, "Thank you for playing Deal or no Deal", "Game Over", JOptionPane.DEFAULT_OPTION, null);
                    System.exit(0);

                }
            }
        }
    }
    
    public void theirWinnings(){
        String userName = "Chris"; // <- Their Username here
        int score = 0; // <- Their Score here
        
        endGame(userName, score);
    }
    
    public void endGame(String userName, int score){
        
        BuildingTheDatabase buildingTheDatabase = new BuildingTheDatabase();
        buildingTheDatabase.establishConnection();
        buildingTheDatabase.createTable();
        buildingTheDatabase.insertTable(userName, score);
        buildingTheDatabase.closeConnections();
        System.exit(0);
    }
    
    public static void main(String[] args) {
 
    DealOrNoDealGUIMain gui = new DealOrNoDealGUIMain();
    
    gui.setVisible(true);
    gui.setSize(1000, 780);
    gui.setResizable(false);
    gui.setLocationRelativeTo(null);
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui.setBackground(Color.white);
    

    }

}

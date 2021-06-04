package tictactoeproject;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class TicTacToe implements ActionListener{
    JFrame frame = new JFrame();//Main Frame
    JPanel headingPanel = new JPanel();//Heading Panel
    JPanel mainPanel = new JPanel();//Main Panel that contains buttons X and O
    JLabel   message = new JLabel();//Message displayed in the heading
    JButton[] buttons = new JButton[9];//Array of nine buttons
    JButton playAgain = new JButton();//PLay Again Button
//    Player one will always have the first turn
    boolean playerOneTurn = true;
    TicTacToe() throws InterruptedException{
        //constructors
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);//Setting the size of the frame
        frame.setLayout(new BorderLayout());//Using border layout for the frame
        message.setBackground(Color.yellow);//Setting backgroudn color of the message label
        message.setForeground(Color.DARK_GRAY);//Setting font color of the message
        message.setHorizontalAlignment(JLabel.CENTER);
        Font newMessageFont=new Font(message.getFont().getName(),message.getFont().getStyle(),32);
        message.setFont(newMessageFont);
        message.setText("Tic Tac Toe");//Setting text inside the heading panel message
        message.setOpaque(true);
        headingPanel.setLayout(new BorderLayout());//Setting layout of heading panel 
        headingPanel.setBounds(0,0,500,100);//Making sure the heading panel stays on top of the frame
        headingPanel.add(message);//Adding message label into the heading panel
        mainPanel.setLayout(new GridLayout(0,3));//Settign layout of buttons panel on the frame
        mainPanel.setBackground(Color.YELLOW);//Setting background cplor of button panel
//        Since all the buttons are placed in an array, so we use a loop to add each button to the main panel
        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton();
            mainPanel.add(buttons[i]);
            buttons[i].setFocusable(false);
            Font newButtonFont=new Font(buttons[i].getFont().getName(),buttons[i].getFont().getStyle(),72); 
            buttons[i].setFont(newButtonFont);
            buttons[i].addActionListener(this);
        }
//        Adding both panels to the frame
        frame.add(headingPanel,BorderLayout.NORTH);
        frame.setVisible(true);
        frame.add(mainPanel);
        this.changeHeading();
    }
//    This method changes the heading from "tic tac toe" into player one automatically after 2 seconds of running the program
    void changeHeading() throws InterruptedException{
        Thread.sleep(2000);
        message.setText("player one");
    }

    @Override
//    This method is called whenever an action is performed
    public void actionPerformed(ActionEvent ae) {
        for(int i=0;i<buttons.length;i++){
//            Executing some action whenever a X or O button is pressed
            if(ae.getSource() == buttons[i]){
                if(playerOneTurn){
//                    SEtting the text on button according to the player turn, whenever a button is pressed
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        playerOneTurn = false;
                        message.setText("player two");
                        checkCondition();
                    }
                }
                else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.black);
                        buttons[i].setText("O");
                        playerOneTurn =true;
                        message.setText("player one");
                        checkCondition();
                    }
                }
            }
        }
//        THis block deals with the action when playAgain button is pressed
        if(ae.getSource()==playAgain){
            try {
//                THis method dispose the current instance and starts a new instance of the same class
                TicTacToe newFrame = new TicTacToe();
                this.frame.dispose();
                newFrame.frame.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    void checkCondition(){
//        Checking player one winning conditins
        if((buttons[0].getText()== "X") && (buttons[1].getText()== "X") && (buttons[2].getText()== "X")){
                playerOneWins(0,1,2);
            }
        if((buttons[3].getText()== "X") && (buttons[4].getText()== "X") && (buttons[5].getText()== "X")){
                playerOneWins(3,4,5);
            }
        if((buttons[6].getText()== "X") && (buttons[7].getText()== "X") && (buttons[8].getText()== "X")){
                playerOneWins(6,7,8);
            }
        if((buttons[0].getText()== "X") && (buttons[4].getText()== "X") && (buttons[8].getText()== "X")){
                playerOneWins(0,4,8);
            }
        if((buttons[2].getText()== "X") && (buttons[4].getText()== "X") && (buttons[6].getText()== "X")){
                playerOneWins(2,4,6);
            }
        if((buttons[0].getText()== "X") && (buttons[3].getText()== "X") && (buttons[6].getText()== "X")){
                playerOneWins(0,3,6);
            }
        if((buttons[1].getText()== "X") && (buttons[4].getText()== "X") && (buttons[7].getText()== "X")){
                playerOneWins(1,4,7);
            }
        if((buttons[2].getText()== "X") && (buttons[5].getText()== "X") && (buttons[8].getText()== "X")){
                playerOneWins(2,5,8);
            }
        
        //    Checking player two winning conditions
        if((buttons[0].getText()== "O") && (buttons[1].getText()== "O") && (buttons[2].getText()== "O")){
                playerTwoWins(0,1,2);
            }
        if((buttons[3].getText()== "O") && (buttons[4].getText()== "O") && (buttons[5].getText()== "O")){
                playerTwoWins(3,4,5);
            }
        if((buttons[6].getText()== "O") && (buttons[7].getText()== "O") && (buttons[8].getText()== "O")){
                playerTwoWins(6,7,8);
            }
        if((buttons[1].getText()== "I") && (buttons[4].getText()== "O") && (buttons[8].getText()== "O")){
                playerTwoWins(1,4,8);
            }
        if((buttons[2].getText()== "O") && (buttons[4].getText()== "O") && (buttons[6].getText()== "O")){
                playerTwoWins(2,4,6);
            }
        if((buttons[0].getText()== "O") && (buttons[3].getText()== "O") && (buttons[6].getText()== "O")){
                playerTwoWins(0,3,6);
            }
        if((buttons[1].getText()== "O") && (buttons[4].getText()== "O") && (buttons[7].getText()== "O")){
                playerTwoWins(1,4,7);
            }
        if((buttons[2].getText()== "O") && (buttons[5].getText()== "O") && (buttons[8].getText()== "O")){
                playerTwoWins(2,5,8);
            }
        //Checkig for draw
        int c=0;
        for(int i=0;i<buttons.length;i++){
            if(buttons[i].getText() == ""){
                c++;
            }
        }
        //If c==0, it means all the buttons are filled and there is no winner  and the match ended in a draw!
        if(c==0){
            Font newMessageFont=new Font(message.getFont().getName(),message.getFont().getStyle(),42);
            message.setFont(newMessageFont);
            message.setText("Match Drawn!");
            playAgain = new JButton();
            playAgain.setHorizontalAlignment(JButton.CENTER);
            playAgain.setText("PLay Again?");
            playAgain.setFocusable(false);
            playAgain.addActionListener(this);
            mainPanel.add(playAgain);
        }
    }
    

    
    public void playerOneWins(int n1,int n2,int n3){
//            Player one wins
//Setting backfround colors
        buttons[n1].setBackground(Color.GREEN);
        buttons[n2].setBackground(Color.GREEN);
        buttons[n3].setBackground(Color.GREEN);
        for(int i=0;i<buttons.length;i++){
            buttons[i].setEnabled(false);
        }
//        Adding Play Again on the main frame
        Font newMessageFont=new Font(message.getFont().getName(),message.getFont().getStyle(),42);
        message.setFont(newMessageFont);
        message.setText("Player One Won!");
        playAgain = new JButton();
        playAgain.setHorizontalAlignment(JButton.CENTER);
        playAgain.setText("PLay Again?");
        playAgain.setFocusable(false);
        playAgain.addActionListener(this);
        mainPanel.add(playAgain);
    }
    public void playerTwoWins(int n1,int n2,int n3){
//            Player two wins
        buttons[n1].setBackground(Color.GREEN);
        buttons[n2].setBackground(Color.GREEN);
        buttons[n3].setBackground(Color.GREEN);
        for(int i=0;i<buttons.length;i++){
            buttons[i].setEnabled(false);
        }
//        Adding playAgain button in main Frame
        Font newMessageFont=new Font(message.getFont().getName(),message.getFont().getStyle(),42);
        message.setFont(newMessageFont);
        message.setText("Player Two Won!");
        playAgain = new JButton();
        playAgain.setHorizontalAlignment(JButton.CENTER);
        playAgain.setText("PLay Again?");
        playAgain.setFocusable(false);
        playAgain.addActionListener(this);
        mainPanel.add(playAgain);
        
    }
    
}

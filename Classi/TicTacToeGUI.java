package packageTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI implements ActionListener{
	private JFrame frame;
	private JButton[][] buttons;
	private TicTacToe game;
	private AIPlayer aiPlayer;
	
	
	public TicTacToeGUI() {
		game = new TicTacToe();
		aiPlayer = new AIPlayer('O','X'); //Il computer giochera come 'O'
		frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(3,3));
		
		buttons = new JButton[3][3];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				buttons[i][j] = new JButton("-");
				buttons[i][j].setFont(new Font("Arial", Font.PLAIN,60));
				buttons[i][j].setFocusPainted(false);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBackground(Color.WHITE);
				buttons[i][j].setForeground(Color.BLACK);
				frame.add(buttons[i][j]);
			}
		}
		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		int row = -1;
		int col = -1;
		
		for(int i=0; i<3; i++) {
			for(int j=0;j<3;j++) {
				if(buttons[i][j]== buttonClicked) {
					row = i;
					col = j;
				}
			}
		}
		if(game.placeMark(row,col)) {
			buttonClicked.setText(String.valueOf(game.getCurrentPlayer()));
			buttonClicked.setEnabled(true);
			
			//imposta il colore del testo basato sul giocatore
			if(game.getCurrentPlayer() == 'X') {
				buttonClicked.setForeground(Color.BLUE);
			    buttonClicked.setBackground(Color.WHITE);
			    
			}
			else if(game.getCurrentPlayer() == 'O')  {
				buttonClicked.setForeground(Color.RED);
			    buttonClicked.setBackground(Color.WHITE);
			   
			}
			
			 buttonClicked.revalidate();
		     buttonClicked.repaint();
			
			
			
			
			if(game.checkForWin()) {
				showWinMessage();
				resetBoard();
			}else if(game.isBoardFull()) {

				showTieMessage();
				resetBoard();
			}else{
				game.changePlayer();
				aiMove();
			}
		}
	}
	//metodo per la mossa del computer
	public void aiMove() {
		int[] move = aiPlayer.getBestMove(game.getBoard());
		if(move != null) {
			game.placeMark(move[0], move[1]);
			buttons[move[0]][move[1]].setText(String.valueOf(game.getCurrentPlayer()));
			buttons[move[0]][move[1]].setEnabled(true);
			if(game.getCurrentPlayer()=='X') {
				buttons[move[0]][move[1]].setForeground(Color.BLUE);
                buttons[move[0]][move[1]].setBackground(Color.WHITE);
			}
			else if(game.getCurrentPlayer()=='O') {
			buttons[move[0]][move[1]].setForeground(Color.RED);
			buttons[move[0]][move[1]].setBackground(Color.WHITE);
			}
			
			// Forza aggiornamento visivo
            buttons[move[0]][move[1]].revalidate();
            buttons[move[0]][move[1]].repaint(); 

			
			if(game.checkForWin()) {
				showWinMessage();
				resetBoard();
			}else if(game.isBoardFull()) {
				showTieMessage();
				resetBoard();
			}else {
				game.changePlayer();
			}
		}
	}
	
	public void resetBoard() {
		game.initializeBoard();
		game.setCurrentPlayer('X'); //assicuriamoci che il giocatore X inizi sempre per primo
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				buttons[i][j].setText("-");
				buttons[i][j].setEnabled(true);
				buttons[i][j].setBackground(Color.WHITE);
				buttons[i][j].setForeground(Color.BLACK);
			}
		}
		
	}
	private void showWinMessage() {
		JOptionPane.showMessageDialog(frame, "Player " + game.getCurrentPlayer() + " vince!");
	}
	private void showTieMessage() {
		JOptionPane.showMessageDialog(frame, "Il game finisce in Pareggio!!");
	}
	public static void main(String[] args) {
		 // Imposta un look and feel di default
		 try {
	            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		SwingUtilities.invokeLater(TicTacToeGUI::new);

	}

}

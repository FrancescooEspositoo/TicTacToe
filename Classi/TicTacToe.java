package packageTicTacToe;

public class TicTacToe {
	private char[][] board;
	private char currentPlayer;
	public TicTacToe() {
		board = new char[3][3];
		currentPlayer='X';
		initializeBoard();
	}
	//inizializzazione dei bordi
	public void initializeBoard() {
		for(int i = 0; i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = '-';
			}
		}
	}
	
	public void printBoard() {
		for(int i = 0; i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(board[i][j]);
			}
		}
	}
	
	public boolean isBoardFull() {
		for(int i = 0; i<3;i++) {
			for(int j=0;j<3;j++) {
				if (board[i][j] == '-') return false;
			}
		}
		return true;
	}
	//controllo della vittoria
	public boolean checkForWin() {
		return (checkRows() || checkColumns() || checkDiagonals());
	}
	private boolean checkRows() {
		for(int i = 0; i<3;i++) {
			if(checkRowCol(board[i][0], board[i][1], board[i][2])) {
				return true;
			}
		}
		return false;
	}
	private boolean checkColumns() {
		for(int i = 0; i<3;i++) {
			if(checkRowCol(board[0][i], board[1][i], board[2][i])) {
				return true;
			}
		}
		return false;
	}
	private boolean checkDiagonals() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }
	private boolean checkRowCol(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2==c3));
	}
	public void changePlayer() {
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	}
	
	public boolean placeMark(int row, int col) {
		if((row >= 0) && (row < 3)) {
			if((col >= 0) && (col < 3)) {
				if(board[row][col] == '-') {
					board[row][col] = currentPlayer;
					return true;
				}
			}
		}
		return false;
	}
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	public char[][]getBoard(){
		return board;
	}
	public void setCurrentPlayer(char currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}

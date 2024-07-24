package packageTicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer {
	private char aiMark;
	private char opponentMark;
	private Random random;
	
	public AIPlayer(char aiMark, char opponentMark) {
		this.aiMark = aiMark;
		this.opponentMark = opponentMark;
		this.random = new Random();
	}
	//metodo per la mossa randomica del computer
	public int[] getBestMove(char[][] board) {
		List<int[]> availableMoves = new ArrayList<>();
		for(int i = 0; i<3;i++) {
			for(int j=0; j<3;j++) {
				if(board[i][j]=='-') availableMoves.add(new int[]{i,j});
			}
		}
		if(availableMoves.isEmpty()) {
			return null;
		}
		return availableMoves.get(random.nextInt(availableMoves.size()));
	}
}

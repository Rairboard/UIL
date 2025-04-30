import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Endless {
	private enum State {
		EMPTY, X, O
	}

	private class Symbol {
		private State state;
		private byte numTurns;

		public Symbol() {
			this.state = State.EMPTY;
			numTurns = 6;
		}

		public void decrement() {
			if(state != State.EMPTY) {
				numTurns--;
			}
		}

		public boolean isDead() {
			return numTurns == 0;
		}

		public State state() {
			return state;
		}
		
		public void reset() {
			state = State.EMPTY;
			numTurns = 6;
		}
		
		public void updateState(State state) {
			this.state = state;
		}
	}

	public static void main(String [] args) throws IOException {
		new Endless().run();
	}

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Endless/endless.dat"));
		PrintWriter out = new PrintWriter(new File("Endless/endless.out"));

		int n = Integer.parseInt(file.readLine());
		while(n-->0) {
			int m = Integer.parseInt(file.readLine());
			int[][] moves = new int[m][2];
			for(int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(file.readLine());
				moves[i][0] = Integer.parseInt(st.nextToken())-1;
				moves[i][1] = Integer.parseInt(st.nextToken())-1;
			}
			Symbol[][] board = new Symbol[3][3];
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					board[i][j] = new Symbol();
				}
			}
			boolean xTurn = true;
			boolean winnerFound = false;
			for(int i = 0; i < m; i++) {
				board[moves[i][0]][moves[i][1]].updateState(xTurn ? State.X : State.O);
				xTurn = !xTurn;
				decrement(board);
				char winner = determineWinner(board);
				if (winner != 'T') {
					out.printf("Player using '%c' wins\n", winner);
					winnerFound = true;
					break;
				}
			}
			if(!winnerFound) {
				out.println("Neither player has won yet...");
			}
		}
		
		file.close();
		out.close();
	}
	
	private void decrement(Symbol[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j].decrement();
				if(board[i][j].isDead()) {
					board[i][j].reset();
				}
			}
		}
	}

	public char determineWinner(Symbol[][] board) {
		// check rows
		for(int i = 0; i < 3; i++) {
			State state = board[i][0].state();
			if(state == State.EMPTY) {
				continue;
			}
			boolean same = (state == board[i][1].state() && state == board[i][2].state());
			if(same) {
				return state == State.X ? 'X' : 'O';
			}
		}
		// check columns
		for (int i = 0; i < 3; i++) {
			State state = board[0][i].state();
			if (state == State.EMPTY) {
				continue;
			}
			boolean same = (state == board[1][i].state() && state == board[2][i].state());
			if (same) {
				return state == State.X ? 'X' : 'O';
			}
		}
		// check diagonals
		State state = board[0][0].state();
		if (state != State.EMPTY) {
			boolean same = (state == board[1][1].state() && state == board[2][2].state());
			if (same) {
				return state == State.X ? 'X' : 'O';
			}
		}
		state = board[0][2].state();
		if (state != State.EMPTY) {
			boolean same = (state == board[1][1].state() && state == board[2][0].state());
			if (same) {
				return state == State.X ? 'X' : 'O';
			}
		}
		return 'T';
	}
}

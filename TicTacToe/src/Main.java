import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		final int MAX_MOVES = 9;
		int moves = 0;
		char player1 = 'X';
		char player2 = 'O';
		boolean Winner = false;
		char[][] board =   {{'1', '2', '3'},
				  			{'4' , '5' , '6'},
				  			{'7' , '8' , '9'}};
		
		
		System.out.println("***************************************************\n"
				+ "*\t\tWelcome to TicTacToe \t\t  *"
				+ "\n***************************************************\n");
		
		while(moves < MAX_MOVES && !Winner) {
			//display game board
			displayBoard(board);
			
			//move player 1
			move(board, player1, kb);
		//increment move
			moves++;
			//did player 1 win?
			if(isWinner(board, player1))
				Winner = true; 
			else if(moves < MAX_MOVES) {
				displayBoard(board);
				move(board, player2, kb);
				moves++;
				if(isWinner(board, player2))
					Winner = true; 
			}
		}//End of while loop
		
		//determine winner
		displayBoard(board);
		if(isWinner(board, player1))
			System.out.printf("\nPlayer %c has won the game.", player1);
		else if(isWinner(board, player2))
			System.out.printf("\nPlayer %c has won the game.", player2);
		else 
			System.out.println("\nThe game has end in a tie. Thank you for playing.");
	}//end of main method
	
	public static void move(char[][] b, char player, Scanner kb) {
		boolean space = true;
		int selected;
		int row = 0; int col = 0;
		
		while(space) {
			System.out.println("\nPlayer " + player + " please select a number on the game board: ");
			selected = kb.nextInt();
			
			if(selected >= 1 && selected <= 9) {
			switch(selected) {
			case 1: row = 0; col = 0; break;
			case 2: row = 0; col = 1; break;
			case 3: row = 0; col = 2; break;
			case 4: row = 1; col = 0; break;
			case 5: row = 1; col = 1; break;
			case 6: row = 1; col = 2; break;
			case 7: row = 2; col = 0; break;
			case 8: row = 2; col = 1; break;
			case 9: row = 2; col = 2; break;
			}
			
			if(Character.isDigit(b[row][col])) {
				b[row][col] = player;
				space = false;
			} else { 
				displayBoard(b);
				System.out.println("Invalid selection.");
			}
		}
	}
}
	
		public static boolean isWinner(char[][] b, char player) {
			
			boolean winner = false;
			
			//check rows for winner
			for(int row = 0; row < b.length; row++)
				if(b[row][0] == player && b[row][1] == player && b[row][2] == player) {
					winner = true;
				}
			//check columns for winner
			for(int col = 0; col < b[0].length; col++)
				if(b[0][col] == player && b[1][col] == player && b[2][col] == player) {
					winner = true;
					
				}


			//Check lower left to upper right (diagonal)
			if(b[2][0] == player && b[1][1] == player && b[0][2] == player) 
				winner = true;
			
			

			//Check lower right to upper left (diagonal)
			if(b[2][2] == player && b[1][1] == player && b[0][0] == player) 
				winner = true;
			
			return winner;
		}
			
		public static void displayBoard(char[][] board) {
			System.out.println("\n" + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
			System.out.println("----------");
			System.out.println(board[1][0] + " | " + board[1][1] +  " | "  + board[1][2]);
			System.out.println("----------");
			System.out.println(board[2][0] + " | " + board[2][1] +  " | "  + board[2][2]);
	}
}
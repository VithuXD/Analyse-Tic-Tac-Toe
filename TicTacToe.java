import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author MeneXia (Xavi Ablaza)
 *
 */
public class TicTacToe {
    
    // Initialisation
	static Scanner in;
	static String[] board;
	static String turn;
    
    // Le Main, declaration du Scanner,Array
	public static void main(String[] args) { 
		in = new Scanner(System.in); // Declaration du Scanner pour l'input de l'utilisateur 
		board = new String[9]; // Declaration d'un Array; [9]=positionnement des valeurs dans la grille, 9 cases dans un Array
		turn = "X"; // Commence toujours avec X, turn signifie le tour d'un joueur 
		String winner = null; // null= rien, String winner=null -> c'est completement nulle
		populateEmptyBoard(); // Methode
		
		// Imprimerie   
		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		printBoard(); // Imprime la grille
		System.out.println("X's will play first. Enter a slot number to place X in:"); // X va jouer en premier
        
        // Boucle While
		while (winner == null) {
			int numInput; // initialiser une varibale de type int qui s'appelle numInput
			
			
			try { // Essayer
				numInput = in.nextInt(); // On utilise un Scanner
				if (!(numInput > 0 && numInput <= 9)) { // Si les chiffres ne sont pas entre 0-9
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) { // Rattrapage des erreurs/exceptions comme les characteres
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			
			
			if (board[numInput-1].equals(String.valueOf(numInput))) { // si les chiffres sont les meme
				board[numInput-1] = turn; //
				if (turn.equals("X")) { // Si c'est le tour de X
					turn = "O"; // Changer la valeur de turn a 0
				} else { // Change a
					turn = "X"; // X
				}
				printBoard(); // Imprime la grille avec des modifications des valeurs
				winner = checkWinner(); // Methode qui verifie s'il y a un gagnant
			} else {
				System.out.println("Slot already taken; re-enter slot number:"); 
				continue;
			}
		}
		
		 
		if (winner.equalsIgnoreCase("draw")) { 
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing."); // Felicitation gagnant a gagne 
		}
	}

    // Methode qui aide le Main, checkwinner precisement verifie qui est le gagnant
	static String checkWinner() {
		for (int a = 0; a < 8; a++) { // Commence a 0 et termine a 8
			String line = null; 
			switch (a) {
			case 0: // Verification des cases
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) { // Verifie s'il y a 3 characteres sur une ligne
				return "X";
			} else if (line.equals("OOO")) { // S'il y a 3 Os
				return "O"; // Ca va donner en retour un O
			}
		}
        
        
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:"); 
		return null;
	}

    // methode qui imprime la grille, c'est comme l'animation
	static void printBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");
	}
    
    // rentre les valeurs dans la grille
	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) { // Boucle for ou la valeur a commence a 0 et termine a 9, augmente la valeur d'a par 1, (0-8)
			board[a] = String.valueOf(a+1); // Calcule a+1 car la valeur de l'index va de 0 a 8
		}
	}
}

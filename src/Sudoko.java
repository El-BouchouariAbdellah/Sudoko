
public class Sudoko {
	
	private static final int GRID_SIZE = 9; // size of the grid 
	
	public static void main(String[] args) {
		
		
		//An easy example 
		int [][] board = {
				{0,0,0,0,0,0,9,0,0},
				{0,0,0,0,0,3,2,0,0},
				{4,0,3,0,0,0,0,0,8},
				{0,5,6,0,0,0,1,9,0},
				{1,0,4,2,3,9,6,0,5},
				{9,0,0,0,0,0,0,0,7},
				{2,0,0,7,0,6,8,0,4},
				{7,1,0,0,8,5,0,0,0},
				{0,0,0,3,0,0,0,0,0}
		};
		
		if (solver(board)) {
			System.out.println("Sudoko Solved Successufly");
			System.out.println();
			printSolver(board);
		}
		else {
			System.out.print("The Sudoko puzzle is Wrong");
		}
	}
	
	
	private static void printSolver(int[][] board) {
		for(int i = 0 ; i < GRID_SIZE ; i++) {
			if (i % 3 == 0 && i != 0)
				System.out.println("------------------------------");
			for(int j =0 ; j < GRID_SIZE ; j++) {
				if (j % 3 == 0 && j != 0)
					System.out.print("|");
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}		
	}

	//Function to check if x exist in a row
	private static boolean isExistInRow (int[][] board , int number , int row) {
		for(int i = 0 ; i < GRID_SIZE ; i++) {
			if(board[row][i] == number)
				return true;
		}
		return false;				
	}
	
	//Function to check if x exist in a column
	private static boolean isExistInColumn (int[][] board , int number , int column) {
		for(int i = 0 ; i < GRID_SIZE ; i++) {
			if(board[i][column] == number)
				return true;
		}
		return false;				
	}
	
	
	// We pass the cooridantes of the box that we want to verify if its local subgrid have the same number or not
	// matalan bghit chouf lmorba3 li kayen ster 1 o colone 0 bghit ndir fih '5' khesni nchouf subgrid li kayntami liah dak lmorba3
	// wach fiha '5' ola la  ?? 
	//bach ntechecki kan cree wa7ed joj d les variables li kay7dedo liya les coordonnées dyal lmorba3 li f lfoo9 3la limn ga3 dyal subgrid
	//khesni n3ref chmen ster o ach men column bach nel9ah khesni nched row li 3tit l function o n9es meno l ba9i dyal l9isma dyalo 3la '3'
	// ye3ni row - (row % 3 ) o nefs lblan ndiro l column heka ghaykopun l code flexible o n9ed nchecki ay subgrid
	private static boolean isExistInSubGrid (int[][] board , int number , int row , int column ) {
		int topBoxRowIndex = row - (row % 3) ; 
		int topBoxColumnIndex = column - (column % 3) ; 
		for(int i = topBoxRowIndex ; i < topBoxRowIndex+3 ; i++) {
			for(int j = topBoxColumnIndex ; j < topBoxColumnIndex+3 ; j++) {
				if(board[i][j] == number)
					return true;
			}
		}
		return false;
	}
	
	private static boolean isItVAlid (int[][] board,int number , int row , int column ) {
		return !isExistInRow(board , number ,row ) && 
				!isExistInColumn(board,number,column) && 
				!isExistInSubGrid(board,number,row,column);
	}
	
	private static boolean solver (int [][] board) {
		for(int i = 0 ; i < GRID_SIZE ; i++) {
			for(int j = 0 ; j < GRID_SIZE ; j++) {
				if (board[i][j] == 0) {
						for (int k = 1 ; k <= GRID_SIZE ; k++) {
							if (isItVAlid(board,k,i,j)) {
								board[i][j] = k ;
								if(solver(board)) {
									return true ;
								}
								else {
									board[i][j]=0;
								}
							}
						}
				return false ;
					}	
				}
			}
		return true;
		}
	}


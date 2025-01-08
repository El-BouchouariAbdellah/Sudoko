
public class Sudoko {
	
	private static final int GRID_SIZE = 9; // size of the grid 
	
	public static void main(String[] args) {
		
		//An easy example 
		int [][] board = {
				{0,0,8,0,0,0,9,0,5},
				{0,0,0,2,5,0,0,3,0},
				{9,0,5,0,0,8,0,0,2},
				{0,0,7,0,0,0,0,0,0},
				{8,9,4,0,0,0,2,1,0},
				{3,1,2,0,0,4,0,0,0},
				{0,8,0,6,2,3,7,0,4},
				{4,7,6,0,9,5,0,2,0},
				{0,0,3,0,4,0,0,9,0}
		};
		

		System.out.println(isExistInRow(board , 7 , 0));
		System.out.println(isExistInColumn(board , 5 , 8));
		System.out.print(isExistInSubGrid(board , 1 , 7 , 8));
		
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
}

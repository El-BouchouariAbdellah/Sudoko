
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
		System.out.print(isExistInColumn(board , 5 , 8));
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
}

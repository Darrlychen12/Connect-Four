import java.util.Scanner;
public class connectfour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board [][] = new char [6][7];
		display(board);
		play(board);
		
	}
	
	public static void play (char[][] grid){
		
		Scanner input = new Scanner(System.in);
		boolean hasWon = false;
		boolean playerTurn = true;
		char token;
		int position = 0;
	
		
		
		while(!hasWon){
			
			if(playerTurn){
				
				System.out.print("Drop a blue disk at column (0 - 6)");
				token = 'B';
				
				
			}else{
				
				System.out.print("Drop a red disk at column (0 - 6)");
				token = 'R';
				
			}
			
			
			position = input.nextInt();
			
			while(position < 0 || position > 6){
				
				System.out.println("Column position must be between either 0 or 6!");
				position = input.nextInt();
				
			}
			
			playerTurn = !playerTurn;
			
			if	(drop(grid,token,position)){
				
				playerTurn = !playerTurn;
				
			}else{
				
				display(grid);
			
				
				if(gameWin(grid,token,position)){
					
					hasWon = true;
					System.out.print(token + " Player has won!");
					

				}
			}
		}
	
		input.close();
	}
		
		
	
		
	public static boolean gameWin (char[][] grid, char token, int column){

		int row = 0;
		
		for (int i = 0; i < grid.length; i++){
			
			if(grid[i][column] != 0 ){
				
				row = i;
				break;
				
				
			}
		}
			
		if(checkVertical(grid,token,column,row)){
			
			return true;
		}
		
		if(checkRow(grid,token,column,row)){
				
			return true;
		}
		
		if(checkDiagonal1(grid,token,column,row)){
			
			return true;
		}
		
		if(checkDiagonal2(grid,token,column,row)){
			
			return true;
		}
	
			return false;
			
	}
	
	public static boolean checkDiagonal1(char[][] grid, char token, int column, int row){
		
		int counter = 1;
		
		for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--,j--){
			
			if(token == grid[i][j]){
				
				counter++;
			}else{
				
				break;
			}
			
		}
	
			
		if(counter >= 4){
			
			return true;
		}
		
		
		for (int i = row + 1, j = column + 1; i < grid.length && j < grid[0].length; i++,j++){
			
			if(token == grid[i][j]){
				
				counter++;
				
			}else{
				
				break;
				
			}
		}
		
		
		if(counter >= 4){
			
			return true;
			
		}
			
		return false;
		
			
	}
	
	public static boolean checkDiagonal2(char[][] grid, char token, int column, int row){
		
		int counter = 1;
		
		for(int i = row + 1, j = column - 1; i < grid.length && j >= 0; i++,j-- ){
			
			if(token == grid[i][j]){
				
				counter++;	
				
			}else{
				
				break;
			}
		}
		
		if(counter >=4){
			
			return true;
		}
			
			
		for(int i = row - 1, j = column + 1; i >= 0 && j < grid[0].length; i--,j++){
			
			if(token == grid[i][j]){
				
				counter++;
				
			}else{
				
				break;
			}
		}
		
		if(counter >=4){
			
			return true;
			
		}
			
		return false;
	}
		
	
	public static boolean checkRow(char[][] grid, char token, int column, int row){
		
		int counter = 1;
				
		for(int i = column - 1; i >= 0; i--){
			
			if(token == grid[row][i]){
				
				counter++;
				
			}else{
				
				break;
				
			}
				
		}
		
		if(counter >= 4){
			
			return true;
		}
		
		
		for(int i = column + 1; i < grid[0].length; i++){
			
			if(token == grid[row][i]){
			
				counter++;
				
			}else{
				
				break;
				
			}
				
		}
		
		if(counter >= 4){
			
			return true;
	
		}
		
		return false;
		
	}
	
	public static boolean checkVertical(char[][] grid, char token, int column, int row){
		
		int counter = 1;
		
		if((row + 4) <= 6){
			
			for(int i = (row + 1); i <= (row + 3); i++){
				
				if(token == grid[i][column]){
					
					counter++;
					
				}else{
					
					break;
					
				}
				
				if(counter == 4){
					
					return true;
					
				}
			
			}
				
		}
		
		return false;
		
	}
	
	
	
	
	public static boolean drop (char[][] grid, char token, int column){
		
		for (int i = grid.length - 1; i >= 0; i--){
			
			if(grid[i][column] == 0){
				
				grid[i][column] = token;
				return false;
				
			}
			
			
		}
		
		System.out.println("Column is full! Try again");
		return true;
		
		
	}
	
	public static void display(char[][] grid){
		
		for (int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				
				System.out.print("|" + grid[i][j]);
				
				
			}
			
			System.out.println("|");
	
		}
		
		for(int i = 0; i < grid.length-1; i++){
			System.out.print("---");
			
		}
		
		System.out.println();
	
	}
	

}

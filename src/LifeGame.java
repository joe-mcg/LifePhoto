public class LifeGame {
	
	int[][] grid;
	int[][] tempGrid;

	public void createNewGrid(int gridLength) {
		grid = new int[gridLength][gridLength];
		tempGrid = new int[gridLength][gridLength];
		for (int i = 0; i<grid.length;i++) {
			for (int j=0; j<grid.length;j++) {
				if (Math.random() >= 0.3) {
					grid[i][j]=0;
				} else {
					grid[i][j]=1;
				}
				
			}
		}
		drawGrid();
	}

	 void move() {
		//loop through each element
		//element.calcuateNextMove returns what it should be
		//in the same place of new array, add the output of calcNextMove
	    for (int i = 0; i<grid.length;i++) {
			for (int j=0; j<grid.length;j++) {
				//This is so it's not a sliding scale of when to move.
				tempGrid[i][j] = calculateNextMove(i,j);
			}
		}
		grid = tempGrid;
		drawGrid();
	}
	 
	public int[][] getGameGrid() {
		return grid;
	}
	 
	private void drawGrid() {
		System.out.println("----------------------");
		for (int i = 0; i<grid.length;i++) {
			System.out.print("[");
			for (int j=0; j<grid.length;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("]");
		}
		System.out.println("----------------------");
	}

	private int calculateNextMove(int i, int j) {		
		int neighbors = calculateNeighbors(i, j);
		
		//2 or less neighbors, cell dies
		if (neighbors <=2 && grid[i][j] == 1) {
			return 0;
		//2 or 3 neighbors, cell lives TODO: remove this rule?
		} else if ((neighbors ==2 || neighbors ==3) && grid[i][j] ==1) {
			return 1;
		//>3 neighbors dies
		} else if (neighbors >3 && grid[i][j] ==1) {
			return 0;
		//dead cell with exactly 3 neighbors becomes alive
		} else if (neighbors ==3 && grid[i][j]==0) {
			return 1;
		//else no change
		} else {
			return grid[i][j];
		}
	}
	
	private int calculateNeighbors(int i, int j) {
		int neighbors = 0;
		try {
		//TOP THREE
		if (grid[i-1][j-1] == 1) {
			neighbors +=1;
		}
		if (grid[i-1][j] == 1) {
			neighbors +=1;
		}
		if (grid[i-1][j+1] == 1) {
			neighbors +=1;
		}
		//MIDDLE THREE
		if (grid[i][j-1] == 1) {
			neighbors +=1;
		}
//		if (grid[i][j] == 1) {
//			neighbors +=1;
//		}
		if (grid[i][j+1] == 1) {
			neighbors +=1;
		}
		//BOTTOM THREE
		if (grid[i+1][j-1] == 1) {
			neighbors +=1;
		}
		if (grid[i+1][j] == 1) {
			neighbors +=1;
		}
		if (grid[i+1][j+1] == 1) {
			neighbors +=1;
		}
		} catch (ArrayIndexOutOfBoundsException npe) {
			
		}
		
		return neighbors;
	}
}

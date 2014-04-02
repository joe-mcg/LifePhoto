public class LifeGame {
	
	int[][] grid;

	public void createNewGrid(int gridLength) {
		grid = new int[gridLength][gridLength];
		for (int i = 0; i<grid.length;i++) {
			for (int j=0; j<grid.length;j++) {
				if (Math.random() >= 0.3) {
					grid[i][j]=0;
				} else {
					grid[i][j]=1;
				}
				
			}
		}
		for (int i = 0; i<grid.length;i++) {
			System.out.print("[");
			for (int j=0; j<grid.length;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("]");
		}
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
